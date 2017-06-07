package sistema.Service;

import java.util.List;

import sistema.Dao.LocalDAO;
import sistema.modelos.Local;;

public class LocalService {
	LocalDAO localDAO = new LocalDAO();

	public Local save(Local local){
		local = localDAO.salvar(local);
		localDAO.closeEntityManager();
		return local;
	}

	public List <Local> getLocais()
	{
		List <Local> list =  localDAO.getAll(Local.class);
		localDAO.closeEntityManager();
		return list;
	}
	public void update(Local local)
	{
		localDAO.salvar(local);
		localDAO.closeEntityManager();
	}
	public void remove(Local local)
	{
		local = localDAO.getById(Local.class, local.getCodigoLocal());
		localDAO.remover(local);
		localDAO.closeEntityManager();
	}
}
