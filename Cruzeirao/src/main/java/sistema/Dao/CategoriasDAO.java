package sistema.Dao;

import sistema.modelos.Campeonato;
import sistema.modelos.Categoria;

public class CategoriasDAO extends BaseDAO<Categoria, Integer> {

	@Override
	protected Class<Categoria> getClasseEntidade() {
		return Categoria.class;
	}

}
