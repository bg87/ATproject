package api.services;

import api.domain.Contribution;

public interface ContributionService {

    Contribution getContributionById(Integer id);

    Contribution saveContribution(Contribution contribution);

    void deleteContribution(Integer id);

}
