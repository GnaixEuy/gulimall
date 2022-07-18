package cn.fluorescent.gulimall.member.dao;

import cn.fluorescent.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author GnaixEuy
 * @email sgghcj@live.com
 * @date 2022-07-18 18:22:08
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
