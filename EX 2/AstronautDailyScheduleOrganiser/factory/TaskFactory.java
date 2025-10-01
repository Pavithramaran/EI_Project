package factory;

import main.Task;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class TaskFactory {
    public Task createTask(String description, String start, String end, String priority) throws Exception {
        try {
            LocalTime startTime = LocalTime.parse(start);
            LocalTime endTime = LocalTime.parse(end);
            if (endTime.isBefore(startTime)) {
                throw new Exception("Error: End time cannot be before start time.");
            }
            return new Task(description, startTime, endTime, priority);
        } catch (DateTimeParseException e) {
            throw new Exception("Error: Invalid time format (expected HH:mm).");
        }
    }
}