package top.mcwebsite.builder_pattern;

/**
 * @author mengchen
 * @time 18-9-25 下午5:37
 */
public abstract class AbstractCarBuilder {

    Product product = new Product();

    abstract void buildPart1();

    abstract void buildPart2();

    public Product build() {
        return product;
    }
}
