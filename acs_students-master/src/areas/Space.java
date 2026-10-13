package areas;

import baseNoStates.Door;
import java.util.ArrayList;

/*
CLASSE SPACE:
* Representa un espai o habitació concreta de l'edifici.
* Representa una classe Leaf dins del patró de disseny Composite.
* Conté la llista de portes que donen accès directe a l'espai.
* Com a node fulla, la cerca d'àrees es limita a la seva pròpia comprovació i retorna únicament
  les seves portes associades.
*/

public class Space extends Area {
  // Atribut: Array de portes que serveixen per accedir a l'espai.
  private ArrayList<Door> doors;

  // Constructor: Id de l'àrea i inicialitza l'array de portes.
  public Space(String id) {
    super(id); //Crida al constructor Area(id)
    this.doors = new ArrayList<>();
  }

  // Afegeix una porta per accedir a l'espai.
  public void addDoor(Door door) {
    if(!doors.contains(door)) {
      doors.add(door);
    }
  }

  // Retorna les portes del'espai.
  @Override
  public ArrayList<Door> getDoorsGivingAccess() {
    return doors;
  }

  // Es retorna a ell mateix si l'id coincideix o NULL si no.
  @Override
  public Area findAreaById(String id) {
    if(this.id.equals(id)) {
      return this;
    }
    return null;
  }

  // Retorna un Array amb ell mateix.
  @Override
  public ArrayList<Space> getSpaces() {
    ArrayList<Space> spaces = new ArrayList<>();
    spaces.add(this);
    return spaces;
  }
}
