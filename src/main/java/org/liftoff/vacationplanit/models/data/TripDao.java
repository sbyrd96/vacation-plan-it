package org.liftoff.vacationplanit.models.data;

import org.liftoff.vacationplanit.models.User;

import org.liftoff.vacationplanit.models.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TripDao extends CrudRepository<Trip, Integer> {

    List<Trip> findByOwner(User user);

}
