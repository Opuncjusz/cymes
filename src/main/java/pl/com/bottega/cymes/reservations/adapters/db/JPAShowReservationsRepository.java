package pl.com.bottega.cymes.reservations.adapters.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.com.bottega.cymes.reservations.domain.ShowReservations;
import pl.com.bottega.cymes.reservations.domain.ShowReservationsExporter;
import pl.com.bottega.cymes.reservations.domain.ShowReservationsRepository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.transaction.Transactional;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class JPAShowReservationsRepository implements ShowReservationsRepository {

    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(ShowReservations showReservations) {
        ShowReservationRecord showReservationRecord = new ShowReservationRecord();
        showReservations.export(showReservationRecord);
        entityManager.persist(showReservationRecord);
    }

    @Override
    public ShowReservations get(UUID uuid) {
        return null;
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