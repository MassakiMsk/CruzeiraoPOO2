package sistema.Service;

import java.util.List;

import sistema.Dao.InscricaoDAO;
import sistema.modelos.Inscricao;

public class InscricaoService {
	InscricaoDAO inscricaoDAO = new InscricaoDAO();

	public Inscricao save(Inscricao inscricao) {
		inscricao = inscricaoDAO.salvar(inscricao);
		inscricaoDAO.closeEntityManager();
		return inscricao;
	}

	public List<Inscricao> getInscricaos() {
		List<Inscricao> list = inscricaoDAO.getAll(Inscricao.class);
		inscricaoDAO.closeEntityManager();
		return list;
	}

	public void update(Inscricao inscricao) {
		inscricaoDAO.salvar(inscricao);
		inscricaoDAO.closeEntityManager();
	}

	public void remove(Inscricao inscricao) {
		inscricao = inscricaoDAO.getById(Inscricao.class, inscricao.getNumero());
		inscricaoDAO.remover(inscricao);
		inscricaoDAO.closeEntityManager();
	}
}
