package top.mcwebsite.builder_pattern;

/**
 * @author mengchen
 * @time 18-9-25 下午5:44
 */
public class Director {

    private AbstractCarBuilder carBuilder;

    public Director(AbstractCarBuilder carBuilder) {
        this.carBuilder = carBuilder;
    }

    public Product construct() {
        carBuilder.buildPart1();
        carBuilder.buildPart2();

        return carBuilder.build();
    }

}
