package Services;

import entities.StockItem;

import java.util.List;

/**
 * Created by Tim on 13/04/2017.
 */
public interface StockItemDAOInterface {

    public void createStockItem(StockItem stockItem);

    public List<StockItem> findAllItems();

    public StockItem getStockItemById(int itemId);

    public void deleteStockItem(StockItem stockItem);
}
