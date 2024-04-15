// This class holds information about a training session based around a distance
package com.stir.cscu9t4practical1;

public class DistanceEntry extends Entry {
  private float distance;

  public DistanceEntry(String n, int d, int m, int y, int h, int min, int s,
                          float dist) {
    super(n, d, m, y, h, min, s); // Call base ctor
    distance = dist;
  }

  // Getters:

  public float getDistance() { return distance; }

  @Override
  public String getEntry() {
    return String.format(
        "%s trained over %g km for %02d:%02d:%02d on %02d/%02d/%d\n", getName(),
        getDistance(), getHour(), getMin(), getSec(), getDay(), getMonth(),
        getYear());
  }

} // DistanceEntry
