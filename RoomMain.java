// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;

/*5.	Write a program to determine the cost of painting a room using the concept of inner class. Also calculate the number of cans used to paint the room*/

//creata a parent class Room with an inner class Paint 
//class Paint encapsulates the painting information
//Room class- att-> room's dimensions methods-> calcArea()
//Paint inner class -> att-> cost per gallon ,coverage area per gallon,can info method-> getNoCans()

//main method to get input and calc cost and no of cans

import java.util.Scanner;

public class RoomMain {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the length of the room : ");
    double length = scanner.nextDouble();

    System.out.println("Enter the width of the room : ");
    double width = scanner.nextDouble();

    System.out.println("Enter the height of the room : ");
    double height = scanner.nextDouble();

    System.out.println("Enter the cost per gallon of paint : ");
    double costPerLiter = scanner.nextDouble();

    System.out.println("Enter the coverage area per liter of paint (in square m): ");
    double coverageAreaPerLiter = scanner.nextDouble();

    Room room = new Room(length, width, height);
    Paint paint = new Paint(costPerLiter, coverageAreaPerLiter);

    double totalCost = paint.calculateCost(room.calculateArea());
    int numCans = paint.calculateCans(room.calculateArea());

    System.out.println("Total cost of painting: $" + totalCost);
    System.out.println("Number of paint cans required: " + numCans);

    scanner.close();
  }

  static class Room {
    private double length;
    private double width;
    private double height;

    public Room(double length, double width, double height) {
      this.length = length;
      this.width = width;
      this.height = height;
    }

    public double calculateArea() {
      // Assuming we're painting the walls and ceiling, not the floor
      double wallArea = 2 * (length * height) + 2 * (width * height);
      double ceilingArea = length * width;
      return wallArea + ceilingArea;
    }
  }

  static class Paint {
    private double costPerLiter;
    private double coverageAreaPerLiter;

    public Paint(double costPerLiter, double coverageAreaPerLiter) {
      this.costPerLiter = costPerLiter;
      this.coverageAreaPerLiter = coverageAreaPerLiter;
    }

    public double calculateCost(double area) {
      double litersNeeded = area / coverageAreaPerLiter;
      return litersNeeded * costPerLiter;
    }

    public int calculateCans(double area) {
      double litersNeeded = area / coverageAreaPerLiter;
      return (int) Math.ceil(litersNeeded); // Round up to the nearest whole can
    }
  }
}
