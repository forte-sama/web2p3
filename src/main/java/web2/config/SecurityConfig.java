package web2.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by forte on 04/10/16.
 */
@Configurable
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //carga de los usuarios en memoria.
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("admin")
                .roles("ADMIN","USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //reglas para permitir unicamente los usuarios
        http.authorizeRequests()
                .antMatchers("/admin/**")
                .hasAnyRole("ADMIN", "USER")
                .and()
                .formLogin()
                .loginPage("/admin_login") //ruta que se esta utilizando.
                .failureUrl("/admin_login?error")
                .permitAll()
                .and()
                .logout()
                .permitAll();

        //deshabilitar proteccion csrf para acceder a consola de H2
        http.csrf().disable();
        //deshabilitar proteccion x-frame-options para acceder a consola de H2
        http.headers().frameOptions().disable();
    }
}