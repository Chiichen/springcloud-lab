package edu.scut.controller;

import edu.scut.client.UserController;
import edu.scut.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*** 购票Controller */
@RequestMapping("/web")
@RestController
public class WebController {
    @Autowired
    private UserController userController;
//    @Autowired
//    private RestTemplate restTemplate;


    /* * * 购票方法     */
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallback")
    public String order() {
        //模拟当前用户
        Integer id = 2;


        User user = userController.findById(id);


//        User user  = restTemplate.getForObject("http://myshop-user/user/"+id, User.class);
        System.out.println(user + "==正在购票...");
        return "购票成功";
    }

    public String fallback() {
        return "This service is unavailable currently";
    }
}
