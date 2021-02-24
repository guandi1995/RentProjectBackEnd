package com.dguan.project_rent.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author dguan
 * @date 2/23/2021 5:51 PM
 */
@Configuration
@EnableRedisHttpSession
public class SessionConfig {

}
