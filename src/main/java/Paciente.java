import java.util.concurrent.atomic.AtomicInteger;

public class Paciente extends Persona {
    private static final AtomicInteger count = new AtomicInteger(0);
    Paciente(){
        setId(count.incrementAndGet());
    }
    Paciente(String nom){setNombre(nom);
        setId(count.incrementAndGet()+1000);
    }


}
