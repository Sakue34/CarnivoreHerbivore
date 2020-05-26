package pl.edu.pwr.carnivoreherbivore.output;

import pl.edu.pwr.carnivoreherbivore.map.SimulationMap;
import pl.edu.pwr.carnivoreherbivore.simulation.SimulationParameters;
import pl.edu.pwr.gui.DisplayPane;

import javax.swing.*;
import java.awt.*;

public final class GUIProgressOutput implements ProgressOutput {
    private final SimulationMap simulationMap;
    private final SimulationParameters simulationParameters;

    private void GUIMain() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    System.out.println(ex.toString());
                }

                JFrame frame = new JFrame("carnivore-herbivore");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new DisplayPane(simulationMap, simulationParameters.mapWidth, simulationParameters.mapHeight));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    @Override
    public void outputSimulationProgress(float elapsedTime) {
        //Display progress with GUI
    }

    public GUIProgressOutput(SimulationParameters simulationParameters, SimulationMap simulationMap) {
        System.out.println("carnivore-herbivore - Progress output: Swing GUI");
        this.simulationParameters = simulationParameters;
        this.simulationMap = simulationMap;
        GUIMain();
    }



}
