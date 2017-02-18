package br.com.devmedia.blog.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import br.com.devmedia.blog.entity.UsuarioLogado;

public class SpringSecurityAuditor implements AuditorAware<String> {

	public String getCurrentAuditor() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null || authentication.getPrincipal().equals("anonymousUser")) {
			
			return authentication.getPrincipal().toString();
		}
		
		return ((UsuarioLogado) authentication.getPrincipal()).getUsername();
	}

}
