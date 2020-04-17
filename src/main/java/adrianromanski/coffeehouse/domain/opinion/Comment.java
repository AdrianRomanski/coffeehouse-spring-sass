package adrianromanski.coffeehouse.domain.opinion;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

/**
 *  We will store this one in MongoDB later
 */
@Entity
@NoArgsConstructor
@Data
public class Comment extends Opinion {

    // To do Missing Class related to CoffeeHouse worker or owner that posted a comment to review

    private boolean refund;
    private Double refundAmount;
    private String voucher;

}
