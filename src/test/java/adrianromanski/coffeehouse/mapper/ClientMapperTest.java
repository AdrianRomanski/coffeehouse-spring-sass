package adrianromanski.coffeehouse.mapper;

import adrianromanski.coffeehouse.domain.person.Client;
import adrianromanski.coffeehouse.domain.Reservation;
import adrianromanski.coffeehouse.domain.Review;
import adrianromanski.coffeehouse.model.person.ClientDTO;
import adrianromanski.coffeehouse.model.ReservationDTO;
import adrianromanski.coffeehouse.model.ReviewDTO;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ClientMapperTest {

    public static final LocalDate DATE_OF_CREATION = LocalDate.now();
    public static final LocalDate DATE_OF_RESERVATION = LocalDate.of(2020, 10, 15);
    public static final long NUMBER_OF_PEOPLE = 4L;
    public static final String PLACE = "1 floor";
    public static final String EMAIL = "Client@client.com";
    public static final String TELEPHONE_NUMBER = "222444666";
    public static final String FIRST_NAME = "Walter";
    public static final String LAST_NAME = "White";
    public static final Long ID = 1L;
    public static final String CONTENT = "Perfect place for perfect people";
    public static final int RATING = 4;

    ClientMapper clientMapper = ClientMapper.INSTANCE;

    @Test
    void clientToClientDTO() {
        Client client = new Client();
        client.setEmail(EMAIL);
        client.setTelephoneNumber(TELEPHONE_NUMBER);
        client.setFirstName(FIRST_NAME);
        client.setLastName(LAST_NAME);
        client.setId(ID);

        Reservation reservation = new Reservation();
        reservation.setDateOfCreation(DATE_OF_CREATION);
        reservation.setDateOfReservation(DATE_OF_RESERVATION);
        reservation.setNumberOfPeople(NUMBER_OF_PEOPLE);
        reservation.setPlace(PLACE);
        reservation.setId(ID);

        Review review = new Review();
        review.setClient(client);
        review.setContent(CONTENT);
        review.setDate(DATE_OF_CREATION);
        review.setRating(RATING);
        review.setId(ID);

        client.getReviews().add(review);
        client.getReservations().add(reservation);
        reservation.setClient(client);

        ClientDTO clientDTO = clientMapper.clientToClientDTO(client);

        // Checking client
        assertEquals(clientDTO.getId(), ID);
        assertEquals(clientDTO.getFirstName(), FIRST_NAME);
        assertEquals(clientDTO.getLastName(), LAST_NAME);
        assertEquals(clientDTO.getTelephoneNumber(), TELEPHONE_NUMBER);
        assertEquals(clientDTO.getEmail(), EMAIL);

        // Checking reservation
        assertEquals(clientDTO.getReservationsDTO().get(0).getId(), ID);
        assertEquals(clientDTO.getReservationsDTO().get(0).getPlace(), PLACE);
        assertEquals(clientDTO.getReservationsDTO().get(0).getNumberOfPeople(), NUMBER_OF_PEOPLE);
        assertEquals(clientDTO.getReservationsDTO().get(0).getDateOfReservation(), DATE_OF_RESERVATION);
        assertEquals(clientDTO.getReservationsDTO().get(0).getDateOfCreation(), DATE_OF_CREATION);

        // Checking review
        assertEquals(clientDTO.getReviewsDTO().get(0).getContent(), CONTENT);
        assertEquals(clientDTO.getReviewsDTO().get(0).getDate(), DATE_OF_CREATION);
        assertEquals(clientDTO.getReviewsDTO().get(0).getRating(), RATING);


    }

    @Test
    void clientDTOToClient() {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setEmail(EMAIL);
        clientDTO.setTelephoneNumber(TELEPHONE_NUMBER);
        clientDTO.setFirstName(FIRST_NAME);
        clientDTO.setLastName(LAST_NAME);
        clientDTO.setId(ID);

        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setDateOfCreation(DATE_OF_CREATION);
        reservationDTO.setDateOfReservation(DATE_OF_RESERVATION);
        reservationDTO.setNumberOfPeople(NUMBER_OF_PEOPLE);
        reservationDTO.setPlace(PLACE);
        reservationDTO.setId(ID);

        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setClientDTO(clientDTO);
        reviewDTO.setContent(CONTENT);
        reviewDTO.setDate(DATE_OF_CREATION);
        reviewDTO.setRating(RATING);
        reviewDTO.setId(ID);

        clientDTO.getReviewsDTO().add(reviewDTO);
        clientDTO.getReservationsDTO().add(reservationDTO);
        reservationDTO.setClientDTO(clientDTO);

        Client client = clientMapper.clientDTOToClient(clientDTO);

        // Checking client
        assertEquals(client.getId(), ID);
        assertEquals(client.getFirstName(), FIRST_NAME);
        assertEquals(client.getLastName(), LAST_NAME);
        assertEquals(client.getTelephoneNumber(), TELEPHONE_NUMBER);
        assertEquals(client.getEmail(), EMAIL);

        // Checking reservation
        assertEquals(client.getReservations().get(0).getId(), ID);
        assertEquals(client.getReservations().get(0).getPlace(), PLACE);
        assertEquals(client.getReservations().get(0).getNumberOfPeople(), NUMBER_OF_PEOPLE);
        assertEquals(client.getReservations().get(0).getDateOfReservation(), DATE_OF_RESERVATION);
        assertEquals(client.getReservations().get(0).getDateOfCreation(), DATE_OF_CREATION);

        // Checking review
        assertEquals(client.getReviews().get(0).getContent(), CONTENT);
        assertEquals(client.getReviews().get(0).getDate(), DATE_OF_CREATION);
        assertEquals(client.getReviews().get(0).getRating(), RATING);

    }
}