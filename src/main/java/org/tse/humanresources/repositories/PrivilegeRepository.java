package org.tse.humanresources.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tse.humanresources.model.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

    Privilege findByName(String name);
}