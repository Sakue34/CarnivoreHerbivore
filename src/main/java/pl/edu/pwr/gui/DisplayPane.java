package pl.edu.pwr.gui;

import pl.edu.pwr.carnivoreherbivore.map.SimulationMap;
import pl.edu.pwr.carnivoreherbivore.pawn.Pawn;
import pl.edu.pwr.carnivoreherbivore.utility.Position;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

/**
 * Klasa używana przez interfejs graficzny Swing.
 */
public final class DisplayPane extends JPanel {
    private final List<Pawn> pawns;
    private final Map<Pawn, Position> pawnsPosition;
    private final int mapWidth;
    private final int mapHeight;

    public DisplayPane(SimulationMap simulationMap, int mapWidth, int mapHeight) {
        this.pawns = simulationMap.getPawns();
        this.pawnsPosition = simulationMap.getPawnsPositions();
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;

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
        return new Dimension(mapWidth, mapHeight);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < pawns.size(); i++) {
            try {
                Pawn pawn = pawns.get(i);
                Position pawnPosition = pawnsPosition.get(pawn);
                g.setColor(Color.decode(pawn.getColourString()));
                g.fillOval((int) pawnPosition.x - pawn.getRadius(), (int) pawnPosition.y - pawn.getRadius(), pawn.getRadius() * 2, pawn.getRadius() * 2);
            }
            catch (NullPointerException exception) {
                return;
            }
        }
    }
}
