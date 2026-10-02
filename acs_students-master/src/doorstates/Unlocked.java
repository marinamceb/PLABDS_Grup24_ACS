package doorstates;
import baseNoStates.Door;

public class Unlocked extends DoorState{

  // CONSTRUCTOR
  public Unlocked(Door door) {
    super(door); // Crida el constructor del pare
    this.name = "unlocked"; // Li assigna l'estat UNLOCKED
  }

  // OPEN: Obre la porta
  @Override
  public void open() {
    // No sé si cal fer això:
    /*
    if(door.isClosed()) {
      door.setClosed(false);
    } else {
      System.out.println("No es pot obrir la porta " + door.getId() + " perque ja està oberta");
    }
     */

    // Faré només, pel moment, que s'obri (aplico el mateix criteri per la resta de mètodes)
    door.setClosed(false);
  }

  // CLOSE: tanca la porta
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

  // LOCK: bloqueja la porta si està tancada
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

  // UNLOCK: ja està desbloquejada
  @Override
  public void unlock() {
    // Ja està desbloquejada
  }
}
