package top.mcwebsite.prototype_pattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mengchen
 * @time 18-10-20 下午5:35
 */
public class Student implements Cloneable {

    private Integer id;

    private String name;

    private Map<String, Double> scores;

    public Student(Integer id, String name, Map<String, Double> scores) {
        this.id = id;
        this.name = name;
        this.scores = scores;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Double> getScores() {
        return scores;
    }

    public void setScores(Map<String, Double> scores) {
        this.scores = scores;
    }

    @Override
    protected Student clone()  {
        Student student = null;
        try {
            student = (Student) super.clone();
            student.scores = (Map<String, Double>) ((HashMap)this.scores).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", scores=" + scores +
                '}';
    }
}
