package sistema.Service;

import java.util.List;

import sistema.Dao.UsuarioDAO;
import sistema.modelos.Usuario;

public class UsuarioService {
	UsuarioDAO userDAO = new UsuarioDAO();

	public Usuario save(Usuario usuario){
		usuario = userDAO.salvar(usuario);
		userDAO.closeEntityManager();
		return usuario;
	}

	public List <Usuario> getUsers()
	{
		List <Usuario> list =  userDAO.getAll(Usuario.class);
		userDAO.closeEntityManager();
		return list;
	}
	public void update(Usuario usuario)
	{
		userDAO.salvar(usuario);
		userDAO.closeEntityManager();
	}
	public void remove(Usuario usuario)
	{
		usuario = userDAO.getById(Usuario.class, usuario.getCodigoUsuario());
		userDAO.remover(usuario);
		userDAO.closeEntityManager();
	}
}
