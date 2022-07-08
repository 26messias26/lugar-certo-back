package br.com.lugarcerto.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lugarcerto.model.Login;


@RestController
@RequestMapping("/login")
public class LoginController {
	
		@PostMapping
		public String logar(@RequestBody Login login) {
			return "Token retornado! dados recebidos: "+login.getEmail()+" - "+ login.getSenha();
		}
}
