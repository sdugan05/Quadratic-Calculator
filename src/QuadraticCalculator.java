import java.util.Scanner;

/**
 * Created by Saul Dugan
 */
public class QuadraticCalculator {

    static double[] solveQuadraticEquation(int a, int b, int c) {
        // Calculate solutions of a quadratic equation using the quadratic formula
        // (-b (+-) sqrt(b^2 - 4ac))/2a
        double discriminant_1 = b*b;
        discriminant_1 -= 4*a*c;
        double discriminant = Math.sqrt(discriminant_1);

        double numerator_plus = (-1*b) + discriminant;
        double numerator_minus = (-1*b) - discriminant;

        double[] solutions = new double[2];

        solutions[0] = numerator_plus / ( 2*a );
        solutions[1] = numerator_minus / ( 2*a );

        return solutions;
    }

    public static void main(String[] args) {

        boolean done = false;
        Scanner inputScanner = new Scanner(System.in);

        while (!done) {

            // enter code to get the information for the equation here
            System.out.println("Please enter the three numbers you want to solve for a, b and c of a quadratic equation:");
            System.out.println("(enter all numbers with spaces, or enter quit to stop the program)");

            // if the first input is a string, then make sure it is time to quit
            if (!inputScanner.hasNextInt()) {
                done = true;
                return;
            }
            // otherwise check to see if it is something we can use, if so grab the rest of the data
            else if (inputScanner.hasNextInt()) {
                int a, b, c;
                try {
                    a = inputScanner.nextInt();
                    b = inputScanner.nextInt();
                    c = inputScanner.nextInt();
                    // do quadratic calculation and output possible answers (there are two)
                    double[] solutions = solveQuadraticEquation(a, b, c);
                    System.out.println("x=" + solutions[0]);
                    System.out.println("x=" + solutions[1]);
                } catch (Exception e) {
                    System.out.println("Invalid Numbers");
                } 
            }
            // it it is none of the above, it is probably invalid input
            else {
                inputScanner.next();
            }
        }

        // we should always clean up after ourselves! Close the scanner object
        inputScanner.close();
        System.out.println("Goodbye!");
    }
}
