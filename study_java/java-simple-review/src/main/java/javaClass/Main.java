package javaClass;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author mengchen
 * @time 18-9-17 上午11:03
 */
public class Main {



    public void aMethod() {

    }

    public int aMethod(int a) {
        return 2;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        double a = sc.nextDouble();
//        double c = a * 5;
//        double s = a * a * Math.sqrt(25 + 10 * Math.sqrt(5)) / 4;
//        DecimalFormat d = new DecimalFormat("#.####");
//        System.out.printf("%.4f\n", s);
//        System.out.println(d.format(c));

        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double c = a * 5;
        double s = a * a * Math.sqrt(25 + 10 * Math.sqrt(5)) / 4;

        DecimalFormat d = new DecimalFormat("#.####");
        System.out.println(d.format(s));
        System.out.println(d.format(c));
    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String name = sc.nextLine();
//        System.out.println("Hello!What's your name?");
//        System.out.println(name + ",Welcome to learn OOP using C++!");
//    }

}

class Rectangle {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return height * width;
    }

    public double getPerimeter() {
        return (height + width) * 2;
    }

}

class Stock {
    private String symbol;
    private String name;
    double previousClosingPrice;
    double currentPrice;

    public Stock(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public double changePercent() {
        return (currentPrice - previousClosingPrice) / previousClosingPrice;
    }
}
