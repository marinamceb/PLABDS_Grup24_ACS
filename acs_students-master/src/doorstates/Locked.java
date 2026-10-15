package doorstates;

import baseNoStates.Door;

public class Locked extends DoorState {

  // CONSTRUCTOR
  public Locked(Door door) {
    super(door); // Call the father's builder
    this.name = "locked"; // Assigns it the LOCKED state
  }

  // OPEN: a door in the LOCKED state cannot be opened
  @Override
  public void open() {
    System.out.println("No es pot obrir la porta " + door.getId() + " perque està bloquejada.");
  }

  // CLOSE: in the LOCKED state, the door is already closed
  @Override
  public void close() {
    // It's already closed because it is blocked
  }

  // LOCK: the door is already locked
  @Override
  public void lock() {
    // It's already locked
  }

  // UNLOCK: unlocks the door
  @Override
  public void unlock() {
    door.setState(new Unlocked(door));
  }
}