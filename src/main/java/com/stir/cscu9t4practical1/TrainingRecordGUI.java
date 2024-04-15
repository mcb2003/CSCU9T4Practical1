// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.lang.Number;
import java.util.*;
import javax.swing.*;

public class TrainingRecordGUI extends JFrame implements ActionListener {
  // Constants for Entry types
  private static final String GENERIC_ENTRY = "Generic";
  private static final String RUN_ENTRY = "Run";
  private static final String REPS_ENTRY = "Reps";
  private static final String CYCLE_ENTRY = "Cycle";
  private static final String SWIM_ENTRY = "Swim";

  // Global Entry fields
  private JPanel globalFields = new JPanel(new GridBagLayout());
  private JComboBox<String> entryType = new JComboBox<>(new String[] {
      GENERIC_ENTRY, RUN_ENTRY, REPS_ENTRY, CYCLE_ENTRY, SWIM_ENTRY});
  private JTextField name = new JTextField(30);
  private JTextField day = new JTextField(2);
  private JTextField month = new JTextField(2);
  private JTextField year = new JTextField(4);
  private JTextField hours = new JTextField(2);
  private JTextField mins = new JTextField(2);
  private JTextField secs = new JTextField(2);
  private JLabel labt = new JLabel("Entry Type:");
  private JLabel labn = new JLabel(" Name:");
  private JLabel labd = new JLabel(" Day:");
  private JLabel labm = new JLabel(" Month:");
  private JLabel laby = new JLabel(" Year:");
  private JLabel labh = new JLabel(" Hours:");
  private JLabel labmm = new JLabel(" Mins:");
  private JLabel labs = new JLabel(" Secs:");

  // Buttons that perform actions
  private JPanel actionsPanel = new JPanel(new FlowLayout());
  private JButton addR = new JButton("Add");
  private JButton lookUpByDate = new JButton("Look Up");
  private JButton findAllByDate = new JButton("Find All");
  private JButton findAllByName = new JButton("Find by Name");
  private JButton removeButton = new JButton("Remove");

  private TrainingRecord myAthletes = new TrainingRecord();

  // A deck of cards, one per Entry type, with options specific to that type
  // CardLayouts show only one child control at a time,. This one is controled
  // by the entryType combobox
  private JPanel cards = new JPanel(new CardLayout());

  // Options for Generic Entry (there aren't any)
  private JPanel genericCard = new JPanel();
  private JLabel genericCardMessage =
      new JLabel("No options specific to " + GENERIC_ENTRY + " Entry");

  // Options for run Entry
  private JPanel runCard = new JPanel(new GridBagLayout());
  private JTextField runTotalDist = new JTextField(4);
  private JLabel labrdist = new JLabel("Total Distance:");

  // Options for reps Entry
  private JPanel repsCard = new JPanel(new GridBagLayout());
  private JTextField repsTotalDist = new JTextField(4);
  private JTextField repDist = new JTextField(4);
  private JTextField recovery = new JTextField(2);
  private JLabel labrtdist = new JLabel("Total Distance:");
  private JLabel labrep = new JLabel("Rep Distance:");
  private JLabel labrec = new JLabel("Recovery Time (mins):");

  // Options for cycle Entry
  private JPanel cycleCard = new JPanel(new GridBagLayout());
  private JTextField cycleTotalDist = new JTextField(4);
  private JTextField cycleTerrain = new JTextField(20);
  private JTextField cycleTempo = new JTextField(4);
  private JLabel labcdist = new JLabel("Total Distance:");
  private JLabel labcterrain = new JLabel("Terrain:");
  private JLabel labctempo = new JLabel("Tempo (RPM):");

  // Options for swim Entry
  private JPanel swimCard = new JPanel(new GridBagLayout());
  private JTextField swimTotalDist = new JTextField(4);
  private JLabel labsdist = new JLabel("Total Distance:");
  private JCheckBox swimInPool = new JCheckBox("In Pool?");

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

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

    // Fields applicable to all Entry types
    globalFields.getAccessibleContext().setAccessibleName("Global Fields");
    addToGrid(globalFields, labt, entryType);
    entryType.addActionListener(this);
    addToGrid(globalFields, labn, name);
    name.setEditable(true);
    addToGrid(globalFields, labd, day);
    day.setEditable(true);
    addToGrid(globalFields, labm, month);
    month.setEditable(true);
    addToGrid(globalFields, laby, year);
    year.setEditable(true);
    addToGrid(globalFields, labh, hours);
    hours.setEditable(true);
    addToGrid(globalFields, labmm, mins);
    mins.setEditable(true);
    addToGrid(globalFields, labs, secs);
    secs.setEditable(true);
    add(globalFields);

    genericCardMessage.setFocusable(true);
    genericCard.add(genericCardMessage);
    addCard(genericCard, GENERIC_ENTRY);

    addToGrid(runCard, labrdist, runTotalDist);
    runTotalDist.setEditable(true);
    addCard(runCard, RUN_ENTRY);

    addToGrid(repsCard, labrtdist, repsTotalDist);
    repsTotalDist.setEditable(true);
    addToGrid(repsCard, labrep, repDist);
    repDist.setEditable(true);
    addToGrid(repsCard, labrec, recovery);
    recovery.setEditable(true);
    addCard(repsCard, REPS_ENTRY);

    addToGrid(cycleCard, labcdist, cycleTotalDist);
    cycleTotalDist.setEditable(true);
    addToGrid(cycleCard, labcterrain, cycleTerrain);
    cycleTerrain.setEditable(true);
    addToGrid(cycleCard, labctempo, cycleTempo);
    cycleTempo.setEditable(true);
    addCard(cycleCard, CYCLE_ENTRY);

    addToGrid(swimCard, labsdist, swimTotalDist);
    swimTotalDist.setEditable(true);
    // Add the checkbox
    GridBagConstraints c = new GridBagConstraints();
    c.gridx = 1;
    c.gridy = 1;
    swimCard.add(swimInPool, c);
    addCard(swimCard, SWIM_ENTRY);

    add(cards);

    actionsPanel.getAccessibleContext().setAccessibleName("Actions");
    actionsPanel.add(addR);
    addR.setMnemonic(KeyEvent.VK_A);
    addR.addActionListener(this);
    actionsPanel.add(lookUpByDate);
    lookUpByDate.setEnabled(false);
    lookUpByDate.setMnemonic(KeyEvent.VK_L);
    lookUpByDate.addActionListener(this);
    actionsPanel.add(findAllByDate);
    findAllByDate.setEnabled(false);
    findAllByDate.setMnemonic(KeyEvent.VK_F);
    findAllByDate.addActionListener(this);
    actionsPanel.add(findAllByName);
    findAllByName.setEnabled(false);
    findAllByName.setMnemonic(KeyEvent.VK_D);
    findAllByName.addActionListener(this);
    actionsPanel.add(removeButton);
    removeButton.setEnabled(false);
    removeButton.setMnemonic(KeyEvent.VK_R);
    removeButton.addActionListener(this);
    add(actionsPanel);

    add(outputArea);
    outputArea.setEditable(false);
    outputArea.getAccessibleContext().setAccessibleName("Output area");
    setSize(720, 200);
    setVisible(true);
    blankDisplay();

    // To save typing in new entries while testing, uncomment
    // the following lines (or add your own test cases)

  } // constructor

  // Add a label and its associated control to a row of a Container using a
  // GridBagLayout
  private void addToGrid(Container grid, JLabel label, Component control) {
    GridBagConstraints c = new GridBagConstraints();
    c.gridx = 0;
    c.gridy = GridBagConstraints.RELATIVE;
    grid.add(label, c);
    c.gridx = GridBagConstraints.REMAINDER;
    grid.add(control, c);
    label.setLabelFor(control);
  }

  // Add a card to the card deck, setting its accessible name
  private void addCard(Component card, String name) {
    card.getAccessibleContext().setAccessibleName(name + " Entry Options");
    cards.add(card, name);
  }

  // listen for and respond to GUI events
  public void actionPerformed(ActionEvent event) {
    String message = "";
    if (event.getSource() == addR) {
      String selectedEntryType = (String)entryType.getSelectedItem();
      message = addEntry(selectedEntryType);
    } else if (event.getSource() == lookUpByDate) {
      message = lookupEntry();
    } else if (event.getSource() == findAllByDate) {
      message = findAllEntries();
    } else if (event.getSource() == findAllByName) {
      message = findByName();
    } else if (event.getSource() == removeButton) {
      message = removeEntry();
    } else if (event.getSource() == entryType) {
      // Show options for the newly selected Entry type
      CardLayout cl = (CardLayout)(cards.getLayout());
      String newCard = (String)entryType.getSelectedItem();
      cl.show(cards, newCard);
      message = "Entry type set to " + newCard;
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
    int h, mm, s;
    try {
      m = Integer.parseInt(month.getText());
      d = Integer.parseInt(day.getText());
      y = Integer.parseInt(year.getText());
      h = Integer.parseInt(hours.getText());
      mm = Integer.parseInt(mins.getText());
      s = Integer.parseInt(secs.getText());
    } catch (NumberFormatException err) {
      return "Input is not a number: " + err.getLocalizedMessage();
    }

    Entry e;
    // Add a new record of the given type
    if (what.equals(GENERIC_ENTRY)) {
      e = new Entry(n, d, m, y, h, mm, s);
    } else if (what.equals(RUN_ENTRY)) {
      // Validate RunEntry specific fields
      float dist;
      try {
        dist = Float.parseFloat(runTotalDist.getText());
      } catch (NumberFormatException err) {
        return "Input is not a number: " + err.getLocalizedMessage();
      }
      e = new RunEntry(n, d, m, y, h, mm, s, dist);

    } else if (what.equals(REPS_ENTRY)) {
      // Validate RepsEntry specific fields
      float dist, repLength;
      int recTime;
      try {
        dist = Float.parseFloat(repsTotalDist.getText());
        repLength = Float.parseFloat(repDist.getText());
        recTime = Integer.parseInt(recovery.getText());
      } catch (NumberFormatException err) {
        return "Input is not a number: " + err.getLocalizedMessage();
      }
      e = new RepsEntry(n, d, m, y, h, mm, s, dist, repLength, recTime);

    } else if (what.equals(CYCLE_ENTRY)) {
      // Validate CycleEntry specific fields
      float dist, tempo;
      String terrain = cycleTerrain.getText();
      try {
        dist = Float.parseFloat(cycleTotalDist.getText());
        tempo = Float.parseFloat(cycleTempo.getText());
      } catch (NumberFormatException err) {
        return "Input is not a number: " + err.getLocalizedMessage();
      }
      e = new CycleEntry(n, d, m, y, h, mm, s, dist, terrain, tempo);

    } else if (what.equals(SWIM_ENTRY)) {
      // Validate SwimEntry specific fields
      float dist;
      try {
        dist = Float.parseFloat(swimTotalDist.getText());
      } catch (NumberFormatException err) {
        return "Input is not a number: " + err.getLocalizedMessage();
      }
      Boolean inPool = swimInPool.isSelected();
      e = new SwimEntry(n, d, m, y, h, mm, s, dist, inPool);

    } else {
      return "Invalid Entry type: " + what;
    }
    if (!myAthletes.addEntry(e)) {
      message = "Entry already exists!";
    }

    // Entry was successfully added, activate buttons
    lookUpByDate.setEnabled(true);
    findAllByDate.setEnabled(true);
    findAllByName.setEnabled(true);
    removeButton.setEnabled(true);

    return message;
  }

  public String lookupEntry() {
    int m, d, y;
    try {
      m = Integer.parseInt(month.getText());
      d = Integer.parseInt(day.getText());
      y = Integer.parseInt(year.getText());
    } catch (NumberFormatException err) {
      return "Input is not a number: " + err.getLocalizedMessage();
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

  public String findByName() {
    String n = name.getText();
    if (n.isEmpty()) {
      return "Invalid input: Name is required";
    }
    return myAthletes.findByName(n);
  }

  public String removeEntry() {
    String n = name.getText();
    int m, d, y;
    try {
      m = Integer.parseInt(month.getText());
      d = Integer.parseInt(day.getText());
      y = Integer.parseInt(year.getText());
    } catch (NumberFormatException err) {
      return "Input is not a number: " + err.getLocalizedMessage();
    }
    outputArea.setText("Removing entry ...");
    if (myAthletes.removeEntry(n, d, m, y)) {
      // Set enabled state of buttons appropriately
      if (myAthletes.getNumberOfEntries() == 0) {
        lookUpByDate.setEnabled(false);
        findAllByDate.setEnabled(false);
        findAllByName.setEnabled(false);
        removeButton.setEnabled(false);
      }
      return "Entry removed";
    }
    return "Entry not found";
  }

  public void blankDisplay() {
    name.setText("");
    day.setText("");
    month.setText("");
    year.setText("");
    hours.setText("");
    mins.setText("");
    secs.setText("");
    runTotalDist.setText("");
    repsTotalDist.setText("");
    repDist.setText("");
    recovery.setText("");
    cycleTotalDist.setText("");
    cycleTerrain.setText("");
    cycleTempo.setText("");
    swimTotalDist.setText("");
    swimInPool.setSelected(false);

  } // blankDisplay
  // Fills the input fields on the display for testing purposes only
  public void fillDisplay(Entry ent) {
    CardLayout cl = (CardLayout)(cards.getLayout());

    // Set subclass specific fields
    if (ent instanceof RunEntry) {
      RunEntry run = (RunEntry)ent;
      // Fill RepsEntry specific fields
      runTotalDist.setText(String.valueOf(run.getDistance()));
      // Show the correct type and panel
      entryType.setSelectedItem(RUN_ENTRY);
      cl.show(cards, RUN_ENTRY);

    } else if (ent instanceof RepsEntry) {
      RepsEntry reps = (RepsEntry)ent;
      // Fill RepsEntry specific fields
      repsTotalDist.setText(String.valueOf(reps.getDistance()));
      repDist.setText(String.valueOf(reps.getDistance()));
      recovery.setText(String.valueOf(reps.getRecovery()));
      // Show the correct type and panel
      entryType.setSelectedItem(REPS_ENTRY);
      cl.show(cards, REPS_ENTRY);

    } else if (ent instanceof CycleEntry) {
      CycleEntry cycle = (CycleEntry)ent;
      // Fill RepsEntry specific fields
      cycleTotalDist.setText(String.valueOf(cycle.getDistance()));
      cycleTerrain.setText(cycle.getTerrain());
      cycleTempo.setText(String.valueOf(cycle.getTempo()));
      // Show the correct type and panel
      entryType.setSelectedItem(CYCLE_ENTRY);
      cl.show(cards, CYCLE_ENTRY);

    } else if (ent instanceof SwimEntry) {
      SwimEntry swim = (SwimEntry)ent;
      // Fill RepsEntry specific fields
      swimTotalDist.setText(String.valueOf(swim.getDistance()));
      swimInPool.setSelected(swim.getInPool());
      // Show the correct type and panel
      entryType.setSelectedItem(SWIM_ENTRY);
      cl.show(cards, SWIM_ENTRY);

    } else {
      entryType.setSelectedItem(GENERIC_ENTRY);
      cl.show(cards, GENERIC_ENTRY);
    }

    // Set global fields
    name.setText(ent.getName());
    day.setText(String.valueOf(ent.getDay()));
    month.setText(String.valueOf(ent.getMonth()));
    year.setText(String.valueOf(ent.getYear()));
    hours.setText(String.valueOf(ent.getHour()));
    mins.setText(String.valueOf(ent.getMin()));
    secs.setText(String.valueOf(ent.getSec()));
  }

} // TrainingRecordGUI
