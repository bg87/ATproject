package ProjectApi.rest;

import ProjectApi.domain.Contribution;
import ProjectApi.services.ContributionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contribution")
public class ContributionRest {

    private Logger log = Logger.getLogger(ContributionRest.class);

    @Autowired
    private ContributionService contributionService;

    // get one
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Contribution getContribution(@PathVariable int id) {
        return contributionService.getContributionById(id);
    }

    // save
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Contribution save(@RequestBody Contribution contribution) {
        return contributionService.saveContribution(contribution);
    }

}
