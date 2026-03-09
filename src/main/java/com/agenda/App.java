package com.agenda;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;

        System.out.println("--- ORGANIZADOR DE TAREAS ---");

        do {
            System.out.println("\n1. Agregar una nueva tarea");
            System.out.println("2. Listar todas las tareas");
            System.out.println("3. Marcar tarea como completada");
            System.out.println("4. Eliminar una tarea");
            System.out.println("5. Ejecutar auto-diagnóstico (Tests)");
            System.out.println("6. Salir");
            System.out.print("\nSeleccione una opción: ");
            
            try {
                opcion = entrada.nextInt();
                entrada.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("Nombre de la tarea: ");
                        String tarea = entrada.nextLine();
                        agenda.agregarTarea(tarea);
                        System.out.println("¡Tarea agregada!");
                        break;

                    case 2:
                        List<String> lista = agenda.obtenerTareas();
                        if (lista.isEmpty()) {
                            System.out.println("La agenda está vacía.");
                        } else {
                            System.out.println("\n--- LISTA DE TAREAS ---");
                            for (int i = 0; i < lista.size(); i++) {
                                String estado = agenda.estaCompletada(i) ? "[Hecha]" : "[Pendiente]";
                                System.out.println(i + ". " + lista.get(i) + " " + estado);
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Índice de la tarea a completar: ");
                        int indiceComp = entrada.nextInt();
                        agenda.marcarComoCompletada(indiceComp);
                        System.out.println("Tarea actualizada.");
                        break;

                    case 4:
                        System.out.print("Índice de la tarea a eliminar: ");
                        int indiceElim = entrada.nextInt();
                        agenda.eliminarTarea(indiceElim); 
                        System.out.println("Tarea eliminada.");           
                        break;

                    case 5: {
                        try {
                            AgendaTest pruebasAuto = new AgendaTest();
                            pruebasAuto.testAgregarTarea();
                            System.out.println("✅ Resultado: El sistema de tareas es estable.");
                        } catch (Throwable e) {
                            System.out.println("❌ Resultado: El diagnóstico detectó un fallo.");
                            System.out.println("Motivo: " + e.getMessage());
                        }
                        break;
                    }

                    case 6:
                        System.out.println("Saliendo de la agenda. ¡Hasta luego!");
                        break;

                    default:
                        System.out.println("Opción no válida. Intenta de nuevo.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: Ingresa un número válido.");
                entrada.nextLine();
            }
        } while (opcion != 6);
        
        entrada.close();
    }
}