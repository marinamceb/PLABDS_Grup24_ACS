package areas;

import baseNoStates.Door;
import java.util.ArrayList;

/*
AREA CLASS:
* Abstract base class representing the Component in the Composite design pattern.
* Defines the common interface and abstract methods (getDoorsGivingAccess, findAreaById, getSpaces)
to uniformly handle both individual spaces (Space) and groups of areas (Partition).
*/

public abstract class Area {
  protected String id;

  public Area(String id) {
    this.id = id;
  }
  public String getId() {
    return id;
  }

  public abstract ArrayList<Door> getDoorsGivingAccess();
  public abstract Area findAreaById(String id);
  public abstract ArrayList<Space> getSpaces();
}
