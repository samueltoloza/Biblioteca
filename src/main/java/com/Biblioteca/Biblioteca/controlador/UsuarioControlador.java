package com.Biblioteca.Biblioteca.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Biblioteca.Biblioteca.modelo.Usuario;
import com.Biblioteca.Biblioteca.servicios.UsuarioServicios;

@Controller
public class UsuarioControlador {

    @Autowired
    private UsuarioServicios usuarioServicios;

    @RequestMapping("/")
    public String verInicio(Model modelo, @Param("palabraClave") String palabraClave) {
        List<Usuario> ListlistaUsuarios = usuarioServicios.listAll(palabraClave);
        modelo.addAttribute("ListlistaUsuarios", ListlistaUsuarios);
        modelo.addAttribute("palabraClave", palabraClave);
        
        return "index";
    }
    
    @RequestMapping("/nuevousuario")
    public String formularioUsuario(Model modelo) {
        Usuario usuario = new Usuario();
        modelo.addAttribute("usuario", usuario);

        return "nuevousuario";
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardarUsuario(@ModelAttribute("usario") Usuario usuario) {
        usuarioServicios.save(usuario);
        return "redirect:/";
    }

    @RequestMapping("/editar/{id}")
    public ModelAndView formularioEditarUsuario(@PathVariable(name = "id") int id) {
        ModelAndView modelo = new ModelAndView("editarusuario");
        Usuario usuario = usuarioServicios.getUsuarioById(id);
        modelo.addObject("usuario", usuario);
        return modelo;
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable(name = "id")int id) {
        usuarioServicios.deleteById(id);
        return "redirect:/";
    }
}