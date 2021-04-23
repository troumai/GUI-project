import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListStudent extends Container {
    public static JTextArea text;
    private JButton buttonList;
    private JButton buttonBack;

    public ListStudent(){
        setSize(500, 400);
        setLayout(null);

        text = new JTextArea();
        text.setBounds(90, 50, 300, 150);
        add(text);

        buttonList = new JButton("LIST STUDENTS");
        buttonList.setBounds(90, 220, 145, 30);
        buttonList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PackageData pd  = new PackageData("LIST");
                Main.connect(pd);
            }
        });
        add(buttonList);

        buttonBack = new JButton("BACK");
        buttonBack.setBounds(245, 220, 145, 30);
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.listWindow.setVisible(false);
                Main.frame.mainWindow.setVisible(true);
            }
        });
        add(buttonBack);
    }
}
