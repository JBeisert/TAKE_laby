package lab.data;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.ws.rs.QueryParam;
import lab.entities.Complaint;

import java.util.List;

@ApplicationScoped
public class ComplaintRepository {
    @Inject
    private EntityManager em;

    public void create(Complaint entity) {
        em.persist(entity);
    }
    public void edit(Complaint entity) {
        em.merge(entity);
    }
    public void remove(Complaint entity) {
        em.remove(em.merge(entity));
    }
    public Complaint find(Object id) {
        return em.find(Complaint.class, id);
    }
    public List<Complaint> findAll(@QueryParam("status") String status) {
        if (status != null && !"".equals(status))
            return em.createNamedQuery("Complaint.findByStatus")
                    .setParameter("status", status)
                    .getResultList();
        else{
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Complaint.class));
            return em.createQuery(cq).getResultList();
        }

    }
}
