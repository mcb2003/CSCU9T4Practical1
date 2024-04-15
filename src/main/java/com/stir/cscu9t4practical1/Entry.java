// This class holds information about a single training session
package com.stir.cscu9t4practical1;

import java.util.Calendar;
public class Entry {
  private String name;
  private Calendar dateAndTime;

  public Entry(String n, int d, int m, int y, int h, int min, int s) {
    name = n;
    Calendar inst = Calendar.getInstance();
    inst.set(y, m - 1, d, h, min, s);
    dateAndTime = inst;
  } // constructor

  public String getName() { return name; } // getName

  public int getDay() { return dateAndTime.get(Calendar.DATE); } // getDay

  public int getMonth() {
    int month = dateAndTime.get(Calendar.MONTH) + 1;
    return month;
  } // getMonth

  public int getYear() { return dateAndTime.get(Calendar.YEAR); } // getYear

  public int getHour() { return dateAndTime.get(Calendar.HOUR); } // getHour

  public int getMin() { return dateAndTime.get(Calendar.MINUTE); } // getMin

  public int getSec() { return dateAndTime.get(Calendar.SECOND); } // getSec

  public String getEntry() {
    return String.format("%s trained for %02d:%02d:%02d on %02d/%02d/%d\n",
                         getName(), getHour(), getMin(), getSec(), getDay(),
                         getMonth(), getYear());
  } // getEntry

} // Entry
