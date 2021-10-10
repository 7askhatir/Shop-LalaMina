package Ecommerce.LalaMina.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Coupon {
   @Id
   private Long idCoupon;
   private String code;
   private double porsontage;
}
