package ch.zli.m223.service;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.oracle.svm.core.annotate.Inject;

import java.util.List;
import ch.zli.m223.model.Booking;

@ApplicationScoped
public class BookingService {
    @Inject
    EntityManager entityManager;

    @Transactional
    public List<Booking> findAll() {
        var query = entityManager.createQuery("FROM Booking", Booking.class);
        return query.getResultList();
    }

    @Transactional
    public Booking createBooking(Booking booking) {
        return entityManager.merge(booking);
    }

    @Transactional
    public Booking readBooking(Long id) {
        return entityManager.find(Booking.class, id);
    }

    @Transactional
    public Booking updateBooking(Long id, Booking booking) {
        booking.setId(id);
        return entityManager.merge(booking);
    }

    @Transactional
    public void deleteBooking(Long id) {
        var entity = entityManager.find(Booking.class, id);
        entityManager.remove(entity);
    }
}
