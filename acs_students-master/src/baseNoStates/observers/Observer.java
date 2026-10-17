package baseNoStates.observers;

// Contract for the Observer pattern
// Any class implementing this will receive preiodic updates from the Observable subject
public interface Observer {
  void update();
}
