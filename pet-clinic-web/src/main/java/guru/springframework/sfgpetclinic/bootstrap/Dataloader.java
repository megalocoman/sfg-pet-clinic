package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Dataloader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public Dataloader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
//        ownerService = new OwnerServiceMap() ;
//        vetService = new VetServiceMap();
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("chibo");
        owner1.setLastName("lito");
        owner1.setAddress("casa fea");
        owner1.setCity("curepto");
        owner1.setTelephone("879654123");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("miki");
        owner2.setLastName("sito");
        owner2.setAddress("casa fea");
        owner2.setCity("curepto");
        owner2.setTelephone("879654123");
        ownerService.save(owner2);

        System.out.println("loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("peepee");
        vet1.setLastName("poopoo");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("el pepe");
        vet2.setLastName("juju");

        vetService.save(vet2);

        System.out.println("loaded vets...");
    }
}
