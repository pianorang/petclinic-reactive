package pianorang.petclinicwebflux.owner.domain;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface OwnerRepository extends ReactiveCrudRepository<Owner, Long> {

    @Query("select * from owners where last_name LIKE :lastName")
    Flux<Owner> findByLastName(String lastName);
}
