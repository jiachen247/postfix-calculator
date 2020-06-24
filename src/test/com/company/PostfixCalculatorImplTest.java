package test.com.company; 

import com.company.PostfixCalculator;
import com.company.PostfixCalculatorImpl;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 


public class PostfixCalculatorImplTest {
    PostfixCalculator calculator = new PostfixCalculatorImpl();

    @Test
    public void testParse() throws Exception {

        assert(calculator.parse("1 2\t + ") ==  3);
        assert(calculator.parse("10\t\t20 -") == -10);
        assert(calculator.parse(" -2 -3 *") == 6);
        assert(calculator.parse(" -1    i") ==  0);
        assert(calculator.parse("10 d\t") == 9);
        assert(calculator.parse("1 2 + 4 5 - * 3 + i d d i i") == 1);

    }
} 
