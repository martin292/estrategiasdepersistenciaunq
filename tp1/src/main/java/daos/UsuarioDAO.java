package daos;

import java.util.List;

import org.hibernate.classic.Session;

import tp1.Usuario;

public class UsuarioDAO {

	public Usuario get(int id){
		return (Usuario)SessionManager.getSession().get(Usuario.class, id);
	}
	
	public List<Usuario> getAll(){
		Session session = SessionManager.getSession();
		return session.createCriteria(Usuario.class).list();
	}

	public void save(Usuario usr) {		
		SessionManager.getSession().saveOrUpdate(usr);
	}
	
}
