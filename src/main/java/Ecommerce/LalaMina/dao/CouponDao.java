package Ecommerce.LalaMina.dao;

import Ecommerce.LalaMina.entity.Coupon;

import java.util.List;

public interface CouponDao {
    List<Coupon> getAllCoupon();
    Coupon findCouponById(Long aLong);
    Coupon updateCopan(Coupon coupon,Long aLong);
    void deletCoupon(Long aLong);
    Coupon createCoupon(Coupon coupon);
}
