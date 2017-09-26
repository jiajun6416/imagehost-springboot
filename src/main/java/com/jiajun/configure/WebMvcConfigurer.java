package com.jiajun.configure;

import java.nio.charset.Charset;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.jiajun.imagehosting.web.interceptor.LoginInterceptor;

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

	// 添加fastjson messageConverters
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
		FastJsonConfig config = new FastJsonConfig();
		config.setSerializerFeatures(SerializerFeature.WriteMapNullValue, // 保留空的字段
				SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullNumberAsZero);
		converter.setFastJsonConfig(config);
		converter.setDefaultCharset(Charset.forName("UTF-8"));
		converters.add(converter);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "upload/local");
		registry.addRedirectViewController("index", "upload/local");
	}

	/**
	 * 依赖userService,不能直接new
	 */
	@Bean
	public LoginInterceptor getLoginInterceptor() {
		return new LoginInterceptor();
	}

	// 添加拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		InterceptorRegistration registration = registry.addInterceptor(getLoginInterceptor());
		// 设置不拦截路径,默认静态资源位置不拦截
		registration.excludePathPatterns("/**.html");
		registration.excludePathPatterns("/login");
		registration.excludePathPatterns("/doLogin");
	}

	@Bean
	public HandlerExceptionResolver getGlobalExceptionResolver() {
		return new HandlerExceptionResolver() {
			@Override
			public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
					Object handler, Exception ex) {
				ModelAndView modelAndView = new ModelAndView();
				if (ex instanceof NoHandlerFoundException) {
					// 404
					modelAndView.setViewName("404");
				} else {
					modelAndView.addObject("message", ex.getMessage());
					modelAndView.setViewName("500");
				}
				return modelAndView;
			}
		};
	}

	// 异常处理器
	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		exceptionResolvers.add(getGlobalExceptionResolver());
	}
}
