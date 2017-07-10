package configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "configuration" })
public class HibernateConfiguration {
	
	
	  @Bean
	    @Autowired
	    public HibernateTransactionManager transactionManager(SessionFactory s) {
	       HibernateTransactionManager txManager = new HibernateTransactionManager();
	       txManager.setSessionFactory(s);
	       return txManager;
	    }
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		LocalSessionFactoryBean SessionFactory=new LocalSessionFactoryBean();
		SessionFactory.setDataSource(dataSourceInitialize());
		SessionFactory.setHibernateProperties(hibernatePropertiesInitialize());
		SessionFactory.setPackagesToScan("model");
		return SessionFactory;
	}

	private Properties hibernatePropertiesInitialize() {
			Properties properties=new Properties();
			properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
			properties.put("hibernate.show_sql", true);
			properties.put("hibernate.format_sql", true);
			properties.put("hibernate.hbm2ddl.auto","create");
		return properties;
	}

	private DataSource dataSourceInitialize() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/HRProject");
		dataSource.setDriverClassName(" com.mysql.jdbc.Driver");

		dataSource.setPassword("");
		dataSource.setUsername("root");

		
		// TODO Auto-generated method stub
		return dataSource;
	}

}
