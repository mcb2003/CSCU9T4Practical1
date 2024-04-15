// This class holds information about a single Cycling training session
package com.stir.cscu9t4practical1;

public class Cycle extends DistanceTraining {
  String terrain;
  float tempo;

  public Cycle(String n, int d, int m, int y, int h, int min, int s, float dist,
               String t, float rpm) {
    super(n, d, m, y, h, min, s, dist); // Call base ctor
    terrain = t;
    tempo = rpm;
  }

  /// Getters:

  public String getTerrain() { return terrain; }

  public float getTempo() { return tempo; }

  @Override
  public String getEntry() {
    return String.format(
        "%s cycled %g km, on %s terrain, with a tempo of %g rpm, in %02d:%02d:%02d on %02d/%02d/%d\n",
        getName(), getDistance(), getTerrain(), getTempo(), getHour(), getMin(),
        getSec(), getDay(), getMonth(), getYear());
  }

} // Cycle
