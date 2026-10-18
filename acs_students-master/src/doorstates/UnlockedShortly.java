package doorstates;

import doors.Door;
import observers.Clock;
import observers.Observer;

// Represents the 10-second grace period after a temporary unlock
// Subscribes to the global clock to count time asynchronously without freezing the server
public class UnlockedShortly extends DoorState implements Observer {
  private static final int TIME_LIMIT = 10;
  private int elapsedSeconds;

  public UnlockedShortly(Door door) {
    super(door);
    this.name = States.UNLOCKED_SHORTLY;
    this.elapsedSeconds = 0;

    // Subscribe to the global clock
    Clock.getInstance().addObserver(this);
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
      // Unsubscribe from the clock before changing state
      Clock.getInstance().deleteObserver(this);
      door.setState(new Locked(door));
    } else {
      System.out.println("Can't lock door " + door.getId() + " because it is open.");
    }
  }

  @Override
  public void unlock() {
    // Unsubscribe from the clock before changing state
    Clock.getInstance().deleteObserver(this);
    door.setState(new Unlocked(door));
  }

  @Override
  public void update(){
    elapsedSeconds++;

    if(elapsedSeconds >= TIME_LIMIT) {
      // Time is up. Unsubscribe from the clock
      Clock.getInstance().deleteObserver(this);

      // Automatic state transition based on the physical state of the door
      if (door.isClosed()) {
        door.setState(new Locked(door));
      } else {
        door.setState(new Propped(door));
      }
    }
  }
}
