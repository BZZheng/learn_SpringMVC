package com.itven.controller;

import com.itven.domain.Account;
import com.itven.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 请求参数绑定
 */
@Controller
@RequestMapping("/param")
public class ParamController {

    /**
     * 请求参数绑定的入门
     *
     * @return
     */
    @RequestMapping("/testParam")
    public String testParam(String username, String password) {
        System.out.println("执行了。。。");
        System.out.println("用户名：" + username + "，密码为：" + password);
        return "success";
    }

    /**
     * 请求参数绑定的入门
     * 将数据封装到JavaBean的类中
     *
     * @return
     */
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account) {
        System.out.println("执行了。。。");
        System.out.println(account);
        return "success";
    }

    /**
     * 自定义类型转换器
     * @return
     */
    @RequestMapping("/saveUser")
    public String saveUser(User user) {
        System.out.println("执行了。。。");
        System.out.println(user);
        return "success";
    }

    /**
     * 原生的API获取
     * @return
     */
    @RequestMapping("/testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("执行了。。。");
        System.out.println(request);
        HttpSession session = request.getSession();
        System.out.println(session);
        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);
        return "success";
    }
}
