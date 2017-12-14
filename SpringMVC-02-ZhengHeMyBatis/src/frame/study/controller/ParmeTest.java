package frame.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by canglang on 2017/5/29.
 * SpringMVC参数的传递
 */
@Controller
public class ParmeTest {

    //跳转到参数传递的测试页面
    @RequestMapping(value = "/parme")
    public String parmeTran(){
        return "parme";
    }

    /**
     * springmvc传递参数：
     * 1.springmvc基于方法进行传递参数
     * 2.springmvc会自动创建在方法中定义的任意对象
     * 3.在方法里面写上接受参数的变量(页面的name取值、实体变量属性、方法上接收的变量一致)，springmvc自动把页面参数封装方法变量中
     */
    @RequestMapping(value = "/tranInt")
    public String tranInt(Integer id){

        System.out.println(id);

        return null;
    }

    @RequestMapping(value = "/tranString")
    public String tranString(String username, String password){

        System.out.println(username);
        System.out.println(password);

        return null;
    }


}
