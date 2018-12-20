# Java之SPI

SPI的全名为Service Provider Interface。是JDK提供的一个简单的服务发现的机制。

也就是说一个接口，可能会有很多实现类，但是可能在使用的时候不知道实现类有哪些，可以通过这种机制来发现实现类。

将配置文件放在META-INF/services中来标识服务提供者，文件名是接口的全限定类名。该文件包含提供者的第一个全限定二进制名称列表，每行一个。

## 一个简单的例子

项目结构图如下：

![](http://img-blog.csdnimg.cn/20181220170223432.png)

接口定义如下：

```java
public interface HelloInterface {

    void sayHello();
}
```

两个实现类如下：

```java
public class ImageHello implements HelloInterface{
    @Override
    public void sayHello() {
        System.out.println("ImageHello");
    }
}
public class TextHello implements HelloInterface{

    @Override
    public void sayHello() {
        System.out.println("TextHello");
    }
}
```

top.mcwebsite.spi.HelloInterface文件的内容如下：

```java
top.mcwebsite.spi.ImageHello
top.mcwebsite.spi.TextHello
```

项目的主程序如下：

```java
public class SPIMain {

    public static void main(String[] args) {
        ServiceLoader<HelloInterface> loaders = ServiceLoader.load(HelloInterface.class);
        System.out.println("classpath:" + System.getProperty("java.class.path"));
        for (HelloInterface in : loaders) {
            in.sayHello();
        }
    }
}

```

运行结果如下：

![](http://img-blog.csdnimg.cn/20181220170655966.png)

