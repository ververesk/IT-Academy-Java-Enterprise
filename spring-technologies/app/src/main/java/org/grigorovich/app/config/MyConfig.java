package org.grigorovich.app.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "org.grigorovich")//где будет происходить сканирование
@EnableWebMvc
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class MyConfig {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver =
                new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public DataSource dataSource() {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("org.postgresql.Driver");
            dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/dbit");
            dataSource.setUser("userit");
            dataSource.setPassword("123321");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("org.grigorovich.model");
        Properties hibernateProperties=new Properties();
        hibernateProperties.setProperty("dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
        hibernateProperties.setProperty("show_sql", "true");
        hibernateProperties.setProperty("hbm2ddl.auto", "none");
        hibernateProperties.setProperty("current_session_context_class", "thread");
        hibernateProperties.setProperty("connection.pool_size", "20");
        hibernateProperties.setProperty("hibernate.dbcp.initialSize", "5");
        hibernateProperties.setProperty("hibernate.dbcp.maxTotal", "20");
        hibernateProperties.setProperty("hibernate.dbcp.maxIdle", "10");
        hibernateProperties.setProperty("hibernate.dbcp.minIdle", "5");
        hibernateProperties.setProperty("hibernate.dbcp.maxWaitMillis", "-1");
        hibernateProperties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
        hibernateProperties.setProperty("hibernate.order_inserts", "true");
        hibernateProperties.setProperty("hibernate.order_updates", "true");
        sessionFactory.setHibernateProperties(hibernateProperties);
        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager=new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
}
