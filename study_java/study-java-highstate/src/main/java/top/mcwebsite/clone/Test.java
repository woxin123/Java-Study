package top.mcwebsite.clone;

/**
 * 被复制的类一般要实现Cloneable
 * @author mengchen
 * @time 18-10-14 下午2:01
 */
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        Person person1 = new Person("张三", "西安市");

        Person person2 = (Person) person1.clone();

        person1.setName("李四");
        System.out.println(person1);
        System.out.println(person2);
    }
}
