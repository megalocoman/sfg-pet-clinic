package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Dataloader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public Dataloader(OwnerService ownerService, VetService vetService) {
//        ownerService = new OwnerServiceMap() ;
//        vetService = new VetServiceMap();
        this.ownerService = ownerService;
        this.vetService = vetService;
    }


    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("chibo");
        owner1.setLastName("lito");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("miki");
        owner2.setLastName("sito");
        ownerService.save(owner2);

        System.out.println("loaded owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("peepee");
        vet1.setLastName("poopoo");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("el pepe");
        vet2.setLastName("juju");

        vetService.save(vet2);

        System.out.println("loaded vets...");
    }
}
