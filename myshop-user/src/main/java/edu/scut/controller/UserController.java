package edu.scut.controller;

import edu.scut.entity.User;
import edu.scut.service.UserService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController   // @RestController=@RequestMapping + @ResponseBody
public class UserController {
    @Autowired
    private UserService userService;

    @Value("${server.port}")
    private Integer port;

    /*** 查询所有用户     */
    @RequestMapping(method = RequestMethod.GET)
    public List<User> findAll() {
        return userService.findAll();
    }

    public static final Log log = LogFactory.getLog(UserController.class);
    /*** 根据id查询用户     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable Integer id) {
        log.info("Entering findById in UserController");
        System.out.println("用户微服务端口：" + port);
        return userService.findById(id);
    }

    /*** 添加用户     */
    @RequestMapping(method = RequestMethod.POST)
    public String add(@RequestBody User user) {
        userService.add(user);
        return "添加成功";
    }

    /*** 修改用户     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String update(@RequestBody User user, @PathVariable Integer id) {
        //设置id
        user.setId(id);
        userService.update(user);
        return "修改成功";
    }

    /*** 根据id删除用户     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable Integer id) {
        userService.deleteById(id);
        return "删除成功";
    }
}

