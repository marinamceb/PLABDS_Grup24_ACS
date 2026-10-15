package areas;

import baseNoStates.Door;
import java.util.ArrayList;
import java.util.Arrays;

/*
DIRECTORYAREAS CLASS:
* Builds and maintains the building tree.
*/
public class DirectoryAreas {
  // Attributes
  private static Area rootArea; // Root of the tree
  private static ArrayList<Door> allDoors = new ArrayList<>(); // Doors

  // Returns the root of the tree
  public Area getRootArea() {
    return rootArea;
  }

  // Construct the complete building tree with partitions, spaces, and doors.
  public static void makeAreas() {
    // Partition initialization
    Partition building = new Partition("building");
    Partition basement = new Partition("basement");
    Partition groundFloor = new Partition("groundFloor");
    Partition floor1 = new Partition("floor1");

    // Add floors to the building
    building.addArea(basement);
    building.addArea(groundFloor);
    building.addArea((floor1));

    // Creation of spaces
    Space parking = new Space("parking");
    Space stairs = new Space("stairs");
    Space exterior = new Space("exterior");
    Space room1 = new Space("room1");
    Space room2 = new Space("room2");
    Space hall = new Space("hall");
    // Space restRoom = new Space("restRoom"); // It has no door, so I don't include it in the partitions
    Space room3 = new Space("room3");
    Space corridor = new Space("corridor");
    Space IT = new Space("IT");

    // Add general spaces to the building
    building.addArea(exterior);
    building.addArea(stairs);

    // Add spaces to the partitions
    basement.addArea(parking);
    groundFloor.addArea(room1);
    groundFloor.addArea(room2);
    groundFloor.addArea(hall);
    floor1.addArea(room3);
    floor1.addArea(corridor);
    floor1.addArea(IT);

    // Create doors: Door(id, fromSpace, toSpace)
    Door d1 = new Door("D1", exterior, parking);
    Door d2 = new Door("D2", stairs, parking);
    Door d3 = new Door("D3", exterior, hall);
    Door d4 = new Door("D4", stairs, hall);
    Door d5 = new Door("D5", room1, hall);
    Door d6 = new Door("D6", room2, hall);
    Door d7 = new Door("D7", corridor, IT);
    Door d8 = new Door("D8", room3, corridor);
    Door d9 = new Door("D9", IT, corridor);

    // Add doors to the building
    allDoors.add(d1);
    allDoors.add(d2);
    allDoors.add(d3);
    allDoors.add(d4);
    allDoors.add(d5);
    allDoors.add(d6);
    allDoors.add(d7);
    allDoors.add(d8);
    allDoors.add(d9);

    // Save the building in the root
    rootArea = building;
  }

  // Searches for an area by its ID recursively
  public static Area findAreaById(String id) {
    if(rootArea.id == null) {
      return null;
    }
    return rootArea.findAreaById(id);
  }

  // Search for a door by its ID within the list of doors
  public Door findDoorById(String id) {
    for(Door door : allDoors) {
      if(door.getId().equals(id)) {
        return door;
      }
    }
    return null;
  }

  // Returns the list of all the doors in the building
  public ArrayList<Door> getAllDoors() {
    return allDoors;
  }
}
