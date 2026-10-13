package baseNoStates;

import baseNoStates.requests.RequestReader;
import areas.Space;
import org.json.JSONObject;
import doorstates.*;


public class Door {
  // ATRIBUTS
  private final String id;
  private boolean closed; // physically
  private DoorState state; // estat de la porta (LOCKED/UNLOCKED)
  private Space fromSpace; // Espai on es troba el reader
  private Space toSpace; // Espai al qual dona accés la porta

  // CONSTRUCTOR
  public Door(String id, Space fromSpace, Space toSpace) {
    this.id = id;
    this.closed = true;
    this.state = new Unlocked(this);
    this.fromSpace = fromSpace;
    this.toSpace = toSpace;

    // Si aquesta porta dona accés a un espai, afegim la porta a l'espai
    if(toSpace!=null) {
      toSpace.addDoor(this);
    }
  }

  // SETTERS
  public void setState(DoorState doorstate){
    this.state = doorstate;
  }
  public void setClosed(boolean closed){
    this.closed = closed;
  }

  // GETTERS
  public boolean isClosed() {
    return closed;
  }
  public String getId() {
    return id;
  }
  public String getStateName() {
    return state.getName();
  }
  public Space getFromSpace() {
    return fromSpace;
  }
  public Space getToSpace() {
    return toSpace;
  }

  // MÈTODES
  public void processRequest(RequestReader request) {
    // it is the Door that process the request because the door has and knows
    // its state, and if closed or open
    if (request.isAuthorized()) {
      String action = request.getAction();
      doAction(action);
    } else {
      System.out.println("not authorized");
    }
    request.setDoorStateName(getStateName());
  }
  private void doAction(String action) {
    switch (action) {
      case Actions.OPEN:
        state.open();
        break;
      case Actions.CLOSE:
        state.close();
        break;
      case Actions.LOCK:
        state.lock();
        break;
      case Actions.UNLOCK:
        state.unlock();
        break;
      case Actions.UNLOCK_SHORTLY:
        // TODO
        System.out.println("Action " + action + " not implemented yet");
        break;
      default:
        assert false : "Unknown action " + action;
        System.exit(-1);
    }
  }

  // PROCESSAR FITXERS
  @Override
  public String toString() {
    return "Door{"
        + ", id='" + id + '\''
        + ", closed=" + closed
        + ", state=" + getStateName()
        + "}";
  }
  public JSONObject toJson() {
    JSONObject json = new JSONObject();
    json.put("id", id);
    json.put("state", getStateName());
    json.put("closed", closed);
    return json;
  }
}
