
import java.time.*;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Cita {
    int idCita;
    String fecha;
    String motivo;
    String doctor;
    String paciente;
    private static final AtomicInteger count = new AtomicInteger(0);
    Cita(){
    }
    Cita( String fecha, String motivo, String doc, String paciente){
        idCita=count.incrementAndGet();
        this.fecha=fecha;
        this.motivo=motivo;
        doctor=doc;
        this.paciente=paciente;
    }

}
