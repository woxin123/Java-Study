import java.util.*;

public class ArrayListToArray {
    public static void main(String[] args) {
        System.out.println("---------��һ�����-----------");
        String[] array1 = {"Hello", " ", "World!"};
        ArrayList<String> list1 = new ArrayList();
        list1.add("my");
        list1.add("name");
        list1.add("is");
        list1.add("emmmmm");
        String[] arrayReturn1 = list1.toArray(array1);
        System.out.println("array���飺");
        for (String str : array1) {
            System.out.println(str);
        }
        System.out.println("list���飺");
        for (String str : list1) {
            System.out.println(str);
        }

        System.out.println("arrayReturn���飺");
        for (String str : arrayReturn1) {
            System.out.println(str);
        }
        System.out.println("---------�ڶ������-----------");
        String[] array2 = {"Hello", " ", "World!", "Hello", " ", "ArrayList", "!"};
        ArrayList<String> list2 = new ArrayList();
        list2.add("my");
        list2.add("name");
        list2.add("is");
        list2.add("emmmmm");
        String[] arrayReturn2 = list2.toArray(array2);
        System.out.println("array���飺");
        for (String str : array2) {
            System.out.println(str);
        }
        System.out.println("list���飺");
        for (String str : list2) {
            System.out.println(str);
        }

        System.out.println("arrayReturn���飺");
        for (String str : arrayReturn2) {
            System.out.println(str);
        }
    }
}