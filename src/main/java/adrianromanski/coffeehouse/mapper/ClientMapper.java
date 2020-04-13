package adrianromanski.coffeehouse.mapper;


import adrianromanski.coffeehouse.domain.Client;
import adrianromanski.coffeehouse.model.ClientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);
    @Mappings({
            @Mapping(target = "reviewsDTO", source = "reviews"),
            @Mapping(target = "reservationsDTO", source = "reservations")
    })
    ClientDTO clientToClientDTO(Client client);

    @Mappings({
            @Mapping(target = "reviews", source = "reviewsDTO"),
            @Mapping(target = "reservations", source = "reservationsDTO")
    })
    Client clientDTOToClient(ClientDTO clientDTO);

}

