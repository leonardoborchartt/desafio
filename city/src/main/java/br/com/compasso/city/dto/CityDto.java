package br.com.compasso.city.dto;

import br.com.compasso.city.entities.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
public class CityDto {

    @NotBlank
    private String name;

    @NotBlank
    private String state;

    public City create() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, City.class);
    }

}
