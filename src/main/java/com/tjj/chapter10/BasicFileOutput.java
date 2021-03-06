package com.tjj.chapter10;

/**
 * @description: 18.6 (13、14)利用LineNumberReader记录行数，比较有无缓存向文件写入比较
 * @author: tangjunjian
 * @create: 2018-07-11 14:32
 **/

import java.io.*;

public class BasicFileOutput {
    static String file = "BasicFileOutput.txt";
    public static void main(String[] args)
            throws IOException {
        LineNumberReader in = new LineNumberReader(
                new StringReader(
                        BufferedInputFile.read("test.txt")));
        String s;

        // 无缓冲
        PrintWriter outWithoutBuf = new PrintWriter(
                new FileWriter(file));
        long startTime=System.nanoTime();   //获取开始时间
        while((s = in.readLine()) != null )
            outWithoutBuf.println(in.getLineNumber() + ": " + s);
        outWithoutBuf.close();
        long endTime=System.nanoTime(); //获取结束时间
        System.out.println("无缓冲程序运行时间： "+(endTime-startTime)+"ns");

        // 有缓冲
//        PrintWriter out = new PrintWriter(
//                new BufferedWriter(new FileWriter(file)));
//        startTime=System.nanoTime();   //获取开始时间
//        while((s = in.readLine()) != null )
//            out.println(in.getLineNumber() + ": " + s);
//        out.close();
//        endTime=System.nanoTime(); //获取结束时间
//        System.out.println("有缓冲程序运行时间： "+(endTime-startTime)+"ns");

        // Show the stored file:
        System.out.println(BufferedInputFile.read(file));
    }
}