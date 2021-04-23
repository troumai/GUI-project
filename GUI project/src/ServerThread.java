import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServerThread extends Thread{
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }
    public void run(){
        try {
            DBManager manager = new DBManager();
            manager.connect();

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            PackageData packageData= null;
            while((packageData=(PackageData)inputStream.readObject())!=null){
                if(packageData.getOperationType().equals("ADD")){/////add, student
                    Student studentFromClient = packageData.getStudent();
                    manager.addStudent(studentFromClient);
                }
                else if(packageData.getOperationType().equals("LIST")){
                    ArrayList<Student> infoForClient = manager.getAllStudents();
                    PackageData toClient = new PackageData(infoForClient);
                    outputStream.writeObject(toClient);
                }
            }
            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

}
