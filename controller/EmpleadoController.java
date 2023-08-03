/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.peluqueria.controller;

import com.app.peluqueria.model.Empleado;
import com.app.peluqueria.repository.EmpleadoRepository;
import java.util.List;

/**
 *
 * @author john
 */
public class EmpleadoController {
    
    private final EmpleadoRepository empleadoRepository;
    
    public EmpleadoController() {
        empleadoRepository = new EmpleadoRepository();
    }
    
    public List<Empleado> obtenerTodosLosEmpleados() {
        return empleadoRepository.getEmpleados();
    }
    
    public void insertarEmpleado(Empleado empleado) {
        empleadoRepository.agregarEmpleado(empleado);
    }
    
    public Empleado obtenerEmpleadoPorId(int id) {
        return empleadoRepository.obtenerEmpleadoPorId(id);
    }
    
    public void eliminarEmpleadoPorId(int id) {
        empleadoRepository.eliminarEmpleadoPorId(id);
    }
    
    public void actualizarEmpleadoPorId(Empleado empleado) {
        empleadoRepository.actualizarEmpleadoPorId(empleado);
    }
}
