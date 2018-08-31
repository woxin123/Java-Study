package top.mcwebsite.concurrency.studyExecutor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author mengchen
 * @time 18-8-25 下午2:45
 */
public class TaskExecutionWebServer {

    private static final int NTHREADS = 100;

    private static final Executor exec = Executors.newFixedThreadPool(NTHREADS);

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            final Socket connection = socket.accept();
            Runnable task = () -> handlerRequest(connection);

            exec.execute(task);
        }
    }

    private static void handlerRequest(Socket connection) {
    }

}
