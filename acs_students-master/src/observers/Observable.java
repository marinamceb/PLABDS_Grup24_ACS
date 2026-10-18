package observers;

// Contract for the subjet in the Observer pattern
// Manages a list of subscribers that want to be notified of events
public interface Observable {
  void addObserver(Observer observer);
  void deleteObserver(Observer observer);
}
