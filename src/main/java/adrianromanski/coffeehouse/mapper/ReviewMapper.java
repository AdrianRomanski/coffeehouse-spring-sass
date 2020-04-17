package adrianromanski.coffeehouse.mapper;

import adrianromanski.coffeehouse.domain.opinion.Review;
import adrianromanski.coffeehouse.model.opinion.ReviewDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReviewMapper {

    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

    @Mapping(target = "clientDTO", source = "client")
    ReviewDTO reviewToReviewDTO(Review review);

    @Mapping(target = "client", source = "clientDTO")
    Review reviewDTOToReview(ReviewDTO reviewDTO);
}
