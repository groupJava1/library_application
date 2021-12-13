package view;

import access.LibroDAO;
import model.LibroModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteLibro extends JFrame implements ActionListener {


    private JLabel      labCodigoLibro;
    private JTextField  texCodigoLibro;
    private JButton     btnDeleteLibro;

    public DeleteLibro()
    {
        initComponents();
    }

    public void initComponents()
    {
        setTitle("Libreria - Borrar Registro de Libro");
        setLayout(new GridLayout(8,2));

        // Codigo de Libro
        this.labCodigoLibro = new JLabel("Codigo");
        add(this.labCodigoLibro);

        this.texCodigoLibro = new JTextField();
        add(this.texCodigoLibro);

        //Boton Borrar
        this.btnDeleteLibro = new JButton("Borrar Libro");
        add(this.btnDeleteLibro);

        //Escuchador de eventos
        this.btnDeleteLibro.addActionListener(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent actionEvent)
    {
        if(actionEvent.getSource() == this.btnDeleteLibro)
        {
            int codigo = Integer.parseInt( (String)this.texCodigoLibro.getText());

            LibroDAO queryLibro = new LibroDAO();
            queryLibro.deleteLibro(codigo);
        }
    }
}
