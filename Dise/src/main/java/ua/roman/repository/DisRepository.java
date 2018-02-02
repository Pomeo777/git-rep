package ua.roman.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ua.roman.model.Disease;

@Repository
public interface DisRepository  extends CrudRepository<Disease, Integer>{

}
