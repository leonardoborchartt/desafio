package br.com.compasso.city.controllers;
import br.com.compasso.city.dto.CityDto;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import br.com.compasso.city.dto.CityResDto;
import br.com.compasso.city.entities.City;
import br.com.compasso.city.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping
    public ResponseEntity<CityResDto> postNewCity(@Valid @RequestBody CityDto cityDto) {
        CityResDto cityResDto = cityService.saveCity(cityDto);
        URI location = getUri(cityResDto.getId());
        return ResponseEntity.created(location).body(cityResDto);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<City>> getCityByName(@PathVariable(value = "name") String name) {
        List<City> cities = new ArrayList<>(cityService.findByName(name));
        return cities.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(cities);

    }

    @GetMapping("/state/{state}")
    public ResponseEntity<List<City>> getByState(@PathVariable(value = "state") String state) {
        List<City> cities = new ArrayList<>(cityService.findByState(state));

        return cities.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(cities);
    }

}
