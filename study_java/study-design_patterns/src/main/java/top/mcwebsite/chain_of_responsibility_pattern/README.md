
# 责任链模式

Avoid coupling the sender of a request to its receiver by giving more than one objecta chance to handler the request. Chain the receiving objects and pass the request along the chain until an object handlers it.(使多个对象都有机会处理请求，从而避免了请求发送者和接受者之间的耦合关系。将这些对象连成一条链，并沿着这条链传递该请求，知道所有对象处理完为止)

责任链模式的重点在“链”上，由这一条链去处理相似的请求，并返回相应的结果。其通用的类图如下所示：
![责任链模式通用类图](https://img-blog.csdnimg.cn/20181102181616133.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3N0YXJleHBsb2Rl,size_16,color_FFFFFF,t_70)

责任链模式的核心在“链”上，“链”是有多个处理者`ConcreteHandler`组成的，我们首先来看抽象`Handler`类，如下所示：

```java
public abstract class Handler {

    private Handler nextHandler;

    public final Response handlerMessage(Request request) {
        Response response = null;
        // 判断自己的处理级别
        if (this.getHandlerLevel().equals(request.getRequestLevel())) {
            response = this.echo(request);
        } else {
            // 不属于自己的处理级别
            // 判断是否有下一个处理者
            if (this.nextHandler != null) {
                response = this.nextHandler.handlerMessage(request);
            } else {
                // 没有适当的处理者，业务自行处理
            }
        }
        return response;
    }

    /**
     * 设置下一个处理者是谁
     * @param handler
     */
    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    /**
     * 每一个处理者都有一个处理级别
     * @return
     */
    protected abstract Level getHandlerLevel();

    /**
     * 每一个处理者都必须实现处理任务
     * @param request
     * @return
     */
    protected abstract Response echo(Request request);

}
```

抽象的处理者实现三个职责：

1. 定义一个请求处理的方法handelMessage，唯一对外开放的方法
2. 定义一个链的编排方法setNext，设置下一个处理者。
3. 定义了具体的请求者必须实现两个方法：
	+ 定义自己的处理级别getHandlerLevel
	+ 具体的处理任务echo

下面定义了三个具体的处理者，以便组成一个链，代码如下：

```java
public class ConcreteHandler1 extends Handler {
    /**
     * 定义自己的处理级别
     * @return
     */
    @Override
    public Level getHandlerLevel() {
        return null;
    }

    /**
     * 定义自己的处理逻辑
     * @param request
     * @return
     */
    @Override
    public Response echo(Request request) {
        return null;
    }

}

public class ConcreteHandler2 extends Handler {
    /**
     * 定义自己的处理级别
     * @return
     */
    @Override
    public Level getHandlerLevel() {
        return null;
    }

    /**
     * 定义自己的处理逻辑
     * @param request
     * @return
     */
    @Override
    public Response echo(Request request) {
        return null;
    }

}

public class ConcreteHandler3 extends Handler {
    /**
     * 定义自己的处理级别
     * @return
     */
    @Override
    public Level getHandlerLevel() {
        return null;
    }

    /**
     * 定义自己的处理逻辑
     * @param request
     * @return
     */
    @Override
    public Response echo(Request request) {
        return null;
    }
}
```

在处理者中涉及了三个类：Level类负责定义请求和处理的级别，Request负责封装请求，Response负责封装返回链中的结果，三个类根据需要的业务产生。

模式中的其他一些代码：

```java
public class Request {
    private Level level;

    public Request(Level level) {
        this.level = level;
    }

    public Level getRequestLevel() {
        return level;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}

public class Response {
}

public class Level {
    private int level;

	public Level(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}

```
在场景类或高层类中对链进行组装，并传递请求，返回结果，如下所示：

```java
public class Client {
    public static void main(String[] args) {
        // 声明所有的处理节点
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler1();
        Handler handler3 = new ConcreteHandler1();

        // 设置链中处理阶段1-->2-->3
        handler1.setNextHandler(handler2);
        handler2.setNextHandler(handler3);
        // 提交请求，返回结果
        Response response = handler1.handlerMessage(new Request(new Level(2)));
    }
}
```
在实际应用中，一般会有一个封装类对责任链模式进行封装，也就是替代Client类，直接返回链中的第一个处理者，具体的链的设置不需要高层次的模块关系，这样，更简化了高层次模块的调用，减少模块间的耦合，提供系统的灵活性。

## 责任链模式的优点

责任链模式非常显著的特点就是将请求和处理分开。请求者可以不用知道是谁处理的，处理者可以不知道请求的全貌，两者解耦，提高系统的灵活性。

## 责任链模式的缺点

责任链模式有两个缺点：

1. 性能问题，每一个请求都是从链表的头遍历到链表的尾，特别是链表比较长的时候，性能是一个很大的问题。
2. 调试很不方便，特别是链表比较长的时候，由于采用了类似与递归的方式，调试的时候逻辑可能比较复杂。