package adrianromanski.coffeehouse.mapper;

import adrianromanski.coffeehouse.domain.Reservation;
import adrianromanski.coffeehouse.model.ReservationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReservationMapper {

    ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

    @Mapping(target = "clientDTO", source = "client")
    ReservationDTO ReservationToReservationDTO(Reservation reservation);

    @Mapping(target = "client", source = "clientDTO")
    Reservation ReservationDTOToReservation(ReservationDTO reservationDTO);
}
