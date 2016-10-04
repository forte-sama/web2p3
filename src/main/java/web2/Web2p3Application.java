package web2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import web2.models.Usuario;
import web2.repositories.RepoUsuario;

import java.util.Locale;

@SpringBootApplication
public class Web2p3Application {

	private static final Logger log = LoggerFactory.getLogger(Web2p3Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Web2p3Application.class, args);
	}

	//para i18n
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		return slr;
	}
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasenames("mensajes");
		source.setUseCodeAsDefaultMessage(true);
		return source;
	}

	//probar orm aqui
	@Bean
	public CommandLineRunner demo(RepoUsuario repository) {
		return (args) -> {
//			Usuario u1 = new Usuario();
//			repository.save(u1);

			//primir algo por consola
//			log.info("--------------------------------------------");
		};
	}
}
