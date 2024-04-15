// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.lang.Number;
import java.util.*;
import javax.swing.*;

public class TrainingRecordGUI extends JFrame implements ActionListener {

  private JTextField name = new JTextField(30);
  private JTextField day = new JTextField(2);
  private JTextField month = new JTextField(2);
  private JTextField year = new JTextField(4);
  private JTextField hours = new JTextField(2);
  private JTextField mins = new JTextField(2);
  private JTextField secs = new JTextField(2);
  private JTextField dist = new JTextField(4);
  private JLabel labn = new JLabel(" Name:");
  private JLabel labd = new JLabel(" Day:");
  private JLabel labm = new JLabel(" Month:");
  private JLabel laby = new JLabel(" Year:");
  private JLabel labh = new JLabel(" Hours:");
  private JLabel labmm = new JLabel(" Mins:");
  private JLabel labs = new JLabel(" Secs:");
  private JLabel labdist = new JLabel(" Distance (km):");
  private JButton addR = new JButton("Add");
  private JButton lookUpByDate = new JButton("Look Up");
  private JButton findAllByDate = new JButton("Find All");

  private TrainingRecord myAthletes = new TrainingRecord();

  private JTextArea outputArea = new JTextArea(5, 50);

  public static void main(String[] args) {
    TrainingRecordGUI applic = new TrainingRecordGUI();
  } // main

  // set up the GUI
  public TrainingRecordGUI() {
    // The below code has been modified to make the interface accessible to
    // screen readers. This was necessary so that I could use the application
    // while developing it. Feel free to adopt the changes into this project for
    // next year!
    super("Training Record");
    setLayout(new FlowLayout());
    add(labn);
    add(name);
    name.setEditable(true);
    labn.setLabelFor(name);
    add(labd);
    add(day);
    day.setEditable(true);
    labd.setLabelFor(day);
    add(labm);
    add(month);
    month.setEditable(true);
    labm.setLabelFor(month);
    add(laby);
    add(year);
    year.setEditable(true);
    laby.setLabelFor(year);
    add(labh);
    add(hours);
    hours.setEditable(true);
    labh.setLabelFor(hours);
    add(labmm);
    add(mins);
    mins.setEditable(true);
    labmm.setLabelFor(mins);
    add(labs);
    add(secs);
    secs.setEditable(true);
    labs.setLabelFor(secs);
    add(labdist);
    add(dist);
    dist.setEditable(true);
    labdist.setLabelFor(dist);
    add(addR);
    addR.setMnemonic(KeyEvent.VK_A);
    addR.addActionListener(this);
    add(lookUpByDate);
    lookUpByDate.setMnemonic(KeyEvent.VK_L);
    lookUpByDate.addActionListener(this);
    add(findAllByDate);
    findAllByDate.setMnemonic(KeyEvent.VK_F);
    findAllByDate.addActionListener(this);
    add(outputArea);
    outputArea.setEditable(false);
    outputArea.getAccessibleContext().setAccessibleName("Output area");
    setSize(720, 200);
    setVisible(true);
    blankDisplay();

    // To save typing in new entries while testing, uncomment
    // the following lines (or add your own test cases)

  } // constructor

  // listen for and respond to GUI events
  public void actionPerformed(ActionEvent event) {
    String message = "";
    if (event.getSource() == addR) {
      message = addEntry("generic");
    } else if (event.getSource() == lookUpByDate) {
      message = lookupEntry();
    } else if (event.getSource() == findAllByDate) {
      message = findAllEntries();
    }
    outputArea.setText(message);
    blankDisplay();
  } // actionPerformed

  public String addEntry(String what) {
    String message = "Record added\n";
    System.out.println("Adding " + what + " entry to the records");

    // Get and validate name
    String n = name.getText();
    if (n.isEmpty()) {
      return "Invalid input: Name is required";
    }

    // Get and validate numeric fields
    int m, d, y;
    float km;
    int h, mm, s;
    try {
      m = Integer.parseInt(month.getText());
      d = Integer.parseInt(day.getText());
      y = Integer.parseInt(year.getText());
      km = java.lang.Float.parseFloat(dist.getText());
      h = Integer.parseInt(hours.getText());
      mm = Integer.parseInt(mins.getText());
      s = Integer.parseInt(secs.getText());
    } catch (NumberFormatException e) {
      return "Input is not a number: " + e.getLocalizedMessage();
    }

    // Check for uniqueness
    Entry e = myAthletes.findExactEntry(n, d, m, y);
    if (e != null) {
      // An entry already exists
      return "Record already added!\n" + e.getEntry();
    }

    e = new Entry(n, d, m, y, h, mm, s, km);
    myAthletes.addEntry(e);
    return message;
  }

  public String lookupEntry() {
    int m, d, y;
    try {
      m = Integer.parseInt(month.getText());
      d = Integer.parseInt(day.getText());
      y = Integer.parseInt(year.getText());
    } catch (NumberFormatException e) {
      return "Input is not a number: " + e.getLocalizedMessage();
    }
    outputArea.setText("looking up record ...");
    String message = myAthletes.lookupEntry(d, m, y);
    return message;
  }

  public String findAllEntries() {
    int m, d, y;
    try {
      m = Integer.parseInt(month.getText());
      d = Integer.parseInt(day.getText());
      y = Integer.parseInt(year.getText());
    } catch (NumberFormatException e) {
      return "Input is not a number: " + e.getLocalizedMessage();
    }
    outputArea.setText("looking up record[s] ...");
    String message = myAthletes.findAllEntries(d, m, y);
    return message;
  }

  public void blankDisplay() {
    name.setText("");
    day.setText("");
    month.setText("");
    year.setText("");
    hours.setText("");
    mins.setText("");
    secs.setText("");
    dist.setText("");

  } // blankDisplay
  // Fills the input fields on the display for testing purposes only
  public void fillDisplay(Entry ent) {
    name.setText(ent.getName());
    day.setText(String.valueOf(ent.getDay()));
    month.setText(String.valueOf(ent.getMonth()));
    year.setText(String.valueOf(ent.getYear()));
    hours.setText(String.valueOf(ent.getHour()));
    mins.setText(String.valueOf(ent.getMin()));
    secs.setText(String.valueOf(ent.getSec()));
    dist.setText(String.valueOf(ent.getDistance()));
  }

} // TrainingRecordGUI
