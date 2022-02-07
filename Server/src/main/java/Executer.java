import java.io.IOException;
import java.net.ServerSocket;

public class Executer {

    private static final int PORT = 8000;

    public static void main(String[] args) {
        System.out.println("Server started");
        try {
            ConectionListener conectionListener = new ConectionListener(new ServerSocket(PORT));
            conectionListener.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
