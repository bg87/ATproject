package api.repositories;


import api.domain.Contribution;
import org.springframework.data.repository.CrudRepository;

public interface ContributionRepository extends CrudRepository<Contribution, Integer> {

}
