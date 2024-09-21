package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Invitado {
    
    private String nombre;
    private String numCelular;
    private String genero;
    private String fecha;
    private String direccion;
    private Evento evento;
}