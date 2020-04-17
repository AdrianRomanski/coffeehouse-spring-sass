package adrianromanski.coffeehouse.model.opinion;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CommentDTO extends OpinionDTO {

    private boolean refund;
    private Double refundAmount;
    private String voucher;
}
