package br.com.devmedia.blog.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import br.com.devmedia.blog.entity.UsuarioLogado;

@ControllerAdvice
public class UsuarioLogadoController {

	@ModelAttribute("logado")
	public UsuarioLogado getUsuarioLogado(Authentication authentication) {
		
		return (authentication == null) ? null : (UsuarioLogado) authentication.getPrincipal();
	}
}
