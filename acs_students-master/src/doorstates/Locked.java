package doorstates;

import baseNoStates.Door;

public class Locked extends DoorState {

  // CONSTRUCTOR
  public Locked(Door door) {
    super(door); // Crida el constructor del pare
    this.name = "locked"; // Li assigna l'estat LOCKED
  }

  // OPEN: no es pot obrir una porta en estat LOCKED
  @Override
  public void open() {
    System.out.println("No es pot obrir la porta " + door.getId() + " perque està bloquejada.");
  }

  // CLOSE: en estat LOCKED, la porta ja està tancada
  @Override
  public void close() {
    // Ja està tancada perque està bloquejada
  }

  // LOCK: la porta ja està bloquejada.
  @Override
  public void lock() {
    // Ja està bloquejada
  }

  // UNLOCK: desbloqueja la porta
  @Override
  public void unlock() {
    door.setState(new Unlocked(door));
  }
}