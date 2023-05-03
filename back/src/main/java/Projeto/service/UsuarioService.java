package Projeto.service;

import Projeto.model.Usuario;
import Projeto.repository.IUsuario;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private IUsuario repository;

    public UsuarioService(IUsuario repository) {
        this.repository = repository;
    }

    public List<Usuario> listaUsuarios() {
        List<Usuario> lista = repository.findAll();
        return lista;
    }

    public Usuario criarUsuarios(Usuario usuario) {
        Usuario usuarioNovo = repository.save(usuario);
        return usuarioNovo;
    }
}
