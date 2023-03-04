package com.gestion.empleado.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEmpleado;
    @NotNull
    @Size(min=1,max=50,message="no cumple con los parametros")
    private String nombre;
    @NotNull
    @Size(min=1,max=50,message="no cumple con los parametros")    
    private String apellido;
    
    @Email
    @NotNull
    @Size(min=1,max=50,message="no cumple con los parametros")
    private String email;
    @NotNull
    @Size(min=1,max=50,message="no cumple con los parametros")
    private String cargo;

    public Empleado() {
    }

    public Empleado(long idEmpleado, String nombre, String apellido, String email, String cargo) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.cargo = cargo;
    }
    
    public Empleado(String nombre, String apellido, String email, String cargo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.cargo = cargo;
    }

    public long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
}
