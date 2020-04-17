package adrianromanski.coffeehouse.mapper;

import adrianromanski.coffeehouse.domain.person.Client;
import adrianromanski.coffeehouse.domain.opinion.Review;
import adrianromanski.coffeehouse.model.person.ClientDTO;
import adrianromanski.coffeehouse.model.opinion.ReviewDTO;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReviewMapperTest {


    public static final LocalDate DATE_OF_REVIEW = LocalDate.of(2020, 10, 15);
    public static final String EMAIL = "Client@client.com";
    public static final String TELEPHONE_NUMBER = "222444666";
    public static final String FIRST_NAME = "Walter";
    public static final String LAST_NAME = "White";
    public static final Long ID = 1L;
    public static final String CONTENT = "Perfect place for perfect people";
    public static final int RATING = 4;
    public static final String NAME = "Champions League Final";

    ReviewMapper reviewMapper = ReviewMapper.INSTANCE;


    @Test
    void reviewToReviewDTO() {
        Review review = new Review();
        review.setId(ID);
        review.setRating(RATING);
        review.setContent(CONTENT);
        review.setDate(DATE_OF_REVIEW);
        review.setName(NAME);


        Client client = new Client();
        client.setFirstName(FIRST_NAME);
        client.setLastName(LAST_NAME);
        client.setTelephoneNumber(TELEPHONE_NUMBER);
        client.setEmail(EMAIL);
        client.setId(ID);
        client.getReviews().add(review);

        review.setClient(client);

        ReviewDTO reviewDTO = reviewMapper.reviewToReviewDTO(review);

        // Checking review
        assertEquals(reviewDTO.getRating(), RATING);
        assertEquals(reviewDTO.getDate(), DATE_OF_REVIEW);
        assertEquals(reviewDTO.getContent(), CONTENT);
        assertEquals(reviewDTO.getName(), NAME);

        // Checking client
        assertEquals(reviewDTO.getClientDTO().getFirstName(), FIRST_NAME);
        assertEquals(reviewDTO.getClientDTO().getLastName(), LAST_NAME);
        assertEquals(reviewDTO.getClientDTO().getEmail(), EMAIL);
        assertEquals(reviewDTO.getClientDTO().getTelephoneNumber(), TELEPHONE_NUMBER);

    }

    @Test
    void reviewDTOToReview() {
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setId(ID);
        reviewDTO.setRating(RATING);
        reviewDTO.setContent(CONTENT);
        reviewDTO.setDate(DATE_OF_REVIEW);
        reviewDTO.setName(NAME);


        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setFirstName(FIRST_NAME);
        clientDTO.setLastName(LAST_NAME);
        clientDTO.setTelephoneNumber(TELEPHONE_NUMBER);
        clientDTO.setEmail(EMAIL);
        clientDTO.setId(ID);
        clientDTO.getReviewsDTO().add(reviewDTO);

        reviewDTO.setClientDTO(clientDTO);

        Review review = reviewMapper.reviewDTOToReview(reviewDTO);

        // Checking review
        assertEquals(review.getRating(), RATING);
        assertEquals(review.getDate(), DATE_OF_REVIEW);
        assertEquals(review.getContent(), CONTENT);
        assertEquals(review.getName(), NAME);

        // Checking client
        assertEquals(review.getClient().getFirstName(), FIRST_NAME);
        assertEquals(review.getClient().getLastName(), LAST_NAME);
        assertEquals(review.getClient().getEmail(), EMAIL);
        assertEquals(review.getClient().getTelephoneNumber(), TELEPHONE_NUMBER);
    }
}