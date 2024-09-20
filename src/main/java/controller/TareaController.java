
package controller;

import java.io.IOException;
import java.util.List;
import model.Tarea;
import repository.TareaRepository;


public class TareaController {
    public void registrarTarea(Tarea libro) throws IOException {
        TareaRepository.guardarTarea(libro);  // Guardar el libro en el archivo
    }

    // Método para cargar todos los libros
    public List<Tarea> listarTareas() throws IOException {
        return TareaRepository.cargarTareas();  // Cargar los libros desde el archivo
    }
    
   

    // Método para buscar libros por Autor
    public List<Tarea> filtrarTareasporProyecto(String autorNombre) throws IOException {
        
        return TareaRepository.buscarTareaPorProyecto(autorNombre);  // Buscar libros por Autor
    }
}
