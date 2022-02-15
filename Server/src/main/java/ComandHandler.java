import controllers.TaskController;
import exceptions.NotFoundException;
import transport.Reqest;

import java.io.IOException;
import java.sql.Time;
import java.util.UUID;

public class ComandHandler {

    public static void parseCommand(Reqest reqest) throws IOException, NotFoundException {
        TaskController controller = new TaskController();

        switch (reqest.getCommand()){
            case "add":
                controller.sheduleTask(reqest.getUserId(), reqest.getTaskName(), reqest.getTaskDesc(), reqest.getAlertTime());
                break;
            case "delete":
                controller.deleteTask(reqest.getTaskId());
                break;
            case "update":
                controller.updateTask(reqest.getTaskId(), reqest.getTaskName(), reqest.getTaskDesc());
                break;
            case "unshedule":
                controller.unsheludeTask(reqest.getTaskId());
                break;
            default: throw new IllegalArgumentException("invalid case");
        }

    }
}
