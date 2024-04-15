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
public class SwimEntryTest {

  public SwimEntryTest() {}

  @BeforeAll
  public static void setUpClass() {}

  @AfterAll
  public static void tearDownClass() {}

  @BeforeEach
  public void setUp() {}

  @AfterEach
  public void tearDown() {}

  /**
   * Test of getName method, of class SwimEntry.
   */
  @Test
  public void testGetName() {
    System.out.println("getName");
    SwimEntry instance = new SwimEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, true);
    String expResult = "Alice";
    String result = instance.getName();
    assertEquals(expResult, result);
  }

  /**
   * Test of getDay method, of class SwimEntry.
   */
  @Test
  public void testGetDay() {
    System.out.println("getDay");
    SwimEntry instance = new SwimEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, false);
    int expResult = 1;
    int result = instance.getDay();
    assertEquals(expResult, result);
  }

  /**
   * Test of getMonth method, of class SwimEntry.
   */
  @Test
  public void testGetMonth() {
    System.out.println("getMonth");
    SwimEntry instance = new SwimEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, true);
    int expResult = 2;
    int result = instance.getMonth();
    assertEquals(expResult, result);
  }

  /**
   * Test of getYear method, of class SwimEntry.
   */
  @Test
  public void testGetYear() {
    System.out.println("getYear");
    SwimEntry instance = new SwimEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, false);
    int expResult = 2003;
    int result = instance.getYear();
    assertEquals(expResult, result);
  }

  /**
   * Test of getHour method, of class SwimEntry.
   */
  @Test
  public void testGetHour() {
    System.out.println("getHour");
    SwimEntry instance = new SwimEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, false);
    int expResult = 0;
    int result = instance.getHour();
    assertEquals(expResult, result);
  }

  /**
   * Test of getMin method, of class SwimEntry.
   */
  @Test
  public void testGetMin() {
    System.out.println("getMin");
    SwimEntry instance = new SwimEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, false);
    int expResult = 16;
    int result = instance.getMin();
    assertEquals(expResult, result);
  }

  /**
   * Test of getSec method, of class SwimEntry.
   */
  @Test
  public void testGetSec() {
    System.out.println("getSec");
    SwimEntry instance = new SwimEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, false);
    int expResult = 7;
    int result = instance.getSec();
    assertEquals(expResult, result);
  }

  /**
   * Test of getDistance method, of class SwimEntry.
   */
  @Test
  public void testGetDistance() {
    System.out.println("getDistance");
    SwimEntry instance = new SwimEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, false);
    float expResult = 3.0F;
    float result = instance.getDistance();
    assertEquals(expResult, result, 0.0);
  }

  /**
   * Test of getInPool method, of class SwimEntry
   */
  @Test
  public void testGetInPool() {
    System.out.println("getInPool");
    SwimEntry instanceA = new SwimEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, true);
    Boolean expResultA = true;
    Boolean result = instanceA.getInPool();
    assertEquals(expResultA, result);

    SwimEntry instanceB =
        new SwimEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, false);
    Boolean expResultB = false;
    result = instanceB.getInPool();
    assertEquals(expResultB, result);
  }
  /**
   * Test of getEntry method, of class SwimEntry.
   */
  @Test
  public void testGetEntry() {
    System.out.println("getEntry");
    SwimEntry instance = new SwimEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, true);
    String expResult =
        "Alice swam 3.00000 km in indoor pool in 00:16:07 on 01/02/2003\n";
    String result = instance.getEntry();
    assertEquals(expResult, result);
  }
}
