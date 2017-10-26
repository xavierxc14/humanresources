package org.tse.humanresources.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.tse.humanresources.model.Country;

public interface CountryRepository extends PagingAndSortingRepository<Country, String> {

}