# Spring事务的实现方式和实现原理

Spring事务的本质其实就是数据库对事务的支持，没有数据库的事务支持，spring是无法提供事务功能的。真正的数据库层的事务提交和回滚是通过binlog或者redo log实现的。

### 1. Spring事务的种类

spring支持编程式事务和声明式事务管理两种方式：
1. 编程式事务使用TranscationTemplate。
    
2. 声明式事务管理建立在AOP之上。其本质是通过AOP功能，对方法前后进行拦截，将事务处理的功能编织到拦截的方法中，也就是在目标方法开始之前加入一个事务，在执行完目标方法后根据执行情况提交或者回滚事务。


声明式事务的最大优点就是不需要在业务代码中参杂事务管理的代码，只需要在配置文件中做相关的事务规则或通过`@Transactional`注解的方式，便可以将事务规则应用到业务逻辑中。

声明式管理要优于编程式事务管理，这正是spring提倡的非侵入式的开发方式，使业务代码不受污染，只要加上注解就可以获得完全的事务支持。唯一不足地方时，最细粒度只能作用到方法级别，无法做到像编程式事务那样可以作用到代码块级别。

### 2. spring的事务传播行为

Spring事务的行为说的是，当多个事务同时存在的时候，spring如何处理这些事务的行为。

1. PROPAGATION_REQUIRED：如果当前没有事务，就创建一个事务，如果当前事务存在，就加入该事务，该设置是最常用的设置。
2. PROPAGATION_SUPPORTS：支持当前事务，如果当前存在事务，就加入该事务，如果当前不存在事务，就以非事务执行。
3. PROPAGATION_MANDATORY：支持当前事务，如果当前存在事务，就加入当前事务，如果当前事务不存在，就抛出异常。
4. PROPAGATION_REQUIRES_NEW：创建新事务，无论当前事务是否存在，都创建新的事务。
5. PROPAGATION_NOT_SUPPORTED：以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。
6. PROPAGATION_NEVER：如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则按REQUIRED属性执行。

```java
public enum Propagation {

	REQUIRED(TransactionDefinition.PROPAGATION_REQUIRED),

	SUPPORTS(TransactionDefinition.PROPAGATION_SUPPORTS),

	MANDATORY(TransactionDefinition.PROPAGATION_MANDATORY),

	REQUIRES_NEW(TransactionDefinition.PROPAGATION_REQUIRES_NEW),

	NOT_SUPPORTED(TransactionDefinition.PROPAGATION_NOT_SUPPORTED),

	NEVER(TransactionDefinition.PROPAGATION_NEVER),

	NESTED(TransactionDefinition.PROPAGATION_NESTED);


	private final int value;


	Propagation(int value) { this.value = value; }

	public int value() { return this.value; }

}
```

### 3. spring中的隔离级别

1. ISOLATION_DEFAULT：这个是PlatformTransactionManager默认的隔离级别，使用数据库默认的事务隔离级别。
2. ISOLATION_READ_COMMITTED：读已提交，保证一个事务的修改的数据提交后才能被另一个事务读取，而且能看到该事务对已有的记录的更新。
4. ISOLATION_REPEATABLE_READ：可重复读，保证一个事务的修改提交后才能被另一个事务读取，但是不能看到该事物对已有的记录的更新。
5. IOSLATION_SERIALIZABLE：一个事务在执行的过程中完全看不到其他事务对数据库所做的更新。这个的这个指的是串行化，事务只能串行的执行，不能并发的执行。

```java
public enum Isolation {

	DEFAULT(TransactionDefinition.ISOLATION_DEFAULT),

	READ_UNCOMMITTED(TransactionDefinition.ISOLATION_READ_UNCOMMITTED),

	READ_COMMITTED(TransactionDefinition.ISOLATION_READ_COMMITTED),

	REPEATABLE_READ(TransactionDefinition.ISOLATION_REPEATABLE_READ),

	SERIALIZABLE(TransactionDefinition.ISOLATION_SERIALIZABLE);

	private final int value;

	Isolation(int value) { this.value = value; }

	public int value() { return this.value; }

}
```

// todo 具体实现