/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stir.cscu9t4practical1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 *
 * @author saemundur
 */
public class RunEntryTest {

  public RunEntryTest() {}

  @BeforeAll
  public static void setUpClass() {}

  @AfterAll
  public static void tearDownClass() {}

  @BeforeEach
  public void setUp() {}

  @AfterEach
  public void tearDown() {}

  /**
   * Test of getName method, of class RunEntry.
   */
  @Test
  public void testGetName() {
    System.out.println("getName");
    RunEntry instance = new RunEntry("Alice", 1, 2, 2003, 0, 16, 7, 3);
    String expResult = "Alice";
    String result = instance.getName();
    assertEquals(expResult, result);
  }

  /**
   * Test of getDay method, of class RunEntry.
   */
  @Test
  public void testGetDay() {
    System.out.println("getDay");
    RunEntry instance = new RunEntry("Alice", 1, 2, 2003, 0, 16, 7, 3);
    int expResult = 1;
    int result = instance.getDay();
    assertEquals(expResult, result);
  }

  /**
   * Test of getMonth method, of class RunEntry.
   */
  @Test
  public void testGetMonth() {
    System.out.println("getMonth");
    RunEntry instance = new RunEntry("Alice", 1, 2, 2003, 0, 16, 7, 3);
    int expResult = 2;
    int result = instance.getMonth();
    assertEquals(expResult, result);
  }

  /**
   * Test of getYear method, of class RunEntry.
   */
  @Test
  public void testGetYear() {
    System.out.println("getYear");
    RunEntry instance = new RunEntry("Alice", 1, 2, 2003, 0, 16, 7, 3);
    int expResult = 2003;
    int result = instance.getYear();
    assertEquals(expResult, result);
  }

  /**
   * Test of getHour method, of class RunEntry.
   */
  @Test
  public void testGetHour() {
    System.out.println("getHour");
    RunEntry instance = new RunEntry("Alice", 1, 2, 2003, 0, 16, 7, 3);
    int expResult = 0;
    int result = instance.getHour();
    assertEquals(expResult, result);
  }

  /**
   * Test of getMin method, of class RunEntry.
   */
  @Test
  public void testGetMin() {
    System.out.println("getMin");
    RunEntry instance = new RunEntry("Alice", 1, 2, 2003, 0, 16, 7, 3);
    int expResult = 16;
    int result = instance.getMin();
    assertEquals(expResult, result);
  }

  /**
   * Test of getSec method, of class RunEntry.
   */
  @Test
  public void testGetSec() {
    System.out.println("getSec");
    RunEntry instance = new RunEntry("Alice", 1, 2, 2003, 0, 16, 7, 3);
    int expResult = 7;
    int result = instance.getSec();
    assertEquals(expResult, result);
  }

  /**
   * Test of getDistance method, of class RunEntry.
   */
  @Test
  public void testGetDistance() {
    System.out.println("getDistance");
    RunEntry instance = new RunEntry("Alice", 1, 2, 2003, 0, 16, 7, 3);
    float expResult = 3.0F;
    float result = instance.getDistance();
    assertEquals(expResult, result, 0.0);
  }

  /**
   * Test of getEntry method, of class RunEntry.
   */
  @Test
  public void testGetEntry() {
    System.out.println("getEntry");
    RunEntry instance = new RunEntry("Alice", 1, 2, 2003, 0, 16, 7, 3);
    String expResult = "Alice ran 3.00000 km in 00:16:07 on 01/02/2003\n";
    String result = instance.getEntry();
    assertEquals(expResult, result);
  }
}
