package com.jiajun.configure;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

/**
 * aspectj表达式事务 Created by jiajun on 2017/09/25 22:52
 */
@Configuration
public class TransActionAdvisor {

	private static String aspectExpression = "execution(* com.jiajun.imagehost.service..*(..))";

	@Bean
	public TransactionInterceptor txAdvice(PlatformTransactionManager transactionManager) {
		// readonly
		RuleBasedTransactionAttribute readOnly = new RuleBasedTransactionAttribute();
		readOnly.setReadOnly(true);
		readOnly.setPropagationBehavior(TransactionDefinition.PROPAGATION_NOT_SUPPORTED);
		// required
		RuleBasedTransactionAttribute required = new RuleBasedTransactionAttribute();
		required.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
		required.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		// support
		RuleBasedTransactionAttribute support = new RuleBasedTransactionAttribute();
		support.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
		support.setPropagationBehavior(TransactionDefinition.PROPAGATION_SUPPORTS);
		// requires_new
		RuleBasedTransactionAttribute requiresNew = new RuleBasedTransactionAttribute();
		requiresNew.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
		requiresNew.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
		Map<String, TransactionAttribute> txMap = new HashMap<>();
		txMap.put("get*", readOnly);
		txMap.put("query*", readOnly);
		txMap.put("add*", required);
		txMap.put("save*", required);
		txMap.put("insert*", required);
		txMap.put("update*", required);
		txMap.put("modify*", required);
		txMap.put("delete*", required);
		txMap.put("batchDelete", required);
		source.setNameMap(txMap);
		return new TransactionInterceptor(transactionManager, source);
	}

	/**
	 * 切面, springboot会自动织入
	 */
	@Bean
	public AspectJExpressionPointcutAdvisor getTxpointcutAdvisor(TransactionInterceptor transactionInterceptor) {
		AspectJExpressionPointcutAdvisor txAspectj = new AspectJExpressionPointcutAdvisor();
		txAspectj.setExpression(aspectExpression);
		txAspectj.setAdvice(transactionInterceptor);
		return txAspectj;
	}
}
