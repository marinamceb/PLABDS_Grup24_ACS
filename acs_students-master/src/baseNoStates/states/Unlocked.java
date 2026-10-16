package baseNoStates.states;

public class Unlocked extends DoorState{
  // Represents the unlocked state of a door
  // The door can be freely opened and closed. It can also be locked, provided it is physically closed

  public Unlocked(Door door) {
    super(door);
    this.name = "unlocked";
  }

  @Override
  public void open() {
    door.setClosed(false);
  }

  @Override
  public void close() {
    door.setClosed(true);
  }

  @Override
  public void lock() {
    if (door.isClosed()) {
      door.setState(new Locked(door));
    } else {
      System.out.println("No es pot bloquejar la porta " + door.getId() + " perquè està oberta");
    }
  }
}
