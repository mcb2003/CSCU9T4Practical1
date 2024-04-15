// This class holds information about a single running / sprinting training
// session composed of several reps, with recovery in between
package com.stir.cscu9t4practical1;

public class Reps extends DistanceTraining {
  private float repDistance;
  private int recoveryMins;

  public Reps(String n, int d, int m, int y, int h, int min, int s, float dist,
              float repDist, int recMins) {
    super(n, d, m, y, h, min, s, dist); // Call base ctor
    repDistance = repDist;
    recoveryMins = recMins;
  }

  // Getters:

  public float getRepDistance() { return repDistance; }

  public int getRecoveryMins() { return recoveryMins; }

  public float getNumReps() { return getDistance() / repDistance; }

  @Override
  public String getEntry() {
    return String.format(
        "%s ran %g %g km reps = %g km, with %d mins recovery, in %02d:%02d:%02d on %02d/%02d/%d\n",
        getName(), getNumReps(), getRepDistance(), getDistance(),
        getRecoveryMins(), getHour(), getMin(), getSec(), getDay(), getMonth(),
        getYear());
  }

} // Reps
