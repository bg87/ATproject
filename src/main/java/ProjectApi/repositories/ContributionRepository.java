package ProjectApi.repositories;


import ProjectApi.domain.Contribution;
import org.springframework.data.repository.CrudRepository;

public interface ContributionRepository extends CrudRepository<Contribution, Integer> {

}
