package api.services.impl;

import api.domain.Contribution;
import api.repositories.ContributionRepository;
import api.services.ContributionService;
import api.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContributionServiceImpl implements ContributionService {

    @Autowired
    private ContributionRepository contributionRepository;

    @Override
    public Contribution getContributionById(Integer id) {
        return contributionRepository.findOne(id);
    }

    @Override
    public Contribution saveContribution(Contribution contribution) {
        return contributionRepository.save(contribution);
    }

    @Override
    public void deleteContribution(Integer id) {
        contributionRepository.delete(id);
    }

}
