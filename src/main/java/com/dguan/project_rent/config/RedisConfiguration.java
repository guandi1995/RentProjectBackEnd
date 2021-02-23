//package com.dguan.project_rent.config;
//
//import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
//import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//
///**
// * configuration for redis
// * @author dguan
// * @date 1/24/2021 5:44 PM
// */
//@Configuration
//public class RedisConfiguration {
//
//    /**
//     * read the properties in application.properties for redis configuration
//     */
//    @Value("${spring.redis.database}")
//    private int database;
//    @Value("${spring.redis.host}")
//    private String host;
//    @Value("${spring.redis.port}")
//    private int port;
//    @Value("${spring.redis.password}")
//    private String password;
//    @Value("${spring.redis.timeout}")
//    private int timeout;
//    @Value("${spring.redis.jedis.pool.max-active}")
//    private int maxActive;
//    @Value("${spring.redis.jedis.pool.max-wait}")
//    private int maxWait;
//    @Value("${spring.redis.jedis.pool.max-idle}")
//    private int maxIdle;
//    @Value("${spring.redis.jedis.pool.min-idle}")
//    private int minIdle;
//
//
//    /**
//     * redis for windows configuration, not for linux
//     * set the hostname, port, password and database
//     * @return
//     */
//    @Bean
//    public RedisStandaloneConfiguration standaloneConfig(){
//        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
//        redisStandaloneConfiguration.setHostName(host);
//        redisStandaloneConfiguration.setPort(port);
//        redisStandaloneConfiguration.setPassword(password);
//        redisStandaloneConfiguration.setDatabase(database);
//        return redisStandaloneConfiguration;
//
//    }
//
//    /**
//     * build a client configuration
//     * @param genericObjectPoolConfig
//     * @return
//     */
//    @Bean
//    public JedisClientConfiguration clientConfig(GenericObjectPoolConfig genericObjectPoolConfig){
//        JedisClientConfiguration.JedisPoolingClientConfigurationBuilder builder = (JedisClientConfiguration.JedisPoolingClientConfigurationBuilder) JedisClientConfiguration.builder();
//        JedisClientConfiguration.JedisPoolingClientConfigurationBuilder jedisPoolingClientConfigurationBuilder = builder.poolConfig(genericObjectPoolConfig);
//        JedisClientConfiguration build = jedisPoolingClientConfigurationBuilder.build();
//        return build;
//    }
//
//    /**
//     * clientConfig uses the parameter of genericObjectPoolConfig
//     * set the maxIdle, maxTotal, maxWait and minIdle in genericObjectPoolConfig
//     * @return
//     */
//    @Bean public GenericObjectPoolConfig genericObjectPoolConfig(){
//        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
//        genericObjectPoolConfig.setMaxIdle(maxIdle);
//        genericObjectPoolConfig.setMinIdle(minIdle);
//        genericObjectPoolConfig.setMaxWaitMillis(maxWait);
//        genericObjectPoolConfig.setMaxTotal(maxActive);
//        genericObjectPoolConfig.setEvictorShutdownTimeoutMillis(timeout);
//        return genericObjectPoolConfig;
//    }
//
//    /**
//     * establish a connection factory to jedis instance
//     * @param standaloneConfig for stand alone(单机版) configuration
//     * @param clientConfig for client(who connect the redis or who use the redis) configuration
//     * @return
//     */
//    @Bean
//    public JedisConnectionFactory jedisConnectionFactory(RedisStandaloneConfiguration standaloneConfig, JedisClientConfiguration clientConfig){
//        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(standaloneConfig, clientConfig);
//        return jedisConnectionFactory;
//    }
//
//}
