package converter.tests;

import converter.ElbonianArabicConverter;
import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for the ElbonianArabicConverter class.
 */
public class ConverterTests {

    @Test
    public void ElbonianToArabicSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1");
        assertEquals(converter.toElbonian(), "I");
    }

    @Test
    public void ArabicToElbonianSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("I");
        assertEquals(converter.toArabic(), 1);
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("TEST");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new ValueOutOfBoundsException("TEST");
    }

//OUR TESTS
    @Test
    public void OurElbonianToArabicSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("3000");
        assertEquals(converter.toElbonian(), "MMM");
        ElbonianArabicConverter converter1 = new ElbonianArabicConverter("3500");
        assertEquals(converter1.toElbonian(), "MMMD");
        ElbonianArabicConverter converter2 = new ElbonianArabicConverter("345");
        assertEquals(converter2.toElbonian(), "CCCmV");
        ElbonianArabicConverter converter3 = new ElbonianArabicConverter("678");
        assertEquals(converter3.toElbonian(), "DCLXXVIII");
        ElbonianArabicConverter converter4 = new ElbonianArabicConverter("24");
        assertEquals(converter4.toElbonian(), "XXw");
        ElbonianArabicConverter converter5 = new ElbonianArabicConverter("3");
        assertEquals(converter5.toElbonian(), "III");
        ElbonianArabicConverter converter6 = new ElbonianArabicConverter("2030");
        assertEquals(converter6.toElbonian(), "MMXXX");
    }

    @Test
    public void OurArabicToElbonianSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("III");
        assertEquals(converter.toArabic(), 3);
        ElbonianArabicConverter converter1 = new ElbonianArabicConverter("MMM");
        assertEquals(converter1.toArabic(), 3000);
        ElbonianArabicConverter converter2 = new ElbonianArabicConverter("MDC");
        assertEquals(converter2.toArabic(), 1600);
        ElbonianArabicConverter converter3 = new ElbonianArabicConverter("LmXX");
        assertEquals(converter3.toArabic(), 110);
        ElbonianArabicConverter converter4 = new ElbonianArabicConverter("CXI");
        assertEquals(converter4.toArabic(), 111);
        ElbonianArabicConverter converter5 = new ElbonianArabicConverter("emw");
        assertEquals(converter5.toArabic(), 444);
        ElbonianArabicConverter converter6 = new ElbonianArabicConverter("DLV");
        assertEquals(converter6.toArabic(), 555);
        ElbonianArabicConverter converter7 = new ElbonianArabicConverter("MCXI");
        assertEquals(converter7.toArabic(), 1111);
    }

    @Test(expected = MalformedNumberException.class)
    public void threeCountError() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMMMMM");
    }
    @Test(expected = MalformedNumberException.class)
    public void oneCountError() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("LLL");
    }

    @Test(expected = MalformedNumberException.class)
    public void outofOrder() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("Mwe");
    }

    @Test(expected = MalformedNumberException.class)
    public void wrongLetter() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("WonG");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void negativeNumber() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("-100");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void outofRangeTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("10000000");
    }

    @Test(expected = MalformedNumberException.class)
    public void ourMalformedTests() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter1 = new ElbonianArabicConverter("P");
        ElbonianArabicConverter converter2 = new ElbonianArabicConverter("PLOP");
        ElbonianArabicConverter converter3 = new ElbonianArabicConverter("MMMMM");
        ElbonianArabicConverter converter4 = new ElbonianArabicConverter("MMDXX");
        ElbonianArabicConverter converter5 = new ElbonianArabicConverter("XXMM");
        ElbonianArabicConverter converter6 = new ElbonianArabicConverter("IwVmLXM");
        ElbonianArabicConverter converter7 = new ElbonianArabicConverter("MeM");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void ourValueOutOfBoundsTests() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter1 = new ElbonianArabicConverter("5000");
        ElbonianArabicConverter converter2 = new ElbonianArabicConverter("0");
        ElbonianArabicConverter converter3 = new ElbonianArabicConverter("-10");
        ElbonianArabicConverter converter4 = new ElbonianArabicConverter("-M");
        ElbonianArabicConverter converter5 = new ElbonianArabicConverter("WonG");
        ElbonianArabicConverter converter6 = new ElbonianArabicConverter("100000");
        ElbonianArabicConverter converter7 = new ElbonianArabicConverter("-876657");
    }

    @Test
    public void ElbonianSingleLetters() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("I");
        assertEquals(converter.toArabic(), 1);
        converter = new ElbonianArabicConverter("V");
        assertEquals(converter.toArabic(), 5);
        converter = new ElbonianArabicConverter("w");
        assertEquals(converter.toArabic(), 4);
        converter = new ElbonianArabicConverter("X");
        assertEquals(converter.toArabic(), 10);
        converter = new ElbonianArabicConverter("L");
        assertEquals(converter.toArabic(), 50);
        converter = new ElbonianArabicConverter("m");
        assertEquals(converter.toArabic(), 40);
        converter = new ElbonianArabicConverter("C");
        assertEquals(converter.toArabic(), 100);
        converter = new ElbonianArabicConverter("D");
        assertEquals(converter.toArabic(), 500);
        converter = new ElbonianArabicConverter("e");
        assertEquals(converter.toArabic(), 400);
        converter = new ElbonianArabicConverter("M");
        assertEquals(converter.toArabic(), 1000);
    }

    @Test
    public void ArabicSingleLetters() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1");
        assertEquals(converter.toElbonian(), "I");
        converter = new ElbonianArabicConverter("5");
        assertEquals(converter.toElbonian(), "V");
        converter = new ElbonianArabicConverter("4");
        assertEquals(converter.toElbonian(), "w");
        converter = new ElbonianArabicConverter("10");
        assertEquals(converter.toElbonian(), "X");
        converter = new ElbonianArabicConverter("50");
        assertEquals(converter.toElbonian(), "L");
        converter = new ElbonianArabicConverter("40");
        assertEquals(converter.toElbonian(), "m");
        converter = new ElbonianArabicConverter("100");
        assertEquals(converter.toElbonian(), "C");
        converter = new ElbonianArabicConverter("500");
        assertEquals(converter.toElbonian(), "D");
        converter = new ElbonianArabicConverter("400");
        assertEquals(converter.toElbonian(), "e");
        converter = new ElbonianArabicConverter("1000");
        assertEquals(converter.toElbonian(), "M");
    }
}


