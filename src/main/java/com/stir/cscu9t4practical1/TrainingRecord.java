// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;

import java.util.*;

public class TrainingRecord {
  private List<Entry> tr;

  public TrainingRecord() { tr = new ArrayList<Entry>(); } // constructor

  // add a record to the list
  public Boolean addEntry(Entry e) {
    Entry existing =
        findExactEntry(e.getName(), e.getDay(), e.getMonth(), e.getYear());
    if (existing != null) {
      return false; // Duplicate entry, e not added
    }
    tr.add(e);
    return true;
  } // addEntry

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
    if (result.isEmpty()) {
      return "No entries found";
    }
    return result.toString();
  } // findAllEntries

  // Find an exact entry by name and date
  public Entry findExactEntry(String n, int d, int m, int y) {
    ListIterator<Entry> iter = tr.listIterator();
    // Linear search through entries
    while (iter.hasNext()) {
      Entry current = iter.next();
      if (current.getName().equals(n) && current.getDay() == d &&
          current.getMonth() == m && current.getYear() == y) {
        // Found match
        return current;
      }
    }
    return null;
  } // findAllEntries

  // Perform a case-insensative, partial name search
  public String findByName(String name) {
    name = name.toLowerCase();

    StringBuilder result = new StringBuilder();
    ListIterator<Entry> iter = tr.listIterator();
    // Linear search through entries
    while (iter.hasNext()) {
      Entry current = iter.next();
      String currentName = current.getName().toLowerCase();
      if (currentName.indexOf(name) != -1) {
        // Found match
        result.append(current.getEntry());
      }
    }
    if (result.isEmpty()) {
      return "No entries found";
    }
    return result.toString();
  }

  // Count the number of entries
  public int getNumberOfEntries() { return tr.size(); }
  // Clear all entries
  public void clearAllEntries() { tr.clear(); }

} // TrainingRecord
