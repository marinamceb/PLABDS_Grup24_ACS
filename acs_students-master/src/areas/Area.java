package areas;

import baseNoStates.Door;
import java.util.ArrayList;

/*
CLASSE AREA:
* Classe abstracta base que representa el Component dins del patró de disseny Composite.
* Defineix la interfície comuna i els mètodes abstractes (getDoorsGivingAccess, findAreaById, getSpaces)
  per poder tractar de manera uniforme tant espais individuals (Space) com grups d'àrees (Partition).
*/

public abstract class Area {
  protected String id;

  public Area(String id) {
    this.id = id;
  }
  public String getId() {
    return id;
  }

  public abstract ArrayList<Door> getDoorsGivingAccess();
  public abstract Area findAreaById(String id);
  public abstract ArrayList<Space> getSpaces();
}
