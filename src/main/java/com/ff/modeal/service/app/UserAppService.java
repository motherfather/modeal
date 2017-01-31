package com.ff.modeal.service.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ff.modeal.repository.app.UserAppDao;
import com.ff.modeal.vo.UserVo;

@Service
public class UserAppService {

	@Autowired
	private UserAppDao userAppDao;

	public UserVo login(UserVo userVo) {
		return userAppDao.login(userVo);
	}
}