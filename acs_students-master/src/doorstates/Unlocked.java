package doorstates;
import baseNoStates.Door;

public class Unlocked extends DoorState{

  public Unlocked(Door door) {
    super(door); // Crida el constructor del pare
    this.name = "unlocked"; // Li assigna l'estat UNLOCKED
  }

  @Override
  public void open() {

  }

  @Override
  public void close() {

  }

  @Override
  public void lock() {

  }

  @Override
  public void unlock() {
    // Ja està desbloquejada
  }
}
