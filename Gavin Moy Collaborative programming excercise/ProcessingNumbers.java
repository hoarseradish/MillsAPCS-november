
/**
 *program that accepts a string of numbers and calculates the largest, smalles, sum of the evens and largest of the evens.
 * 
 * @author (Gavin Moy) 
 * @version (11/6/15)
 */
import java.util.*;
public class ProcessingNumbers
{
    public static void main (String[] args) {
         Scanner console = new Scanner(System.in);
        int sum = 0; // all the variables that needed in the program so that they can be used in the while and if statements
        int count = 0;
        int max=0;
        int min=0;
        int evenMax = -2147483648; // -(2^31)  lowest possible int
        System.out.println("How many numbers?");
        int times = console.nextInt();
        System.out.println("Enter a String of numbers with each seperated by a space");
        while (count < times ) { //loops for the amount of numbers entered
            int inputNumber = console.nextInt();
            if ( count == 0) { // when it goes through the first time, the first input number is the max
                max = inputNumber;
            }
            else if ( count == 1) { // on the second loop, only compare the first and second number
                min = Math.min(max, inputNumber);
                max = Math.max(max, inputNumber);
            }
            else { // tests if the input number is higher or lower than the max and min
                max = Math.max (max, inputNumber);
                min = Math.min (min, inputNumber);
            }
            if ((inputNumber%2) == 0 ) { // if even, see if input number is higher than max, and add to the sum for even numbers
                evenMax = Math.max (inputNumber, evenMax);
                sum += inputNumber;
            }
            count++;
        }
        System.out.println ("The largest number input was " + max);
        System.out.println( "The smallest number input was " + min);
        System.out.println("The sum of all the even numbers input is " + sum);
        System.out.println("The largest even number input was " + evenMax);
    }
}
       
       
    