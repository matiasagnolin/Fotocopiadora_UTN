package ar.com.config.spring;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.HibernateExceptionTranslator;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import ar.com.DataLayer.data.DataLayerImple;
import ar.com.Request.data.Request;
import ar.com.ServiceLayer.ServiceBussines;
import ar.com.ServiceLayer.ServiceCRUD;
import ar.com.ServiceLayer.ServiceLayer;
import ar.com.ServiceLayer.ServiceLayerBO;
import ar.com.model.domain.Persona;
import ar.com.model.domain.Profesor;
import ar.com.model.domain.Tipos;
import ar.com.model.domain.Usuario;
import ar.com.model.domain.Valores;
import ar.com.model.domain.Administrador;
import ar.com.model.domain.Alumno;
import ar.com.model.domain.Archivo;
import ar.com.model.domain.Carreras;
import ar.com.model.domain.Comprobantes;
import ar.com.model.domain.DetallePedido;
//import ar.com.model.domain.Carreras;
import ar.com.model.domain.Materias;
import ar.com.model.domain.Pedido;
import ar.com.repository.Repository;


@Configuration
@EnableJpaRepositories(basePackages="ar.com.repository")
public class AppConfig {

	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource driverManager = new DriverManagerDataSource("jdbc:mysql://localhost:3306/test", "root", "root");
		driverManager.setDriverClassName("com.mysql.jdbc.Driver");
		return driverManager;
	}
	
	@Bean(name="entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactory(){
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setPackagesToScan("ar.com.model.domain");
		
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		
		entityManagerFactory.setJpaProperties(hibernateProperties);
		
		entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactory.setDataSource(dataSource());
		
		return entityManagerFactory;
	}
	
	@Bean
	public HibernateExceptionTranslator exceptionTranslator(){
		return new HibernateExceptionTranslator();
	}
	
	@Bean(name="transactionManager")
	public JpaTransactionManager transactionManager(){
		return new JpaTransactionManager();
	}
	@Bean
	public Repository ReadRepository(){
		return new DataLayerImple();
	}
	@Bean
	public ServiceCRUD Service(){
		return new ServiceLayer();
	}
	@Bean
	public ServiceBussines ServiceBO(){
		return new ServiceLayerBO();
	}
//	@Bean
//	public Materias Materias(){
//		return new Materias();
//	}
	@Bean
	public Request request(){
		return new Request();
	}
	@Bean
	public Usuario usuario(){
		return new Usuario();
	}
	@Bean
	public Pedido pedido(){
		Pedido pedido= new Pedido();
		List<DetallePedido> dp = new ArrayList<>();
		pedido.setDetalleventa(dp);
		return pedido;
	}
	
	@Bean(name="sessionFactory") 
	public AnnotationSessionFactoryBean sessionFactoryBean(){
		AnnotationSessionFactoryBean sessionFactoryBean = new AnnotationSessionFactoryBean();
//		
		Class[] annotatedClasses = {Persona.class,Usuario.class,Archivo.class,Pedido.class,DetallePedido.class,Valores.class,
				Profesor.class,Alumno.class,Materias.class,Administrador.class,Tipos.class,Carreras.class,Comprobantes.class};

		sessionFactoryBean.setAnnotatedClasses(annotatedClasses); 
		
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		
		sessionFactoryBean.setHibernateProperties(hibernateProperties);
		sessionFactoryBean.setDataSource(dataSource());
		
		return sessionFactoryBean;
	}
	
	
}	
