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
public class EntryTest {

  public EntryTest() {}

  @BeforeAll
  public static void setUpClass() {}

  @AfterAll
  public static void tearDownClass() {}

  @BeforeEach
  public void setUp() {}

  @AfterEach
  public void tearDown() {}

  /**
   * Test of getName method, of class Entry.
   */
  @Test
  public void testGetName() {
    System.out.println("getName");
    Entry instance = new Entry("Alice", 1, 2, 2003, 0, 16, 7);
    String expResult = "Alice";
    String result = instance.getName();
    assertEquals(expResult, result);
  }

  /**
   * Test of getDay method, of class Entry.
   */
  @Test
  public void testGetDay() {
    System.out.println("getDay");
    Entry instance = new Entry("Alice", 1, 2, 2003, 0, 16, 7);
    int expResult = 1;
    int result = instance.getDay();
    assertEquals(expResult, result);
  }

  /**
   * Test of getMonth method, of class Entry.
   */
  @Test
  public void testGetMonth() {
    System.out.println("getMonth");
    Entry instance = new Entry("Alice", 1, 2, 2003, 0, 16, 7);
    int expResult = 2;
    int result = instance.getMonth();
    assertEquals(expResult, result);
  }

  /**
   * Test of getYear method, of class Entry.
   */
  @Test
  public void testGetYear() {
    System.out.println("getYear");
    Entry instance = new Entry("Alice", 1, 2, 2003, 0, 16, 7);
    int expResult = 2003;
    int result = instance.getYear();
    assertEquals(expResult, result);
  }

  /**
   * Test of getHour method, of class Entry.
   */
  @Test
  public void testGetHour() {
    System.out.println("getHour");
    Entry instance = new Entry("Alice", 1, 2, 2003, 0, 16, 7);
    int expResult = 0;
    int result = instance.getHour();
    assertEquals(expResult, result);
  }

  /**
   * Test of getMin method, of class Entry.
   */
  @Test
  public void testGetMin() {
    System.out.println("getMin");
    Entry instance = new Entry("Alice", 1, 2, 2003, 0, 16, 7);
    int expResult = 16;
    int result = instance.getMin();
    assertEquals(expResult, result);
  }

  /**
   * Test of getSec method, of class Entry.
   */
  @Test
  public void testGetSec() {
    System.out.println("getSec");
    Entry instance = new Entry("Alice", 1, 2, 2003, 0, 16, 7);
    int expResult = 7;
    int result = instance.getSec();
    assertEquals(expResult, result);
  }

  /**
   * Test of getEntry method, of class Entry.
   */
  @Test
  public void testGetEntry() {
    System.out.println("getEntry");
    Entry instance = new Entry("Alice", 1, 2, 2003, 0, 16, 7);
    String expResult = "Alice trained for 00:16:07 on 01/02/2003\n";
    String result = instance.getEntry();
    assertEquals(expResult, result);
  }
}
