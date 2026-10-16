package baseNoStates.users;

import baseNoStates.areas.Area;
import baseNoStates.areas.Space;

import java.time.LocalDateTime;
import java.util.List;

// Defines the Role-Based Access Control (RBAC) profile
// Groups the rules answering: "Where" (Areas), "What" (Actions), and "When" (Schedule)
public class UserGroup {
  private final String name;
  private final Schedule schedule;
  private final List<String> actions;
  private final List<Area> areas;

  public UserGroup (String name, Schedule schedule, List<String> actions, List<Area> areas) {
    this.name = name;
    this.schedule = schedule;
    this.actions = actions;
    this.areas = areas;
  }

  public String getName() { return name; }

  public boolean canSendRequests(LocalDateTime now) {
    return schedule.canSendRequests(now);
  }

  public boolean canDoAction(String action) {
    return actions.contains(action);
  }

  public boolean canBeInSpace (Space space) {
    for (Area area : areas) {
      if (area.getSpaces().contains(space)) {
        return true;
      }
    }
    return false;
  }
}
