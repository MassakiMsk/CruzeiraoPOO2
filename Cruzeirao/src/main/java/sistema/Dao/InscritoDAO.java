package sistema.Dao;

import sistema.modelos.Inscrito;

public class InscritoDAO extends BaseDAO<Inscrito, Integer>{

	@Override
	protected Class<Inscrito> getClasseEntidade() {
		return Inscrito.class;
	}

}