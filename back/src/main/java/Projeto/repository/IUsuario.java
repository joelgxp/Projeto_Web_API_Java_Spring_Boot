package Projeto.repository;

import Projeto.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuario  extends JpaRepository<Usuario, Integer> {
    public Usuario findByNomeOrEmail(String nome, String email);
}
