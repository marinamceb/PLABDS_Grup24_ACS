package baseNoStates;

import areas.*;

// Before executing enable assertions :
// https://se-education.org/guides/tutorials/intellijUsefulSettings.html

public class Main {
  public static void main(String[] args) {
    /*
    DirectoryDoors.makeDoors();
    DirectoryUsers.makeUsers();
    new WebServer();
    */

    // Build the hierarchy of areas and doors
    DirectoryAreas.makeAreas();
    // Load the system users
    DirectoryUsers.makeUsers();
    // Inicializes the ACU
    new WebServer();
  }
}
