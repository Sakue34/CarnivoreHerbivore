package pl.edu.pwr.gui;

import java.awt.*;
import java.util.ArrayList;

import pl.edu.pwr.carnivoreherbivore.Pawn;

public class PawnDrawManager {
    public static void drawEveryEntity(ArrayList<Pawn> pawnList, Graphics g) {
        for (Pawn pawn : pawnList) {
            pawn.draw(g);
        }
    }
}
