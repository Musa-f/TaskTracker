import controller.TaskManager;
import model.Database;
import model.Status;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        TaskManager taskManager = new TaskManager();
        taskManager.addTask("Faire la vaisselle", "", LocalDate.of(2022, 4, 18), LocalDate.of(2022, 4, 19), Status.TODO);
        taskManager.addTask("lunch", "", LocalDate.of(2022, 4, 18), LocalDate.of(2022, 4, 19), Status.IN_PROGRESS);
        taskManager.addTask("rdv dentiste", "", LocalDate.of(2022, 4, 18), LocalDate.of(2022, 4, 19), Status.TODO);

        /*taskManager.deleteTask(2);
        taskManager.updateTask(3, Status.IN_PROGRESS);

        for (Task task : taskManager.getTasks()) {
            if(task.getStatusTask() == Status.TODO){
                System.out.println(task.getIdTask() + task.getNameTask() + " - " + task.getStatusTask());
            }
        }*/

        //new Frame(taskManager);
        new Database();
    }
}
