/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.util.List;
import model.Evento;
import repository.EventoRepository;


public class ProyectoController {
    public void guardarProyecto(Evento proyecto) throws IOException {
        EventoRepository.guardarProyecto(proyecto);  // Guardar el proyecto en el archivo
    }
    
    public List<Evento> listarProyectos() throws IOException {
        return EventoRepository.cargarProyectos();  // Cargar los autores desde el archivo
    }
}
