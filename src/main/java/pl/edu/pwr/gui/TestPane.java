package pl.edu.pwr.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pl.edu.pwr.carnivoreherbivore.PawnManager;

public class TestPane extends JPanel {

    PawnManager pawnManager;

    public TestPane(PawnManager pawnManager) {
        this.pawnManager = pawnManager;
        Timer timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timer.start();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(GUIMain.MAP_WIDTH, GUIMain.MAP_HEIGHT);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < pawnManager.getPawnList().size(); i++) {
            PawnDrawManager.drawEveryEntity(pawnManager.getPawnList(), g);
        }
    }
}
