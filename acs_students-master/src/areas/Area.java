package areas;

import java.util.ArrayList;

// Abstract base component of the Composite pattern.
// Allows the system to treat individual rooms (Spaces) and large zones (Partitions) uniformly.
public abstract class Area {
  protected String id;

  public Area(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public abstract ArrayList<doors.Door> getDoorsGivingAccess();
  public abstract Area findAreaById(String id);
  public abstract ArrayList<Space> getSpaces();
}
