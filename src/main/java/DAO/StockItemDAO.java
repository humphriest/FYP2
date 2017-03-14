package DAO;

import entities.StockItem;
import persistence.persistenceUtil;

/**
 * Created by Tim on 05/12/2016.
 */
public class StockItemDAO {

    public void createStockItem(StockItem stockItem){
        persistenceUtil.persist(stockItem);
    }


    public void deleteStockItem(StockItem stockItem){
        persistenceUtil.remove(stockItem);
    }
}
