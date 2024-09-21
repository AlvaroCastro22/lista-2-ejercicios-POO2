/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Evento;
import model.Invitado;

/**
 *
 * @author alvar
 */
public class InvitadoRepository {
    private static final String FILE_PATH = "invitados.txt";
    
    public static void guardarTarea(Invitado tarea) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH,true))){
            writer.write(tarea.getNombre()+";"+tarea.getNumCelular()+";"+tarea.getGenero()+";"+tarea.getFecha()+";"+tarea.getDireccion()+";"+tarea.getEvento().getNombre());
            writer.newLine();
        }
    }
    public static List<Invitado> cargarTareas() throws IOException{
        
        List<Invitado> tareas = new ArrayList<>();
        File file = new File(FILE_PATH);
        if(!file.exists()){
            return tareas;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            
            String line;
            while ((line=reader.readLine()) != null){
                
                String[] parts = line.split(";");
                if(parts.length == 6){
                    String nombre = parts[0];
                    String numCelular = parts[1];
                    String genero = parts[2];
                    String fecha = parts[3];
                    String direccion = parts[4];
                    Evento proyecto = new Evento(parts[5]);
                    
                    tareas.add(new Invitado(nombre,numCelular,genero,fecha,direccion,proyecto));
                }
            }
        }
        return tareas;
    };
    

    // Método para buscar invitados por Evento
   public static List<Invitado> buscarInvitadoPorEvento(String proyecto) throws IOException {
        List<Invitado> invitados = InvitadoRepository.cargarTareas();
        
        List<Invitado> invitadosFiltradas = new ArrayList<>();

        for (Invitado tarea : invitados) {
            // Verificar si el nombre del autor coincide, ignorando mayúsculas y espacios en blanco
            if (tarea.getEvento().getNombre().equalsIgnoreCase(proyecto)) {
                invitadosFiltradas.add(tarea); 
            }
        }

        return invitadosFiltradas;  
    }
}
