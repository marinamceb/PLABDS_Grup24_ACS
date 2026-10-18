package doorstates;

import doors.Door;

public abstract class DoorState {
  // Abstract base class representing the state of a door
  // It provides default behavior (denying the action) for all possible actions
  // Subclasses should override only the actions permitted in their specific state
  protected Door door;
  protected String name;

  public DoorState(doors.Door door) {
    this.door = door;
  }

  public String getName() {
    return name;
  }

  public void open() {
    System.out.println("Action open is not allowed in state " + name);
  }

  public void close() {
    System.out.println("Action close is not allowed in state " + name);
  }

  public void lock() {
    System.out.println("Action lock is not allowed in state " + name);
  }

  public void unlock() {
    System.out.println("Action unlock is not allowed in state " + name);
  }

  public void unlockShortly() {
    System.out.println("Action unlockShortly is not allowed in state " + name);
  }

}
