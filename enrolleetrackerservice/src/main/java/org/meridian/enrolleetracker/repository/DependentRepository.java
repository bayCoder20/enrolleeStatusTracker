package org.meridian.enrolleetracker.repository;

import org.meridian.enrolleetracker.model.Dependent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DependentRepository extends JpaRepository<Dependent, Long> {

}
