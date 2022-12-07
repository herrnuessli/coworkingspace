package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.oracle.svm.core.annotate.Inject;

import ch.zli.m223.model.ApplicationUser;

@ApplicationScoped
public class ApplicationUserService {
    @Inject
    EntityManager entityManager;

    public List<ApplicationUser> findAll() {
        var query = entityManager.createQuery("FROM ApplicationUser", ApplicationUser.class);
        return query.getResultList();
    }

    @Transactional
    public ApplicationUser createApplicationUser(ApplicationUser applicationUser){
        return entityManager.merge(applicationUser);
    }

    @Transactional
    public ApplicationUser readApplicationUser(Long id){
        return entityManager.find(ApplicationUser.class, id);
    }

    @Transactional
    public ApplicationUser updateApplicationUser(Long id, ApplicationUser applicationUser) {
        applicationUser.setId(id);
        return entityManager.merge(applicationUser);
    }
    
    @Transactional
    public ApplicationUser updatePassword(Long id, String newPassword) {
        var applicationUser = entityManager.find(ApplicationUser.class, id);
        applicationUser.setPassword(newPassword);
        return entityManager.merge(applicationUser);
    }

    @Transactional
    public void deleteApplicationUser(Long id) {
        var entity = entityManager.find(ApplicationUser.class, id);
        entityManager.remove(entity);
    }

    

}
