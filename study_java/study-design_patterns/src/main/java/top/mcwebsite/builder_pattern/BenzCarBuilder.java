package top.mcwebsite.builder_pattern;

/**
 * @author mengchen
 * @time 18-9-25 下午5:40
 */
public class BenzCarBuilder extends AbstractCarBuilder {


    @Override
    public void buildPart1() {
        System.out.println("建造奔驰车的第一部分");
        product.setPart1("This is part one for benz");
    }

    @Override
    public void buildPart2() {
        System.out.println("建造奔驰车的第二部分");
        product.setPart2("This is part two for benz");
    }

}
