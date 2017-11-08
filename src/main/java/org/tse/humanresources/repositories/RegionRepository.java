package org.tse.humanresources.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tse.humanresources.model.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {

}