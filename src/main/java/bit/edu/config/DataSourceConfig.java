package bit.edu.config;

import java.io.IOException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
@Configuration
@MapperScan(basePackages = "**/mapper/**", sqlSessionFactoryRef = "sqlSessionFactoryBean")
@PropertySource("classpath:/db.properties")
public class DataSourceConfig {

    @Value("${database.driver}")
    private String driver;

    @Value("${database.url}")
    private String url;

    @Value("${database.username}")
    private String username;

    @Value("${database.password}")
    private String password;

    @Value("${database.initial.size}")
    private String initialSize;

    @Value("${database.max.size}")
    private String maxSize;

    @Bean
    public DataSource dataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(driver);
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);
        basicDataSource.setInitialSize(Integer.parseInt(initialSize));
        basicDataSource.setMaxTotal(Integer.parseInt(maxSize));
        return basicDataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws IOException {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/**/mapper/*.xml"));
        return sqlSessionFactoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

}
