package pl.edu.pwr.gui;

import pl.edu.pwr.carnivoreherbivore.pawn.Pawn;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GUIMain {
    public static final int MAP_WIDTH = 1024;
    public static final int MAP_HEIGHT = 800;

    TestPane testPane;

    public void SetNewPawnList(ArrayList<Pawn> pawnArrayList) {
        testPane.SetNewPawnList(pawnArrayList);
    }

    public GUIMain(ArrayList<Pawn> pawnList) {
        testPane = new TestPane(pawnList);
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    System.out.println(ex.toString());
                }

                JFrame frame = new JFrame("Simulation GUI test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(testPane);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}
