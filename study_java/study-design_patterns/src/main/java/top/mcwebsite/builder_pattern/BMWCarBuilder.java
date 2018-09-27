package top.mcwebsite.builder_pattern;

/**
 * @author mengchen
 * @time 18-9-25 下午5:43
 */
public class BMWCarBuilder extends AbstractCarBuilder {


    @Override
    public void buildPart1() {
        System.out.println("建造宝马的第一部分");
        product.setPart1("This is part one for BMW");
    }

    @Override
    public void buildPart2() {
        System.out.println("建造宝马的第二部分");
        product.setPart1("This is part two for BMW");
    }

}
