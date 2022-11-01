import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class StringCalculatorTest {

    public StringCalculator stringCalculator = new StringCalculator();
    //Un string vacio retorna cero

    @Test
    public void emptyStringTest() throws Exception {
        assertEquals(stringCalculator.add(""),0);
    }

    // Un solo número devuelve el valor
    @Test
    public void singleNumberReturnItsValueTest() throws Exception {
        assertEquals(stringCalculator.add("2"), 2);
        assertEquals(stringCalculator.add("1"), 1);
    }

    //Dos números, delimitados por comas, devuelven la suma
    @Test
    public void twoNumbersCommaDelimitedReturnsTheSumTest() throws Exception {
        assertEquals(stringCalculator.add("0,2"), 2);
        assertEquals(stringCalculator.add("1,1"), 2);
        assertEquals(stringCalculator.add("1,2"), 3);
    }

    // Dos números, delimitados por saltos de línea, devuelve la suma
    @Test
    public void sameThatBeforeButNewLineDelimitedTest() throws Exception {
        assertEquals(stringCalculator.add("0\n2"), 2);
        assertEquals(stringCalculator.add("1\n1"), 2);
        assertEquals(stringCalculator.add("1\n2"), 3);
    }

    // Tres números, delimitados de cualquier manera, devuelven la suma
    @Test
    public void sameThatBeforeButAllDelimitersWorksTest() throws Exception {
        assertEquals(stringCalculator.add("1\n2,3"), 6);
        assertEquals(stringCalculator.add("1,2\n4"), 7);
    }

    // Los números negativos arrojan una excepción
    @Test()
    public void negativeNumbersThrowsAnExceptionTest() throws Exception {
        Exception exception = assertThrows(Exception.class, () ->{
            stringCalculator.add("-1,-1");
        });
    }

    // Los números superiores a 1000 se ignoran
    @Test
    public void greaterThan1000AreIgnoredTest() throws Exception {
        assertEquals(stringCalculator.add("2,1000"), 1002);
        assertEquals(stringCalculator.add("2,1001"), 2);
    }

    // Se puede definir un solo delimitador de caracteres en la primera línea
    @Test
    public void singleCharDelimiterTest() throws Exception {
        assertEquals(stringCalculator.add("#2#1000"), 1002);
    }


}
