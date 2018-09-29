package www.coolcat.club.config;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import java.util.Properties;

// mapper 接口类扫描包配置
@MapperScan("www.coolcat.club.dao")
@Configuration
public class MyBatisConfig {

    @Autowired
    private DruidConfiguration druidConfig;

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(druidConfig.mysqlDataSource());
        sqlSessionFactoryBean.setTypeAliasesPackage("www.coolcat.club");
        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            //@SpringBootApplication(exclude = PageHelperAutoConfiguration.class) 默认已经加载
            //配置mybatis的分页插件pageHelper
           /* Properties properties = new Properties();
            properties.setProperty("helperDialect", "mysql");
            properties.setProperty("offsetAsPageNum", "true");
            properties.setProperty("rowBoundsWithCount", "true");
            properties.setProperty("reasonable", "true");
            Interceptor interceptor = new PageInterceptor();
            interceptor.setProperties(properties);
            sqlSessionFactoryBean.setPlugins(new Interceptor[] {interceptor});
            */
            sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
            sqlSessionFactoryBean.setConfigLocation(resolver.getResource("classpath:configuration.xml"));
            return sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Bean
    public DataSourceTransactionManager transactionManager() throws Exception {
        return new DataSourceTransactionManager(druidConfig.mysqlDataSource());
    }

}
