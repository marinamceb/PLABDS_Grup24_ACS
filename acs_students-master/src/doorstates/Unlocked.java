package doorstates;
import baseNoStates.Door;

public class Unlocked extends DoorState{

  // CONSTRUCTOR
  public Unlocked(Door door) {
    super(door); // Calls the father's constructor
    this.name = "unlocked"; // Assigns it the UNLOCKED state
  }

  // OPEN: Opens the door
  @Override
  public void open() {
    // I don't know if that's necessary:
    /*
    if(door.isClosed()) {
      door.setClosed(false);
    } else {
      System.out.println("No es pot obrir la porta " + door.getId() + " perque ja està oberta");
    }
     */

    // For the moment, I will only have it open (I am applying the same criterion to the rest of the methods)
    door.setClosed(false);
  }

  // CLOSE: Closes the door
  @Override
  public void close() {
    /*
    if(door.isClosed()) {
      System.out.println("No es pot tancar la porta " + door.getId() + " perque ja està tancada");
    } else {
      door.setClosed(true);
    }
    */
    door.setClosed(true);
  }

  // LOCK: Locks the door just if it's closed
  @Override
  public void lock() {
    /*
    if (door.isClosed()) {
      door.setState(new Locked(door));
    } else {
      System.out.println("No es pot bloquejar la porta " + door.getId() + " perquè està oberta");
    }
    */
    door.setState(new Locked(door));
  }

  // UNLOCK: Unlocks the door (it's already unlocked)
  @Override
  public void unlock() {
    // It's already unlocked
  }
}
