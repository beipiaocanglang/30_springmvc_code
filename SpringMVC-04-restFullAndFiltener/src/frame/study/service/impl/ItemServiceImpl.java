package frame.study.service.impl;

import frame.study.domain.Items;
import frame.study.mapper.ItemsMapper;
import frame.study.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by canglang on 2017/5/21.
 *
 */
@Component
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public List<Items> itemsList() {

        List<Items> itemsList = itemsMapper.itemList();

        return itemsList;
    }

    //根据id查询商品信息
    @Override
    public Items findItemsById(Integer id) {

        Items items = itemsMapper.selectByPrimaryKey(id);

        return items;
    }

    //根据主键保存修改后的商品
    @Override
    public void updateItems(Items items) {

        itemsMapper.updateByPrimaryKey(items);
    }
}
