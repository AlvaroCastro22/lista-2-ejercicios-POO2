/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.util.List;
import model.Proyecto;
import repository.ProyectoRepository;


public class ProyectoController {
    public void guardarProyecto(Proyecto proyecto) throws IOException {
        ProyectoRepository.guardarProyecto(proyecto);  // Guardar el proyecto en el archivo
    }
    
    public List<Proyecto> listarProyectos() throws IOException {
        return ProyectoRepository.cargarProyectos();  // Cargar los autores desde el archivo
    }
}
