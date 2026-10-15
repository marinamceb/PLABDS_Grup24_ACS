package baseNoStates;

import java.util.ArrayList;

// Represents a system user.
// The 'areas' list defines their access permissions (Role-Based Access Control - RBAC).
public class User {
  private final String name;
  private final String credential;
  private ArrayList<Area> areas;

  public User(String name, String credential) {
    this.name = name;
    this.credential = credential;
    this.areas = new ArrayList<>();
  }

  public void addArea(Area area) {
    this.areas.add(area);
  }

  public String getCredential() {
    return credential;
  }

  // Evaluates if the user is authorized to enter a specific space
  // by checking if it belongs to any of their allowed areas.
  public boolean canBeInSpace(Space sp) {
    for (Area area : areas) {

      if (area.getSpaces().contains(sp)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    return "User{name=" + name + ", credential=" + credential + "}";
  }
}
