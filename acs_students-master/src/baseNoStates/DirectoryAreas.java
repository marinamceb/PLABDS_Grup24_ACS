package baseNoStates;

// Acts as the factory and registry for the building's physical layout.
// It builds the Composite tree and keeps a reference to the root node.
public final class DirectoryAreas {
  private static Area rootArea;

  public static void makeAreas() {
    // partitions and spaces
    Partition building = new Partition("building");
    Partition basement = new Partition("basement");
    Partition ground = new Partition("ground_floor");
    Partition floor1 = new Partition("floor1");

    Space parking = new Space("parking");
    Space stairs = new Space("stairs");
    Space room1 = new Space("room1");
    Space room2 = new Space("room2");
    Space hall = new Space("hall");
    Space room3 = new Space("room3");
    Space IT = new Space("IT");
    Space exterior = new Space("exterior");
    Space corridor = new Space("corridor");

    // Building
    building.addArea(basement);
    building.addArea(ground);
    building.addArea(floor1);
    building.addArea(stairs);
    building.addArea(exterior);
    // Basement
    basement.addArea(parking);
    // Ground
    ground.addArea(hall);
    ground.addArea(room1);
    ground.addArea(room2);
    // Floor1
    floor1.addArea(room3);
    floor1.addArea(corridor);
    floor1.addArea(IT);

    rootArea = building;
  }

  // Utility method used by other classes to quickly search the entire building tree
  public static Area findAreaById(String id) {
    return rootArea.findAreaById(id);
  }
}
