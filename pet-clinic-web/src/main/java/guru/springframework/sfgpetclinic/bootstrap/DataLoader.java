package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

  private  final OwnerService ownerService;
  private  final VetService vetService;
  private  final PetTypeService petTypeService;
    private  final SpecialtyService specialtyService;

  // by default it s autowird
  public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService ,SpecialtyService specialtyService) {
    this.ownerService = ownerService;
    this.vetService = vetService;
    this.petTypeService = petTypeService;
    this.specialtyService = specialtyService;
  }

    @Override
    public void run(String... args) throws Exception {
      int count = petTypeService.findAll().size();
      if ( count == 0 ) {
          loadData();
      }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("cat");
        PetType savedcatType = petTypeService.save(dog);

        Speciality radiology = new Speciality();
        radiology.setDescription("radiology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality surgery= new Speciality();
        surgery.setDescription("surgery");
        Speciality savedSurgery =  specialtyService.save(surgery);

        Speciality dentistry= new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentisitry  = specialtyService.save(dentistry);


        Owner owner1 = new Owner();
        owner1.setFirstName("michael");
        owner1.setLastName("charpentier");
        owner1.setAddress("hot Address 445 ");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("millou");
        owner2.setLastName("bamboni");
        owner2.setAddress("super adres 45 ");
        System.out.println("load Owners...");

        ownerService.save(owner1);

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("rock");

        owner1.getPets().add(mikesPet);

        Pet millouPet = new Pet();
        millouPet.setPetType(savedDogType);
        millouPet.setOwner(owner1);
        millouPet.setBirthDate(LocalDate.now());
        millouPet.setName("puppy");

        owner2.getPets().add(millouPet);

        Vet vet1 = new Vet();
        vet1.setFirstName("wadio");
        vet1.setLastName("specter");
        vet1.getSpecialities().add(dentistry);
        vetService.save(vet1);
        System.out.println("load vets...");
    }
}
