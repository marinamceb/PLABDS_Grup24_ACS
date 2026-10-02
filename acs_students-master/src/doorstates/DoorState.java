package doorstates;
import baseNoStates.Door;

public abstract class DoorState {
  // ATRIBUTS
  protected Door door;
  protected String name;

  // CONSTRUCTOR
  public DoorState(Door door){
    this.door = door;
  }

  // MÈTODES
  public abstract void open();
  public abstract void close();
  public abstract void lock();
  public abstract void unlock();
}
