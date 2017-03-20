package DAO;

import entities.StockItem;
import persistence.persistenceUtil;


public class StockItemDAO {

    public void createStockItem(StockItem stockItem){
        persistenceUtil.persist(stockItem);
    }


    public void deleteStockItem(StockItem stockItem){
        persistenceUtil.remove(stockItem);
    }
}
