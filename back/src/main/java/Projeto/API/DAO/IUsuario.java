package Projeto.API.DAO;

import Projeto.API.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuario  extends CrudRepository<Usuario, Integer> {
}
