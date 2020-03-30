package br.com.compasso.city.repositories;

import br.com.compasso.city.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

     List<City> findByName(String name);
     List<City> findByState(String state);

}
