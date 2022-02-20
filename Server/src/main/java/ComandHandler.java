import controllers.TaskController;
import exceptions.NotFoundException;
import transport.Reqest;
import transport.Response;

import java.io.IOException;
import java.sql.Time;
import java.util.UUID;

public class ComandHandler {
    private static TaskController taskController = new TaskController();
    private static String userId;

    public static Response parseCommand(Reqest reqest) throws IOException, NotFoundException {

        switch (reqest.getCommand()){
            case "add":
                taskController.sheduleTask(reqest.getUserId(), reqest.getTaskName(), reqest.getTaskDesc(), reqest.getAlertTime());
                return null;
                /*return new Response();*/
            case "delete":
                taskController.deleteTask(reqest.getTaskId());
                return null;
            case "update":
                taskController.updateTask(reqest.getTaskId(), reqest.getTaskName(), reqest.getTaskDesc());
                return null;
            case "unshedule":
                taskController.unsheludeTask(reqest.getTaskId());
                return null;
            default: throw new IllegalArgumentException("invalid case");
        }

    }

    /*private static String createResponse() {
        taskController.getAllTasks();
    }*/
}
