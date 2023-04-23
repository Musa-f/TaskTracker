package controller;

import model.Status;
import model.Task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(String name, String description, LocalDate startDate, LocalDate endDate, Status statusTask){
        Task newTask = new Task();
        newTask.setNameTask(name);
        newTask.setDescriptionTask(description);
        newTask.setStartDateTask(startDate);
        newTask.setEndDateTask(endDate);
        newTask.setStatusTask(statusTask);
        tasks.add(newTask);
    }

    public void deleteTask(int idTask){
        for(Task task : tasks){
            if(task.getIdTask() == idTask){
                tasks.remove(task);
                break;
            }
        }
    }

    public void updateTask(int idTask, Status statusTask){
        for(Task task : tasks){
            if(task.getIdTask() == idTask){
                task.setStatusTask(statusTask);
                break;
            }
        }
    }

    public void editTask(int idTask, String newName, String newDescription, LocalDate newStartDate, LocalDate newEndDate){
        for(Task task : tasks){
            if(task.getIdTask() == idTask){
                if(newName != null){
                    task.setNameTask(newName);
                }
                if(newDescription != null){
                    task.setDescriptionTask(newDescription);
                }
                if(newStartDate != null){
                    task.setStartDateTask(newStartDate);
                }
                if(newEndDate != null){
                    task.setEndDateTask(newEndDate);
                }
                break;
            }
        }
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
