import java.util.concurrent.atomic.AtomicInteger;

public class Doctor extends Persona{
    private String especialidad;
    private static final AtomicInteger count = new AtomicInteger(0);
    Doctor(){

    }
    Doctor(String nom, String esp){
        setId(count.incrementAndGet()+5000);
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
