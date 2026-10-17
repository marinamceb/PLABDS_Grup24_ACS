package baseNoStates.states;

import baseNoStates.observers.Clock;
import baseNoStates.observers.Observer;

// Represents the 10-second grace period after a temporary unlock
// Subscribes to the global clock to count time asynchronously without freezing the server
public class UnlockedShortly extends DoorState implements Observer {
  private static final int TIME_LIMIT = 10;
  private int elapsedSeconds;

  public UnlockedShortly(Door door) {
    super(door);

    this.name = "unlocked_shortly";
    this.elapsedSeconds = 0;

    // Subscribe to the global clock
    Clock.getInstance().addObserver(this);
  }

  @Override
  public void open(){
    door.setClosed(false);
  }

  @Override
  public void close() {
    door.setClosed(true);
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
