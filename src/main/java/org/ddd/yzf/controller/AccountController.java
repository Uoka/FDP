package org.ddd.yzf.controller;

import org.ddd.yzf.dto.RequestDTO;
import org.ddd.yzf.dto.RespondDTO;
import org.ddd.yzf.service.login.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 袁泽锋
 * @since 2019年10月5日 19:59
 * Description: TODO
 */
@RestController
@RequestMapping("/account")
@CrossOrigin(allowCredentials = "true")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@PostMapping("/userLogin")
	public RespondDTO<Object> userLogin(@RequestBody RequestDTO<Object> requestDTO) {
		return accountService.userLogin(requestDTO);
	}


	@GetMapping("/userLogout")
	public void userLogout() {
		accountService.userLogout();
	}




}
