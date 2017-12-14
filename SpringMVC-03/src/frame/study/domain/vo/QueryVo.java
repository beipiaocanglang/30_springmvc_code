package frame.study.domain.vo;

import frame.study.domain.Items;

import java.util.List;

/**
 * Created by canglang on 2017/5/29.
 * 定义包装类
 */
public class QueryVo extends Items {
    private Items items;

    private List<Items> itemsList;

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public List<Items> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<Items> itemsList) {
        this.itemsList = itemsList;
    }

    @Override
    public String toString() {
        return "QueryVo{" +
                "items=" + items +
                ", itemsList=" + itemsList +
                '}';
    }
}
