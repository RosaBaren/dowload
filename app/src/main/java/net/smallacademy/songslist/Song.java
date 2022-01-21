package net.smallacademy.songslist;

public class Song {
    private String id;
    private String descripcion;
    private String fecha;
    private String url;

    public Song() {

    }

    public Song(String id, String descripcion, String fecha, String url) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
