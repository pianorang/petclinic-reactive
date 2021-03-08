package pianorang.petclinicwebflux.owner.ui;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pianorang.petclinicwebflux.owner.domain.Owner;
import pianorang.petclinicwebflux.owner.domain.OwnerRepository;
import pianorang.petclinicwebflux.owner.service.OwnerService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequestMapping("/api/owners")
@RestController
public class OwnerController {

    private final OwnerService ownerService;
    private final ModelMapper modelMapper;

    public OwnerController(OwnerService ownerService, ModelMapper modelMapper) {
        this.ownerService = ownerService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public Flux<OwnerResponseDto> getOwners(OwnerRequestDto ownerRequestDto){
        return this.ownerService.findAll()
                .map(o -> this.modelMapper.map(o, OwnerResponseDto.class)).log();
    }

    @PostMapping("/new")
    public Mono<OwnerResponseDto> addOwner(OwnerRequestDto ownerRequestDto){
        Owner owner = this.modelMapper.map(ownerRequestDto, Owner.class);
        Mono<Owner> newOwner = this.ownerService.save(owner);
        return newOwner.map(o-> this.modelMapper.map(o, OwnerResponseDto.class)).log();
    }

    @GetMapping("/find")
    public Flux<OwnerResponseDto> findOwners(OwnerRequestDto ownerRequestDto){
        return this.ownerService.findByLastName(ownerRequestDto.getLastName())
                .map(o-> this.modelMapper.map(o, OwnerResponseDto.class));
    }


}
