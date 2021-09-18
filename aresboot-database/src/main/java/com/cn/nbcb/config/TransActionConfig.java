package com.cn.nbcb.config;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * AOP事物处理类
 * @author xy
 * @date 2021-8-28
 */
public class TransActionConfig {

    private static final int TRANSACTION_METHO_TIMEOUT = 5;
    private static final String AOP_POINTCUT_EXCEPTION = "execution (* com.cn.nbcb..service.*.*(..))";

    /**
     * 事物管理器
     */
    @Autowired
    private TransactionManager transactionManager;

    @Bean("txAdvice")
    public TransactionInterceptor transactionInterceptorConfig(){
        RuleBasedTransactionAttribute readOnlyAttribute = new RuleBasedTransactionAttribute();
        // 只读事物
        readOnlyAttribute.setReadOnly(true);
        // 非事物运行
        readOnlyAttribute.setPropagationBehavior(TransactionDefinition.PROPAGATION_NOT_SUPPORTED);
        // 配置了数据更新规则
        RuleBasedTransactionAttribute requireAttribute = new RuleBasedTransactionAttribute();
        requireAttribute.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        requireAttribute.setTimeout(TRANSACTION_METHO_TIMEOUT);
        // 配置所有要进行事物处理的方法名称定义
        Map<String, TransactionAttribute> transactionAttributeMap = new HashMap<>();
        transactionAttributeMap.put("add*",requireAttribute);
        transactionAttributeMap.put("edit*",requireAttribute);
        transactionAttributeMap.put("delete*",requireAttribute);
        transactionAttributeMap.put("list*",readOnlyAttribute);
        transactionAttributeMap.put("get*",readOnlyAttribute);
        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
        source.setNameMap(transactionAttributeMap); // 配置方法名称的映射
        TransactionInterceptor interceptor = new TransactionInterceptor(transactionManager,source);
        return interceptor;
    }

    @Bean("txAdvisor")
    public Advisor transactionAdvisor(@Autowired TransactionInterceptor interceptor){
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(AOP_POINTCUT_EXCEPTION);
        return new DefaultPointcutAdvisor(pointcut,interceptor);
    }

}
