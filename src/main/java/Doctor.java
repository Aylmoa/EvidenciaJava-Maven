
public class Doctor extends Persona{
    private String especialidad;

    Doctor(){

    }
    Doctor(int id, String nom, String esp){
        setId(id);
        setNombre(nom);
        setEspecialidad(esp);
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
