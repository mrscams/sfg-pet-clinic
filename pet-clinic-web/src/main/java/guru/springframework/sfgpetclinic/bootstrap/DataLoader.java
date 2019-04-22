package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

  private  final OwnerService ownerService;
  private  final VetService vetService;

  // by default it s autowird
  public DataLoader(OwnerService ownerService, VetService vetService) {
    this.ownerService = ownerService;
    this.vetService = vetService;
  }

    @Override
    public void run(String... args) throws Exception {
      Owner owner1 = new Owner();
      owner1.setId(1L);
      owner1.setFirstName("michael");
      owner1.setLastName("charpentier");


      ownerService.save(owner1);

      Owner owner2 = new Owner();
      owner2.setId(1L);
      owner2.setFirstName("millou");
      owner2.setLastName("bamboni");

      System.out.println("load Owners...");

      ownerService.save(owner1);

      Vet vet1 = new Vet();
      vet1.setId(1L);
      vet1.setFirstName("wadio");
      vet1.setLastName("specter");

      vetService.save(vet1);

      System.out.println("load vets...");
    }
}
