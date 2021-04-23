import javax.swing.*;

public class MainFrame extends JFrame {
    public static MainMenu mainWindow;
    public static AddStudent addWindow;
    public static ListStudent listWindow;

    public MainFrame(){
        setSize(500, 400);
        setTitle("STUDENT APPLICATION");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainWindow = new MainMenu();
        setLocation(0,0);
        add(mainWindow);

        addWindow = new AddStudent();
        setLocation(0, 0);
        addWindow.setVisible(false);
        add(addWindow);

        listWindow = new ListStudent();
        setLocation(0, 0);
        listWindow.setVisible(false);
        add(listWindow);
    }
}
