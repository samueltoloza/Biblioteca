package com.Biblioteca.Biblioteca.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Biblioteca.Biblioteca.modelo.Usuario;

@Repository
public interface UsuarioRepositorios extends JpaRepository<Usuario, Integer> {

    @Query("SELECT u FROM Usuario u WHERE u.nombre LIKE %?1%"
    + " OR u.apellido LIKE %?1%"
    + " OR u.fechaNacimiento LIKE %?1%")
    public List<Usuario> findAll(String palabraClave);
}