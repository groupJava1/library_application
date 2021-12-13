package controller;

import access.LibroDAO;
import model.LibroModel;
import java.util.ArrayList;

public class InitialData {

    private ArrayList<LibroModel> modeloLibroID = null;

    public InitialData()
    {
        LibroDAO queryLibroID = new LibroDAO();
        this.modeloLibroID = queryLibroID.getAllLibros();

    }

    public ArrayList<LibroModel> getLibrosID()
    {
        return modeloLibroID;
    }
}
