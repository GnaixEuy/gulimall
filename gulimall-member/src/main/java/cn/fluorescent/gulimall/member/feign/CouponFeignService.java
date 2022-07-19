package cn.fluorescent.gulimall.member.feign;

import cn.fluorescent.gulimall.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <img src="http://blog.gnaixeuy.cn/wp-content/uploads/2022/06/bug.png"/>
 *
 * <p>项目： gulimall </p>
 *
 * @author GnaixEuy
 * @date 2022/7/19
 * @see <a href="https://github.com/GnaixEuy"> GnaixEuy的GitHub </a>
 */

@FeignClient("gulimall-coupon")
public interface CouponFeignService {
    @RequestMapping("/coupon/coupon/member/list")
    R membercoupons();//得到一个R对象
}
