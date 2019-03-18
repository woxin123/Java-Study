package top.mcwebsite.javaproxy;

public aspect BookAspect {
    void around():call(void BookServiceImpl2.saveBook()) {
        System.out.println("开始保存图书");
        proceed();
        System.out.println("保存图书结束");
    }
}