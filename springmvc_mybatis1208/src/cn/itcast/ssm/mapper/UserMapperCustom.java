package cn.itcast.ssm.mapper;




import cn.itcast.ssm.po.UserCustom;
import cn.itcast.ssm.po.UserQueryVo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserMapperCustom {
    //商品查询列表
	public List<UserCustom> findUserList(UserQueryVo userQueryVo)throws Exception;
}