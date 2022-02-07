import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ConectionListener {

    private ServerSocket serverSocket;

    public ConectionListener(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void start() throws IOException {
        try {
            while (true){
                Socket socket = serverSocket.accept();
                System.out.println("client connected");
                Server newConection = new Server(socket);
                newConection.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            serverSocket.close();
        }
    }

}
