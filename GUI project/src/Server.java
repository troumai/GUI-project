import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);

        while(true){
            System.out.println("Waiting clients");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            ServerThread st = new ServerThread(socket);
            st.start()  ;
        }
    }
}
