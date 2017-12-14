package frame.study;

import frame.study.domain.Items;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by canglang on 2017/5/21.
 * 搭建springmvc开发环境的第i个测定hi类
 *
 */
@Controller
public class ItemControllerTest {

    //第一个测试方法
    @RequestMapping("/itemsList")
    public String itesList(Model model){

        //springmvc会自动创建Model对象，相当于Response域

        //封装集合数据
        List<Items> itemList = new ArrayList<>();

        Items items = new Items();
        items.setName("zhangsan");
        items.setId(1111);
        items.setCreatetime(new Date());
        items.setPrice(66F);
        items.setDetail("详情！！！！！！！！！！！");

        Items items1 = new Items();
        items1.setName("zhangsan");
        items1.setId(1111);
        items1.setCreatetime(new Date());
        items1.setPrice(66F);
        items1.setDetail("详情！！！！！！！！！！！");

        Items items2 = new Items();
        items2.setName("zhangsan");
        items2.setId(1111);
        items2.setCreatetime(new Date());
        items2.setPrice(66F);
        items2.setDetail("详情！！！！！！！！！！！");

        itemList.add(items);
        itemList.add(items1);
        itemList.add(items2);

        //ModelAndView mv = new ModelAndView();
        //设置页面回显数据
        //mv.addObject("itemList", itemList);
        //设置物理结果视图(不需要使用视图解析器)(相当于编译后的绝对路径)
        //mv.setViewName("/WEB-INF/jsps/itemList.jsp");
        //mv.setViewName("itemList");
        model.addAttribute("itemList", itemList);

        return "itemList";
    }


}
