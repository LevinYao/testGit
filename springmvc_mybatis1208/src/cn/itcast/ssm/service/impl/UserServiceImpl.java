package cn.itcast.ssm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.ssm.mapper.ItemsMapper;
import cn.itcast.ssm.mapper.ItemsMapperCustom;
import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.service.ItemsService;
import cn.itcast.ssm.mapper.UserMapper;
import cn.itcast.ssm.mapper.UserMapperCustom;
import cn.itcast.ssm.po.User;
import cn.itcast.ssm.po.UserCustom;
import cn.itcast.ssm.po.UserQueryVo;
import cn.itcast.ssm.service.UserService;





/**
 * 
 * <p>Title: ItemsServiceImpl</p>
 * <p>Description: 商品管理</p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2015-4-13下午3:49:54
 * @version 1.0
 */
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapperCustom userMapperCustom;
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<UserCustom> findUserList(UserQueryVo userQueryVo)
			throws Exception {
				
		//通过ItemsMapperCustom查询数据库
		return userMapperCustom.findUserList(userQueryVo);

	}

	@Override
	public UserCustom findUserById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		User user = userMapper.selectByPrimaryKey(id);
		//返回UserCustom
		UserCustom userCustom = new UserCustom();
		//将user的属性值拷贝到userCustom
		BeanUtils.copyProperties(user, userCustom);
		
		return userCustom;
	}

	@Override
	public void updateUser(Integer id, UserCustom userCustom) throws Exception {
		// TODO Auto-generated method stub
		//更新商品信息使用updateByPrimaryKeyWithBLOBs根据id更新items表中所有字段，包括 大文本类型字段
		//updateByPrimaryKeyWithBLOBs要求必须转入id
		//itemsCustom.setId(id);
		//itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
		userCustom.setId(id);
		userMapper.updateByPrimaryKey(userCustom);
	}

	@Override
	public void deleteUser(Integer id, UserCustom userCustom) throws Exception {
		// TODO Auto-generated method stub
		userCustom.setId(id);
		userMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void insertUser(UserCustom userCustom) throws Exception {
		// TODO Auto-generated method stub
		userMapper.insert(userCustom);
	}

	

}
