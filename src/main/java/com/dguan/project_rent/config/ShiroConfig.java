package com.dguan.project_rent.config;

import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * shiro configuration for residence
 * @author dguan
 * @date 1/19/2021 8:30 PM
 */

@Configuration
public class ShiroConfig {

    /**
     * 设置CredentialsMatcher
     * 主要用来密码的加密
     * @return
     */
    @Bean
    public CredentialsMatcher credentialsMatcher(){
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("SHA-512");
        matcher.setHashIterations(1024);
        return matcher;
    }

    /**
     * 配置realm
     * 创建realm instance，把credentialsMatcher设置到realm中
     * 以便于realm内部处理principal时需要用到的密码加密算法
     * @param credentialsMatcher
     * @return
     */
    @Bean
    public Realm realm(CredentialsMatcher credentialsMatcher){
        ResidenceShiroRealm residenceRealm = new ResidenceShiroRealm();
        //set the credential matcher algorithm to realm
        residenceRealm.setCredentialsMatcher(credentialsMatcher);
        return residenceRealm;
    }

    /**
     * 配置securityManager
     * shiro的核心，所有的信息都通过securityManager来处理
     * securityManager需要设置realm来进行登录认证
     * realm的功能就是用户登录的授权和认证
     * @param realm
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager(Realm realm){
        DefaultWebSecurityManager  securityManager = new DefaultWebSecurityManager();
        //set the realm to security manager
        securityManager.setRealm( realm );
        return securityManager;
    }

    /**
     * 配置shiroFilterFactoryBean
     * 创建shiroFilterFactoryBean工厂，并将securityManager放入工厂中管理
     * 在工厂中设置url的放行和拦截功能
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //set the security manager to the shiro filter factory
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //set the filter url map("/url","type")
        HashMap<String, String> filterMaps = new HashMap<>();
        //pass
//        filterMaps.put("/rent/residence/login","anon");
//        filterMaps.put("/rent/residence/signup","anon");
//        filterMaps.put("/api/residence/login","anon");
//        //filter
//        filterMaps.put("/rent/residence/** ","authc");
//
//        shiroFilterFactoryBean.setLoginUrl("/unauth");
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMaps);

//        shiroFilterFactoryBean.setLoginUrl("/residence/toLogin");
//        shiroFilterFactoryBean.setSuccessUrl("/residence/index");
//        shiroFilterFactoryBean.setUnauthorizedUrl("");

        return shiroFilterFactoryBean;
    }

}
