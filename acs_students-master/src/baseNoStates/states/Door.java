package baseNoStates.states;

import baseNoStates.Actions;
import baseNoStates.areas.Space;
import baseNoStates.requests.RequestReader;
import org.json.JSONObject;

// Represents a physical door connecting an origin (fromSpace) and a destination (toSpace).
// Uses the State design pattern to dynamically change its behavior (Locked, Unlocked, etc.).
public class Door {
  private final String id;
  private boolean closed; // physically
  private DoorState state; // Keeps the current state of the door

  private Space fromSpace;
  private Space toSpace;

  public Door(String id, Space fromSpace, Space toSpace) {
    this.id = id;
    closed = true;
    this.state = new Unlocked(this); // The initial state is "unlocked"
    this.fromSpace = fromSpace;
    this.toSpace = toSpace;

    if (toSpace != null) {
      toSpace.addDoor(this);
    }

    if (fromSpace != null) {
      fromSpace.addDoor(this);
    }
  }

  public Space getFromSpace() {
    return fromSpace;
  }

  public Space getToSpace() {
    return toSpace;
  }

  public void processRequest(RequestReader request) {
    // Security check: Action is only processed if the user has access to both connected spaces
    if (request.isAuthorized()) {
      String action = request.getAction();
      doAction(action);
    } else {
      System.out.println("not authorized");
    }
    request.setDoorStateName(getStateName());
  }

  private void doAction(String action) {
    // Delegates the execution of the requested action to the current state object.
    // This avoids massive if/else structures and makes adding new states effortless.
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
        state.unlockShortly();
        break;
      default:
        assert false : "Unknown action " + action;
        System.exit(-1);
    }
  }

  public boolean isClosed() {
    return closed;
  }

  // Updates the physical state of the door (closed or open)
  public void setClosed(boolean closed) {
    this.closed = closed;
  }

  // Transitions the door to a new logical state
  public void setState(DoorState state) {
    this.state = state;
  }

  public String getId() {
    return id;
  }

  public String getStateName() {
    return state.name;
  }

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
    // The client apps need to know which two spaces the door connects
    json.put("originSpace", fromSpace.getId());
    json.put("destinationSpace", toSpace.getId());
    return json;
  }
}