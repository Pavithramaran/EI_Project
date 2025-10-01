package proxy;

import main.ScheduleManager;
import main.Task;

public class ScheduleProxy {
    private final ScheduleManager manager;

    public ScheduleProxy() {
        this.manager = ScheduleManager.getInstance();
    }

    public boolean addTask(Task task) {
        return manager.addTask(task);
    }

    public boolean removeTask(String description) {
        return manager.removeTask(description);
    }

    public void viewTasks() {
        manager.viewTasks();
    }

    public void viewByPriority(String priority) {
        manager.viewByPriority(priority);
    }

    public void dailySummary() {
        manager.dailySummary();
    }
}