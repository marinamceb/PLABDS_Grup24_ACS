package doorstates;

import doors.Door;

public class Unlocked extends DoorState{
  // Represents the unlocked state of a door
  // The door can be freely opened and closed. It can also be locked, provided it is physically closed

  public Unlocked(Door door) {
    super(door);
    this.name = States.UNLOCKED;
  }

  @Override
  public void open() {
    if (door.isClosed()) {
      door.setClosed(false);
    } else {
      System.out.println("Door " + door.getId() + " is already open.");
    }
  }

  @Override
  public void close() {
    if (!door.isClosed()) {
      door.setClosed(true);
    } else {
      System.out.println("Door " + door.getId() + " is already closed.");
    }
  }

  @Override
  public void lock() {
    if (door.isClosed()) {
      door.setState(new Locked(door));
    } else {
      System.out.println("Can't lock the door " + door.getId() + " because it is open.");
    }
  }

  @Override
  public void unlock() {
    System.out.println("Door " + door.getId() + " is already unlocked.");
  }
}
