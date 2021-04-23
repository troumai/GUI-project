import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    private static Connection connection;
    private static String url = "jdbc:postgresql://localhost:5432/oop";
    private static String user="postgres";
    private static String password = "1234567";
    public static void connect(){
        try {
            Class.forName("org.postgresql.Driver");///////путь к драйверу
            connection = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public void addStudent(Student student) throws SQLException {
        String sql = "INSERT INTO Students(id, name, surname, faculty, groups) VALUES (default, ?, ?, ?, ?);";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, student.getName());
        statement.setString(2, student.getSurname());
        statement.setString(3, student.getFaculty());
        statement.setString(4, student.getGroup());

        statement.executeUpdate();//Insert, delete, update

        statement.close();
    }
    public ArrayList<Student> getAllStudents() throws SQLException {
        ArrayList<Student>studentList=new ArrayList<>();
        String sql = "select*from Students";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            Integer id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String faculty = resultSet.getString("faculty");
            String group = resultSet.getString("groups");

            studentList.add(new Student(id, name, surname, faculty, group));
        }
        statement.close();
        return studentList;
    }
}
