package main;

import factory.TaskFactory;
import observer.ConflictObserver;
import proxy.ScheduleProxy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        TaskFactory factory = new TaskFactory();
        ScheduleProxy proxy = new ScheduleProxy();

        ScheduleManager.getInstance().addObserver(new ConflictObserver());

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Astronaut Daily Schedule Organizer ---");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View Tasks");
            System.out.println("4. View by Priority");
            System.out.println("5. Daily Summary");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Description: ");
                    String desc = sc.nextLine();
                    System.out.print("Start Time (HH:mm): ");
                    String start = sc.nextLine();
                    System.out.print("End Time (HH:mm): ");
                    String end = sc.nextLine();
                    System.out.print("Priority (High/Medium/Low): ");
                    String priority = sc.nextLine();
                    try {
                        Task task = factory.createTask(desc, start, end, priority);
                        proxy.addTask(task);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Enter task description to remove: ");
                    String removeDesc = sc.nextLine();
                    if (!proxy.removeTask(removeDesc)) {
                        System.out.println("Error: Task not found.");
                    }
                    break;
                case 3:
                    proxy.viewTasks();
                    break;
                case 4:
                    System.out.print("Enter priority: ");
                    String p = sc.nextLine();
                    proxy.viewByPriority(p);
                    break;
                case 5:
                    proxy.dailySummary();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}