/*16.	Develop a program that implements multi- threaded application that has three threads. First thread generates a random integer every 1 second and if value us even, second thread computes square of number and prints. If value is odd, the third thread will print value of cube of number*/

//multi-threaded program to calculate squares and cubes

/*Algorithm:

Initialization:

Create three threads:
RandomNumberGenerator thread
SquareCalculator thread
CubeCalculator thread
Each thread will share a common RandomNumberGenerator object.
RandomNumberGenerator Thread:

Loop: Continuously:
Generate a random integer.
Print the generated number.
Synchronize on the RandomNumberGenerator object:
Call notifyAll() to wake up any waiting threads.
Sleep for 1 second.
SquareCalculator Thread:

Loop: Continuously:
Synchronize on the RandomNumberGenerator object:
Call wait() to wait for a number to be generated.
Get the latest random number from the RandomNumberGenerator object.
If the number is even:
Calculate the square of the number.
Print the result.
CubeCalculator Thread:

Loop: Continuously:
Synchronize on the RandomNumberGenerator object:
Call wait() to wait for a number to be generated.
Get the latest random number from the RandomNumberGenerator object.
If the number is odd:
Calculate the cube of the number.
Print the result.
Synchronization:

The synchronized blocks are essential for coordinating the threads and ensuring data consistency:
The RandomNumberGenerator thread notifies other threads after generating a number using notifyAll().
The SquareCalculator and CubeCalculator threads wait for a number using wait().
This synchronization prevents race conditions where threads might access the shared random number at the wrong time.
Overall Flow:

The RandomNumberGenerator thread is the "producer" of random numbers.
The SquareCalculator and CubeCalculator threads are the "consumers" of these numbers, each performing calculations based on the number's even or odd status.
Key Concepts:

Multithreading: The program uses multiple threads to perform different tasks concurrently.
Synchronization: The synchronized blocks ensure that the threads access shared data (the random number) in a safe and controlled manner.
wait() and notifyAll(): These methods are used to pause and resume threads, ensuring proper coordination.
Producer-Consumer Pattern: The program implements a simple form of the producer-consumer pattern, where one thread produces data, and other threads consume it.*/


    import java.util.Random;

    public class MultiThreadApp {

        public static void main(String[] args) {
            RandomNumberGenerator thread1 = new RandomNumberGenerator();
            SquareCalculator thread2 = new SquareCalculator(thread1);
            CubeCalculator thread3 = new CubeCalculator(thread1);

            thread1.start();
            thread2.start();
            thread3.start();
        }

        static class RandomNumberGenerator extends Thread {
            private Random random = new Random();
            public int number;

            @Override
            public void run() {
                while (true) {
                    number = random.nextInt(100); // Generate random numbers between 0 and 99
                    System.out.println("Generated number: " + number);

                    // Notify other threads
                    synchronized (this) {
                        notifyAll(); // Wake up any waiting threads
                    }

                    try {
                        Thread.sleep(1000); // Sleep for 1 second
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        static class SquareCalculator extends RandomNumberGenerator implements Runnable {
            private RandomNumberGenerator randomNumberGenerator;
          

            public SquareCalculator(RandomNumberGenerator randomNumberGenerator) {
                this.randomNumberGenerator = randomNumberGenerator;
            }

            @Override
            public void run() {
                while (true) {
                    synchronized (randomNumberGenerator) {
                        try {
                            randomNumberGenerator.wait(); // Wait for a number to be generated
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        if (randomNumberGenerator.number % 2 == 0) {
                            System.out.println("Square of " + randomNumberGenerator.number + " is: " + (randomNumberGenerator.number * randomNumberGenerator.number));
                        }
                    }
                }
            }
        }

        static class CubeCalculator extends RandomNumberGenerator implements Runnable {
            private RandomNumberGenerator randomNumberGenerator;

            public CubeCalculator(RandomNumberGenerator randomNumberGenerator) {
                this.randomNumberGenerator = randomNumberGenerator;
            }

            @Override
            public void run() {
                while (true) {
                    synchronized (randomNumberGenerator) {
                        try {
                            randomNumberGenerator.wait(); // Wait for a number to be generated
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        if (randomNumberGenerator.number % 2 != 0) {
                            System.out.println("Cube of " + randomNumberGenerator.number + " is: " + (randomNumberGenerator.number * randomNumberGenerator.number * randomNumberGenerator.number));
                        }
                    }
                }
            }
        }
    }