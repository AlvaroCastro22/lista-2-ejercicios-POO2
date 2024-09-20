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

/**
 *
 * @author alvar
 */
public class ProyectoRepository {
    private static final String FILE_PATH = "proyectos.txt";
    
    
    public static void guardarProyecto(Proyecto proyecto) throws IOException{
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH,true))){
            writer.write(proyecto.getNombre());
            writer.newLine();
        }
    }
    public static List<Proyecto> cargarProyectos() throws IOException{
        
        List<Proyecto> proyectos = new ArrayList<>();
        File file = new File(FILE_PATH);
        if(!file.exists()){
            return proyectos;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line=reader.readLine()) != null){
            proyectos.add(new Proyecto(line));
            }
        }
        return proyectos;
    };
}
