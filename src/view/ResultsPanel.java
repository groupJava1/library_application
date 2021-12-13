package view;

import javax.swing.*;
import java.awt.*;

public class ResultsPanel extends JPanel {

    private JTable      tblResults;
    private JScrollPane jspPane;

    public ResultsPanel()
    {
        initComponents();
    }

    private void initComponents()
    {
        this.tblResults = new JTable();
        this.tblResults.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        this.jspPane = new JScrollPane(this.tblResults);
        add(jspPane, BorderLayout.CENTER);

        setPreferredSize(new Dimension(1020, 800));
    }

    public JTable getTblResults()
    {
        return tblResults;
    }

    public void setTblResults(JTable tblResults)
    {
        this.tblResults=tblResults;
    }

}
