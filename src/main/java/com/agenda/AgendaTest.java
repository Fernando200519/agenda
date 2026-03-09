package com.agenda;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AgendaTest {

    @Test
    public void testAgregarTarea() {
        Agenda miAgenda = new Agenda();
        String tareaDePrueba = "Comprar pan ";

        miAgenda.agregarTarea(tareaDePrueba);

        List<String> tareas = miAgenda.obtenerTareas();
        
        assertEquals(1, tareas.size(), "La lista debería tener 1 tarea.");
        
        assertEquals(tareaDePrueba, tareas.get(0), "La tarea guardada no coincide.");
    }
}
