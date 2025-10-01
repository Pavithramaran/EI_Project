package observer;

import main.Task;

public interface Observer {
    void notifyConflict(Task existing, Task newTask);
}