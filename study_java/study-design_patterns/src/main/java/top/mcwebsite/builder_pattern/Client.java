package top.mcwebsite.builder_pattern;

/**
 * @author mengchen
 * @time 18-9-25 下午5:47
 */
public class Client {

    public static void main(String[] args) {
        BenzCarBuilder benzCarBuilder  = new BenzCarBuilder();
        Director director = new Director(benzCarBuilder);
        Product product = director.construct();
        System.out.println(product);
    }

}
