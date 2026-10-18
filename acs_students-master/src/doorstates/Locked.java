package doorstates;

import doors.Door;

public class Locked extends DoorState {
  // Represents the locked state of a door
  // In this state, the door cannot be opened; it can only be unlocked

  public Locked(Door door){
    super(door);
    this.name = States.LOCKED;
  }

  @Override
  public void open(){
    System.out.println("Can't open door " + door.getId() + " because it is locked.");
  }

  @Override
  public void close() {
    System.out.println("Door " + door.getId() + " is already closed.");
  }

  @Override
  public void lock() {
    System.out.println("Door " + door.getId() + " is already locked.");
  }

  @Override
  public void unlock(){
    door.setState(new Unlocked(door));
  }

  @Override
  public void unlockShortly() {
    door.setState(new UnlockedShortly(door));
  }
}
