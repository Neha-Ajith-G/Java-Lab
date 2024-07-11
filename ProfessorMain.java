/*4.	Write a program to implement Multi-level inheritance for the hierarchy Professor, Associate Professor and Assistant Professor. The class Person should be given the top inheritance priority and should include all personal details. Given the id, the system should display the experience details and calculate appropriate salary for the same.*/

  //Person: The base class with basic personal details.
  //Professor: Extends Person and adds years of experience. It also defines a base salary and a method to calculate the total salary.
  //AssociateProfessor: Extends Professor and overrides the calculateSalary method to have a different salary calculation.
  //AssistantProfessor: Extends AssociateProfessor and overrides calculateSalary again.

//multi-level inheritance: Person-> Professor -> associate -> assistant

import java.util.Scanner;

public class ProfessorMain{
  public static void main(String args[]){
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter Proffessor ID:");
    int id = scanner.nextInt();
    
    System.out.println("Enter Professor Name:");
    String name = scanner.next();
    
    System.out.println("Enter Professor Address:");
    String address = scanner.next();
    
    System.out.println("Enter Professor Age:");
    int age = scanner.nextInt();
    
    System.out.println("Enter Professor Years of Experience:");
    int yearsOfExperience = scanner.nextInt();

    Professor professor;
    if (id >= 10 && id <= 100){
      professor = new Professor(name, id, address, age, yearsOfExperience);
    }
    else if (id >= 100 && id <= 200){
      professor = new AssociateProfessor(name, id, address, age, yearsOfExperience);
    }
    else if(id >= 200 && id <= 300){
      professor = new AssistantProfessor(name, id, address, age, yearsOfExperience);
    }
    else{
      System.out.println("Invalid Professor ID.");
      return;
    }


    System.out.println("Professor Details:");
    System.out.println("Name: " + professor.name);
    System.out.println("ID: " + professor.id);
    System.out.println("Address: " + professor.address);
    System.out.println("Age: " + professor.age);
    professor.displayExperience();
    System.out.println("Salary: $" + professor.calculateSalary());

    scanner.close();
  }
}

class Person{
  String name;
  int id;
  String address;
  int age;
  public  Person(String name,int id,String address,int age){
    this.name = name;
    this.id = id;
    this.address = address;
    this.age = age;
  }
}

class Professor extends Person{
  int yearsOfExperience;
  public Professor(String name, int id, String address, int age, int yearsOfExperience){
    super(name,id,address,age);
    this.yearsOfExperience = yearsOfExperience;
  }

  public double calculateSalary() {
    return 100000 + yearsOfExperience * 5000;
  }

  public void displayExperience(){
    System.out.println("Years of Experience: " + yearsOfExperience);
  }
}

class AssociateProfessor extends Professor{
  public AssociateProfessor(String name, int id, String address, int age, int yearsOfExperience){
    super(name, id, address, age, yearsOfExperience);
  }

  @Override
  public double calculateSalary() {
    return 60000 + yearsOfExperience * 3000;
  }
}

class AssistantProfessor extends Professor{
  public AssistantProfessor(String name, int id, String address, int age, int yearsOfExperience){
    super(name, id, address, age, yearsOfExperience);
  }

  @Override
  public double calculateSalary() {
    return 40000 + yearsOfExperience * 2000;
  }
}