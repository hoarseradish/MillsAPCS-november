//Gavin Moy
// 11/22/15
// FracCalC CheckPoint 2 

import java.util.*;
public class FracCalc {

    public static void main(String[] args) 
    {

        System.out.println("Input a question with fractions.");
        Scanner input = new Scanner(System.in);
        String question = input.nextLine();
        while ( question != "stop") {
        String answer = produceAnswer(question);
        System.out.println(answer);
        question = input.nextLine();
    }

    }

    public static String produceAnswer(String input)
    { 

        String[] inputParts = input.split(" ");
        String operand1 = inputParts[0];
        String operand2 = inputParts[2];
        String operator = inputParts[1];
        //return operand2;            check point 1
        int denominator1 = denominator(operand1); // find the denominator, whole number and numerator for both operands
        int denominator2 = denominator(operand2);
        int whole1 = wholeNumber(operand1, denominator1);
        int whole2 = wholeNumber(operand2, denominator2);
        int numerator1 = numerator(operand1, whole1);
        int numerator2 = numerator(operand2, whole2);

        String answer = "whole:" + whole2 + " numerator:" + numerator2 + " denominator:" + denominator2;
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
        if (denominator ==1 && index ==-1) { // if the denominator is 1 and there is no _, the whole number is the entire operand
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

}
