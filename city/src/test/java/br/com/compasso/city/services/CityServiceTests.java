package br.com.compasso.city.services;

import br.com.compasso.city.dto.CityDto;
import br.com.compasso.city.dto.CityResDto;
import br.com.compasso.city.entities.City;
import br.com.compasso.city.repositories.CityRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CityServiceTests {

    @Mock
    private CityRepository cityRepository;

    @InjectMocks
    private CityService cityService;

    @Test
    public void testeSalvaCidadeERetorno(){
        CityDto request = new CityDto("Florianopolis", "Santa Catarina");
        City cityWithId = request.create();
        cityWithId.setId(1L);

        when(cityRepository.save(request.create())).thenReturn(cityWithId);

        Assertions.assertThat(cityService.saveCity(request)).isExactlyInstanceOf(CityResDto.class);
        Assertions.assertThat(cityService.saveCity(request).getId()).isEqualTo(1L);
        Assertions.assertThat(cityService.saveCity(request).getName()).isEqualTo("Florianopolis");
        Assertions.assertThat(cityService.saveCity(request).getState()).isEqualTo("Santa Catarina");
    }

    @Test
    public void testaRetornoNomeCidade() {
        String cityName = "Florianopolis";
        City city = new City(1L, "Florianopolis", "Santa Catarina");
        List<City> list = new ArrayList<>();
        list.add(city.create());

        when(cityRepository.findByName(cityName)).
                thenReturn(list);

        Assertions.assertThat(cityService.findByName(cityName)).hasSize(1);
        Assertions.assertThat(cityService.findByName(cityName).get(0).getName()).isEqualTo(cityName);
    }
    @Test
    public void testaRetornoNomeEstado() {
        String stateName = "Santa Catarina";
        City city = new City(1L, "Florianopolis", "Santa Catarina");
        List<City> list = new ArrayList<>();
        list.add(city.create());

        when(cityRepository.findByState(stateName)).
                thenReturn(list);
        Assertions.assertThat(cityService.findByState(stateName).get(0).getState()).isEqualTo(stateName);
    }

}
