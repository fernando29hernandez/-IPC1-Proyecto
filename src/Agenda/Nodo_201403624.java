package Agenda;

public class Nodo_201403624 {

    private String apellido;
    private String nombre;
    private String titulo;
    private String genero;
    private String direccion;
    private String telefono;
    private String fecnac;
    private String edad;
    private String nacionalidad;
    private String correo;
    private String dirfoto;
    private Nodo_201403624 siguiente;
    private Nodo_201403624 anterior;
    private int id;

    public Nodo_201403624(int id, String apellido, String nombre, String titulo, String genero, String direccion, String telefono,
            String fecnac, String edad, String nacionalidad, String correo, String dirfoto) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.titulo = titulo;
        this.genero = genero;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fecnac = fecnac;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
        this.correo = correo;
        this.dirfoto = dirfoto;
        this.siguiente = null;
        this.anterior = null;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFecnac() {
        return fecnac;
    }

    public void setFecnac(String fecnac) {
        this.fecnac = fecnac;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDirfoto() {
        return dirfoto;
    }

    public void setDirfoto(String dirfoto) {
        this.dirfoto = dirfoto;
    }

    public Nodo_201403624 getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo_201403624 siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo_201403624 getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo_201403624 anterior) {
        this.anterior = anterior;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
