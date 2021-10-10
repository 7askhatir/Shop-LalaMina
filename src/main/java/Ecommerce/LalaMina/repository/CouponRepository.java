package Ecommerce.LalaMina.repository;

import Ecommerce.LalaMina.entity.Coupon;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CouponRepository extends MongoRepository<Coupon,Long> {
Coupon findCouponByIdCoupon(Long aLong);
}
