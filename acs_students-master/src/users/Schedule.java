package users;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

// Defines the temporal access window (When) for a user group
// Evaluates if the current date, time, and weekday fall within the allowed limits
public class Schedule {
  private final LocalDate startDate;
  private final LocalDate endDate;
  private final LocalTime startTime;
  private final LocalTime endTime;
  private final List<DayOfWeek> daysOfWeeks;

  public Schedule(LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime, List<DayOfWeek> daysOfWeek) {
    this.startDate = startDate;
    this.endDate = endDate;
    this.startTime = startTime;
    this.endTime = endTime;
    this.daysOfWeeks = daysOfWeek;
  }

  public boolean canSendRequests(LocalDateTime now) {
    LocalDate date = now.toLocalDate();
    LocalTime time = now.toLocalTime();
    DayOfWeek day = now.getDayOfWeek();

    if (date.isBefore(startDate) || date.isAfter(endDate)) return false;
    if (time.isBefore(startTime) || time.isAfter(endTime)) return false;
    if (!daysOfWeeks.contains(day)) return false;

    return true;
  }
}
