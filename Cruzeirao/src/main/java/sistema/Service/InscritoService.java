package sistema.Service;

import java.util.List;

import sistema.Dao.InscritoDAO;
import sistema.modelos.Inscrito;

public class InscritoService {
	InscritoDAO inscritoDAO = new InscritoDAO();

	public Inscrito save(Inscrito inscrito) {
		inscrito = inscritoDAO.salvar(inscrito);
		inscritoDAO.closeEntityManager();
		return inscrito;
	}

	public List<Inscrito> getInscritos() {
		List<Inscrito> list = inscritoDAO.getAll(Inscrito.class);
		inscritoDAO.closeEntityManager();
		return list;
	}

	public void update(Inscrito inscrito) {
		inscritoDAO.salvar(inscrito);
		inscritoDAO.closeEntityManager();
	}

	public void remove(Inscrito inscrito) {
		inscrito = inscritoDAO.getById(Inscrito.class, inscrito.getCodigoInscrito());
		inscritoDAO.remover(inscrito);
		inscritoDAO.closeEntityManager();
	}
}
