package top.mcwebsite.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author mengchen
 * @time 18-11-7 下午4:44
 */
public class StudentFactoryBean implements FactoryBean<Student> {

    private String studentInfo;

    @Override
    public Student getObject() throws Exception {
        Student student = new Student();
        String[] infos = studentInfo.split(",");
        student.setSid(infos[0]);
        student.setName(infos[1]);
        student.setClazz(infos[2]);
        student.setSex(infos[3].charAt(0));
        return student;
    }

    @Override
    public Class<?> getObjectType() {
        return Student.class;
    }

    public String getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(String studentInfo) {
        this.studentInfo = studentInfo;
    }
}
