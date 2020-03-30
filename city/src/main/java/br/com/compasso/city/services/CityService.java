package br.com.compasso.city.services;

import br.com.compasso.city.dto.CityDto;
import br.com.compasso.city.dto.CityResDto;
import br.com.compasso.city.entities.City;
import br.com.compasso.city.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    public CityRepository cityRepository;


    public CityResDto saveCity(CityDto cityDto) {
        City city = cityDto.create();
        City savedCity = cityRepository.save(city);
        return savedCity.toResDto();
    }


    public List<City> findByName(String name) {
        return cityRepository.findByName(name);
    }


    public List<City> findByState(String state) {

        return cityRepository.findByState(state);
    }
}
