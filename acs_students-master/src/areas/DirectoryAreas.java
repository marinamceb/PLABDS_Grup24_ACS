package areas;

import doors.Door;

import java.util.ArrayList;

// Acts as the factory and registry for the building's physical layout.
// It builds the Composite tree and keeps a reference to the root node.
public final class DirectoryAreas {
  private static Area rootArea;
  private static final ArrayList<Door> allDoors = new ArrayList<>();

  public static void makeAreas() {
    allDoors.clear();

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

    // Creation of doors (id, fromSpace, toSpace)
    Door d1 = new Door("D1", exterior, parking);
    Door d2 = new Door("D2", stairs, parking);
    Door d3 = new Door("D3", exterior, hall);
    Door d4 = new Door("D4", stairs, hall);
    Door d5 = new Door("D5", hall, room1);
    Door d6 = new Door("D6", hall, room2);
    Door d7 = new Door("D7", stairs, corridor);
    Door d8 = new Door("D8", corridor, room3);
    Door d9 = new Door("D9", corridor, IT);

    // Add doors to the global list
    allDoors.add(d1);
    allDoors.add(d2);
    allDoors.add(d3);
    allDoors.add(d4);
    allDoors.add(d5);
    allDoors.add(d6);
    allDoors.add(d7);
    allDoors.add(d8);
    allDoors.add(d9);

    // Associate doors with the spaces they give access to (toSpace)
    parking.addDoor(d1);
    parking.addDoor(d2);
    hall.addDoor(d3);
    hall.addDoor(d4);
    room1.addDoor(d5);
    room2.addDoor(d6);
    corridor.addDoor(d7);
    room3.addDoor(d8);
    IT.addDoor(d9);
  }

  // Utility method used by other classes to quickly search the entire building tree
  public static Area findAreaById(String id) {
    if (rootArea == null) {
      return null;
    }
    return rootArea.findAreaById(id);
  }

  // Utility method to search for a door by its ID
  public static Door findDoorById(String doorId) {
    for (Door door : allDoors) {
      if (door.getId().equals(doorId)) {
        return door;
      }
    } return null;
  }

  // Returns the list of all doors in the system.
  public static ArrayList<Door> getAllDoors() {
    return allDoors;
  }
}
