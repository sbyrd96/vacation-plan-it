package org.liftoff.vacationplanit.models.data;

import org.liftoff.vacationplanit.models.Plan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PlanDao extends CrudRepository<Plan, Integer> {
}
