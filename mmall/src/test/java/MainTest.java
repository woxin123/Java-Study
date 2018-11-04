//import java.lang.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 刘玮婷 on 2018/10/28.
 */
public class MainTest {
    public static void main(String args[]){
        int i;
        int n1,n2;
        String name;
        int age;
        boolean gender;
        ArrayList<PersonOverride> List1 = new ArrayList<>();
        ArrayList<PersonOverride> List2 = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        n1 = in.nextInt();
        in.nextLine();
        for(i=0; i<n1; i++) {
            PersonOverride person1 = new PersonOverride();
            List1.add(person1);
        }
        //PersonOverride[] person11 =
        //        List1.toArray(new PersonOverride[List1.size()]);
        n2 = in.nextInt();
        in.nextLine();
        for(i=0; i<n2; i++){
            name = in.next();
            age = in.nextInt();
            gender = in.nextBoolean();
            in.nextLine();
            PersonOverride person2 = new PersonOverride(name,age,gender);
            System.out.println("cwshi:"+List2.contains(person2));
            if(!List2.contains(person2))
                List2.add(person2);
        }
        //PersonOverride[] person22 =
        //        List2.toArray(new PersonOverride[List2.size()]);
        for (i=0; i<List1.size(); i++)
            //    System.out.println(person11[i].toString());
            System.out.println(List1.get(i));
        for (i=0; i<List2.size(); i++)
            //    System.out.println(person22[i].toString());
            //System.out.println(person22.length);
            System.out.println(List2.get(i));
        System.out.println(List2.size());

        System.out.println(Arrays.toString(PersonOverride.class.getConstructors()));
    }
}

class PersonOverride{
    private String name ;
    private int age;
    private boolean gender;

    public PersonOverride(String name, int age, boolean gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public PersonOverride(){
        this("default",1,true);
    }

    public String toString(){
        return String.format("%s-%d-%s",name,age,gender);
    }


    public boolean equals(Object o) {
        PersonOverride p = (PersonOverride) o;
        return (name.equals(p.name) && age == p.age && p.gender == gender);
    }
}

