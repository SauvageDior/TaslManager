import exceptions.NotFoundException;
import transport.Reqest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

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
        while (true) {
            try {
                Reqest reqest = (Reqest) ois.readObject();
                ComandHandler comandHandler = new ComandHandler();
                comandHandler.parseCommand(reqest);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException | NotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
