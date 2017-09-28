package com.jiajun.configure;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class MybatisConfiurer {

	/**
	 * 使用的 直接操作sqlTemplate, 而没有使用Mapper代理开发
	 */
	@Bean
	public SqlSessionFactory sqlTemplateFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		sessionFactoryBean.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources("classpath:mapper/**/*Mapper.xml"));
		sessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
		sessionFactoryBean.setDataSource(dataSource);
		return sessionFactoryBean.getObject();
	}
}
