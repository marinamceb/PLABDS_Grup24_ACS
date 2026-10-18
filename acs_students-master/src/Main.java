import areas.DirectoryAreas;
import users.DirectoryUserGroup;
import users.DirectoryUsers;


public class Main {
  public static void main(String[] args) {
    // The ACS (Access Control System) must be built in a strict top-down order:
    // 1. Areas and Doors (physical structure) -> 2. Groups -> 3. Users (permissions)
    DirectoryAreas.makeAreas();
    DirectoryUserGroup.makeUserGroups();
    DirectoryUsers.makeUsers();

    // Starts listening to simulator and mobile app requests
    new WebServer();
  }
}