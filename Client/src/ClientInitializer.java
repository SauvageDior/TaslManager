import java.io.IOException;
import java.net.Socket;

public class ClientInitializer {
    private static final int PORT = 8000;
    private static final String HOST = "127.0.0.1";

    public static void main(String[] args) {
        try {
            Client client = new Client(new Socket(HOST, PORT));
            client.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
