package com.gr.user.controller;

import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.gr.common.domain.UserDomain;
import com.gr.common.utils.Base64;
import com.gr.common.utils.MD5;
import com.gr.user.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	private final static Logger log = LoggerFactory.getLogger(UserController.class);
	@Resource
	private UserService userService;
	@RequestMapping(value = "/test")//, method = RequestMethod.POST
	public ModelAndView test() {
		List<UserDomain> user = userService.queryAll();
		ModelAndView mv = new ModelAndView();
        mv.addObject("user",user);
        mv.setViewName("test");
		return mv;
	}
	
	@RequestMapping(value = "/test1")
	public ModelAndView test1() {
		Map<String,String> map = new HashMap<String,String>();
//		map = userService.queryOne();
		ModelAndView mv = new ModelAndView();
        mv.addObject("user",map);
        mv.setViewName("test");
		return mv;
	}
	
	@RequestMapping(value = "/insert")
	@ResponseBody
	public String insert() {
		userService.insertAll();
		return "ok";
	}
	
	@RequestMapping(value = "/test2")
	@ResponseBody
	public String test2(String name, String idNumber, String mobile, String url, String auto) throws Exception {
		if(StringUtils.isNotEmpty(auto)){
			url=auto;
		}
		log.info("name={},idNumber={},url={}", name, idNumber, url);
		// partneridΪ���Ŵ����������ȡ��ս�Ժ���ID
		String partnerid = "JZJF";
		String thridUuid = "20160128191836916593#3";
		// �Ŵ���������ǩ�������ܳ�
		String key = "AXP-J56jXq8htYQ=bJqIG7q8pMQ3dk";
		Date date = new Date();
		long timestamp = date.getTime() / 1000;
		Map<String, String> map = new HashMap<String, String>();
		// ���û������û�qq���û��ֻ��������base64����
		// ��ѡ�ֶ�
		map.put("username", Base64.encode(name));
		map.put("usermobile", Base64.encode(mobile));
		map.put("idnumber", Base64.encode(idNumber));
		map.put("province", Base64.encode("110000"));
		map.put("city", Base64.encode("110101"));
		map.put("loc", Base64.encode("����ҵ���ַ"));
		map.put("firstrelation", Base64.encode("PARENT_CHILD,����,18956562536"));
		map.put("secondrelation", Base64.encode("SPOUSE,����,18956562537"));
		String signature = "";
		try {
			signature = MD5.encode(URLEncoder.encode(
					"partnerid=" + partnerid + "usermobile=" + mobile + "timestamp=" + timestamp + "key=" + key,
					"UTF-8"), 32).toLowerCase();
		} catch (Exception e) {
			e.printStackTrace();
		}
		url = url + "?partnerid=" + partnerid + "&thridUuid=" + URLEncoder.encode(thridUuid, "UTF-8") + "&timestamp="
				+ timestamp + "&signature=" + signature + "&jsondata="
				+ URLEncoder.encode(JSON.toJSONString(map), "UTF-8");
		return url;
	}
}
