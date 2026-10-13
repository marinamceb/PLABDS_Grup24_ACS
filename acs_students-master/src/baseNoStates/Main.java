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

    // Construeix la jerarquia d'àrees i portes
    DirectoryAreas.makeAreas();
    // Carrega els usuaris del sistema
    DirectoryUsers.makeUsers();
    // Inicialitza l'ACU
    new WebServer();
  }
}
