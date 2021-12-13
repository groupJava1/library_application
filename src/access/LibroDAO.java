package access;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import model.LibroModel;
import utils.ConnectionDB;

public class LibroDAO {

    private Connection conn = null;


    // retrieve all
    public ArrayList<LibroModel> getAllLibros()
    {
        ArrayList<LibroModel> libros = new ArrayList();
        try
        {
            if(conn == null)
            {
                conn= ConnectionDB.getConnection();
            }
            String sql = "select codigo, nombre, cantidad, anio from libro;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while(result.next())
            {
                LibroModel registroLibro = new LibroModel(result.getInt(1), result.getString(2), result.getInt(3), result.getInt(4));
                libros.add(registroLibro);
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Codigo: " + ex.getErrorCode() + "\nError: " + ex.getMessage());
        }

        return libros;
    }


    // retrieve by codigo
    public ArrayList<LibroModel> getLibrosByCodigo(int codigoLibro)
    {
        ArrayList<LibroModel> libros = new ArrayList();
        try
        {
            if(conn == null)
            {
                conn=ConnectionDB.getConnection();
            }

            String sql= "select codigo, nombre, cantidad, anio from libro where codigo=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, codigoLibro);
            ResultSet result = statement.executeQuery();

            while(result.next())
            {
                LibroModel registroLibro = new LibroModel(result.getInt(1), result.getString(2), result.getInt(3), result.getInt(4));
                libros.add(registroLibro);
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Codigo: " + ex.getErrorCode() + "\nError: " + ex.getMessage());
        }

        return libros;
    }


    // create libro
    public void insertLibro(LibroModel libro)
    {
        try
        {
            if(conn == null)
            {
                conn=ConnectionDB.getConnection();
            }

            String sql = "insert into libro (codigo, nombre, cantidad, anio) values (?, ?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, libro.getCodigo());
            statement.setString(2, libro.getNombre());
            statement.setInt(3, libro.getCantidad());
            statement.setInt(4,libro.getAnio());

            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0)
            {
                JOptionPane.showMessageDialog(null, "Registro agregado exitoso!");
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Codigo: " + ex.getErrorCode() + "\nError: " + ex.getMessage());
        }
    }


    // update libro
    public void updateLibro(LibroModel libro)
    {
        try
        {
            if(conn == null)
            {
                conn= ConnectionDB.getConnection();
            }

            String sql="update libro set cantidad=? where codigo=?;";
            PreparedStatement statement= conn.prepareStatement(sql);
            statement.setInt(1, libro.getCantidad());
            statement.setInt(2, libro.getCodigo());

            int rowsUpdated = statement.executeUpdate();
            System.out.println("codigo-"+libro.getCodigo()+"-cantidad-"+libro.getCantidad()+"-row-"+rowsUpdated);
            if(rowsUpdated > 0)
            {
                JOptionPane.showMessageDialog(null,"Registro actualizado exitosamente!");
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Codigo: " + ex.getErrorCode() + "\nError: " + ex.getMessage());
        }
    }


    // delete libro
    public void deleteLibro(int codigoLibro)
    {
        try
        {
            if(conn == null)
            {
                conn= ConnectionDB.getConnection();
            }

            String sql="delete from libro where codigo=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1,codigoLibro);

            int rowsDelete = statement.executeUpdate();
            if(rowsDelete > 0)
            {
                JOptionPane.showMessageDialog(null,"Registro eliminado exitosamente!");
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Codigo: " + ex.getErrorCode() + "\nError: " + ex.getMessage());
        }
    }




}
