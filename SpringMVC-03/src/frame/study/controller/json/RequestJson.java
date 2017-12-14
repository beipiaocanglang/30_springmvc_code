package frame.study.controller.json;

import frame.study.domain.Items;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.PrivateKey;

/**
 * Created by canglang on 2017/5/30.
 * json请求和返回
 */
@Controller
public class RequestJson {

    //跳转到测试页面
    @RequestMapping("/requestJson")
    public String requestJson(){
        return "requestJson/requestJson";
    }

    //请求json返回json
    @RequestMapping("/requestJsonAndResponsJson")
    public @ResponseBody Items requestJsonAndResponsJson(@RequestBody Items items){

        return items;
    }

    //请求pojo返回json
    @RequestMapping("/requestPojoAndResponsJson")
    public @ResponseBody Items requestPojoAndResponsJson(String name, Float price){

        Items items = new Items();
        items.setName(name);
        items.setPrice(price);

        return items;
    }
}
