package frame.study.service;

import frame.study.domain.Items;

import java.util.List;

/**
 * Created by canglang on 2017/5/21.
 *
 */
public interface ItemService {
    //查询所有
    public List<Items> itemsList();

    //根据id查询商品信息
    Items findItemsById(Integer id);

    //保存修改后的商品数据
    void updateItems(Items items);
}
