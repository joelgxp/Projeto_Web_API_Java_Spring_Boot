package Projeto.service;

import Projeto.model.Usuario;
import Projeto.repository.IUsuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {
    private IUsuario repository;
    private PasswordEncoder passwordEncoder;

    public UsuarioService(IUsuario repository) {

        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<Usuario> listaUsuarios() {
        List<Usuario> lista = repository.findAll();
        return lista;
    }

    public Usuario criarUsuarios(Usuario usuario) {
        String encoder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);
        Usuario usuarioNovo = repository.save(usuario);
        return usuarioNovo;
    }
    public Usuario editarUsuarios(Usuario usuario) {
        String encoder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);
        Usuario usuarioNovo = repository.save(usuario);
        return usuarioNovo;
    }
    public Boolean excluirUsuarios(Integer id) {
        repository.deleteById(id);
        return true;
    }


    public Boolean validarSenha(Usuario usuario) {
        String senha = repository.getById(usuario.getId()).getSenha();
        Boolean valida = passwordEncoder.matches(usuario.getSenha(), senha);
        return valida;
    }
}
