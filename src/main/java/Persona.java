public class Persona {
    private int id;
    private String Nombre;

    Persona(){}
    Persona( String nom){
        setNombre(nom);
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
