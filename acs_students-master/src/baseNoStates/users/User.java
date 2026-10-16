package baseNoStates.users;

import baseNoStates.areas.Area;
import baseNoStates.areas.Space;

import java.time.LocalDateTime;
import java.util.ArrayList;

// Represents a system user.
// Permisions are no longer hardcoded here; they are delegated to the UserGroup
public class User {
  private final String name;
  private final String credential;
  private final UserGroup group;

  public User(String name, String credential, UserGroup group) {
    this.name = name;
    this.credential = credential;
    this.group = group;
  }

  public String getCredential() {
    return credential;
  }

  public boolean canSendRequests(LocalDateTime now) {
    return group.canSendRequests(now);
  }

  public boolean canDoAction(String action) {
    return group.canDoAction(action);
  }

  // Evaluates if the user is authorized to enter a specific space
  // by checking if it belongs to any of their allowed areas.
  public boolean canBeInSpace(Space sp) {
    return group.canBeInSpace(sp);
  }

  @Override
  public String toString() {
    return "User{name=" + name + ", credential=" + credential + "}";
  }
}
