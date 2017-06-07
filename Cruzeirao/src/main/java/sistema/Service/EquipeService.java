package sistema.Service;

import java.util.List;

import sistema.Dao.EquipeDAO;
import sistema.modelos.Equipe;


public class EquipeService {
	EquipeDAO equiDAO = new EquipeDAO();

	public Equipe save(Equipe equipe){
		equipe = equiDAO.salvar(equipe);
		equiDAO.closeEntityManager();
		return equipe;
	}

	public List <Equipe> getEquis()
	{
		List <Equipe> list =  equiDAO.getAll(Equipe.class);
		equiDAO.closeEntityManager();
		return list;
	}
	public void update(Equipe equipe)
	{
		equiDAO.salvar(equipe);
		equiDAO.closeEntityManager();
	}
	public void remove(Equipe equipe)
	{
		equipe = equiDAO.getById(Equipe.class, equipe.getCodigoEquipe());
		equiDAO.remover(equipe);
		equiDAO.closeEntityManager();
	}	
}
