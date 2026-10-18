package users;

import areas.DirectoryAreas;
import areas.Area;
import doorstates.Actions;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// factory and registry for Role profiles (User Groups)
// Initializes the system's roles acording to the specifications
public class DirectoryUserGroup {
  private static final List<UserGroup> userGroups = new ArrayList<>();

  public static void makeUserGroups() {
    Area building = DirectoryAreas.findAreaById("building");
    Area ground = DirectoryAreas.findAreaById("ground_floor");
    Area floor1 = DirectoryAreas.findAreaById("floor1");
    Area stairs = DirectoryAreas.findAreaById("stairs");
    Area exterior = DirectoryAreas.findAreaById("exterior");

    // Admin: Can do anything, anywhere, anytime
    Schedule adminSchedule = new Schedule(LocalDate.MIN, LocalDate.MAX, LocalTime.MIN, LocalTime.MAX, Arrays.asList(DayOfWeek.values()));
    List<String> allActions = Arrays.asList(Actions.OPEN, Actions.CLOSE, Actions.LOCK, Actions.UNLOCK, Actions.UNLOCK_SHORTLY);
    userGroups.add(new UserGroup("Admin", adminSchedule, allActions, Arrays.asList(building)));

    // Manager: Specific months, M-Sat, 8h-20h
    Schedule managerSchedule = new Schedule(LocalDate.of(2026, 9, 1), LocalDate.of(2027, 3, 1), LocalTime.of(8, 0), LocalTime.of(20, 0),
        Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY));
    userGroups.add(new UserGroup("Manager", managerSchedule, allActions, Arrays.asList(building)));

    // Employee: M-F, 9h-17h. Can't access parking.
    Schedule empSchedule = new Schedule(LocalDate.of(2026, 9, 1), LocalDate.of(2027, 3, 1), LocalTime.of(9, 0), LocalTime.of(17, 0),
        Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY));
    List<String> empActions = Arrays.asList(Actions.OPEN, Actions.CLOSE, Actions.UNLOCK_SHORTLY);
    userGroups.add(new UserGroup("Employee", empSchedule, empActions, Arrays.asList(ground, floor1, stairs, exterior)));

    // Blank: No permissions
    Schedule blankSchedule = new Schedule(LocalDate.MAX, LocalDate.MAX, LocalTime.MIN, LocalTime.MIN, new ArrayList<>());
    userGroups.add(new UserGroup("Blank", blankSchedule, new ArrayList<>(), new ArrayList<>()));
  }

  public static UserGroup findGroupByName(String name) {
    for (UserGroup g : userGroups) {
      if (g.getName().equals(name)) return g;
    }
    return null;
  }
}
