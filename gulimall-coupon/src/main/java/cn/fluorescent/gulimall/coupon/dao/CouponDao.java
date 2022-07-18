package cn.fluorescent.gulimall.coupon.dao;

import cn.fluorescent.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author GnaixEuy
 * @email sgghcj@live.com
 * @date 2022-07-18 18:05:14
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
