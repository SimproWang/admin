package com.simproWangQ.admin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 安全配置类
 * @author WangQ
 *
 */

@EnableWebSecurity 
@EnableGlobalMethodSecurity(prePostEnabled = true) // 启用方法安全设置
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String KEY = "WangQ";
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Bean  
    public PasswordEncoder passwordEncoder() {  
        return new BCryptPasswordEncoder();   // 使用 BCrypt 加密
    }  
	
	@Bean  
    public AuthenticationProvider authenticationProvider() {  
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder); // 设置密码加密方式
        return authenticationProvider;  
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
			.antMatchers("/register", "/").permitAll() // 都可以访问
	        .anyRequest().authenticated()//所有的请求需要认证即登陆后才能访问
	        .and()
	        .formLogin().loginPage("/login")
	        .defaultSuccessUrl("/index")
	        .failureUrl("/login-error").permitAll() //登录页面可任意访问
	        .and().rememberMe().key(KEY) // 启用 remember me
	        .and()
	        .logout().permitAll();//注销请求可任意访问 
		
		http.csrf().disable();
		
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/css/**", "/js/**", "/fonts/**", "/img/**");
	}
	
	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.inMemoryAuthentication()
			.passwordEncoder(new MyPasswordEncoder())//在此处应用自定义PasswordEncoder
			.withUser("admin").password("123456").roles("ADMIN");
		
		auth.inMemoryAuthentication()
			.passwordEncoder(new MyPasswordEncoder())//在此处应用自定义PasswordEncoder
			.withUser("wq").password("123456").roles("USER");
	}*/
	
	/**
	 * 认证信息管理
	 * @param auth
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		auth.authenticationProvider(authenticationProvider());
	}
	
}
