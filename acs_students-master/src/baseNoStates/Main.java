package baseNoStates;

public class Main {
  public static void main(String[] args) {
    // The ACS (Access Control System) must be built in a strict top-down order:
    // 1. Areas (physical structure) -> 2. Doors (connections) -> 3. Users (permissions)
    DirectoryAreas.makeAreas();
    DirectoryDoors.makeDoors();
    DirectoryUsers.makeUsers();

    // Starts listening to simulator and mobile app requests
    new WebServer();
  }
}