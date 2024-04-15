// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;

import java.util.*;

public class TrainingRecord {
  private List<Entry> tr;

  public TrainingRecord() { tr = new ArrayList<Entry>(); } // constructor

  // add a record to the list
  public void addEntry(Entry e) { tr.add(e); } // addClass

  // look up the entry of a given day and month
  public String lookupEntry(int d, int m, int y) {
    ListIterator<Entry> iter = tr.listIterator();
    String result = "No entries found";
    while (iter.hasNext()) {
      Entry current = iter.next();
      if (current.getDay() == d && current.getMonth() == m &&
          current.getYear() == y)
        result = current.getEntry();
    }
    return result;
  } // lookupEntry

  // look up all entries of a given day and month
  public String findAllEntries(int d, int m, int y) {
    ListIterator<Entry> iter = tr.listIterator();
    StringBuilder result = new StringBuilder();
    // Linear search through entries
    while (iter.hasNext()) {
      Entry current = iter.next();
      if (current.getDay() == d && current.getMonth() == m &&
          current.getYear() == y) {
        // Found match
        result.append(current.getEntry());
      }
    }
    if (result.length() == 0) {
      return "No entries found";
    }
    return result.toString();
  } // findAllEntries

  // Count the number of entries
  public int getNumberOfEntries() { return tr.size(); }
  // Clear all entries
  public void clearAllEntries() { tr.clear(); }

} // TrainingRecord
