package com.makers.makersbnb.repository;

import com.makers.makersbnb.model.Space;
import org.springframework.data.repository.CrudRepository;

public interface SpaceRepository extends CrudRepository<Space, Long>  {
}


//extends CrudRepository<Space, Long> —
// this is what makes my empty interface suddenly powerful.
// It says this repository works with Space objects,
// and their id field is of type Long.
// Once this is in place, Springboot automatically gives
//me methods like .save(), .findAll(), .findById(), .delete()