package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

  private  final OwnerService ownerService;
  private  final VetService vetService;
  private  final PetTypeService petTypeService;

  // by default it s autowird
  public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService ) {
    this.ownerService = ownerService;
    this.vetService = vetService;
    this.petTypeService = petTypeService;
  }

    @Override
    public void run(String... args) throws Exception {



      PetType dog = new PetType();
      dog.setName("dog");
      PetType savedDogType = petTypeService.save(dog);

      PetType cat = new PetType();
      dog.setName("cat");
      PetType savedcatType = petTypeService.save(dog);




      Owner owner1 = new Owner();
      //owner1.setId(1L);
      owner1.setFirstName("michael");
      owner1.setLastName("charpentier");


      ownerService.save(owner1);

      Owner owner2 = new Owner();
      //owner2.setId(1L);
      owner2.setFirstName("millou");
      owner2.setLastName("bamboni");

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
      //vet1.setId(1L);
      vet1.setFirstName("wadio");
      vet1.setLastName("specter");

      vetService.save(vet1);

      System.out.println("load vets...");
    }
}
