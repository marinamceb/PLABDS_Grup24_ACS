package areas;

import baseNoStates.Door;
import java.util.ArrayList;

/*
SPACE CLASS:
* Represents a specific space or room within the building.
* Represents a Leaf class within the Composite design pattern.
* Contains the list of doors that provide direct access to the space.
* As a leaf node, the search for areas is limited to its own check and returns only
  its associated doors.
*/

public class Space extends Area {
  // Attribute: Array of doors used to access the space
  private ArrayList<Door> doors;

  // Constructor: Id of the area and initializes the gate array
  public Space(String id) {
    super(id); //Crida al constructor Area(id)
    this.doors = new ArrayList<>();
  }

  // Add a door to access the space
  public void addDoor(Door door) {
    if(!doors.contains(door)) {
      doors.add(door);
    }
  }

  // Return the doors of space
  @Override
  public ArrayList<Door> getDoorsGivingAccess() {
    return doors;
  }

  // It returns itself if the ID matches, or NULL otherwise
  @Override
  public Area findAreaById(String id) {
    if(this.id.equals(id)) {
      return this;
    }
    return null;
  }

  // Returns an array containing itself
  @Override
  public ArrayList<Space> getSpaces() {
    ArrayList<Space> spaces = new ArrayList<>();
    spaces.add(this);
    return spaces;
  }
}
