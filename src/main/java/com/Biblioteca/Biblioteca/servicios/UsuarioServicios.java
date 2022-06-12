package com.Biblioteca.Biblioteca.servicios;

import java.util.List;

import com.Biblioteca.Biblioteca.modelo.Usuario;
import com.Biblioteca.Biblioteca.repositorios.UsuarioRepositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicios {
    @Autowired
    private UsuarioRepositorios usuarioRepositorios;

    public List<Usuario> listAll(String palabraClave) {
        if(palabraClave != null){
            return usuarioRepositorios.findAll(palabraClave);
        }
        return usuarioRepositorios.findAll();
    }

    public void save(Usuario usuario) {
        usuarioRepositorios.save(usuario);
    }

    public Usuario getUsuarioById(int id) {
        return usuarioRepositorios.findById(id).get();
    }

    public void deleteById(int id) {
        usuarioRepositorios.deleteById(id);
    }
}
