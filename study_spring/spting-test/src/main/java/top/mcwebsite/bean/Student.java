package top.mcwebsite.bean;

import org.springframework.stereotype.Component;

/**
 * @author mengchen
 * @time 18-11-6 下午3:31
 */
public class Student {
   private String sid;
   private String name;
   private String clazz;
   private char sex;

   public Student() {
   }

    public Student(String sid, String name, String clazz, char sex) {
        this.sid = sid;
        this.name = name;
        this.clazz = clazz;
        this.sex = sex;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }
    public void init() {
        System.out.println("init student");
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", name='" + name + '\'' +
                ", clazz='" + clazz + '\'' +
                ", sex=" + sex +
                '}';
    }
}
