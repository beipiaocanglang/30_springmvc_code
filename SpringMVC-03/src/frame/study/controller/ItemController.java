package frame.study.controller;

import frame.study.customExcetpion.CustomException;
import frame.study.domain.Items;
import frame.study.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by canglang on 2017/5/21.
 *
 */
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/itemList")
    public String itemList(Model model){

        List<Items> itemList = itemService.itemsList();

        model.addAttribute("itemList", itemList);

        return "itemList";
    }
    /**
     * 根据id修改商品
     * loclahost:8080/itemEdit.do?id=9(查询一个数据库没有的id)
     */
    @RequestMapping(value = "/itemEdit", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String itemsEdit(Integer id, Model model) throws Exception {

        Items items = itemService.findItemsById(id);

        //系统异常
        //int a = 1/0;

        //自定义异常
        //if (items == null){
       //     throw new CustomException("item is not exist!");
       // }

        model.addAttribute("item", items);

        return "editItem";
    }

    /**
     * 保存修改后的商品数据
     * @RequestParam
     *      defaultValue：给参数设置默认值，当前页面传递值为null或者为空，把默认值直接赋值给方法参数
     *      value：给参数定义一个别名，当指定value属性时，页面传递参数name属性中值必须和注解属性value的值一致
     *      required：判断参数值是否必须传递
     * @RequestMapping
    //   @RequestMapping("tranInt.do")
    //	 @RequestMapping(value="tranInt.do")
    //	 @RequestMapping(value="/tranInt.do")
    //	 @RequestMapping(value="/tranInt.do",method=RequestMethod.GET)
    //	 @RequestMapping(value="/tranInt.do",method=RequestMethod.POST)
    //	 @RequestMapping(value="/tranInt.do",method=RequestMethod.POST, produces = "text/html;charset=UTF-8")
    //	 @RequestMapping(value="/tranInt.do",method={RequestMethod.POST,RequestMethod.GET})
     */
    @RequestMapping("/updateitem")
    public String updateitem(Items items){

        itemService.updateItems(items);

        return "redirect:itemList.do";
    }

    /**
     * 使用注解的方式转换时间类型
     * 此注解是spring提供的，在其他方法执行前会先执行
     */
    @InitBinder
    public void webDateBingParm(WebDataBinder binding){

        //Date.class:要转换的类型
        binding.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

}
