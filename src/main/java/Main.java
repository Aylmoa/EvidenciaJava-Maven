import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static ArrayList<Object>total= new ArrayList<Object>();
    static ArrayList<Usuario>Usuarios= new ArrayList();
    static Path origi=null;
    static ObjectMapper mapper= new ObjectMapper();

    public static void main(String[] args) throws IOException {

    menu();
    }
    public static void menu() throws IOException {
        Scanner sc= new Scanner(System.in);
        String cont="o";String nombre;
        load();
        cargarUsu();
        System.out.println("Username:");String usr= sc.nextLine();
        System.out.println("Password:");String pass= sc.nextLine();
        Boolean existe; existe=validarUsuarios(usr,pass);
        if(existe) {
            System.out.println("Bienvenido");
            do {
                System.out.println("Porfavor escoga que es lo que va a querer hacer\n1= Registrar Doctor 2= Registrar Paciente" +
                        "3= Registrar nueva cita 0= Salir");
                try {
                    int eleccion = Integer.parseInt(sc.next());
                    switch (eleccion) {
                        case 1:
                            System.out.println("Cual es el nombre del Doctor?");
                            nombre = sc.next();
                            System.out.println("Cual es la especialidad del Doctor?");
                            String espe = sc.next();
                            crearDoc(nombre, espe);
                            //Doctor doc= new Doctor(nombre,espe);
                            //String doce=mapper.writeValueAsString(doc);
                            //System.out.println(doce);
                            break;
                        case 2:
                            System.out.println("Cual es el nombre del paciente nuevo(a)?");
                            nombre = sc.next();
                            crearPaciente(nombre);
                            break;
                        case 3:
                            System.out.println("Cuál es la fecha y hora de la cita?");
                            String fecha = sc.next();
                            System.out.println("Cuál es la razón de la cita?");
                            String razon = sc.next();
                            System.out.println("Que doctor antenderá?");
                            String doc = sc.next();
                            System.out.println("Que paciente atenderá?");
                            String pac = sc.next();
                            if (Verificar(doc, pac)) crearCita(fecha, razon, doc, pac);
                            else {
                                System.out.println("No se encuentran el doctor o el paciente en la base de datos");
                            }
                            break;
                        case 0:
                            Save();
                            cont = "n";
                            break;
                        default:
                            System.out.println("Opción Invalida, vuelva a escoger");
                            break;
                    }
                } catch (NumberFormatException | JsonProcessingException exception) {
                    System.out.println("----No escribiste un numero intenta de nuevo---");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } while (cont.equals("o"));
        }else System.out.println("No existe el Usario o contraseña, intente de nuevo");

        }
        public static void crearDoc(String nombre, String especialidad) throws IOException {
            Doctor doc= new Doctor(nombre,especialidad);
            String doce= mapper.writeValueAsString(doc);total.add(doce);
           // Save();
        }
    public static void crearPaciente(String nombre) throws IOException {
        Paciente paciente= new Paciente(nombre);
        String pac= mapper.writeValueAsString(paciente);total.add(pac);
       // Save();
    }
    public static void crearCita(String fecha, String razon,String Doc,String pac) throws IOException {
        Cita cit= new Cita(fecha,razon,Doc,pac);
        String cita= mapper.writeValueAsString(cit);total.add(cita);
        //Save();
    }
    public static void cargarUsu(){
        if (Usuarios==null){
            Usuarios= new ArrayList<>();
        }

        Usuarios.add(new Usuario("Admin","123"));
        Usuarios.add(new Usuario("Leonardz","Comida"));
        System.out.println("Exito");
    }
    public static boolean validarUsuarios(String Usr, String Pass){
           return Usuarios.stream().anyMatch(s -> s.getPassword().equals(Pass) && s.getUsername().equals(Usr));
    }

        public static void load(String json){
        Gson gson = new Gson();
        Cita cita= gson.fromJson(json,Cita.class);

        }
    public static boolean Verificar(String doc, String paciente){
        boolean aux= false;
        boolean aux2=false;
        try (BufferedReader reader = Files.newBufferedReader(origi, Charset.defaultCharset()); ) {

            Gson gson = new Gson();
                String line=null;
                while ((line = reader.readLine()) != null){
                    if(line.contains("fecha")){}
                    else if(line.contains("especialidad")){
                        if(line.contains(doc))aux=true;
                        if(line.contains(paciente))aux2=true;
                    }

            }
        } catch (IOException x) {System.err.format("IOException: %s%n", x);}
        if(aux==true && aux2==true)return true;
        else return false;
    }
    public static void load() throws IOException {
        ArrayList<String> ola= new ArrayList<>();
        String separator = FileSystems.getDefault().getSeparator();
        String filename = String.format("src%smain%sresources%scitas", separator, separator, separator);
        Path orig = Paths.get(filename);origi=orig;
        try (BufferedReader reader = Files.newBufferedReader(orig, Charset.defaultCharset()); ) {
            String line=null;
            while (( line=reader.readLine()) != null) {
                    total.add(line);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

    public static void Save( ) throws IOException {
        String separator = FileSystems.getDefault().getSeparator();
        String filename = String.format("src%smain%sresources%scitas", separator, separator,separator);
        Path orig = Paths.get(filename);origi=orig;
        try (BufferedWriter writer = Files.newBufferedWriter(orig, Charset.defaultCharset())){
            for (Object ete:total)
            {mapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
                writer.write(String.valueOf(ete));
            }

        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);}
    }


}
