package model;

public class LibroModel {

    private int codigo;
    private String nombre;
    private int cantidad;
    private int anio;

    public LibroModel(int codigo, String nombre, int cantidad, int anio)
    {
        this.codigo=codigo;
        this.nombre=nombre;
        this.cantidad=cantidad;
        this.anio=anio;
    }

    public void setCodigo(int codigo)
    {
        this.codigo=codigo;
    }

    public int getCodigo()
    {
        return codigo;
    }

    public void setNombre(String nombre)
    {
        this.nombre=nombre;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setCantidad(int cantidad)
    {
        this.cantidad=cantidad;
    }

    public int getCantidad()
    {
        return cantidad;
    }

    public void setAnio(int anio)
    {
        this.anio=anio;
    }

    public int getAnio()
    {
        return anio;
    }

    public String toString()
    {
        return "Libro: "+this.nombre+" publicado en: "+this.anio+" unidades: "+this.cantidad;
    }

    public Object[] toArray()
    {
        Object[] data={codigo, nombre, cantidad, anio};
        return data;
    }



}
