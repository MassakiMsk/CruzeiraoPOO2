package sistema.Dao;

import sistema.modelos.Campeonato;
import sistema.modelos.Usuario;

public class UsuarioDAO extends BaseDAO<Usuario, Integer>{
	@Override
	protected Class<Usuario> getClasseEntidade() {
		return Usuario.class;
	}
}
