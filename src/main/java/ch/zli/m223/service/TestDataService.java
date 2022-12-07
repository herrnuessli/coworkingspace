package ch.zli.m223.service;

import java.time.LocalDate;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.aayushatharva.brotli4j.common.annotations.Local;

import ch.zli.m223.model.ApplicationUser;
import ch.zli.m223.model.Booking;
import ch.zli.m223.model.TimePeriod;

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
        var user1ApplicationUser = new ApplicationUser();
        user1ApplicationUser.setFirstname("Raph");
        user1ApplicationUser.setLastname("Stricker");
        user1ApplicationUser.setAdmin(false);
        user1ApplicationUser.setEmail("raphael.stricker@gmail.com");
        user1ApplicationUser.setPassword("Password123");
        entityManager.persist(user1ApplicationUser);

        var user2ApplicationUser = new ApplicationUser();
        user2ApplicationUser.setFirstname("Mark");
        user2ApplicationUser.setLastname("Cedrickstaller");
        user2ApplicationUser.setAdmin(true);
        user2ApplicationUser.setEmail("mark.cedrickstaller@gmail.com");
        user2ApplicationUser.setPassword("Zli123");
        entityManager.persist(user2ApplicationUser);

        var user3ApplicationUser = new ApplicationUser();
        user3ApplicationUser.setFirstname("Miles");
        user3ApplicationUser.setLastname("Milian");
        user3ApplicationUser.setAdmin(false);
        user3ApplicationUser.setEmail("miles.milian@gmail.com");
        user3ApplicationUser.setPassword("VeGGieGanGzz");
        entityManager.persist(user3ApplicationUser);

        //Bookings
        var firstBooking = new Booking();
        firstBooking.setDate(LocalDate.parse("2022-12-01"));
        firstBooking.setTimePeriod(TimePeriod.FULLDAY);
        firstBooking.setApplicationUser(user1ApplicationUser);
        entityManager.persist(firstBooking);

        var secondBooking = new Booking();
        secondBooking.setDate(LocalDate.parse("2022-12-02"));
        secondBooking.setTimePeriod(TimePeriod.MORNING);
        secondBooking.setApplicationUser(user1ApplicationUser);
        entityManager.persist(secondBooking);

        var thirdBooking = new Booking();
        thirdBooking.setDate(LocalDate.parse("2022-12-03"));
        thirdBooking.setTimePeriod(TimePeriod.AFTERNOON);
        thirdBooking.setApplicationUser(user2ApplicationUser);
        entityManager.persist(thirdBooking);
    }
}
