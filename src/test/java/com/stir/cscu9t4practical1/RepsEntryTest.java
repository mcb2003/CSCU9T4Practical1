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
public class RepsEntryTest {

  public RepsEntryTest() {}

  @BeforeAll
  public static void setUpClass() {}

  @AfterAll
  public static void tearDownClass() {}

  @BeforeEach
  public void setUp() {}

  @AfterEach
  public void tearDown() {}

  /**
   * Test of getName method, of class RepsEntry.
   */
  @Test
  public void testGetName() {
    System.out.println("getName");
    RepsEntry instance =
        new RepsEntry("Alice", 1, 2, 2003, 0, 16, 7, 300, 4, 2);
    String expResult = "Alice";
    String result = instance.getName();
    assertEquals(expResult, result);
  }

  /**
   * Test of getDay method, of class RepsEntry.
   */
  @Test
  public void testGetDay() {
    System.out.println("getDay");
    RepsEntry instance =
        new RepsEntry("Alice", 1, 2, 2003, 0, 16, 7, 300, 4, 2);
    int expResult = 1;
    int result = instance.getDay();
    assertEquals(expResult, result);
  }

  /**
   * Test of getMonth method, of class RepsEntry.
   */
  @Test
  public void testGetMonth() {
    System.out.println("getMonth");
    RepsEntry instance =
        new RepsEntry("Alice", 1, 2, 2003, 0, 16, 7, 300, 4, 2);
    int expResult = 2;
    int result = instance.getMonth();
    assertEquals(expResult, result);
  }

  /**
   * Test of getYear method, of class RepsEntry.
   */
  @Test
  public void testGetYear() {
    System.out.println("getYear");
    RepsEntry instance =
        new RepsEntry("Alice", 1, 2, 2003, 0, 16, 7, 300, 4, 2);
    int expResult = 2003;
    int result = instance.getYear();
    assertEquals(expResult, result);
  }

  /**
   * Test of getHour method, of class RepsEntry.
   */
  @Test
  public void testGetHour() {
    System.out.println("getHour");
    RepsEntry instance =
        new RepsEntry("Alice", 1, 2, 2003, 0, 16, 7, 300, 4, 2);
    int expResult = 0;
    int result = instance.getHour();
    assertEquals(expResult, result);
  }

  /**
   * Test of getMin method, of class RepsEntry.
   */
  @Test
  public void testGetMin() {
    System.out.println("getMin");
    RepsEntry instance =
        new RepsEntry("Alice", 1, 2, 2003, 0, 16, 7, 300, 4, 2);
    int expResult = 16;
    int result = instance.getMin();
    assertEquals(expResult, result);
  }

  /**
   * Test of getSec method, of class RepsEntry.
   */
  @Test
  public void testGetSec() {
    System.out.println("getSec");
    RepsEntry instance =
        new RepsEntry("Alice", 1, 2, 2003, 0, 16, 7, 300, 4, 2);
    int expResult = 7;
    int result = instance.getSec();
    assertEquals(expResult, result);
  }

  /**
   * Test of getDistance method, of class RepsEntry.
   */
  @Test
  public void testGetDistance() {
    System.out.println("getDistance");
    RepsEntry instance =
        new RepsEntry("Alice", 1, 2, 2003, 0, 16, 7, 300, 4, 2);
    float expResult = 300;
    float result = instance.getDistance();
    assertEquals(expResult, result, 0.0);
  }

  /**
   * Test of getRepDistance method of class RepsEntry
   */
  @Test
  public void testGetRepDistance() {
    System.out.println("getRepDistance");
    RepsEntry instance =
        new RepsEntry("Alice", 1, 2, 2003, 0, 16, 7, 300, 4, 2);
    float expResult = 4;
    float result = instance.getRepDistance();
    assertEquals(expResult, result);
  }

  /**
   * Test of getNumReps method of class RepsEntry
   */
  @Test
  public void testGetNumReps() {
    System.out.println("getNumReps");
    RepsEntry instance =
        new RepsEntry("Alice", 1, 2, 2003, 0, 16, 7, 300, 4, 2);
    float expResult = 75.0f;
    float result = instance.getNumReps();
    assertEquals(expResult, result);
  }

  /**
   * Test of getRecovery method of class RepsEntry
   */
  @Test
  public void testGetRecovery() {
    System.out.println("getRecovery");
    RepsEntry instance =
        new RepsEntry("Alice", 1, 2, 2003, 0, 16, 7, 300, 4, 2);
    int expResult = 2;
    int result = instance.getRecovery();
    assertEquals(expResult, result);
  }

  /**
   * Test of getEntry method, of class RepsEntry.
   */
  @Test
  public void testGetEntry() {
    System.out.println("getEntry");
    RepsEntry instance =
        new RepsEntry("Alice", 1, 2, 2003, 0, 16, 7, 300, 4, 2);
    String expResult =
        "Alice ran 75.0000 4.00000 km reps = 300.000 km, with 2 mins recovery, in 00:16:07 on 01/02/2003\n";
    String result = instance.getEntry();
    assertEquals(expResult, result);
  }
}
