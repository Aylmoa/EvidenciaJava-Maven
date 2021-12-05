
import java.util.concurrent.atomic.AtomicInteger;

public class Cita {
    private int idCita;
    private String fecha;
    private String motivo;
    private String doctor;
    private String paciente;
    private static final AtomicInteger count = new AtomicInteger(0);
    Cita(){
    }
    Cita( String fecha, String motivo, String doc, String paciente){
        setIdCita(getCount().incrementAndGet());
        this.setFecha(fecha);
        this.setMotivo(motivo);
        setDoctor(doc);
        this.setPaciente(paciente);
    }

    public static AtomicInteger getCount() {
        return count;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }
}
