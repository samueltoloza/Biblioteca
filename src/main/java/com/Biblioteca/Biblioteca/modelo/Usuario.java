package com.Biblioteca.Biblioteca.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
    @Column(nullable = false, length = 20)
    private String nombre;
    @Column(nullable = false, length = 20)
    private String apellido;
    @Column(nullable = false, length = 12)
    private String fechaNacimiento;
    private int idlibro;

    public Usuario() {
       
    }

    public Usuario(int id, String nombre, String apellido, String fechaNacimiento, int idlibro) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.idlibro = idlibro;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public int getIdlibro() {
        return idlibro;
    }
    public void setIdlibro(int idlibro) {
        this.idlibro = idlibro;
    }
    

}