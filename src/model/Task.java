package model;

import java.time.LocalDate;

public class Task {
    private static int nextId = 1;
    private int idTask;
    private String nameTask;
    private String descriptionTask;
    private LocalDate startDateTask;
    private LocalDate endDateTask;
    private Status statusTask;

    public Task() {
        this.idTask = nextId;
        nextId++;
    }

    public int getIdTask(){
        return idTask;
    }

    public String getNameTask(){
        return nameTask;
    }

    public void setNameTask(String nameTask){
        this.nameTask = nameTask;
    }

    public String getDescriptionTask() {
        return descriptionTask;
    }

    public void setDescriptionTask(String descriptionTask) {
        this.descriptionTask = descriptionTask;
    }
    public LocalDate getStartDateTask() {
        return startDateTask;
    }

    public void setStartDateTask(LocalDate startDateTask) {
        this.startDateTask = startDateTask;
    }

    public LocalDate getEndDateTask() {
        return endDateTask;
    }

    public void setEndDateTask(LocalDate endDateTask) {
        this.endDateTask = endDateTask;
    }

    public Status getStatusTask() {
        return statusTask;
    }

    public void setStatusTask(Status statusTask) {
        this.statusTask = statusTask;
    }
}
