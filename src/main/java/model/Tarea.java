package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Tarea {
    
    private String nombre;
    private String responsable;
    private String estado;
    private Proyecto proyecto;
}