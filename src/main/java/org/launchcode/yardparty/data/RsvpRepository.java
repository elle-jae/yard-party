package org.launchcode.yardparty.data;

import org.launchcode.yardparty.models.Rsvp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RsvpRepository extends CrudRepository<Rsvp, Integer> {
}

