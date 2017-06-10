package sistema.Dao;

import sistema.modelos.Inscricao;

public class InscricaoDAO extends BaseDAO<Inscricao, Integer>{

	@Override
	protected Class<Inscricao> getClasseEntidade() {
		return Inscricao.class;
	}

}