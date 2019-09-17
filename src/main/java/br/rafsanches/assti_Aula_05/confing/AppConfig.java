package br.rafsanches.assti_Aula_05.confing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.rafsanches.assti_Aula_05.interceptor.DateInterceptor;
import br.rafsanches.assti_Aula_05.interceptor.LoginInterceptor;
import br.rafsanches.assti_Aula_05.util.Calculadora;

@Configuration
public class AppConfig implements WebMvcConfigurer {
	@Bean
	public Calculadora getCalculadora() {
		return new Calculadora();
	}
	@Override
	public void addInterceptors (InterceptorRegistry registry) {
		registry.addInterceptor(
				new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/login", "/", "/fazerLogin");
		registry.addInterceptor(
				new DateInterceptor()).addPathPatterns("/**");
	}
}
