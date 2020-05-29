package Agenda;

public class Lista_201403624 {

    int contador_id = 0;
    private Nodo_201403624 inicio;
    private Nodo_201403624 fin;
    String nombre, titulo, genero, direccion, telefono, fecnac, edad, nacionalidad, correo, dirfoto, apellido;
    private int tamano = 0;

    public Lista_201403624() {

        this.inicio = null;
        this.fin = null;
    }

    public boolean ListaVacia() {
        if (this.inicio == null) {
            return true;
        } else {
            return false;
        }

    }

    public void insertarFrente(String apellido, String nombre, String titulo, String genero, String direccion, String telefono,
            String fecnac, String edad, String nacionalidad, String correo, String dirfoto) {
        Nodo_201403624 nuevo = new Nodo_201403624(contador_id, apellido, nombre, titulo, genero, direccion, telefono,
                fecnac, edad, nacionalidad, correo, dirfoto);
        if (this.inicio == null) {
            this.inicio = nuevo;
            this.inicio.setSiguiente(null);
            this.inicio.setAnterior(null);
            this.contador_id++;
        } else {
            this.inicio.setAnterior(nuevo);
            nuevo.setSiguiente(this.inicio);
            nuevo.setAnterior(null);
            this.inicio = nuevo;
            this.contador_id++;
        }
        tamano++;
    }

    public void borrarlista() {
        this.inicio = null;
    }

    public Nodo_201403624 buscar(int id) {
        Nodo_201403624 actual = this.inicio;
        while (!(actual == null)) {
            if (actual.getId() == id) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public void recorrer() {
        Nodo_201403624 actual = inicio;
        while (!(actual == null)) {
            apellido = actual.getApellido();
            nombre = actual.getNombre();
            titulo = actual.getTitulo();
            genero = actual.getGenero();
            direccion = actual.getDireccion();
            telefono = actual.getTelefono();
            fecnac = actual.getFecnac();
            edad = actual.getEdad();
            nacionalidad = actual.getNacionalidad();
            correo = actual.getCorreo();
            dirfoto = actual.getDirfoto();
            System.out.println(apellido + nombre + titulo + genero + direccion + telefono + fecnac + edad + nacionalidad + correo + dirfoto);
            actual = actual.getSiguiente();
        }

    }

    public void recorreratras() {
        Nodo_201403624 actual = fin;
        while (actual != null) {
            apellido = actual.getApellido();
            nombre = actual.getNombre();
            titulo = actual.getTitulo();
            genero = actual.getGenero();
            direccion = actual.getDireccion();
            telefono = actual.getTelefono();
            fecnac = actual.getFecnac();
            edad = actual.getEdad();
            nacionalidad = actual.getNacionalidad();
            correo = actual.getCorreo();
            dirfoto = actual.getDirfoto();
            System.out.println(apellido + nombre + titulo + genero + direccion + telefono + fecnac + edad + nacionalidad + correo + dirfoto);
            actual = actual.getAnterior();
        }

    }

    public Nodo_201403624[] Clonar() {
        Nodo_201403624 nuevo_clon[] = new Nodo_201403624[Principal_201403624.L.tamano];
        Nodo_201403624 actual = inicio;
        int indice = 0;
        while (!(actual == null)) {
            nuevo_clon[indice] = new Nodo_201403624(actual.getId(), actual.getApellido(), actual.getNombre(), actual.getTitulo(), actual.getGenero(), actual.getDireccion(), actual.getTelefono(), actual.getFecnac(), actual.getEdad(), actual.getNacionalidad(), actual.getCorreo(), actual.getDirfoto());
            indice++;
            actual = actual.getSiguiente();
        }
        return nuevo_clon;
    }

    public void eliminar(int id) {
        if (!ListaVacia()) {
            if (inicio == fin && id == inicio.getId()) {
                inicio = fin = null;
            } else if (id == inicio.getId()) {
                inicio.getSiguiente().setAnterior(null);
                inicio = inicio.getSiguiente();

            } else {
                Nodo_201403624 anterior, temporal;
                anterior = inicio;
                temporal = inicio.getSiguiente();
                while (temporal != null && !(temporal.getId() == id)) {
                    anterior = anterior.getSiguiente();
                    temporal = temporal.getSiguiente();
                }
                if (temporal != null) {
                    anterior.setSiguiente(temporal.getSiguiente());
                    if (temporal == fin) {
                        fin = anterior;
                    }
                }
            }
        }
        tamano--;
    }

    public Nodo_201403624 getInicio() {
        return inicio;
    }

    public void setInicio(Nodo_201403624 inicio) {
        this.inicio = inicio;
    }

    public Nodo_201403624 getFin() {
        return fin;
    }

    public void setFin(Nodo_201403624 fin) {
        this.fin = fin;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }
}
