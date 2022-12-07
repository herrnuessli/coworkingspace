package ch.zli.m223.service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.ApplicationUser;

import javax.inject.Inject;

import io.quarkus.arc.profile.IfBuildProfile;
import io.quarkus.runtime.StartupEvent;

@IfBuildProfile("dev")
@ApplicationScoped
public class TestDataService {
    @Inject
    EntityManager entityManager;

    @Transactional
    void generateTestData(@Observes StartupEvent event){
        //applicationUsers
        var projectAApplicationUser = new ApplicationUser();
        projectAApplicationUser.setFirstname("Raph");
        projectAApplicationUser.setLastname("Stricker");
        projectAApplicationUser.setAdmin(false);
        projectAApplicationUser.setEmail("raphael.stricker@gmail.com");
        projectAApplicationUser.setPassword("Password123");


    }
}
