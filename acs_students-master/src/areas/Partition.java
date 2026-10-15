package areas;

import baseNoStates.Door;
import java.util.ArrayList;

/*
PARTITION CLASS:
* Represents a hierarchical grouping of areas; the Composite class within the Composite design pattern.
* Contains a set of sub-areas (both Partition and Space).
*/

public class Partition extends Area {
  // Attribute: List of areas contained in the partition
  private ArrayList<Area> areas;

  // Constructor: Id of the area and initializes the area array
  Partition(String id) {
    super(id); //Crida al constructor Area(id)
    this.areas = new ArrayList<>();
  }

  // Add an area to the partition
  public void addArea(Area area) {
    if(!areas.contains(area)) {
      areas.add(area);
    }
  }

  // Returns the ports of the partition areas
  @Override
  public ArrayList<Door> getDoorsGivingAccess() {
    ArrayList<Door> doors = new ArrayList<>();
    for(Area area : areas) {
      for(Door door : area.getDoorsGivingAccess()) {
        if(!doors.contains(door))
        {
          doors.add(door);
        }
      }
    }
    return doors;
  }

  // It returns itself or one of the areas it contains if the ID matches, or NULL if no ID matches.
  @Override
  public Area findAreaById(String id) {
    if(this.id.equals(id)) {
      return this;
    }
    for(Area area : areas)
    {
      Area foundArea = area.findAreaById(id);
      if(foundArea != null) {
        return foundArea;
      }
    }
    return null;
  }

  // Returns all the spaces it contains
  @Override
  public ArrayList<Space> getSpaces() {
    ArrayList<Space> spaces = new ArrayList<>();
    for(Area area : areas) {
      spaces.addAll(area.getSpaces());
    }
    return spaces;
  }
}
