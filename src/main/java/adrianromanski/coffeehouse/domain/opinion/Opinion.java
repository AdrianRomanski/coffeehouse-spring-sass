package adrianromanski.coffeehouse.domain.opinion;

import adrianromanski.coffeehouse.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
@Getter
@Setter
public class Opinion extends BaseEntity {

    private String content;
    private LocalDate date;
    private String name;

}
