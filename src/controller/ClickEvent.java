package controller;

import access.LibroDAO;
import model.LibroModel;
import view.AddLibro;
import view.ControlsPanel;
import view.DeleteLibro;
import view.UpdateLibro;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ClickEvent implements ActionListener {

    private ControlsPanel controlsPanel;

    public ClickEvent(ControlsPanel controlsPanel)
    {
        this.controlsPanel = controlsPanel;
    }

    public void actionPerformed(ActionEvent actionEvent)
    {
        if(actionEvent.getSource() == this.controlsPanel.getBtnSearch())
        {
            int codigoLib    = Integer.parseInt(this.controlsPanel.getTexCodigoLibro().getText());
            String nombreLib = (String)this.controlsPanel.getTexNombreLibro().getText();
            int cantidadLib  = Integer.parseInt(this.controlsPanel.getTexCantidadLibro().getText());
            int anioLib      = Integer.parseInt(this.controlsPanel.getTexAnioLibro().getText());

            LibroDAO querylibroCE = new LibroDAO();
            ArrayList<LibroModel> registrosLibros = querylibroCE.getAllLibros();

            this.controlsPanel.setTblResults(registrosLibros);
        }
        else if(actionEvent.getSource() == this.controlsPanel.getBtnAddLibro())
        {
            AddLibro addLibroView = new AddLibro();
            addLibroView.setVisible(true);
        }
        else if(actionEvent.getSource() == this.controlsPanel.getBtnDeleteLibro())
        {
            DeleteLibro deleteLibroView = new DeleteLibro();
            deleteLibroView.setVisible(true);
        }
        else if(actionEvent.getSource() == this.controlsPanel.getBtnUpdateLibro())
        {
            UpdateLibro updateLibroView = new UpdateLibro();
            updateLibroView.setVisible(true);
        }
    }

}
