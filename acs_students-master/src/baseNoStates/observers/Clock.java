package baseNoStates.observers;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

// Singleton clock running on a separate parallel thread
// It acts as the Observable subject, notifying subscribed states every second
public class Clock implements Observable {
  private static Clock instance;
  private final Timer timer;
  private final List<Observer> observers;

  private Clock() {
    observers = new ArrayList<>();
    timer = new Timer(true);

    // Executes the run() method every 1000 milliseconds
    timer.scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
        notifyObservers();
      }
    }, 0, 1000);
  }

  // Ensures only one global clocke xists in the entire system
  // synchronized: every request runs in its own thread, so two of them could create
  // the clock at the same time and we would end up with two clocks
  public static synchronized Clock getInstance() {
    if (instance == null) {
      instance = new Clock();
    }
    return instance;
  }

  // The lock must be the shared list (the same one notifyObservers locks), not the
  // observer: locking different objects does not prevent the clock thread and a request
  // thread from modifying the list at the same time
  @Override
  public void addObserver(Observer observer) {
    synchronized (observers) {
      observers.add(observer);
    }
  }

  @Override
  public void deleteObserver(Observer observer) {
    synchronized (observers) {
      observers.remove(observer);
    }
  }

  // Boradcasts the 1-second tick to all currently active subscribers
  private void notifyObservers() {
    synchronized (observers) {

      // Create a copy to avoid ConcurrentModificationException if an observer removes itself during the loop
      List<Observer> copy = new ArrayList<>(observers);
      for (Observer observer : copy) {
        observer.update();
      }
    }
  }
}