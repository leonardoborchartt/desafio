package br.com.compasso.city.entities;
import br.com.compasso.city.dto.CityResDto;
import org.modelmapper.ModelMapper;
import org.springframework.data.annotation.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cities")
public class City  {

    @Id @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String state;
    public City create() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, City.class);
    }

    public CityResDto toResDto() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, CityResDto.class);
    }

}
