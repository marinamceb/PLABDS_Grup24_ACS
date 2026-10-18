package doorstates;

import doors.Door;

// Represents an alarm state where a door was left physically open beyond its allowed period
// The only way to exit this state is to physically close the door
public class Propped extends DoorState {

  public Propped(Door door) {
    super(door);
    this.name = States.PROPPED;
  }

  @Override
  public void close() {
    // Closing a propped door resolves the alarm and returns it to the locked state
    door.setClosed(true);
    door.setState(new Locked(door));
  }
}
