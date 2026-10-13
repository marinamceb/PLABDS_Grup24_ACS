package areas;

import baseNoStates.Door;
import java.util.ArrayList;

/*
CLASSE PARTITION:
* Representa una agrupació jeràrquica d'àrees; la classe Composite dins del patró de disseny Composite.
* Conté el conjunt de sub-àrees (tant Partition com Space).
*/

public class Partition extends Area {
  // Atribut: Llistat d'àrees que conté la partició.
  private ArrayList<Area> areas;

  // Constructor: Id de l'àrea i inicialitza l'array d'àrees.
  public Partition(String id) {
    super(id); //Crida al constructor Area(id)
    this.areas = new ArrayList<>();
  }

  // Afegeix una àrea a la partició.
  public void addArea(Area area) {
    if(!areas.contains(area)) {
      areas.add(area);
    }
  }

  // Retorna les portes de les àrees de la partició.
  @Override
  public ArrayList<Door> getDoorsGivingAccess() {
    ArrayList<Door> doors = new ArrayList<>();
    for(Area area : areas) {
      for(Door door : area.getDoorsGivingAccess()) {
        if(!doors.contains(door))
        {
          doors.add(door);
        }
      }
    }
    return doors;
  }

  // Es retorna a ell mateix o una de les àrees que conté si l'id coincideix, o NULL si cap id coincideix.
  @Override
  public Area findAreaById(String id) {
    if(this.id.equals(id)) {
      return this;
    }
    for(Area area : areas)
    {
      Area foundArea = area.findAreaById(id);
      if(foundArea != null) {
        return foundArea;
      }
    }
    return null;
  }

  // Retorna tots els espais que conté.
  @Override
  public ArrayList<Space> getSpaces() {
    ArrayList<Space> spaces = new ArrayList<>();
    for(Area area : areas) {
      spaces.addAll(area.getSpaces());
    }
    return spaces;
  }
}
