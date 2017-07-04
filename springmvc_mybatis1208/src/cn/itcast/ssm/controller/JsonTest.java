package cn.itcast.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.ssm.po.ItemsCustom;

@Controller
public class JsonTest {
	
	//传入参数  json数据类型
	//需要返回json类型   java对象转换成json串，@reson 
	@RequestMapping("/requestJson")
	public @ResponseBody ItemsCustom   requestJson(@RequestBody ItemsCustom itemsCustom) {
		return itemsCustom ;
	}
	
	//璇锋眰key/value锛岃緭鍑簀son
		@RequestMapping("/responseJson")
		public @ResponseBody ItemsCustom responseJson(ItemsCustom itemsCustom){
			
			//@ResponseBody灏唅temsCustom杞垚json杈撳嚭
			return itemsCustom;
		}

	
}
