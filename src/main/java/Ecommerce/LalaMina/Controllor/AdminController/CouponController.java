package Ecommerce.LalaMina.Controllor.AdminController;

import Ecommerce.LalaMina.dao.CouponDao;
import Ecommerce.LalaMina.entity.Coupon;
import Ecommerce.LalaMina.response.ResponseObjet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("Admin/coupon")
public class CouponController {
    @Autowired
    CouponDao couponDao;


    @GetMapping("/")
    public ResponseEntity<ResponseObjet<List<Coupon>>> getAllCoupon(){
        List<Coupon> coupons=couponDao.getAllCoupon();
        ResponseObjet<List<Coupon>> listResponseObjet=new ResponseObjet<List<Coupon>>(true,"List des Coupons",coupons);
        return new ResponseEntity<ResponseObjet<List<Coupon>>>(listResponseObjet, HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<ResponseObjet<Coupon>> addCoupon(@RequestBody Coupon coupon){
        Coupon coupon1=couponDao.createCoupon(coupon);
        ResponseObjet<Coupon> responseObjet=new ResponseObjet<Coupon>(true,"Coupon ajouté avec succès",coupon1);
        return new ResponseEntity<ResponseObjet<Coupon>>(responseObjet,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delet/{id}")
    public ResponseEntity<ResponseObjet<Void>> deletCouponById(@Valid @PathVariable Long id){
        couponDao.deletCoupon(id);
        ResponseObjet<Void> voidResponseObjet=new ResponseObjet<Void>(true,"le Coupon et supprimer",null);
        return new ResponseEntity<ResponseObjet<Void>>(voidResponseObjet,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseObjet<Coupon>> updateCoupon(@Valid @PathVariable Long id,@RequestBody Coupon coupon){
        Coupon coupon1=couponDao.updateCopan(coupon,id);
        ResponseObjet<Coupon> responseObjet=new ResponseObjet<Coupon>(true,"Coupon et modifié",coupon);
        return new ResponseEntity<ResponseObjet<Coupon>>(responseObjet,HttpStatus.ACCEPTED);
    }
}
