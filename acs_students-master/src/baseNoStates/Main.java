package baseNoStates;

import baseNoStates.directories.DirectoryAreas;
import baseNoStates.directories.DirectoryDoors;
import baseNoStates.directories.DirectoryUserGroup;
import baseNoStates.directories.DirectoryUsers;

public class Main {
  public static void main(String[] args) {
    // The ACS (Access Control System) must be built in a strict top-down order:
    // 1. Areas (physical structure) -> 2. Doors (connections) -> 3. Groups -> 4. Users (permissions)
    DirectoryAreas.makeAreas();
    DirectoryDoors.makeDoors();
    DirectoryUserGroup.makeUserGroups();
    DirectoryUsers.makeUsers();

    // Starts listening to simulator and mobile app requests
    new WebServer();
  }
}