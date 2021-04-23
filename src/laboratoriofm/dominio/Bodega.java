/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratoriofm.dominio;

/**
 *
 * @author gegmo
 */
public class Bodega {
    private int Id_Bodega;
    private String Nombre_Art;
    private String Autor_Art;
    private String Genero;
    private String Tipo_Art;
    private int Cantidad_Art;

    public int getId_Bodega() {
        return Id_Bodega;
    }

    public void setId_Bodega(int Id_Bodega) {
        this.Id_Bodega = Id_Bodega;
    }

    public String getNombre_Art() {
        return Nombre_Art;
    }

    public void setNombre_Art(String Nombre_Art) {
        this.Nombre_Art = Nombre_Art;
    }

    public String getAutor_Art() {
        return Autor_Art;
    }

    public void setAutor_Art(String Autor_Art) {
        this.Autor_Art = Autor_Art;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getTipo_Art() {
        return Tipo_Art;
    }

    public void setTipo_Art(String Tipo_Art) {
        this.Tipo_Art = Tipo_Art;
    }

    public int getCantidad_Art() {
        return Cantidad_Art;
    }

    public void setCantidad_Art(int Cantidad_Art) {
        this.Cantidad_Art = Cantidad_Art;
    }

   
}
