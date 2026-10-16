package baseNoStates.areas;

import baseNoStates.states.Door;

import java.util.ArrayList;
import java.util.Arrays;

// Represents a single physical room (Leaf in the Composite pattern).
// It holds the doors that give access to it and cannot contain sub-areas.
public class Space extends Area{
  private ArrayList<Door> doors;

  public Space (String id) {
    super(id);
    this.doors = new ArrayList<>();
  }

  public void addDoor(Door door) {
    doors.add(door);
  }

  @Override
  public ArrayList<Door> getDoorsGivingAccess() {
    return doors;
  }

  @Override
  public Area findAreaById(String searchId) {
    if (this.id.equals(searchId)) {
      return this;
    }
    return null; // If the name is not the same
  }

  @Override
  public ArrayList<Space> getSpaces() {
    return new ArrayList<>(Arrays.asList(this));
  }
}
