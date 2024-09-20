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
import model.Proyecto;
import model.Tarea;

/**
 *
 * @author alvar
 */
public class TareaRepository {
    private static final String FILE_PATH = "tareas.txt";
    
    public static void guardarTarea(Tarea tarea) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH,true))){
            writer.write(tarea.getNombre()+";"+tarea.getResponsable()+";"+tarea.getEstado()+";"+tarea.getProyecto().getNombre());
            writer.newLine();
        }
    }
    public static List<Tarea> cargarTareas() throws IOException{
        
        List<Tarea> tareas = new ArrayList<>();
        File file = new File(FILE_PATH);
        if(!file.exists()){
            return tareas;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            
            String line;
            while ((line=reader.readLine()) != null){
                
                String[] parts = line.split(";");
                if(parts.length == 4){
                    String nombre = parts[0];
                    String responsable = parts[1];
                    String estado = parts[2];
                    Proyecto proyecto = new Proyecto(parts[3]);
                    
                    tareas.add(new Tarea(nombre,responsable,estado,proyecto));
                }
            }
        }
        return tareas;
    };
    

    // Método para buscar tareas por Proyecto
   public static List<Tarea> buscarTareaPorProyecto(String proyecto) throws IOException {
        List<Tarea> tareas = TareaRepository.cargarTareas();
        
        List<Tarea> tareasFiltradas = new ArrayList<>();

        for (Tarea tarea : tareas) {
            // Verificar si el nombre del autor coincide, ignorando mayúsculas y espacios en blanco
            if (tarea.getProyecto().getNombre().equalsIgnoreCase(proyecto)) {
                tareasFiltradas.add(tarea); 
            }
        }

        return tareasFiltradas;  
    }
}
