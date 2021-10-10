package Ecommerce.LalaMina.dao;


import Ecommerce.LalaMina.entity.Coupon;
import Ecommerce.LalaMina.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CouponDaoImp implements CouponDao{
    @Autowired
    CouponRepository couponRepository;


    @Override
    public List<Coupon> getAllCoupon() {
        return couponRepository.findAll();
    }

    @Override
    public Coupon findCouponById(Long aLong) {
        return couponRepository.findCouponByIdCoupon(aLong);
    }

    @Override
    public Coupon updateCopan(Coupon coupon, Long aLong) {
        Coupon coupon1=findCouponById(aLong);
        if(coupon1!=null){
            coupon1.setCode(coupon.getCode());
            coupon1.setPorsontage(coupon.getPorsontage());
        }
        return couponRepository.save(coupon1);
    }

    @Override
    public void deletCoupon(Long aLong) {
        Coupon coupon1=findCouponById(aLong);
        if(coupon1!=null)couponRepository.delete(coupon1);
    }

    @Override
    public Coupon createCoupon(Coupon coupon) {
        return couponRepository.insert(coupon);
    }
}
