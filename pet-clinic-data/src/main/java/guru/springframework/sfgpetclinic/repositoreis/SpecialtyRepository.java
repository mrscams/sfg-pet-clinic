package guru.springframework.sfgpetclinic.repositoreis;

import guru.springframework.sfgpetclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;


public interface SpecialtyRepository extends CrudRepository<Specialty,Long> {

}
