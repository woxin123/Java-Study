package top.mcwebsite.concurrency.future;

/**
 * @author mengchen
 * @time 18-10-11 下午3:27
 */
public class Main {

    public static void main(String[] args) {
        Client client = new Client();
        Data data = client.request("name");
        System.out.println("请求完毕");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("数据 = " + data.getResult());
    }


}
