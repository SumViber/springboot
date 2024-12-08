package com.sumvibe.springboot.controller;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class TheadDemo {
    public static void main(String[] args) {
        // 创建自定义线程池
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);
        executor.setMaxPoolSize(8);
        executor.setQueueCapacity(10);
        executor.initialize();

        // 任务数量
        int taskCount = 30;
        List<CompletableFuture<Long>> futures = new ArrayList<>();

        // 提交任务并统计耗时
        for (int i = 1; i <= taskCount; i++) {
            final int taskId = i; // 使用 final 变量
            CompletableFuture<Long> future = CompletableFuture.supplyAsync(() -> {
                long startTime = System.currentTimeMillis();
                // 模拟任务执行时间
                try {
                    Thread.sleep((long) (Math.random() * 2000) + 1000); // 随机休眠 1 到 3 秒
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // 恢复中断状态
                }
                long endTime = System.currentTimeMillis();
                long duration = endTime - startTime; // 计算执行耗时
                System.out.println("任务 " + taskId + " 执行耗时: " + duration + " 毫秒");
                return duration; // 返回执行耗时
            }, executor);

            futures.add(future);
        }

        // 等待所有任务完成并统计总耗时
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allOf.join(); // 等待所有任务完成

        // 汇总所有任务的耗时
        long totalDuration = futures.stream()
                .mapToLong(future -> {
                    try {
                        return future.get(); // 获取每个任务的耗时
                    } catch (Exception e) {
                        e.printStackTrace();
                        return 0;
                    }
                })
                .sum();

        // 打印总耗时
        System.out.println("所有任务的总耗时: " + totalDuration + " 毫秒");

        // 关闭线程池
        executor.shutdown();
    }
}
