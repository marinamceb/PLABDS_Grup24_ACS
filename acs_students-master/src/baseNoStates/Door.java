package baseNoStates;

import baseNoStates.requests.RequestReader;
import org.json.JSONObject;
import doorstates.*;


public class Door {
  private final String id;
  private boolean closed; // physically
  private DoorState state; // estat de la porta (LOCKED/UNLOCKED)

  // CONSTRUCTOR
  public Door(String id) {
    this.id = id;
    closed = true;
    this.state = new Unlocked(this);
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
