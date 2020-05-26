package pl.edu.pwr.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import pl.edu.pwr.carnivoreherbivore.pawn.Pawn;

public class TestPane extends JPanel {

    public ArrayList<Pawn> pawnList;

    public TestPane(ArrayList<Pawn> pawnList) {
        this.pawnList = pawnList;
        Timer timer = new Timer(0, new ActionListener() {
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

        for (int i = 0; i < pawnList.size(); i++) {
            PawnDrawManager.drawEveryEntity(pawnList, g);
        }
    }

    public void SetNewPawnList(ArrayList<Pawn> pawnArrayList) {
        pawnList = pawnArrayList;
    }
}
