package Model;

public class Coupon extends Payment {
    private String couponCode;

    public Coupon(String couponCode) {
        this.couponCode = couponCode;
    }

    public String getCouponCode() {
        return couponCode;
    }

    @Override
    public boolean isValid() {
        return true;
    }
}
