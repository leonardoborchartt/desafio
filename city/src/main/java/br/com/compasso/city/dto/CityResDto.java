package br.com.compasso.city.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityResDto {
    private Long id;
    private String name;
    private String state;
}
