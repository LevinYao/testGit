package cn.itcast.ssm.service;

import java.util.List;

//import cn.itcast.ssm.po.ItemsCustom;

import cn.itcast.ssm.po.UserCustom;
import cn.itcast.ssm.po.UserQueryVo;

/**
 * 
 * <p>Title: UserService</p>
 * <p>Description:用户管理service </p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	20170622
 * @version 1.0
 */
public interface UserService {
	
	//商品查询列表
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
	
//	//根据id查询商品信息
//	/**
//	 * 
//	 * <p>Title: findItemsById</p>
//	 * <p>Description: </p>
//	 * @param id 查询商品的id
//	 * @return
//	 * @throws Exception
//	 */
//	public ItemsCustom findItemsById(Integer id) throws Exception;
	
	//根据id查找到要修改的用户
	public UserCustom findUserById(Integer id) throws Exception;
	
//	
//	//修改商品信息
//	/**
//	 * 
//	 * <p>Title: updateItems</p>
//	 * <p>Description: </p>
//	 * @param id 修改商品的id
//	 * @param itemsCustom 修改的商品信息
//	 * @throws Exception
//	 */
	public void updateUser(Integer id,UserCustom userCustom) throws Exception;
	
//删除用户信息
	public void deleteUser(Integer id,UserCustom userCustom) throws Exception;
	
	//添加用户
	public void insertUser(UserCustom userCustom)throws Exception; 

}
