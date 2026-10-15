package baseNoStates;

import areas.*;

import java.util.ArrayList;

public class User {
  private final String name;
  private final String credential;
  private Area areas; // ??? SESSION 2

  public User(String name, String credential) {
    this.name = name;
    this.credential = credential;
  }

  public String getCredential() {
    return credential;
  }

  @Override
  public String toString() {
    return "User{name=" + name + ", credential=" + credential + "}";
  }

  // ??? SESSION 2
  public Boolean canBeInSpace(Space sp) {
    // ???
    return null;
  }

  // ??? SESSION 2
  private ArrayList<Space> getSpaces() {
    //???
    return null;
  }
}
