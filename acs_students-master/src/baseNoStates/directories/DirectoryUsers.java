package baseNoStates.directories;

import baseNoStates.areas.Area;
import baseNoStates.User;

import java.util.ArrayList;

// Creates the users and assigns them specific access rights based on the building areas
// to simulate different roles (e.g., Admin, Manager, Employee).
public final class DirectoryUsers {
  private static final ArrayList<User> users = new ArrayList<>();

  public static void makeUsers() {
    //TODO: make user groups according to the specifications in the comments, because
    // now all are the same
    Area building = DirectoryAreas.findAreaById("building");
    Area basement = DirectoryAreas.findAreaById("basement");
    Area ground = DirectoryAreas.findAreaById("ground_floor");
    Area floor1 = DirectoryAreas.findAreaById("floor1");
    Area stairs = DirectoryAreas.findAreaById("stairs");
    Area exterior = DirectoryAreas.findAreaById("exterior");

    // users without any privilege, just to keep temporally users instead of deleting them,
    // this is to withdraw all permissions but still to keep user data to give back
    // permissions later
    users.add(new User("Bernat", "12345"));
    users.add(new User("Blai", "77532"));

    // employees :
    // Sep. 1 this year to Mar. 1 next year
    // week days 9-17h
    // just shortly unlock
    // ground floor, floor1, exterior, stairs (this, for all), that is, everywhere but the parking
    User ernest = new User("Ernest", "74984");
    ernest.addArea(ground);
    ernest.addArea(floor1);
    ernest.addArea(stairs);
    ernest.addArea(exterior);
    users.add(ernest);

    User eulalia = new User("Eulalia", "43295");
    eulalia.addArea(ground);
    eulalia.addArea(floor1);
    eulalia.addArea(stairs);
    eulalia.addArea(exterior);
    users.add(eulalia);


    // managers :
    // Sep. 1 this year to Mar. 1 next year
    // week days + saturday, 8-20h
    // all actions
    // all spaces
    User manuel = new User("Manel", "95783");
    manuel.addArea(building);
    users.add(manuel);

    User marta = new User("Marta", "05827");
    marta.addArea(building);
    users.add(marta);

    // admin :
    // always=Jan. 1 this year to 2100
    // all days of the week
    // all actions
    // all spaces
    User ana = new User("Ana", "11343");
    ana.addArea(building);
    users.add(ana);
  }

  public static User findUserByCredential(String credential) {
    for (User user : users) {
      if (user.getCredential().equals(credential)) {
        return user;
      }
    }
    System.out.println("user with credential " + credential + " not found");
    return null; // otherwise we get a Java error
  }

}
