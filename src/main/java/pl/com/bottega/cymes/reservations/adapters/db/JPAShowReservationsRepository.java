package pl.com.bottega.cymes.reservations.adapters.db;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import pl.com.bottega.cymes.reservations.domain.ShowReservations;
import pl.com.bottega.cymes.reservations.domain.ShowReservationsExporter;
import pl.com.bottega.cymes.reservations.domain.ShowReservationsRepository;

@Repository
@AllArgsConstructor
public class JPAShowReservationsRepository implements ShowReservationsRepository {

    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(ShowReservations showReservations) {
        ShowReservationRecord record = new ShowReservationRecord();
        showReservations.export(record);
        entityManager.persist(record);
    }
}

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
class ShowReservationRecord implements ShowReservationsExporter {

    @Id
    private UUID showId;

    @Override
    public void addShowId(UUID showId) {
        this.showId = showId;
    }
}
