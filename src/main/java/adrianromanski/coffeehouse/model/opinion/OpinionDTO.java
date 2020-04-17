package adrianromanski.coffeehouse.model.opinion;

import adrianromanski.coffeehouse.model.BaseEntityDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public class OpinionDTO extends BaseEntityDTO {

    private String content;
    private LocalDate date;
    private String name;

}
