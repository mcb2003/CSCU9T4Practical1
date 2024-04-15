// This class holds information about a single running / sprinting training
// session
package com.stir.cscu9t4practical1;

public class RunEntry extends DistanceEntry {

  public RunEntry(String n, int d, int m, int y, int h, int min, int s,
                  float dist) {
    super(n, d, m, y, h, min, s, dist); // Call base ctor
  }

  @Override
  public String getEntry() {
    return String.format("%s ran %g km in %02d:%02d:%02d on %02d/%02d/%d\n",
                         getName(), getDistance(), getHour(), getMin(),
                         getSec(), getDay(), getMonth(), getYear());
  }

} // RunEntry
