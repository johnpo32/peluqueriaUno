/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.app.peluqueria;

import com.app.peluqueria.controller.EmpleadoController;
import com.app.peluqueria.model.Empleado;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author john
 */
public class Peluqueria {

    public static void main(String[] args) {
        EmpleadoController empleadoController = new EmpleadoController();
        
        try (Scanner scanner = new Scanner(System.in)) {
            int opcion;
            do {
                System.out.println("\nMenú de Empleados");
                System.out.println("1. Agregar Empleado");
                System.out.println("2. Buscar Empleado por ID");
                System.out.println("3. Mostrar todos los Empleados");
                System.out.println("4. Actualizar Empleado");
                System.out.println("5. Eliminar Empleado por ID");
                System.out.println("0. Salir");
                System.out.print("Ingrese una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea después del nextInt()
                
                switch (opcion) {
                    case 1 -> {
                        System.out.print("Ingrese el nombre del empleado: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese el apellido del empleado: ");
                        String apellido = scanner.nextLine();
                        System.out.print("Ingrese el email del empleado: ");
                        String email = scanner.nextLine();
                        System.out.print("Ingrese el especialidad del empleado: ");
                        String especialidad = scanner.nextLine();
                        
                        Empleado empleado = new Empleado();
                        empleado.setNombre(nombre);
                        empleado.setApellido(apellido);
                        empleado.setEmail(email);
                        empleado.setEspecialidad(especialidad);
                        
                        empleadoController.insertarEmpleado(empleado);
                        System.out.println("Empleado agregado exitosamente.");
                    }
                    case 2 -> {
                        System.out.print("Ingrese el ID del empleado a buscar: ");
                        int idBuscar = scanner.nextInt();
                        Empleado empleado = empleadoController.obtenerEmpleadoPorId(idBuscar);
                        if (empleado != null) {
                            System.out.println("Empleado encontrado:");
                            System.out.println(empleado.toString());
                        } else {
                            System.out.println("Empleado no encontrado.");
                        }
                    }
                    case 3 -> {
                        List<Empleado> listaEmpleados = empleadoController.obtenerTodosLosEmpleados();
                        if (!listaEmpleados.isEmpty()) {
                            System.out.println("Lista de Empleados:");
                            for (Empleado emp : listaEmpleados) {
                                System.out.println(emp.toString());
                            }
                        } else {
                            System.out.println("No hay empleados registrados.");
                        }
                    }
                    case 4 -> {
                        System.out.print("Ingrese el ID del empleado a actualizar: ");
                        int idActualizar = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Ingrese el nuevo nombre del empleado: ");
                        String nuevoNombre = scanner.nextLine();
                        System.out.print("Ingrese el nuevo apellido del empleado: ");
                        String nuevoApellido = scanner.nextLine();
                        System.out.print("Ingrese el nuevo email del empleado: ");
                        String nuevoEmail = scanner.nextLine();
                        System.out.print("Ingrese la nueva especialidad del empleado: ");
                        String nuevaEspecialidad = scanner.nextLine();
                        
                        Empleado empleado = new Empleado();
                        empleado.setId(idActualizar);
                        empleado.setNombre(nuevoNombre);
                        empleado.setApellido(nuevoApellido);
                        empleado.setEmail(nuevoEmail);
                        empleado.setEspecialidad(nuevaEspecialidad);
                        
                        empleadoController.actualizarEmpleadoPorId(empleado);
                        System.out.println("Empleado actualizado exitosamente.");
                    }
                    case 5 -> {
                        System.out.print("Ingrese el ID del empleado a eliminar: ");
                        int idEliminar = scanner.nextInt();
                        empleadoController.eliminarEmpleadoPorId(idEliminar);
                        System.out.println("Empleado eliminado exitosamente.");
                    }
                    case 0 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción inválida. Intente nuevamente.");
                }
            } while (opcion != 0);
        }
    }
}
