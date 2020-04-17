package adrianromanski.coffeehouse.mapper;

import adrianromanski.coffeehouse.domain.opinion.Comment;
import adrianromanski.coffeehouse.model.opinion.CommentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    CommentDTO commentToCommentDTO(Comment comment);

    Comment commentDTOToComment(CommentDTO commentDTO);

}
