/*9.	Develop a Java program to calculate area of a particular shape using concept of abstract class*/

import java.util.*;

abstract class Shape{
  public abstract double calcArea();
}

class Circle extends Shape {
  private double radius;
  public Circle(double radius){
    this.radius = radius;
  }

  @Override
  public double calcArea(){
    return Math.PI * radius * radius;
  }
} 

class Rectangle extends Shape {
    private double length;
    private double width;
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
  
    @Override
    public double calcArea() {
        return length * width;
    }
}


class Triangle extends Shape {
    private double base;
    private double height;
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    @Override
    public double calcArea() {
        return 0.5 * base * height;
    }
}


public class ShapeMain {
  public static void main(String args[]){
    Scanner scanner = new Scanner(System.in);

    System.out.println("Choose a shape by number:");
    System.out.println("1. Circle");
    System.out.println("2. Rectangle");
    System.out.println("3. Triangle");
    System.out.print("Enter your choice: ");

    int choice = scanner.nextInt();
    Shape shape;

    switch(choice){
      case 1:
        System.out.println("Enter the radius of the circle: ");
        double radius = scanner.nextDouble();
        shape = new Circle(radius);
        break;

      case 2:
        System.out.println("Enter the length:");
        double length = scanner.nextDouble();
        System.out.print("Enter the width of the rectangle: ");
        double width = scanner.nextDouble();
        shape = new Rectangle(length,width);
        break;

      case 3:
        System.out.println("Enter the base:");
        double base = scanner.nextDouble();
        System.out.print("Enter the height of the triangle: ");
        double height = scanner.nextDouble();
        shape = new Triangle( base, height);
        break;

      default:
        System.out.println("Invalid Choice.");
        return;
    }

    double area = shape.calcArea();
    System.out.println("Area of the shape: "+ area);

    scanner.close();
  }
}