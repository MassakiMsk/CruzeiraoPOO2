package sistema.Service;

import java.util.List;

import sistema.Dao.CategoriasDAO;
import sistema.modelos.Categoria;

public class CategoriaService {

	CategoriasDAO catDAO = new CategoriasDAO();

	public Categoria save(Categoria categoria) {
		categoria = catDAO.salvar(categoria);
		catDAO.closeEntityManager();
		return categoria;
	}

	public List<Categoria> getCats() {
		List<Categoria> list = catDAO.getAll(Categoria.class);
		catDAO.closeEntityManager();
		return list;
	}
	public void update(Categoria categoria){
		catDAO.salvar(categoria);
		catDAO.closeEntityManager();
	}
	
	public void remove(Categoria categoria){
		categoria = catDAO.getById(Categoria.class,categoria.getCodigoCategoria());
		catDAO.closeEntityManager();
	}
}
