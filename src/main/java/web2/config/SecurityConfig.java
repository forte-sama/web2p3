package web2.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configurable
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //usando base de datos para autenticar usuarios
        auth.jdbcAuthentication().dataSource(dataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //reglas para permitir unicamente los usuarios
        http.authorizeRequests()
            .anyRequest().permitAll()
        .and()
            .formLogin().loginPage("/login").permitAll()
        .and()
            .logout().invalidateHttpSession(true).logoutSuccessUrl("/login?logout").permitAll()
        .and()
            .exceptionHandling().accessDeniedPage("/access_denied");

        //deshabilitar proteccion csrf para acceder a consola de H2
        http.csrf().disable();
        //deshabilitar proteccion x-frame-options para acceder a consola de H2
        http.headers().frameOptions().disable();
    }
}