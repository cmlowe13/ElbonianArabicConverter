package converter;

import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;

/**
 * This class implements a converter that takes a string that represents a number in either the
 * Elbonian or Arabic numeral form. This class has methods that will return a value in the chosen form.
 *
 * @version 3/18/17
 */
public class ElbonianArabicConverter {

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
        this.number = number;
       // this.anumber = anumber;
    }

    /**
     * Converts the number to an Arabic numeral or returns the current value as an int if it is already
     * in the Arabic form.
     *
     * @return An arabic value
     */
    public int toArabic(String number) {
        // TODO Fill in the method's body
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

        if ()
        return 1;
    }

    /**
     * Converts the number to an Elbonian numeral or returns the current value if it is already in the Elbonian form.
     *
     * @return An Elbonian value
     */
    public String toElbonian(int number) {
        // TODO Fill in the method's body
        String s = "";
        if (number < 1 || number >= 4332){
            //  throw new ValueOutOfBoundsException;
            return "Invalid input. Must be between 1 and 3999";
        }
        else{
            //can be used three times
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

            while (number >= 1000 && Mcount < 3) {
                s+="M";
                number-=1000;
                Mcount+=1;
            }
            while (number >= 500 && Dcount < 1) {
                s+="D";
                number-=500;
                Dcount+=1;
            }
            while (number >= 400 && ecount < 1) {
                s+="e";
                number-=400;
                ecount+=1;
            }
            while (number >= 100 && Ccount < 3) {
                s+="C";
                number-=100;
                Ccount+=1;
            }
            while (number >= 50 && Lcount < 1) {
                s+="L";
                number-=50;
                Lcount+=1;
            }
            while (number >= 40 && mcount < 1) {
                s+="m";
                number-=40;
                mcount+=1;
            }
            while (number >= 10 && Xcount < 3) {
                s+="X";
                number-=10;
                Xcount+=1;
            }
            while (number >= 5 && Vcount < 1) {
                s+="V";
                number-=5;
                Vcount+=1;
            }
            while (number >= 4 && wcount < 1) {
                s+="w";
                number-=4;
                wcount+=1;
            }
            while (number >= 1 && Icount < 3) {
                s+="I";
                number-=1;
                Icount+=1;
            }

        }
        return s;
    }

}
