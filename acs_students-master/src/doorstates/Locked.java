package doorstates;

import baseNoStates.Door;

public class Locked extends DoorState {

  public Locked(Door door) {
    super(door); // Crida el constructor del pare
    this.name = "locked"; // Li assigna l'estat UNLOCKED
  }

  @Override
  public void open() {

  }

  @Override
  public void close() {
    // Ja està tancada perque està bloquejada
  }

  @Override
  public void lock() {
    // Ja està bloquejada
  }

  @Override
  public void unlock() {

  }
}