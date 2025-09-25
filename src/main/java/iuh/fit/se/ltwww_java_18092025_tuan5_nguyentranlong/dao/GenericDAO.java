package iuh.fit.se.ltwww_java_18092025_tuan5_nguyentranlong.dao;

import iuh.fit.se.ltwww_java_18092025_tuan5_nguyentranlong.modal.DienThoai;
import iuh.fit.se.ltwww_java_18092025_tuan5_nguyentranlong.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class GenericDAO<T> {
    private Class<T> type;

    public GenericDAO(Class<T> type) {
        this.type = type;
    }

    public List<T> findAll() {
        EntityManager em = JpaUtil.getEmf().createEntityManager();

        try {
            String jpql = """
                    SELECT e FROM %s e
                    """.formatted(type.getSimpleName());
            TypedQuery<T> query = em.createQuery(jpql,type);

            return query.getResultList();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            em.clear();
        }
        return null;
    }

    public  T findById(long id) {
        EntityManager em = JpaUtil.getEmf().createEntityManager();

        try{
            return em.find(type, id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            em.close();
        }
        return null;
    }

    public void save(T entity) {
        EntityManager em =JpaUtil.getEmf().createEntityManager();

        try{
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            em.close();
        }
    }

    public boolean delete(long maDT) {
        EntityManager em =JpaUtil.getEmf().createEntityManager();
        try {
            em.getTransaction().begin();
            DienThoai dt = em.find(DienThoai.class, maDT);
            if(dt == null) return false;
            em.remove(dt);
            em.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
