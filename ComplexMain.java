/*Add two complex numbers*/
import java.util.Scanner;

class Complex{
  public int real,img;
  public Complex( int real, int img){
    this.real = real;
    this.img = img;
  }

  public void displayNo(){
    System.out.println( real + " + "+ img + "i");
  }

  static class ComplexMethods{
    Complex c1;
    Complex c2; 
    private int r, i;

    public ComplexMethods(Complex c1,Complex c2){
      this.c1 = c1;
      this.c2 = c2;
    }

    public void addNos(){
      int r = c1.real + c2.real;
      int i = c1.img + c2.img;
      Complex result = new Complex(r,i);
      result.displayNo();
    };
  }
}


class ComplexMain {
  public int r1,i1,r2,i2;
  public static void main(String args[]){

    Scanner scanner = new Scanner(System.in);

    System.out.println("Input real value for first no:");
    int r1 = scanner.nextInt();

    System.out.println("Input img value for first no:");
    int i1 = scanner.nextInt();

    System.out.println("Input real value for second no:");
    int r2 = scanner.nextInt();

    System.out.println("Input img value for second no:");
    int i2 = scanner.nextInt();

    Complex complex1 = new  Complex(r1,i1);
    Complex complex2 = new Complex(r2,i2);


    complex1.displayNo();
    complex2.displayNo();

    Complex.ComplexMethods ans = new Complex.ComplexMethods(complex1,complex2);

    System.out.println("SUM : ");
    ans.addNos();

    scanner.close();

  }
}