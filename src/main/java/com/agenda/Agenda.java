package com.agenda;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<String> tareas;
    private List<Boolean> completadas;

    public Agenda() {
        this.tareas = new ArrayList<>();
        this.completadas = new ArrayList<>();
    }

    public void agregarTarea(String tarea) {
        tareas.add(tarea);
        completadas.add(false);
    }

    public void marcarComoCompletada(int indice) {
        if (indice >= 0 && indice < tareas.size()) {
            completadas.set(indice, true);
        }
    }

    public List<String> obtenerTareas() {
        return tareas;
    }

   public boolean estaCompletada(int indice) {
        if (indice >= 0 && indice < completadas.size()) {
            return completadas.get(indice);
        }
        return false;
    }

    public void eliminarTarea(int indice) {
        if (indice >= 0 && indice < tareas.size()){
            tareas.remove(indice);
            completadas.remove(indice);
        }
    }
}
