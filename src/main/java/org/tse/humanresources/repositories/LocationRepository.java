package org.tse.humanresources.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tse.humanresources.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {

}