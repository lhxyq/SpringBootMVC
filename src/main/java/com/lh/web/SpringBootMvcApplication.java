package com.lh.web;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.lh.web.mapper")
@EnableTransactionManagement
public class SpringBootMvcApplication {
    private final static String TYPE_ALISE_PACKAGE = "com.lh.web.domain";
    private final static String MPPER_LOCALTION = "classpath:/mybatis/*.xml";

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMvcApplication.class, args);
    }

    @Bean
    @Autowired
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        //类别名
        sqlSessionFactoryBean.setTypeAliasesPackage(TYPE_ALISE_PACKAGE);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MPPER_LOCALTION));

        return sqlSessionFactoryBean.getObject();
    }
}
