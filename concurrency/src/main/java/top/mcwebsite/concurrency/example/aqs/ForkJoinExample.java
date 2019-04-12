package top.mcwebsite.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @author mengchen
 * @time 19-4-12 下午4:36
 */
@Slf4j
public class ForkJoinExample extends RecursiveTask<Integer> {

    private static final int threadhold = 20000;
    private int start;
    private int end;

    public ForkJoinExample(int start, int end) {
        this.start = start;
        this.end = end;
    }

    /**
     * The main computation performed by this task.
     *
     * @return the result of the computation
     */
    @Override
    protected Integer compute() {
        int sum = 0;

        // 如果任务足够小就计算
        boolean canComputer = (end - start) <= threadhold;

        if (canComputer) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            // 如果任务大于阈值，就分类成两个子任务计算
            int middle = (start + end) / 2;
            ForkJoinExample leftTask = new ForkJoinExample(start, middle);
            ForkJoinExample rightTask = new ForkJoinExample(middle + 1, end);

            // 执行子任务
            leftTask.fork();
            rightTask.fork();

            // 等待任务执行结束合并结果
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            // 合并任务结果
            sum = leftResult + rightResult;
        }

        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        // 生成一个计算任务，计算1 + 2 + ... + n
        ForkJoinExample task = new ForkJoinExample(1, 100000000);

        // 执行一个任务
        Future<Integer> result = forkJoinPool.submit(task);

        try {
            log.info("result: {}", result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
