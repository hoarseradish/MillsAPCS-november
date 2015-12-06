//Gavin Moy
// 12/5/15
// FracCalC Final

import java.util.*;
public class FracCalc {

    public static void main(String[] args) 
    {
        System.out.println("Input a question with fractions.");
        Scanner input = new Scanner(System.in);
        String question = input.nextLine();
        while ( !(question.equals ("stop"))) {
            String answer = produceAnswer(question);
            System.out.println(answer);
            System.out.println("Input a question with fractions. (enter \"stop\" to stop)");
            question = input.nextLine();
        }
    }

    public static String produceAnswer(String input)
    { 
        int space;    // seperating the operands and the operator
        space = input.indexOf(" ");
        String operand1 = input.substring(0,space);
        int length = input.length();
        String operator = input.substring(space+1,length);
        space = operator.indexOf(" ");
        length = operator.length();
        String operand2= operator.substring(space+1, length);
        operator = operator.substring(0, space);
        //return operand2;          //  check point 1
        int denominator1 = denominator(operand1); // find the denominator, whole number and numerator for both operands
        int denominator2 = denominator(operand2);
        int whole1 = wholeNumber(operand1, denominator1);
        int whole2 = wholeNumber(operand2, denominator2);
        int numerator1 = numerator(operand1, whole1);
        int numerator2 = numerator(operand2, whole2);
        //String answer = "whole:" + whole2 + " numerator:" + numerator2 + " denominator:" + denominator2;        //check point 2
        //return answer;
        numerator1 = improperNumerator( numerator1, denominator1, whole1); // change both operands into improper fractons
        numerator2 = improperNumerator( numerator2, denominator2, whole2);
        int numerator3;
        int denominator3;
        if (operator.indexOf("*")==0) {
            numerator3= numerator1 * numerator2;
            denominator3 = denominator1 * denominator2;
        }
        else if (operator.indexOf( "/")==0) {
            numerator3 = numerator1 * denominator2;
            if (numerator2 < 0) {

                numerator3 = (numerator1 * denominator2)* -1;
                denominator3 = (Math.abs(numerator2) * denominator1);
            }
            else {
                numerator3 = numerator1 * denominator2;
                denominator3 = numerator2 * denominator1;
            }
        }
        else 
        {
            denominator3 = denominator1 * denominator2; // changing the denominator and numerator of both operands so that they can be added
            numerator1= (numerator1 * denominator2); 
            numerator2 =(numerator2 * denominator1);

            if (operator.indexOf( "+")== 0) {
                numerator3 = numerator1+numerator2;
            }
            else {
                numerator3 = numerator1-numerator2;
            }
        }
        //String answer = numerator3+ "/" + denominator3;   //checkpoint 3
        String answer = reduce(numerator3, denominator3);
        return answer;

    }

    public static int denominator(String operand) { // finds the denominator of the operand
        int fowardslash = operand.indexOf("/");
        String denominator;
        if (fowardslash == -1 ) { // if theres no fraction in the operand, the denominator is 1
            denominator = "1";
        }
        else { // the denonminator is from after the foward slash to the end of the operand
            int start = operand.indexOf("/")+ 1;
            int end = operand.length() ;
            denominator = operand.substring(start,end );
        }
        return Integer.parseInt(denominator); // returns the denominator in int form

    }

    public static int wholeNumber(String operand, int denominator) { // finds the whole number
        int index = operand.indexOf("_");
        String whole;
        if (denominator ==1 && index ==-1) { // if the denominator is 1 and there is no _, the whole number is usually the entire operand unless the operand is something like -2/1
            whole = operand;
        }
        else {
            if (index == -1  ) { // If there is no _, ther is no whole number
                whole = "0";
            }
            else { // the whole number is forom the begining of the operand to before the _
                whole = operand.substring(0, index);
            }
        }
        index = whole.indexOf("/"); // in the case of the exception above, the whole number is 0
        if ( index != -1) {
            whole = "0";
        }
        return Integer.parseInt(whole); // returns the whole number in int form
    }

    public static int numerator(String operand, int whole) { // finds the numerator
        String numerator;
        int end = operand.indexOf("/");
        if (end == -1) { // if there is no fraction, the numerator is 0
            numerator = "0";
        }
        else {

            if (whole == 0) { // if there is no whole number, the numerator is from the begining of the operand to before the /
                numerator = operand.substring(0,end);

            }
            else { // the numerator starts after the _ and ends before the /
                int start = operand.indexOf("_") + 1;  
                numerator = operand.substring(start, end);

            }
        }
        return Integer.parseInt(numerator); // returns the numerator in int form

    }

    public static int improperNumerator( int numerator, int denominator, int whole) { //  the denominator by the whole number and add that to the numerator to make improper fraction
        if (whole <0) {
            return numerator = ((numerator + denominator * Math.abs(whole)) * -1) ;
        }
        else {
            return  numerator = numerator + denominator * whole;
        }
    }

    public static String reduce (int numerator, int denominator) {// changes numerator and denominator into mixed number, then reduces 
        int whole=0;
        if (Math.abs(numerator) > denominator) { // changes improper fractions into mixed numbers
            whole = numerator/denominator;
            numerator = Math.abs(numerator)%denominator;
        }
        int gcf = gcf(Math.abs(numerator), denominator); // finds the greatest common factor and divides the numerator and denominator by it
        numerator = numerator/gcf;
        denominator = denominator/gcf;

        if( whole !=0 && numerator != 0 ) { //different returns so that parts that equal 0 do not show up in the final answer 
            return (whole + "_" + numerator + "/" +denominator); 
        }
        else if (whole ==0 && numerator == 0) {
            return "0";
        }
        else if (whole == 0 && numerator == denominator) {
            return "1";
        }
        else if (whole == 0 ) {
            return (numerator + "/" + denominator);
        }
        else  {
            return Integer.toString(whole);
        }
    }

    private static int gcf (int numerator, int denominator) // finds the greatest common factor of the numerator and the doenminator
    {
        while (denominator > 0)
        {
            int c = denominator;
            denominator = numerator % denominator; 
            numerator = c;
        }
        return Math.abs(numerator+denominator);
    }
}

