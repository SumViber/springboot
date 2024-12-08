package com.sumvibe.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@Slf4j
public class ThreadPoolController {

    @Qualifier("threadPool")
    @Autowired
    public ThreadPoolTaskExecutor threadPoolExecutor;

//    public ThreadPoolController(ThreadPoolExecutor threadPoolExecuto) {
//        this.threadPoolExecutor = threadPoolExecuto;
//    }

   @GetMapping("/testThreadPool")
public void testThreadPoolExecutor() {
    // 记录当前线程池执行器的信息
    log.info("线程池执行器是 {}", threadPoolExecutor);

    // 创建一个列表来存储所有的 CompletableFuture
    List<CompletableFuture<Void>> futureList = new ArrayList<>();

    // 记录开始时间
    long startTime = System.currentTimeMillis();

    // 使用原子变量来记录总耗时
    AtomicLong totalTime = new AtomicLong(0L);

    // 提交30个任务到线程池
    for (int i = 1; i <= 30; i++) {
        // 将当前任务的索引保存为 final 变量
        int taskIndex = i;

        // 异步执行任务
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            // 记录任务执行的开始
            log.info(Thread.currentThread().getName() + " 开始执行任务！");
            try {
                // 模拟任务执行，休眠20秒
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                // 处理线程中断异常
                throw new RuntimeException(e);
            }
            // 记录任务执行结束
            log.info(Thread.currentThread().getName() + " **** 执行任务结束！****");
            log.info("第 " + taskIndex + " 任务执行完成！");
        }, threadPoolExecutor);

        // 将 CompletableFuture 添加到列表中
        futureList.add(future);
    }

    // 等待所有任务执行完成
    CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0])).join();

    // 记录结束时间
    long endTime = System.currentTimeMillis();

    // 计算并记录所有任务完成的总耗时
    log.info("所有任务完成总耗时为：" + (endTime - startTime) + " ms ");
}
}
