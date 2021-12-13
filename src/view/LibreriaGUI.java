package view;

import javax.swing.*;

public class LibreriaGUI extends JFrame {
    private JPanel mainPanel;
    private JLabel libreriaJLabel;
    private JButton ingresarLibroButton;
    private JButton consultarLibroButton;
    private JButton actualizarLibroButton;
    private JButton eliminarLibroButton;

    public LibreriaGUI(String title)
    {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
    }



    public static void main(String[] args)
    {
        JFrame frame= new LibreriaGUI("Inventario");
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
