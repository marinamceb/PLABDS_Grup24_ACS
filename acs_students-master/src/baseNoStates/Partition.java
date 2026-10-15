package baseNoStates;

import java.util.ArrayList;

// Represents a logical grouping of areas (Composite node).
// It can contain Spaces or even other nested Partitions (e.g., a floor containing rooms).
public class Partition extends Area{
  private ArrayList<Area> children;

  public Partition(String id) {
    super(id);
    this.children = new ArrayList<>();
  }

  public void addArea(Area area) {
    children.add(area);
  }

  @Override
  public ArrayList<Door> getDoorsGivingAccess() {
    ArrayList<Door> allDoors = new ArrayList<>();

    // Recursively traverses down the tree to collect all doors within this partition
    for (Area child : children) {
      allDoors.addAll(child.getDoorsGivingAccess());
    }

    return allDoors;
  }

  @Override
  public Area findAreaById(String searchId) {
    if (this.id.equals(searchId)) return this;

    // Recursively traverses down the tree to collect all doors within this partition
    for (Area child : children) {
      Area found = child.findAreaById(searchId);
      if (found != null) return found;
    }
    return null;
  }

  @Override
  public ArrayList<Space> getSpaces() {
    ArrayList<Space> allSpaces = new ArrayList<>();

    for (Area child : children) {
      allSpaces.addAll(child.getSpaces());
    }
    return allSpaces;
  }
}
