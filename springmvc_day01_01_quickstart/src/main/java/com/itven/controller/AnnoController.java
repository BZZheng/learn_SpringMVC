package com.itven.controller;

import com.itven.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

/**
 * 常用的注解
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"msg"}) //把msg=美美存入到session域对象中
public class AnnoController {

    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "name") String username){
        System.out.println("执行了。。。");
        System.out.println("用户名："+username);
        return "success";
    }

    /**
     * 获取到请求体的内容
     * @param body
     * @return
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println("执行了。。。");
        System.out.println(body);
        return "success";
    }

    /**
     * PahthVariable注解
     * @param id
     * @return
     */
    @RequestMapping("/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(name = "sid") String id){
        System.out.println("执行了。。。");
        System.out.println(id);
        return "success";
    }

    /**
     * 获取请求头的值
     * RequestHeader注解
     * @param header
     * @return
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String header){
        System.out.println("执行了。。。");
        System.out.println(header);
        return "success";
    }

    /**
     * 获取Cookie的值
     * CookieValue注解
     * @param cookie
     * @return
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookie){
        System.out.println("执行了。。。");
        System.out.println(cookie);
        return "success";
    }

    /**
     * ModelAttribute注解
     * @return
     */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute(value = "abc") User user){
        System.out.println("testModelAttribute执行了。。。");
        System.out.println(user);
        return "success";
    }

    @ModelAttribute
    public void showUser(String uname, Map<String, User> map) {
        System.out.println("showUser执行了。。。");
        //通过用户名查询数据库(模拟)
        User user = new User();
        user.setUname(uname);
//        user.setAge(20);
        user.setDate(new Date());
        map.put("abc",user);
    }

    /**
     * 该方法会先执行
     * @return
     */
/*     @ModelAttribute
   public User showUser(String uname){
        System.out.println("showUser执行了。。。");
        //通过用户名查询数据库(模拟)
        User user = new User();
        user.setUname(uname);
//        user.setAge(20);
        user.setDate(new Date());
        return user;
    }*/

    /**
     * SessionAttributes的注解
     * @return
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model){
        System.out.println("testSessionAttributes执行了。。。");
        //底层会帮忙存储到request域中
        model.addAttribute("msg","美美");
        return "success";
    }

    /**
     * 从session域中取值
     * @param modelMap
     * @return
     */
    @RequestMapping("/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap){
        System.out.println("getSessionAttributes执行了。。。");
        String msg = (String) modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }

    /**
     * 删除session
     * @param status
     * @return
     */
    @RequestMapping("/delSessionAttributes")
    public String delSessionAttributes(SessionStatus status){
        System.out.println("delSessionAttributes执行了。。。");
        status.setComplete();
        return "success";
    }
}
