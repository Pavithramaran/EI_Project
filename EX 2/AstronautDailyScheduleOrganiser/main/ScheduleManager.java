package main;

import observer.Observer;
import java.time.LocalTime;
import java.util.*;

public class ScheduleManager {
    private static ScheduleManager instance;
    private final List<Task> tasks;
    private final List<Observer> observers;

    private ScheduleManager() {
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers(Task existing, Task newTask) {
        for (Observer obs : observers) {
            obs.notifyConflict(existing, newTask);
        }
    }

    public boolean addTask(Task task) {
        for (Task t : tasks) {
            if (task.getStartTime().isBefore(t.getEndTime()) &&
                task.getEndTime().isAfter(t.getStartTime())) {
                
                // Conflict -> Suggest free slot
                Task suggestion = suggestSlot(task);
                notifyObservers(t, task);
                if (suggestion != null) {
                    System.out.println("Suggested slot: " 
                            + suggestion.getStartTime() + " - " + suggestion.getEndTime());
                }
                return false;
            }
        }
        tasks.add(task);
        tasks.sort(Comparator.comparing(Task::getStartTime));
        System.out.println("Task added successfully. No conflicts.");
        return true;
    }

    private Task suggestSlot(Task newTask) {
        LocalTime start = newTask.getStartTime();
        LocalTime end = newTask.getEndTime();

        for (Task t : tasks) {
            if (start.isBefore(t.getEndTime()) && end.isAfter(t.getStartTime())) {
                start = t.getEndTime();
                end = start.plusMinutes(
                        java.time.Duration.between(newTask.getStartTime(), newTask.getEndTime()).toMinutes()
                );
            }
        }

        if (end.isBefore(LocalTime.MAX.minusMinutes(1))) {
            return new Task(newTask.getDescription(), start, end, newTask.getPriority());
        }
        return null;
    }

    public boolean removeTask(String description) {
        return tasks.removeIf(t -> {
            if (t.getDescription().equalsIgnoreCase(description)) {
                System.out.println("Task removed successfully.");
                return true;
            }
            return false;
        });
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
            return;
        }
        for (Task t : tasks) {
            System.out.println(t);
        }
    }

    public void viewByPriority(String priority) {
        tasks.stream()
                .filter(t -> t.getPriority().equalsIgnoreCase(priority))
                .forEach(System.out::println);
    }

    // New Feature: Daily Summary
    public void dailySummary() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
            return;
        }

        long completed = tasks.stream().filter(Task::isCompleted).count();
        long pending = tasks.size() - completed;

        System.out.println("\n--- Daily Mission Summary ---");
        System.out.println("Total Tasks: " + tasks.size());
        System.out.println("Completed: " + completed);
        System.out.println("Pending: " + pending);

        tasks.stream()
             .filter(t -> !t.isCompleted())
             .min(Comparator.comparing(t -> {
                 switch (t.getPriority().toLowerCase()) {
                     case "high": return 1;
                     case "medium": return 2;
                     default: return 3;
                 }
             }))
             .ifPresent(t -> System.out.println("Highest Priority Pending Task: " + t));

        System.out.println("Available Free Slots:");
        for (int i = 0; i < tasks.size() - 1; i++) {
            Task current = tasks.get(i);
            Task next = tasks.get(i + 1);
            if (current.getEndTime().isBefore(next.getStartTime())) {
                System.out.println(current.getEndTime() + " - " + next.getStartTime());
            }
        }
        System.out.println("------------------------------");
    }
}