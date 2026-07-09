package com.mmcoe.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;

public class TestLifeCycle {
	private List<String> items;
	
	@BeforeAll
    public static void BeforeAll(){
        System.out.println("Before All Executed");
    }

    @AfterAll
    public static void AfterAll(){
        System.out.println("After All Executed");
    }

    @BeforeEach
    public void init(){
        items=new ArrayList<>();
        System.out.println("Before Each Executed");
    }

    @AfterEach
    public void clean(){
        items=null;
        System.out.println("After Each Executed");
    }

    @Test
    public void testEmptyList(){
        assertTrue(items.isEmpty());
    }

    @Test
    public void testOneItem(){
        items.add("Apple");
        
        assertEquals(1, items.size());
    }
}