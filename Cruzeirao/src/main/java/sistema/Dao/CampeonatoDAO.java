package sistema.Dao;

import sistema.modelos.Campeonato;

public class CampeonatoDAO extends BaseDAO<Campeonato, Integer>{

	@Override
	protected Class<Campeonato> getClasseEntidade() {
		return Campeonato.class;
	}

}