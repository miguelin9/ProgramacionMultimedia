package es.vcarmen.material10;

/**
 * Created by matinal on 30/11/17.
 */

public class Encapsulador {

    private int idImagen;
    private String textoTitulo;
    private String textoContenido;

    public Encapsulador(int idImagen, String textoTitulo, String textoContenido) {
        this.idImagen = idImagen;
        this.textoTitulo = textoTitulo;
        this.textoContenido = textoContenido;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getTextoTitulo() {
        return textoTitulo;
    }

    public void setTextoTitulo(String textoTitulo) {
        this.textoTitulo = textoTitulo;
    }

    public String getTextoContenido() {
        return textoContenido;
    }

    public void setTextoContenido(String textoContenido) {
        this.textoContenido = textoContenido;
    }
}
