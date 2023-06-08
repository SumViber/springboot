package com.sumvibe.springboot.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Download {

    /**
     * 保存到本地的工具类
     * @param args
     */
    public static void main(String[] args) {
        String txUrl = "https://hcdn02.ibigvideos.com/video/m3u8/2021/09/06/bd502d12/index.m3u8";
        // 生成文件 以路径后缀为文件名
//        char[] chars = txUrl.toCharArray();
//        //System.out.println(chars[56]);
//        String prex = "";
//        for (int i = txUrl.length()-1; i > -1; i--) {
//            if ((chars[i]+"").equals(".")){
//                prex = txUrl.substring(i, chars.length);
//                break;
//            }
//        }
        //System.out.println(prex);
//        String spName = System.currentTimeMillis() + prex;
        String spName = System.currentTimeMillis() + "";
        System.out.println(spName);
        // win系统的自行更换
        String bdPath = "/Users/xuxufu/Desktop/"+spName; // 保存到服务器的地址
        boolean downVideo = downVideo(txUrl, bdPath);
        System.out.println(downVideo);
    }


    /**
     * 下载视频
     * @param videoUrl 视频网络地址
     * @param downloadPath  视频保存地址
     */
    public static boolean downVideo (String videoUrl, String downloadPath) {
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        RandomAccessFile randomAccessFile = null;
        boolean re;
        try {

            URL url = new URL(videoUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Range", "bytes=0-");
            connection.connect();
            if (connection.getResponseCode() / 100 != 2) {
                System.out.println("连接失败...");
                return false;
            }
            inputStream = connection.getInputStream();
            int downloaded = 0;
            int fileSize = connection.getContentLength();
            randomAccessFile = new RandomAccessFile(downloadPath, "rw");
            while (downloaded < fileSize) {
                byte[] buffer = null;
                if (fileSize - downloaded >= 1000000) {
                    buffer = new byte[1000000];
                } else {
                    buffer = new byte[fileSize - downloaded];
                }
                int read = -1;
                int currentDownload = 0;
                long startTime = System.currentTimeMillis();
                while (currentDownload < buffer.length) {
                    read = inputStream.read();
                    buffer[currentDownload++] = (byte) read;
                }
                long endTime = System.currentTimeMillis();
                double speed = 0.0;
                if (endTime - startTime > 0) {
                    speed = currentDownload / 1024.0 / ((double) (endTime - startTime) / 1000);
                }
                randomAccessFile.write(buffer);
                downloaded += currentDownload;
                randomAccessFile.seek(downloaded);
                System.out.printf(downloadPath+"下载了进度:%.2f%%,下载速度：%.1fkb/s(%.1fM/s)%n", downloaded * 1.0 / fileSize * 10000 / 100,
                        speed, speed / 1000);
            }
            re = true;
            return re;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            re = false;
            return re;
        } catch (IOException e) {
            e.printStackTrace();
            re = false;
            return re;
        } finally {
            try {
                connection.disconnect();
                inputStream.close();
                randomAccessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
