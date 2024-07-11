/*6.	Write a program to calculate the commission of a salesman using nested class*/

//Salesman main outer class
//Commission inner class

import java.util.Scanner;

public class Salesman {
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter sales Amount: ");

    double salesAmount = scanner.nextDouble();

  
	Salesman.Commission commission = new Salesman.Commission(salesAmount);



    System.out.println("Commission: $" + commission.calculateCommissions(salesAmount));

    scanner.close();
  }

  static class Commission {
    private double salesAmount;

    public Commission(double salesAmount) {
      this.salesAmount = salesAmount;
    }

    public double calculateCommissions(double salesAmount) {
      double commissionRate;
      if (salesAmount <= 10000) {
        commissionRate = 0.05; // 5% commission
      } else if (salesAmount <= 20000) {
        commissionRate = 0.10; // 10% commission
      } else {
        commissionRate = 0.15; // 15% commission
      }
      return salesAmount * commissionRate;
    }
  }
}