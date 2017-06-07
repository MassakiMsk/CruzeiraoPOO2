package sistema.Service;

import java.util.List;

import sistema.Dao.CampeonatoDAO;
import sistema.modelos.Campeonato;

public class CampeonatoService {
	CampeonatoDAO champDAO = new CampeonatoDAO();

	public Campeonato save(Campeonato campeonato) {
		campeonato = champDAO.salvar(campeonato);
		champDAO.closeEntityManager();
		return campeonato;
	}

	public List<Campeonato> getChamps() {
		List<Campeonato> list = champDAO.getAll(Campeonato.class);
		champDAO.closeEntityManager();
		return list;
	}

	public void update(Campeonato campeonato) {
		champDAO.salvar(campeonato);
		champDAO.closeEntityManager();
	}

	public void remove(Campeonato campeonato) {
		campeonato = champDAO.getById(Campeonato.class, campeonato.getCodigoCampeonato());
		champDAO.remover(campeonato);
		champDAO.closeEntityManager();
	}
}
