package areas;

import baseNoStates.Door;
import java.util.ArrayList;
import java.util.Arrays;

/*
CLASSE DIRECTORYAREAS:
* Construeix i manté l'arbre de l'edifici.
*/
public class DirectoryAreas {
  // Atributs
  private Area rootArea; // Arrel de l'arbre
  private ArrayList<Door> allDoors = new ArrayList<>(); // Portes

  // Retorna l'arrel de l'edifici
  public Area getRootArea() {
    return rootArea;
  }

  //Construeix l'arbre complet de l'edifici amb particions, espais i portes.
  public void makeAreas() {
    // Inicialització de les particions
    Partition building = new Partition("building");
    Partition basement = new Partition("basement");
    Partition groundFloor = new Partition("groundFloor");
    Partition floor1 = new Partition("floor1");

    // Afegir les plantes a l'edifici
    building.addArea(basement);
    building.addArea(groundFloor);
    building.addArea((floor1));

    // Creació d'espais
    Space parking = new Space("parking");
    Space stairs = new Space("stairs");
    Space exterior = new Space("exterior");
    Space room1 = new Space("room1");
    Space room2 = new Space("room2");
    Space hall = new Space("hall");
    // Space restRoom = new Space("restRoom"); // No té porta, no la fico a les particions :)
    Space room3 = new Space("room3");
    Space corridor = new Space("corridor");
    Space IT = new Space("IT");

    // Afegir espais generals a l'edifici
    building.addArea(exterior);
    building.addArea(stairs);

    // Afegir espais a les particions
    basement.addArea(parking);
    groundFloor.addArea(room1);
    groundFloor.addArea(room2);
    groundFloor.addArea(hall);
    floor1.addArea(room3);
    floor1.addArea(corridor);
    floor1.addArea(IT);

    // Crear portes: Door(id, fromSpace, toSpace)
    Door d1 = new Door("D1", exterior, parking);
    Door d2 = new Door("D2", stairs, parking);
    Door d3 = new Door("D3", exterior, hall);
    Door d4 = new Door("D4", stairs, hall);
    Door d5 = new Door("D5", room1, hall);
    Door d6 = new Door("D6", room2, hall);
    Door d7 = new Door("D7", corridor, IT);
    Door d8 = new Door("D8", room3, corridor);
    Door d9 = new Door("D9", IT, corridor);

    // Afegir portes a l'edifici
    allDoors.add(d1);
    allDoors.add(d2);
    allDoors.add(d3);
    allDoors.add(d4);
    allDoors.add(d5);
    allDoors.add(d6);
    allDoors.add(d7);
    allDoors.add(d8);
    allDoors.add(d9);

    // Guardar edifici a l'arrel
    rootArea = building;
  }

  // Cerca una àrea pel seu ID de forma recursiva.
  public Area findAreaById(String id) {
    if(rootArea.id == null) {
      return null;
    }
    return rootArea.findAreaById(id);
  }

  // Cerca una porta pel seu ID dins la llista de portes.
  public Door findDoorById(String id) {
    for(Door door : allDoors) {
      if(door.getId().equals(id)) {
        return door;
      }
    }
    return null;
  }

  // Retorna la llista de totes les portes de l'edifici
  public ArrayList<Door> getAllDoors() {
    return allDoors;
  }
}
