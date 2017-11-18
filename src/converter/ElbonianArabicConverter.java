package converter;

import com.sun.deploy.util.StringUtils;
import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;
import java.lang.*;

/**
 * This class implements a converter that takes a string that represents a number in either the
 * Elbonian or Arabic numeral form. This class has methods that will return a value in the chosen form.
 *
 * @version 3/18/17
 */
public class ElbonianArabicConverter{
    int t = 0;
    int M = 1000;
    int C = 100;
    int X = 10;
    int I = 1;
    int D = 500;
    int L = 50;
    int V = 5;
    int e = 400;
    int m = 40;
    int w = 4;
    // A string that holds the number (Elbonian or Arabic) you would like to convert
    private final String number;
   // private final Double anumber;

    /**
     * Constructor for the ElbonianArabic class that takes a string. The string should contain a valid
     * Elbonian or Arabic numeral. The String can have leading or trailing spaces. But there should be no
     * spaces within the actual number (ie. "9 9" is not ok, but " 99 " is ok). If the String is an Arabic
     * number it should be checked to make sure it is within the Elbonian number systems bounds. If the
     * number is Elbonian, it must be a valid Elbonian representation of a number.
     *
     * @param number A string that represents either a Elbonian or Arabic number.
     * @throws MalformedNumberException Thrown if the value is an Elbonian number that does not conform
     * to the rules of the Elbonian number system. Leading and trailing spaces should not throw an error.
     * @throws ValueOutOfBoundsException Thrown if the value is an Arabic number that cannot be represented
     * in the Elbonian number system.
     */
    public ElbonianArabicConverter(String number) throws MalformedNumberException, ValueOutOfBoundsException {
        // TODO check to see if the number is valid, then set it equal to the string

        boolean badArabNum = false;
        boolean badElbNum = false;
        int Mcount = 0; //1000
        int Ccount = 0; //100
        int Xcount = 0; //10
        int Icount = 0; //1
        // can be used once
        int Dcount = 0; //500
        int ecount = 0; //400
        int Lcount = 0; //50
        int mcount = 0; //40
        int Vcount = 0; //5
        int wcount = 0; //4

        int i = 0;
        int arabic = 0;

        if (isNumeric(number)) {
            arabic = Integer.parseInt(number);
            try {
                Integer arabicNum = Integer.parseInt(number);
                if (arabicNum < 1 || arabicNum >= 4332) {
                    badArabNum = true;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        else {
            //number is an elbonian
            for (i = 0; i < number.length() ; i++) {
                if (number.charAt(i) == 'M') {
                    Mcount+=1;
                }
                if (number.charAt(i) == 'C') {
                    Ccount+=1;
                }
                if (number.charAt(i) == 'X') {
                    Xcount+=1;
                }
                if (number.charAt(i) == 'I') {
                    Icount+=1;
                }
                if (number.charAt(i) == 'D') {
                    Dcount+=1;
                }
                if (number.charAt(i) == 'e') {
                    ecount+=1;
                }
                if (number.charAt(i) == 'L') {
                    Lcount+=1;
                }
                if (number.charAt(i) == 'm') {
                    mcount+=1;
                }
                if (number.charAt(i) == 'V') {
                    Vcount+=1;
                }
                if (number.charAt(i) == 'w') {
                    wcount+=1;
                }
            }
            if (Mcount > 3 || Ccount > 3 ||  Xcount > 3 || Icount>3 || Dcount > 1 || ecount > 1 || Lcount > 1 || mcount > 1 || Vcount > 1 || wcount > 1){
                badElbNum = true;
            }
        }






 /*       int number_check = this.toArabic();
        if (number.equals(Integer.toString(number_check))){
            badElbNum = true;
        }

        if (!elbonianNum.matches("MCXIDeLmVw")){
            badElbNum = true;
        }*/



        if (badArabNum == true) {
            throw new ValueOutOfBoundsException("Number is out of range");
        }
        if (badElbNum == true) {
            throw new MalformedNumberException("String is not in correct Elbonian format");
        }

        this.number = number;

    }

    public String getNumber() {
        return number;
    }

    /**
     * Converts the number to an Arabic numeral or returns the current value as an int if it is already
     * in the Arabic form.
     *
     * @return An arabic value
     */
    public static boolean isNumeric(String str) {
        int size = str.length();
        for (int i = 0; i<size; i++) {
                if (!Character.isDigit(str.charAt(i))){
                    return false;
            }
        }
        return true;
    }
    public int toArabic(){
        // TODO Fill in the method's body
        if (isNumeric(number)){
            return Integer.parseInt(number);
        }
        else {
            int t = 0;
            int M = 1000;
            int C = 100;
            int X = 10;
            int I = 1;
            int D = 500;
            int L = 50;
            int V = 5;
            int e = 400;
            int m = 40;
            int w = 4;

            for (int i = 0; i < number.length(); i++) {
                if (number.charAt(i) == 'M') {
                    t += M;
                }
                if (number.charAt(i) == 'C') {
                    t += C;
                }
                if (number.charAt(i) == 'X') {
                    t += X;
                }
                if (number.charAt(i) == 'I') {
                    t += I;
                }
                if (number.charAt(i) == 'D') {
                    t += D;
                }
                if (number.charAt(i) == 'L') {
                    t += L;
                }
                if (number.charAt(i) == 'V') {
                    t += V;
                }
                if (number.charAt(i) == 'e') {
                    t += e;
                }
                if (number.charAt(i) == 'm') {
                    t += m;
                }
                if (number.charAt(i) == 'w') {
                    t += w;

                }
            }
            return t;
        }
    }

    /**
     * Converts the number to an Elbonian numeral or returns the current value if it is already in the Elbonian form.
     *
     * @return An Elbonian value
     */
    public String toElbonian() {
        // TODO Fill in the method's body

        if (!isNumeric(number)){
            return number;
        }
        else {
            int number2 = Integer.parseInt(number);
            String s = "";
            while (number2 >= 1000) {
                s += "M";
                number2 -= 1000;
            }
            while (number2 >= 500) {
                s += "D";
                number2 -= 500;
            }
            while (number2 >= 400) {
                s += "e";
                number2 -= 400;
            }
            while (number2 >= 100) {
                s += "C";
                number2 -= 100;
            }
            while (number2 >= 50) {
                s += "L";
                number2 -= 50;
            }
            while (number2 >= 40) {
                s += "m";
                number2 -= 40;
            }
            while (number2 >= 10) {
                s += "X";
                number2 -= 10;
            }
            while (number2 >= 5) {
                s += "V";
                number2 -= 5;
            }
            while (number2 >= 4) {
                s += "w";
                number2 -= 4;
            }
            while (number2 >= 1) {
                s += "I";
                number2 -= 1;
            }

            return s;
        }
    }
}
