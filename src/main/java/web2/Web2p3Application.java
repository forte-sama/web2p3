package web2;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import web2.repositories.RepoUsers;

@SpringBootApplication
public class Web2p3Application {

	private static final Logger log = LoggerFactory.getLogger(Web2p3Application.class);
	@Value("${spring.datasource.driver-class-name}")
	private String databaseDriverClassName;
	@Value("${spring.datasource.url}")
	private String datasourceUrl;
	@Value("${spring.datasource.username}")
	private String databaseUsername;
	@Value("${spring.datasource.password}")
	private String databasePassword;

	/** main */
	public static void main(String[] args) {
		SpringApplication.run(Web2p3Application.class, args);
	}

	//beans para manejar los locale y el asunto del i18n
	@Bean
	public LocaleResolver localeResolver() {
		return new SessionLocaleResolver();
	}
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasenames("mensajes");
		source.setUseCodeAsDefaultMessage(true);
		return source;
	}

	//bean para seguridad usando la base de datos
	@Bean
	public DataSource datasource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName(databaseDriverClassName);
		ds.setUrl(datasourceUrl);
		ds.setUsername(databaseUsername);
		ds.setPassword(databasePassword);

		return ds;
	}

	//bean para probar cosas con algun repo aqui
	@Bean
	public CommandLineRunner demo(RepoUsers repository) {
		return (args) -> {
			//User u1 = new User();
			//repository.save(u1);

			//primir algo por consola
			//log.info("--------------------------------------------");
		};
	}
}
