package Projeto.API.controller;

import Projeto.API.DAO.IUsuario;
import Projeto.API.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private IUsuario dao;
    @GetMapping("/usuarios")
    public List<Usuario> listaUsuarios() {
        return (List<Usuario>) dao.findAll();
    }
}
