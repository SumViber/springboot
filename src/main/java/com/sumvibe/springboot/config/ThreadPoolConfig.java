package com.sumvibe.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @date: 2023/12/4 14:08:48
 * @author: xuxufu
 * @description: 多线程配置类
 */
@Configuration
public class ThreadPoolConfig {
    @Bean(name = "threadPool01")
    public ThreadPoolTaskExecutor threadPool01() {
        // 创建线程池任务执行器对象
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 设置核心线程数量
        executor.setCorePoolSize(8);
        // 设置最大线程数量
        executor.setMaxPoolSize(16);
        // 设置阻塞队列容量
        executor.setQueueCapacity(256);
        // 设置线程空闲时间，默认为 60 秒
        executor.setKeepAliveSeconds(60);
        // 设置是否支持回收核心线程，默认为 false
        executor.setAllowCoreThreadTimeOut(false);
        // 设置线程名称前缀，若不设置则根据对象的 beanName 生成
        executor.setThreadNamePrefix("threadPool01-");
        // 设置线程池拒绝策略，默认为 AbortPolicy，即线程数量达到最大线程数量，且阻塞队列容量已满，再添加任务则抛出异常。
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        // 初始化
        executor.initialize();
        return executor;
    }
}
