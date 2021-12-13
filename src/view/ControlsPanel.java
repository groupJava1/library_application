package view;

import controller.InitialData;
import model.LibroModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import controller.ClickEvent;


public class ControlsPanel extends JPanel {

    private JLabel      labNombreLibro;
    private JTextField  texNombreLibro;
    private JLabel      labCodigoLibro;
    private JTextField  texCodigoLibro;
    private JLabel      labCantidadLibro;
    private JTextField  texCantidadLibro;
    private JLabel      labAnioLibro;
    private JTextField  texAnioLibro;
    private JLabel      labName;
    private JTextField  texLibro;
    private JButton     btnSearch;
    private JButton     btnAddLibro;
    private JTable      tblResults;
    private JButton     btnDeleteLibro;
    private JButton     btnUpdateLibro;


    public ControlsPanel(ResultsPanel resultsPanel)
    {
        this.tblResults = resultsPanel.getTblResults();
        initComponents();
    }

    private void initComponents()
    {
        setLayout(new GridLayout(2,1));
        InitialData initialData = new InitialData();

        this.setTblResults(initialData.getLibrosID());

        //Codigo Libro
        this.labCodigoLibro = new JLabel("Codigo");
        add(this.getLabCodigoLibro());

        this.texCodigoLibro = new JTextField();
        add(this.getTexCodigoLibro());

        //Name Libro
        this.labNombreLibro = new JLabel("Nombre");
        add(this.getLabNombreLibro());

        this.texNombreLibro = new JTextField();
        add(this.getTexNombreLibro());

        //Cantidad Libro
        this.labCantidadLibro = new JLabel("Cantidad");
        add(this.getLabCantidadLibro());

        this.texCantidadLibro = new JTextField();
        add(this.getTexCantidadLibro());

        //Anio Libro
        this.labAnioLibro = new JLabel();
        add(this.getLabAnioLibro());

        this.texAnioLibro = new JTextField();
        add(this.getTexAnioLibro());

        //Search button
        this.btnSearch = new JButton("Buscar");
        add(this.btnSearch);

        ClickEvent clickEvent = new ClickEvent(this);
        this.btnSearch.addActionListener(clickEvent);

        //Insert button
        this.btnAddLibro = new JButton("Agregar Libro");
        add(this.getBtnAddLibro());
        this.getBtnAddLibro().addActionListener(clickEvent);

        //Delete button
        this.btnDeleteLibro = new JButton("Borrar Libro");
        add(this.getBtnDeleteLibro());
        this.getBtnDeleteLibro().addActionListener(clickEvent);

        //Update button
        this.btnUpdateLibro = new JButton("Actualizar Libro");
        add(this.getBtnUpdateLibro());
        this.getBtnUpdateLibro().addActionListener(clickEvent);



    }

    public JLabel getLabNombreLibro()
    {
        return labNombreLibro;
    }

    public JTextField getTexNombreLibro()
    {
        return texNombreLibro;
    }

    public JLabel getLabCodigoLibro()
    {
        return labCodigoLibro;
    }

    public JTextField getTexCodigoLibro()
    {
        return texCodigoLibro;
    }

    public JLabel getLabCantidadLibro()
    {
        return labCantidadLibro;
    }

    public JTextField getTexCantidadLibro()
    {
        return texCantidadLibro;
    }

    public JLabel getLabAnioLibro()
    {
        return labAnioLibro;
    }

    public JTextField getTexAnioLibro()
    {
        return texAnioLibro;
    }

    public JButton getBtnSearch()
    {
        return btnSearch;
    }

    public JButton getBtnAddLibro()
    {
        return btnAddLibro;
    }

    public JButton getBtnDeleteLibro()
    {
        return btnDeleteLibro;
    }

    public JButton getBtnUpdateLibro()
    {
        return btnUpdateLibro;
    }

    public JTable getTblResults()
    {
        return tblResults;
    }

    public void setTblResults(ArrayList<LibroModel> libros)
    {
        String[] headers = {"CODIGO", "NOMBRE", "CANTIDAD", "AÑO"};
        this.tblResults.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers);
        this.tblResults.setModel(tableModel);
        for(int i=0; i<libros.size(); i++)
        {
            tableModel.addRow(libros.get(i).toArray());

        }

    }

}
