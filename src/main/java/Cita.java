
import java.time.*;
import java.util.Date;

public class Cita {
    int idCita;
    Date fecha;
    String motivo;
    Doctor doctor;
    Paciente paciente;
    Cita(){
    }
    Cita(int id, Date fecha, String motivo, Doctor doc, Paciente paciente){
        idCita=id;
        this.fecha=fecha;
        this.motivo=motivo;
        doctor=doc;
        this.paciente=paciente;
    }

}
