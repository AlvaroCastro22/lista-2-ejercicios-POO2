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

/**
 *
 * @author alvar
 */
public class EventoRepository {
    private static final String FILE_PATH = "eventos.txt";
    
    
    public static void guardarProyecto(Evento evento) throws IOException{
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH,true))){
            writer.write(evento.getNombre());
            writer.newLine();
        }
    }
    public static List<Evento> cargarProyectos() throws IOException{
        
        List<Evento> eventos = new ArrayList<>();
        File file = new File(FILE_PATH);
        if(!file.exists()){
            return eventos;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line=reader.readLine()) != null){
            eventos.add(new Evento(line));
            }
        }
        return eventos;
    };
}
