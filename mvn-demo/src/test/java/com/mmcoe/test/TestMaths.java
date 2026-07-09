package com.mmcoe.test;
import static org.junit.jupiter.api.Assertions.*;
import com.mmcoe.pojo.Maths;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestMaths {
    private static Maths m;
    @BeforeAll
    public static void init(){
        m=new Maths();
    }

    @Test
    public void testAdd(){
        assertEquals(10, m.add(5, 5));
    }

    @Test
    public void testSubstract(){
        assertEquals(5, m.substract(10, 5));
    }

    @Test
    public void testDiv(){
        assertEquals(2, m.div(10, 5));
    }

    @Test
    public void testDivByZero(){
        assertThrows(ArithmeticException.class, () -> m.div(10, 0));
    }
}
