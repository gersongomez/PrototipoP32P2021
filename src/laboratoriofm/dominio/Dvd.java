package laboratoriofm.dominio;

public class Dvd {

    private int id_Dvd;
    private String nombre_Dvd;
    private String autor_Dvd;
    private String genero_Dvd;
    private int existencias_Dvd;

    public int getId_Dvd() {
        return id_Dvd;
    }

    public void setId_Dvd(int id_Dvd) {
        this.id_Dvd = id_Dvd;
    }

    public String getNombre_Dvd() {
        return nombre_Dvd;
    }

    public void setNombre_Dvd(String nombre_Dvd) {
        this.nombre_Dvd = nombre_Dvd;
    }

    public String getAutor_Dvd() {
        return autor_Dvd;
    }

    public void setAutor_Dvd(String autor_Dvd) {
        this.autor_Dvd = autor_Dvd;
    }

    public String getGenero_Dvd() {
        return genero_Dvd;
    }

    public void setGenero_Dvd(String genero_Dvd) {
        this.genero_Dvd = genero_Dvd;
    }

    public int getExistencias_Dvd() {
        return existencias_Dvd;
    }

    public void setExistencias_Dvd(int existencias_Dvd) {
        this.existencias_Dvd = existencias_Dvd;
    }

    @Override
    public String toString() {
        return "Dvd{"
                + "id_Dvd=" + id_Dvd
                + ", nombre_Dvd=" + nombre_Dvd
                + ", autor_Dvd=" + autor_Dvd
                + ", genero_Dvd=" + genero_Dvd
                + ", existencias_Dvd=" + existencias_Dvd
                + '}';
    }

}
