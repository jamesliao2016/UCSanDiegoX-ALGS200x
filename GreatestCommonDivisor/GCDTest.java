package main.java.GreatestCommonDivisor;

import org.junit.Test;
import static org.junit.Assert.*;

public class GCDTest {
    GCD gcd = new GCD();

    @Test
    public void findGCD(){
        assertEquals(5, gcd.findGCD(5, 10));
        assertEquals(4,gcd.findGCD(8, 12));
        assertEquals(1, gcd.findGCD(18, 35));
        assertEquals(201, gcd.findGCD(53667, 25527) );
        assertEquals(151, gcd.findGCD(135749, 163231));
    }
}
