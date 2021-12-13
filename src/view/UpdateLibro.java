package view;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import access.LibroDAO;
import model.LibroModel;

public class UpdateLibro extends JFrame implements ActionListener {

    private JLabel      labCodigoLibro;
    private JTextField  texCodigoLibro;
    private JLabel      labCantidadLibro;
    private JTextField  texCantidadLibro;
    private JButton     btnUpdateLibro;

    public UpdateLibro()
    {
        initComponents();
    }

    public void initComponents()
    {
        setTitle("Libreria - Actualizar Registro de Libro");
        setLayout(new GridLayout(8,2));

        //Codigo del Libro
        this.labCodigoLibro = new JLabel("Codigo de Libro a Actualizar");
        add(this.labCodigoLibro);

        this.texCodigoLibro = new JTextField();
        add(this.texCodigoLibro);

        //Cantidad del Libro
        this.labCantidadLibro = new JLabel("Nueva Cantidad de Libros");
        add(this.labCantidadLibro);

        this.texCantidadLibro = new JTextField();
        add(this.texCantidadLibro);

        //Boton Actualizar
        this.btnUpdateLibro = new JButton("Actualizar Libro");
        add(this.btnUpdateLibro);

        //Oyente de eventos
        this.btnUpdateLibro.addActionListener(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        pack();
        setVisible(true);

    }

    public void actionPerformed(ActionEvent actionEvent)
    {
        if(actionEvent.getSource() == this.btnUpdateLibro)
        {
            int codigoLibro      = Integer.parseInt( (String)this.texCodigoLibro.getText());
            int cantidadLibro    = Integer.parseInt( (String)this.texCantidadLibro.getText());
            String nombreLibro   = "prueba";
            int anioLibro        = 100;

            LibroModel modeloLibro = new LibroModel(codigoLibro, nombreLibro, cantidadLibro, anioLibro );

            LibroDAO queryLibro = new LibroDAO();
            queryLibro.updateLibro(modeloLibro);
        }
    }
}








