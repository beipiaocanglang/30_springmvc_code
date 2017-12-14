package frame.study.controller;

import frame.study.domain.Items;
import frame.study.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

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
     */
    @RequestMapping("/itemEdit")
    public String itemsEdit(Integer id, Model model){

        Items items = itemService.findItemsById(id);

        model.addAttribute("item", items);

        return "editItem";
    }

    /**
     * 保存修改后的商品数据
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
