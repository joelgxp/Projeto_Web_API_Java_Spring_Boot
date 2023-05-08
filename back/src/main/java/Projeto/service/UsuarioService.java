package Projeto.service;

import Projeto.dto.UsuarioDTO;
import Projeto.model.Usuario;
import Projeto.repository.IUsuario;
import Projeto.security.Token;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import Projeto.security.TokenUtil;

@Service
public class UsuarioService {
    private IUsuario repository;
    private PasswordEncoder passwordEncoder;
    private final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    public UsuarioService(IUsuario repository) {
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<Usuario> listaUsuarios() {
        logger.info("Usuario: " + getLogado() + "listando usuarios");
        return repository.findAll();
    }

    public Usuario criarUsuarios(Usuario usuario) {
        String encoder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);
        logger.info("Usuario: " + getLogado() + "criando usuarios");
        return repository.save(usuario);
    }
    public Usuario editarUsuarios(Usuario usuario) {
        String encoder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);
        logger.info("Usuario: " + getLogado() + "editando usuarios: " + usuario);
        return repository.save(usuario);
    }
    public Boolean excluirUsuarios(Integer id) {
        repository.deleteById(id);
        logger.info("Usuario: " + getLogado() + "excluindo usuarios: " + id);
        return true;
    }

    public Token gerarToken(@Valid UsuarioDTO usuario) {
        Usuario user = repository.findByNomeOrEmail(usuario.getNome(), usuario.getEmail());
        if(user != null) {
            Boolean valid = passwordEncoder.matches(usuario.getSenha(), user.getSenha());
            if(valid) {
                return new Token(TokenUtil.createToken(user));
            }
        }
        return null;
    }

    private String getLogado() {
        Authentication userLogado = SecurityContextHolder.getContext().getAuthentication();
        if(!(userLogado instanceof AnonymousAuthenticationToken)) {
            return userLogado.getName();
        }
        return null;
    }
}
