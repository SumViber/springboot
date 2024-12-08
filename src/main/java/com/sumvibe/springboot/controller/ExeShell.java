package com.sumvibe.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

@RestController
public class ExeShell {

    @GetMapping(value = "/exeShell")
    public void exeShell() {
        try {
            String workPath = "/home/sumvibe/summer/sourcefile";
            System.out.println("执行命令："+"cd " + workPath + " && " + "tar -cvf /home/sumvibe/summer/tarfile/haha.tar *");
            Process exec = Runtime.getRuntime().exec("cd " + workPath + " && " + "tar -cvf /home/sumvibe/summer/tarfile/haha.tar *");
            // 获取输出
            BufferedReader reader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            // 等待进程结束
            int exitCode = exec.waitFor();
            System.out.println("\nExited with error code : " + exitCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
