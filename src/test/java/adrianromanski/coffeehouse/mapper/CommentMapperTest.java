package adrianromanski.coffeehouse.mapper;

import adrianromanski.coffeehouse.domain.opinion.Comment;
import adrianromanski.coffeehouse.model.opinion.CommentDTO;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CommentMapperTest {

    public static final boolean REFUND = true;
    public static final double REFUND_AMOUNT = 1.20;
    public static final String VOUCHER = "Free water";
    public static final LocalDate DATE = LocalDate.now();
    public static final long ID = 1L;
    public static final String CONTENT = "We are sorry for a water with fly";
    public static final String NAME = "Fly in water";
    CommentMapper commentMapper = CommentMapper.INSTANCE;

    @Test
    void commentToCommentDTO() {
        Comment comment = new Comment();
        comment.setRefund(REFUND);
        comment.setRefundAmount(REFUND_AMOUNT);
        comment.setVoucher(VOUCHER);
        comment.setDate(DATE);
        comment.setId(ID);
        comment.setContent(CONTENT);
        comment.setName(NAME);

        CommentDTO commentDTO = commentMapper.commentToCommentDTO(comment);

        assertEquals(commentDTO.isRefund(), REFUND);
        assertEquals(commentDTO.getRefundAmount(), REFUND_AMOUNT);
        assertEquals(commentDTO.getVoucher(), VOUCHER);
        assertEquals(commentDTO.getDate(), DATE);
        assertEquals(commentDTO.getId(), ID);
        assertEquals(commentDTO.getContent(), CONTENT);
        assertEquals(commentDTO.getName(), NAME);
    }

    @Test
    void commentDTOToComment() {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setRefund(REFUND);
        commentDTO.setRefundAmount(REFUND_AMOUNT);
        commentDTO.setVoucher(VOUCHER);
        commentDTO.setDate(DATE);
        commentDTO.setId(ID);
        commentDTO.setContent(CONTENT);
        commentDTO.setName(NAME);

        Comment comment = commentMapper.commentDTOToComment(commentDTO);

        assertEquals(comment.isRefund(), REFUND);
        assertEquals(comment.getRefundAmount(), REFUND_AMOUNT);
        assertEquals(comment.getVoucher(), VOUCHER);
        assertEquals(comment.getDate(), DATE);
        assertEquals(comment.getId(), ID);
        assertEquals(comment.getContent(), CONTENT);
        assertEquals(comment.getName(), NAME);
    }
}