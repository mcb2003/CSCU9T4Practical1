// This class holds information about a single SwimEntryning training session
package com.stir.cscu9t4practical1;

public class SwimEntry extends DistanceEntry {
  private Boolean inPool;

  public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist,
              Boolean pool) {
    super(n, d, m, y, h, min, s, dist); // Call base ctor
    inPool = pool;
  }

  // Getters:

  public Boolean getInPool() { return inPool; }

  @Override
  public String getEntry() {
    String location = inPool ? "in indoor pool" : "outdoors";
    return String.format("%s swam %g km %s in %02d:%02d:%02d on %02d/%02d/%d\n",
                         getName(), getDistance(), location, getHour(),
                         getMin(), getSec(), getDay(), getMonth(), getYear());
  }

} // SwimEntry
