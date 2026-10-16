package baseNoStates.states;

public abstract class DoorState {
  // Abstract base class representing the state of a door
  // It provides default behavior (denying the action) for all possible actions
  // Subclasses should override only the actions permitted in their specific state
  protected Door door;
  protected String name;

  public DoorState(Door door) {
    this.door = door;
  }

  public String getName() {
    return name;
  }

  public void open() {
    System.out.println("L'acció open no està permesa en l'estat " + name);
  }

  public void close() {
    System.out.println("L'acció close no està permesa en l'estat " + name);
  }

  public void lock() {
    System.out.println("L'acció lock no està permesa en l'estat " + name);
  }

  public void unlock() {
    System.out.println("L'acció unlock no està permesa en l'estat " + name);
  }

  public void unlockShortly() {
    System.out.println("L'acció unlockShortly no està permesa en l'estat " + name);
  }

}
