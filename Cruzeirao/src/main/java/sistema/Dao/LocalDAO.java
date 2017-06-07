package sistema.Dao;

import sistema.modelos.Local;

public class LocalDAO extends BaseDAO<Local, Integer> {

	@Override
	protected Class<Local> getClasseEntidade() {
		return Local.class;
	}

}
