# Spring中的aware接口

Spring中有很多继承于aware中的接口，这些接口到底是做什么用的。

![](https://upload-images.jianshu.io/upload_images/3397380-6ef519bbc705ce28.png)

`aware`，翻译过来是知道的，以感知的，意识到的，所以这些接口从字面意思应该是能感知到所有 `Aware` 前面的含义。

先举个 `BeanNameAware` 的例子，实现 `BeanNameAware` 接口，可以让该 `Bean` 感知到自身的 `BeanName` （对应Spring容器的 `BeanId` 属性），举个例子：

+ BeanNameAware接口的定义

    ```java
    public interface BeanNameAware extends Aware {
	    void setBeanName(String name);
    }
    ```

+ 定义两个 `User`，一个实现 `BeanNameAware`，一个不识闲。

```java
@Data
public class User implements BeanNameAware {

    private String id;
    private String name;
    private String address;

    @Override
    public void setBeanName(String name) {
        this.id = name;
    }
}

@Data
public class User2 {
    private String id;
    private String name;
    private String address;
}

```

+ 在Spring配置文件中初始化两个对象。

```
<bean id="zhangsan" class="study.spring.aware.User">
    <property name="name" value="zhangsan" />
    <property name="address" value="火星" />
</bean>
<bean id="lisi" class="study.spring.aware.User2" >
    <property name="name" value="lisi" />
    <property name="address" value="火星" />
</bean>
```

+ main方法测试一下 `BeanNameAware`接口所起的作用。

```java
public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-core-aware.xml");
    User user = context.getBean(User.class);
    System.out.println(user);
    User2 user2 = context.getBean(User2.class);
    System.out.println(user2);
}
```

+ 运行结果

```
User(id=zhangsan, name=zhangsan, address=火星)
User2(id=null, name=lisi, address=火星)
```

能够看到，我们在实现了 `BeanNameAware`的`User`中，获取到了Spring容器中的BeanId（对应spring配置文件中的`id`属性），而没有实现`BeanNameAware`的`User2`，则不能获取到Spring容器的Id属性。

所以BeanNameAware接口是为了让自身bean能够感知到，获取到自身在Spring容器中的id属性。

同理，其他的Aware接口也是为了能够感知到自身的一些属性。比如实现了`ApplicationContextAware`接口的类，能够获取到ApplicationContext，实现 `BeanFactoryAware`接口的类，能够获取到 `BeanFactory`对象。