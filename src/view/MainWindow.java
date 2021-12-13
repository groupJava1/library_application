package view;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public MainWindow ()
    {
        initComponents();
    }

    private void initComponents()
    {
        setTitle("LibreriaEFRC");

        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        ResultsPanel resultsPanel = new ResultsPanel();
        setContentPane(resultsPanel);
        add(new ControlsPanel(resultsPanel));

        setSize(1040, 720);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation((screenSize.width - frameSize.width)      /2,
                       (screenSize.height - frameSize.height) /2);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
