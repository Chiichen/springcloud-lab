package edu.scut.controller;

import edu.scut.client.UserController;
import edu.scut.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*** 购票Controller */
@RequestMapping("/web")
@RestController
@Api(description = "购票web核心api")
public class WebController {
    @Qualifier("edu.scut.client.UserController")
    @Autowired
    private UserController userController;
//    @Autowired
//    private RestTemplate restTemplate;


    /* * * 购票方法     */
    @ApiOperation(value = "远程方法：根据用户 ID 查询用户的方法")
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
