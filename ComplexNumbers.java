class ComplexNumbers {
    double real;
    double imag;

    public ComplexNumbers(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public static ComplexNumber addComplexNumbers(double real1, double imag1, double real2, double imag2) {
        ComplexNumber result = new ComplexNumber(0.0, 0.0);
        result.real = real1 + real2;
        result.imag = imag1 + imag2;
        return result;
    }

    public static void main(String[] args) {
        double real1 = 2.3, imag1 = 4.5;
        double real2 = 3.4, imag2 = 5.0;
        ComplexNumber sum = addComplexNumbers(real1, imag1, real2, imag2);
        System.out.printf("Sum = %.1f + %.1fi", sum.real, sum.imag);
    }
}
