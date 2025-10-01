package observer;

import main.Task;

public class ConflictObserver implements Observer {
    @Override
    public void notifyConflict(Task existing, Task newTask) {
        System.out.println("Error: Task conflicts with existing task \"" 
                           + existing.getDescription() + "\".");
    }
}