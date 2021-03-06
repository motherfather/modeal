package com.ff.modeal.controller.app;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ff.modeal.dto.Gmail;
import com.ff.modeal.dto.TemporaryPassword;
import com.ff.modeal.service.app.UserAppService;
import com.ff.modeal.vo.UserVo;

@Controller
@RequestMapping("/userapp")
public class UserAppController {

	@Autowired
	private UserAppService userAppService;

	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Map<String, Object> login(@RequestBody UserVo userVo) {
//		System.out.println(userAppService.login(userVo));
		return userAppService.login(userVo);
	}

	@ResponseBody
	@RequestMapping(value = "/social", method = RequestMethod.POST)
	public Map<String, Object> SocialJoin(@RequestBody UserVo userVo) {
		return userAppService.SocialJoin(userVo);
	}

	@ResponseBody
	@RequestMapping(value = "/findpw", method = RequestMethod.POST)
	public UserVo findPW(@RequestParam(value = "email", required = true, defaultValue = "") String email) {
		UserVo userVo = userAppService.findPW(email);
		if (userVo != null) {
			if (userVo.getManagerIdentified() == 3L || userVo.getManagerIdentified() == 4L) {
				return null;
			}
			String password = TemporaryPassword.temporaryPassword(8); // 임시비밀번호생성
			userAppService.changePassword(email, password);
			Gmail.sendMail(userVo, password);
		}
		return userVo;
	}
}
