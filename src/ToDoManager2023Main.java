import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ToDoManager2023Main {
    public static JFrame frame;
    public static void main (String[] args){
        ToDoManager toDoManager =  new ToDoManager();
        frame = new JFrame("ToDOManager");
        frame.setSize(1200,900);
        frame.setContentPane(new MainScreen(toDoManager).$$$getRootComponent$$$());
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                toDoManager.saveAllToDos();
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
