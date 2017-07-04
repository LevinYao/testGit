package cn.itcast.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.UserCustom;
import cn.itcast.ssm.service.ItemsService;
import cn.itcast.ssm.service.UserService;

/**
 * 
 * <p>
 * Title: UserController
 * </p>
 * <p>
 * Description:的controller
 * </p>
 * <p>
 * Company: www.itcast.com
 * </p>
 * 
 * @author 传智.燕青
 * @date 2015-4-13下午4:03:35
 * @version 1.0
 */
@Controller
//为了对url进行分类管理 ，可以在这里定义根路径，最终访问url是根路径+子路径
//比如：用户列表：/user/queryItems.action
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	// 商品查询
	@RequestMapping("/queryUser")
	public ModelAndView queryUser(HttpServletRequest request) throws Exception {
		//测试forward后request是否可以共享
		
		System.out.println(request.getParameter("id"));

		// 调用service查找 数据库，查询商品列表
		List<UserCustom>  userList = userService.findUserList(null); 
		
		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 相当 于request的setAttribut，在jsp页面中通过itemsList取数据
		modelAndView.addObject("userList", userList);

		// 指定视图
		// 下边的路径，如果在视图解析器中配置jsp路径的前缀和jsp路径的后缀，修改为
		// modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
		// 上边的路径配置可以不在程序中指定jsp路径的前缀和jsp路径的后缀
		modelAndView.setViewName("items/MyUser");

		return modelAndView;

	}

	@RequestMapping(value="/editUser",method={RequestMethod.POST,RequestMethod.GET})
	//@RequestParam里边指定request传入参数名称和形参进行绑定。
	//通过required属性指定参数是否必须要传入
	//通过defaultValue可以设置默认值，如果id参数没有传入，将默认值和形参绑定。
	public String editUser(Model model,@RequestParam(value="id",required=true) Integer user_id)throws Exception {
		
		//调用service根据商品id查询商品信息
		//ItemsCustom itemsCustom = itemsService.findItemsById(user_id);
		UserCustom userCustom = userService.findUserById(user_id);
		
		
		//通过形参中的model将model数据传到页面
		//相当于modelAndView.addObject方法
		model.addAttribute("userCustom", userCustom);
		
		return "items/MyTest";
	}
	
	//商品信息修改提交
	@RequestMapping("/editUserSubmit")
	public String editUserSubmit(HttpServletRequest request,Integer id,UserCustom userCustom)throws Exception {
		
		//调用service更新商品信息，页面需要将商品信息传到此方法
		//itemsService.updateItems(id, itemsCustom);
		userService.updateUser(id, userCustom);
		//重定向到商品查询列表
//		return "redirect:queryItems.action";
		//页面转发
		//return "forward:queryItems.action";		
		return "success";
	}
	
	//删除用户
	@RequestMapping("/deleteUser")
	public String deleteString(HttpServletRequest request,Integer id,UserCustom userCustom)throws Exception {
		userService.deleteUser(id, userCustom);
		return "success";
		
	}
	
	//新增用户
	@RequestMapping("/addUser")
	public String addString(HttpServletRequest request,UserCustom userCustom)throws Exception{
		//userService.insertUser(userCustom);
		return "items/myInsert";	
	}
	
	@RequestMapping("/addUserSubmit")
	public String addUserSubmit(HttpServletRequest request,UserCustom userCustom)throws Exception{
		userService.insertUser(userCustom);
		return "success";	
	}
	
}
