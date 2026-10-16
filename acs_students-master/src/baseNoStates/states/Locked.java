package baseNoStates.states;

public class Locked extends DoorState {
  // Represents the locked state of a door
  // In this state, the door cannot be opened; it can only be unlocked

  public Locked(Door door){
    super(door);
    this.name = "locked";
  }

  @Override
  public void open(){
    System.out.println("Can't open a locked door");
  }

  @Override
  public void unlock(){
    door.setState(new Unlocked(door));
  }
}
