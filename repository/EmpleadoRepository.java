/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.peluqueria.repository;

import com.app.peluqueria.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.app.peluqueria.model.Empleado;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author john
 */
public class EmpleadoRepository {
    
    public List<Empleado> getEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        try (Connection conn = MySQLConnection.getConnection()) {
            String consulta = "SELECT * FROM empleado";
            PreparedStatement stmt = conn.prepareStatement(consulta);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                // Obtener los datos del resultado de la consulta
                Empleado empleado = new Empleado();
                empleado.setId(rs.getInt("ID_Empleado"));
                empleado.setNombre(rs.getString("Nombre"));
                empleado.setApellido(rs.getString("Apellido"));
                empleado.setEmail(rs.getString("Email"));
                empleado.setEspecialidad(rs.getString("Especialidad"));
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleados;
    }
    
    public void agregarEmpleado (Empleado empleado) {
        
        String sql = "INSERT INTO empleado (nombre, apellido, email, especialidad) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, empleado.getNombre());
            pstmt.setString(2, empleado.getApellido());
            pstmt.setString(3, empleado.getEmail());
            pstmt.setString(4, empleado.getEspecialidad());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Empleado obtenerEmpleadoPorId(int id) {
        
        String sql = "SELECT * FROM empleado WHERE ID_Empleado = ?";
        
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int empleadoId = rs.getInt("ID_Empleado");
                    String nombre = rs.getString("Nombre");
                    String apellido = rs.getString("Apellido");
                     String email = rs.getString("Email");
                    String especialidad = rs.getString("Especialidad");

                    return new Empleado(empleadoId, nombre, apellido, email, especialidad);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public void eliminarEmpleadoPorId(int id) {
        String sql = "DELETE FROM empleado WHERE ID_Empleado = ?";

        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void actualizarEmpleadoPorId(Empleado empleado) {
        
        String sql = "UPDATE empleado SET Nombre = ?, Apellido = ?, Email = ?, Especialidad = ? WHERE ID_Empleado = ?";

        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, empleado.getNombre());
            pstmt.setString(2, empleado.getApellido());
            pstmt.setString(3, empleado.getEmail());
            pstmt.setString(4, empleado.getEspecialidad());
            pstmt.setInt(5, empleado.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
