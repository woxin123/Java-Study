package top.mcwebsite.concurrency.future;

/**
 * @author mengchen
 * @time 18-10-11 下午3:25
 */
public class Client {

    public Data request(final String queryStr) {
        final FutureData future = new FutureData();
        new Thread() {
            @Override
            public void run() {
                RealData realData = new RealData(queryStr);
                future.setRealData(realData);
            }
        }.start();
        return future;
    }

}
