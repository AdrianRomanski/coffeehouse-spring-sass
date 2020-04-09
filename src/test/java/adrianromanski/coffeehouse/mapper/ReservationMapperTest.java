package adrianromanski.coffeehouse.mapper;

import adrianromanski.coffeehouse.domain.Client;
import adrianromanski.coffeehouse.domain.Reservation;
import adrianromanski.coffeehouse.model.ClientDTO;
import adrianromanski.coffeehouse.model.ReservationDTO;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReservationMapperTest {

    public static final LocalDate DATE_OF_CREATION = LocalDate.now();
    public static final LocalDate DATE_OF_RESERVATION = LocalDate.of(2020, 10, 15);
    public static final long NUMBER_OF_PEOPLE = 4L;
    public static final String PLACE = "1 floor";
    public static final String EMAIL = "Client@client.com";
    public static final String TELEPHONE_NUMBER = "222444666";
    public static final String FIRST_NAME = "Walter";
    public static final String LAST_NAME = "White";
    public static final Long ID = 1L;

    ReservationMapper reservationMapper = ReservationMapper.INSTANCE;

    @Test
    void reservationToReservationDTO() {
        Reservation reservation = new Reservation();
        reservation.setDateOfCreation(DATE_OF_CREATION);
        reservation.setDateOfReservation(DATE_OF_RESERVATION);
        reservation.setNumberOfPeople(NUMBER_OF_PEOPLE);
        reservation.setPlace(PLACE);
        reservation.setId(ID);

        Client client = new Client();
        client.setEmail(EMAIL);
        client.setTelephoneNumber(TELEPHONE_NUMBER);
        client.setFirstName(FIRST_NAME);
        client.setLastName(LAST_NAME);
        client.setId(ID);
        reservation.setClient(client);
        client.getReservations().add(reservation);

        ReservationDTO reservationDTO = reservationMapper.ReservationToReservationDTO(reservation);

        assertEquals(reservationDTO.getDateOfCreation(), DATE_OF_CREATION);
        assertEquals(reservationDTO.getDateOfReservation(), DATE_OF_RESERVATION);
        assertEquals(reservationDTO.getNumberOfPeople(), NUMBER_OF_PEOPLE);
        assertEquals(reservationDTO.getPlace(), PLACE);
        assertEquals(reservationDTO.getId(), ID);

        assertEquals(reservationDTO.getClientDTO().getEmail(), EMAIL);
        assertEquals(reservationDTO.getClientDTO().getTelephoneNumber(), TELEPHONE_NUMBER);
        assertEquals(reservationDTO.getClientDTO().getFirstName(), FIRST_NAME);
        assertEquals(reservationDTO.getClientDTO().getLastName(), LAST_NAME);
        assertEquals(reservationDTO.getClientDTO().getId(), ID);


    }

    @Test
    void reservationDTOToReservation() {
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setDateOfCreation(DATE_OF_CREATION);
        reservationDTO.setDateOfReservation(DATE_OF_RESERVATION);
        reservationDTO.setNumberOfPeople(NUMBER_OF_PEOPLE);
        reservationDTO.setPlace(PLACE);
        reservationDTO.setId(ID);

        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setEmail(EMAIL);
        clientDTO.setTelephoneNumber(TELEPHONE_NUMBER);
        clientDTO.setFirstName(FIRST_NAME);
        clientDTO.setLastName(LAST_NAME);
        clientDTO.setId(ID);
        reservationDTO.setClientDTO(clientDTO);
        clientDTO.getReservationsDTO().add(reservationDTO);

        Reservation reservation = reservationMapper.ReservationDTOToReservation(reservationDTO);

        assertEquals(reservation.getDateOfCreation(), DATE_OF_CREATION);
        assertEquals(reservation.getDateOfReservation(), DATE_OF_RESERVATION);
        assertEquals(reservation.getNumberOfPeople(), NUMBER_OF_PEOPLE);
        assertEquals(reservation.getPlace(), PLACE);
        assertEquals(reservation.getId(), ID);

        assertEquals(reservation.getClient().getEmail(), EMAIL);
        assertEquals(reservation.getClient().getTelephoneNumber(), TELEPHONE_NUMBER);
        assertEquals(reservation.getClient().getFirstName(), FIRST_NAME);
        assertEquals(reservation.getClient().getLastName(), LAST_NAME);
        assertEquals(reservation.getClient().getId(), ID);
    }
}