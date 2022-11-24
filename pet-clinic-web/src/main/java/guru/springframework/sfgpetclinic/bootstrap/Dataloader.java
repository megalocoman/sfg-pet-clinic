package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Dataloader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public Dataloader(OwnerService ownerService, VetService vetService,
                      PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
//        ownerService = new OwnerServiceMap() ;
//        vetService = new VetServiceMap();
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if (count == 0){
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality dentistry = new Speciality();
        radiology.setDescription("Dentistry");
        Speciality savedDentristy = specialityService.save(dentistry);

        Speciality surgery = new Speciality();
        radiology.setDescription("Surgery");
        Speciality savedSurgey = specialityService.save(surgery);

        Owner owner1 = new Owner();
        owner1.setFirstName("chibo");
        owner1.setLastName("lito");
        owner1.setAddress("casa fea");
        owner1.setCity("curepto");
        owner1.setTelephone("879654123");

        Pet pet1 = new Pet();
        pet1.setPetType(savedDogPetType);
        pet1.setOwner(owner1);
        pet1.setBirthDate(LocalDate.now());
        pet1.setName("el bebe");
        owner1.getPets().add(pet1);

        Visit dogVisit = new Visit();
        dogVisit.setPet(pet1);
        dogVisit.setDate(LocalDate.now());
        dogVisit.setDescription("diarhea");
        visitService.save(dogVisit);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("miki");
        owner2.setLastName("sito");
        owner2.setAddress("casa fea");
        owner2.setCity("curepto");
        owner2.setTelephone("879654123");

        Pet pet2 = new Pet();
        pet2.setPetType(savedCatPetType);
        pet2.setOwner(owner2);
        pet2.setBirthDate(LocalDate.now());
        pet2.setName("el chuchu");
        owner2.getPets().add(pet2);

        Visit catVisit = new Visit();
        catVisit.setPet(pet2);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("gatitis");
        visitService.save(catVisit);

        ownerService.save(owner2);

        System.out.println("loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("peepee");
        vet1.setLastName("poopoo");
        vet1.getSpecialty().add(savedRadiology);
        vet1.getSpecialty().add(savedSurgey);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("el pepe");
        vet2.setLastName("juju");
        vet2.getSpecialty().add(savedSurgey);
        vet2.getSpecialty().add(savedDentristy);

        vetService.save(vet2);

        System.out.println("loaded vets...");
    }
}
