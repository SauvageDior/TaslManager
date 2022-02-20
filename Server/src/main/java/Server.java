import controllers.TaskController;
import controllers.TimerScheduler;
import exceptions.NotFoundException;
import model.Task;
import transport.Reqest;
import transport.Response;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Time;
import java.util.List;
import java.util.Timer;
import java.util.UUID;

public class Server extends Thread {
    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public Server(Socket socket) throws IOException {
        this.socket = socket;
        this.oos = new ObjectOutputStream(socket.getOutputStream());
        this.ois = new ObjectInputStream(socket.getInputStream());
    }

    public Server() {
    }

    public void run() {
        TimerScheduler scheduler = getTimer();
        ComandHandler comandHandler = new ComandHandler();
        while (true) {
            try {
                Reqest reqest = (Reqest) ois.readObject();
                Response response = comandHandler.parseCommand(reqest);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException | NotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private TimerScheduler getTimer() {
        TaskController controller = new TaskController();
        List<Task> taskList = null;
        try {
            taskList = controller.getAllTasks(UUID.fromString("f5643624-0494-492c-9225-7cc576b1fdef"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Time timeTemplate = new Time(999, 59, 60);
        Task executedTask = null;
        for(Task cur : taskList) {
            if(cur.getAlert().getAlertTime().getTime() < timeTemplate.getTime()) {
                executedTask = cur;
                timeTemplate = cur.getAlert().getAlertTime();
            }
        }
        TimerScheduler scheduler = new TimerScheduler(3);
        return scheduler;
    }
}
