package pianorang.petclinicwebflux.owner.service;

import org.springframework.stereotype.Service;
import pianorang.petclinicwebflux.owner.domain.Owner;
import pianorang.petclinicwebflux.owner.domain.OwnerRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.DoubleStream;

@Service
public class OwnerService {
    private OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public Mono<Owner> findById(Long id){
        return this.ownerRepository.findById(id);
    }

    public Mono<Owner> save(Owner owner){
        return this.ownerRepository.save(owner);
    }

    public Flux<Owner> findByLastName(String lastName){
        return this.ownerRepository.findByLastName(lastName);
    }


    public Flux<Owner> findAll() {
        return this.ownerRepository.findAll();
    }
}
