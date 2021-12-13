package view;

import access.LibroDAO;
import controller.InitialData;
import model.LibroModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddLibro extends JFrame implements ActionListener {

    private JLabel      labNombreLibro;
    private JTextField  texNombreLibro;
    private JLabel      labCodigoLibro;
    private JTextField  texCodigoLibro;
    private JLabel      labCantidadLibro;
    private JTextField  texCantidadLibro;
    private JLabel      labAnioLibro;
    private JTextField  texAnioLibro;
    private JButton     btnInsertLibro;

    public AddLibro()
    {
        initComponents();
    }

    public void initComponents()
    {
        setTitle("Libreria - Agregar Registro de Libro");
        setLayout(new GridLayout(8,2));
        InitialData initalData = new InitialData();

        //Codigo Libro
        this.labCodigoLibro = new JLabel("Codigo");
        add(this.labCodigoLibro);

        this.texCodigoLibro = new JTextField();
        add(this.texCodigoLibro);

        //Nombre Libro
        this.labNombreLibro = new JLabel("Nombre");
        add(this.labNombreLibro);

        this.texNombreLibro = new JTextField();
        add(this.texNombreLibro);

        //Cantidad Libro
        this.labCantidadLibro = new JLabel("Cantidad");
        add(this.labCantidadLibro);

        this.texCantidadLibro = new JTextField();
        add(this.texCantidadLibro);

        //Anio Libro
        this.labAnioLibro = new JLabel("Año");
        add(this.labAnioLibro);

        this.texAnioLibro = new JTextField();
        add(this.texAnioLibro);

        //boton insertar
        this.btnInsertLibro = new JButton("Agregar Libro");
        add(this.btnInsertLibro);

        //Agregar escuchador de eventos
        this.btnInsertLibro.addActionListener(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent actionEvent)
    {
        if(actionEvent.getSource() == this.btnInsertLibro)
        {
            int codigo    = Integer.parseInt( (String)this.texCodigoLibro.getText());
            String nombre = (String)this.texNombreLibro.getText();
            int cantidad  = Integer.parseInt( (String)this.texCantidadLibro.getText());
            int anio      = Integer.parseInt( (String)this.texAnioLibro.getText());

            LibroModel modeloLibro = new LibroModel(codigo, nombre, cantidad, anio);

            LibroDAO queryLibro = new LibroDAO();
            queryLibro.insertLibro(modeloLibro);
        }
    }

}
