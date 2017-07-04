package cn.itcast.ssm.po;

/**
 * 
 * <p>Title: UserQueryVo</p>
 * <p>Description:用户包装对象 </p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	
 * @version 1.0
 */
public class UserQueryVo {
	
	//商品信息
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}

	//为了系统 可扩展性，对原始生成的po进行扩展
	private UserCustom userCustom;

	
	

}
