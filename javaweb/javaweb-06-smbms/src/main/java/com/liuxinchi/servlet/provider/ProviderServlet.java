package com.liuxinchi.servlet.provider;

import com.liuxinchi.pojo.Provider;
import com.liuxinchi.pojo.User;
import com.liuxinchi.service.provider.ProviderService;
import com.liuxinchi.utils.Constant;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class ProviderServlet extends HttpServlet {

    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    ProviderService providerService = (ProviderService) context.getBean("providerService");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        switch (method){
            case "query": qureyProviderList(req, resp);break;
            case "add": insertProvider(req, resp);break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void qureyProviderList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String proCode = req.getParameter("queryProCode");
        String proName = req.getParameter("queryProName");

        List<Provider> providerList = providerService.queryProviderlist(proCode, proName);
        req.setAttribute("providerList",providerList);
        req.getRequestDispatcher("providerlist.jsp").forward(req,resp);
    }

    protected void insertProvider(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute(Constant.USER_SESSION);

        String proCode = req.getParameter("proCode");
        String proName = req.getParameter("proName");
        String proContact = req.getParameter("proContact");
        String proPhone = req.getParameter("proPhone");
        String proAddress = req.getParameter("proAddress");
        String proFax = req.getParameter("proFax");
        String proDesc = req.getParameter("proDesc");
        Long createdBy = user.getUserRole();
        Date creationDate = new Date();

        Provider provider = new Provider(proCode,proName,proDesc,proContact,proPhone,proAddress,proFax,createdBy,creationDate);
        if(providerService.insertProvider(provider)){
            req.getRequestDispatcher("provider.do?method=query").forward(req,resp);
        }else{
            resp.sendRedirect("/jsp/provideradd.jsp");
        }
    }

}
