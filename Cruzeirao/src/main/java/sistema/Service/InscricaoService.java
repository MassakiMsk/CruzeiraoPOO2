package sistema.Service;

import java.util.List;

import sistema.Dao.InscricaoDAO;
import sistema.modelos.Inscricao;

public class InscricaoService {
	InscricaoDAO inscriDAO = new InscricaoDAO();

	public Inscricao save(Inscricao inscricao){
		inscricao = inscriDAO.salvar(inscricao);
		inscriDAO.closeEntityManager();
		return inscricao;
	}

	public List <Inscricao> getInscris()
	{
		List <Inscricao> list =  inscriDAO.getAll(Inscricao.class);
		inscriDAO.closeEntityManager();
		return list;
	}
	public void update(Inscricao inscricao)
	{
		inscriDAO.salvar(inscricao);
		inscriDAO.closeEntityManager();
	}
	public void remove(Inscricao inscricao)
	{
		inscricao = inscriDAO.getById(Inscricao.class, inscricao.getNumero());
		inscriDAO.remover(inscricao);
		inscriDAO.closeEntityManager();
	}	
}
