package sistema.Dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;


public abstract class BaseDAO<T, I extends Serializable> {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<T> classeEntidade;

	public BaseDAO() {
		if (emf == null)
			emf = Persistence.createEntityManagerFactory("Cruzeirao");

		// Usar CDI!!!!
		em = emf.createEntityManager();
	}

	protected abstract Class<T> getClasseEntidade();

	@PostConstruct
	public void init() {
		classeEntidade = getClasseEntidade();
	}

	public EntityManager getEntityManager() {

		if (em == null)
			em = emf.createEntityManager();

		return em;
	}

	public void closeEntityManager() {

		if (em != null)
			em.close();

		em = null;
	}

	public Query criarNativeQuery(String sql) {
		return em.createNativeQuery(sql);
	}

	public T salvar(T entidade) {
		T saved = null;

		getEntityManager().getTransaction().begin();
		saved = getEntityManager().merge(entidade);
		getEntityManager().getTransaction().commit();

		return saved;
	}

	public void remover(T entity) {
		getEntityManager().getTransaction().begin();
		getEntityManager().remove(entity);
		getEntityManager().getTransaction().commit();
	}

	public T atualizar(T entidade) {
		return em.merge(entidade);
	}

	public T pesquisarPorId(Long id) {
		return em.find(classeEntidade, id);
	}

	public T pesquisarReferencia(Long id) {
		return em.getReference(classeEntidade, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> pesquisarTodos() {
		CriteriaQuery<Object> cq = em.getCriteriaBuilder().createQuery();
		cq.select(cq.from(classeEntidade));
		return (List<T>) em.createQuery(cq).getResultList();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected T pesquisarUm(String namedQuery, Map parametros) {
		T resultado = null;

		try {
			Query query = em.createNamedQuery(namedQuery);
			if (parametros != null && !parametros.isEmpty()) {
				popularParametrosQuery(query, parametros);
			}
			resultado = (T) query.setMaxResults(1).getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

		return resultado;
	}

	protected void popularParametrosQuery(Query query, Map<String, Object> parametros) {
		for (Map.Entry<String, Object> parametro : parametros.entrySet()) {
			query.setParameter(parametro.getKey(), parametro.getValue());
		}
	}

	// Gets Diferentes
	@SuppressWarnings("unchecked")
	public List<T> getAll(Class<T> classe) {

		return getEntityManager().createQuery("select o from " + classe.getSimpleName() + " o").getResultList();
	}

	public T getById(Class<T> classe, I pk) {

		try {
			T t = getEntityManager().find(classe, pk);
			getEntityManager().refresh(t);
			return t;
		} catch (NoResultException e) {
			return null;
		}

	}
}