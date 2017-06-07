package sistema.Dao;

import sistema.modelos.Equipe;

public class EquipeDAO extends BaseDAO<Equipe, Integer>{

	@Override
	protected Class<Equipe> getClasseEntidade() {
		return Equipe.class;
	}

}
