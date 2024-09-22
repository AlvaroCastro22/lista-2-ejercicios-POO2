
package controller;

import java.io.IOException;
import java.util.List;
import model.Invitado;
import repository.InvitadoRepository;


public class InvitadoController {
    public void registrarInvitado(Invitado libro) throws IOException {
        System.out.println("XD");
        InvitadoRepository.guardarTarea(libro);  // Guardar el libro en el archivo
    }

    // Método para cargar todos los libros
    public List<Invitado> listarInvitados() throws IOException {
        return InvitadoRepository.cargarTareas();  // Cargar los libros desde el archivo
    }
    
   

    // Método para buscar libros por Autor
    public List<Invitado> filtrarTareasporProyecto(String autorNombre) throws IOException {
        
        return InvitadoRepository.buscarInvitadoPorEvento(autorNombre);  // Buscar libros por Autor
    }
}
