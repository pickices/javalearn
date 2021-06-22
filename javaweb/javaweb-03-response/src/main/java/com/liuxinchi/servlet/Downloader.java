package com.liuxinchi.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class Downloader extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //    获取路径
        String realpath = "D:\\Download\\0810-ebod531\\0810-ebod531.avi";
        //    获取文件名
        String filename = realpath.substring(realpath.lastIndexOf("\\")+1);
        //    让浏览器支持下载
        resp.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename,"UTF-8"));
        //    获取下载输入流
        FileInputStream in = new FileInputStream(realpath);
        //    创建缓冲区
        int len;
        byte[] buffer = new byte[1024];
        //    获取OutputStream对象
        ServletOutputStream out = resp.getOutputStream();
        //    将FileOutputStream流写入buffer缓冲区
        //    使用OutputStream将缓冲区中的数据输出到客户端
        while ((len = in.read(buffer))>0){
            out.write(buffer,0,len);
        }
        in.close();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req, resp);
    }

}
