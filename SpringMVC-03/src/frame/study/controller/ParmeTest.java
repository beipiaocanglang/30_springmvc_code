package frame.study.controller;

import frame.study.domain.vo.QueryVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
     * 传递基本数据类型
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

    /**
     * 传递string类型
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/tranString")
    public String tranString(String username, String password){

        System.out.println(username);
        System.out.println(password);

        return null;
    }

    /**
     * 传递包装类型参数
     * @return
     */
    @RequestMapping("/tranVo")
    public String tranVo(QueryVo vo){

        System.out.println(vo);

        return null;
    }

    /**
     * 传递数组类型参数
     * @return
     */
    @RequestMapping("/tranArray")
    public String tranArray(Integer[] ids){

        System.out.println(ids);

        return null;
    }

    /**
     * 传递list类型参数
     * @return
     */
    @RequestMapping("/tranList")
    public String tranList(QueryVo vo){

        System.out.println(vo);

        return null;
    }
}
