// This class holds information about a single running / sprinting training
// session composed of several reps, with recovery in between
package com.stir.cscu9t4practical1;

public class RepsEntry extends DistanceEntry {
  private float repDistance;
  private int recovery;

  public RepsEntry(String n, int d, int m, int y, int h, int min, int s,
                   float dist, float repDist, int recovery) {
    super(n, d, m, y, h, min, s, dist); // Call base ctor
    repDistance = repDist;
    this.recovery = recovery;
  }

  // Getters:

  public float getRepDistance() { return repDistance; }

  public int getRecovery() { return recovery; }

  public float getNumReps() { return getDistance() / repDistance; }

  @Override
  public String getEntry() {
    return String.format(
        "%s ran %g %g km reps = %g km, with %d mins recovery, in %02d:%02d:%02d on %02d/%02d/%d\n",
        getName(), getNumReps(), getRepDistance(), getDistance(), getRecovery(),
        getHour(), getMin(), getSec(), getDay(), getMonth(), getYear());
  }

} // RepsEntry
