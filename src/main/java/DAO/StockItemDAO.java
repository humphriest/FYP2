package DAO;

import Services.StockItemDAOInterface;
import entities.StockItem;
import persistence.persistenceUtil;

import javax.persistence.EntityManager;
import java.util.List;


public class StockItemDAO implements StockItemDAOInterface{

    public void createStockItem(StockItem stockItem){
        persistenceUtil.persist(stockItem);
    }

    public void updateItem(StockItem item, Double num){
        persistenceUtil.merge(item); // merge new item
        //pass through old price and new item to notify users
        item.updatePrice(item, num); // not sure if this part is correct
    }


    public List<StockItem> findAllItems(){
        EntityManager em = persistenceUtil.createEM();
        List<StockItem> items = (List<StockItem>)
                em.createNamedQuery("stockItem.findAll").getResultList();
        em.close();

        return items;

    }

    public StockItem getStockItemById(int itemId){
        EntityManager em = persistenceUtil.createEM();
        List<StockItem> items = (List<StockItem>)
                em.createNamedQuery("stockItem.findById").
                        setParameter("stockItemId", itemId).getResultList();
        em.close();

        if(items.size() == 0){
            return null;
        } else
            return items.get(0);
    }

    public void deleteStockItem(StockItem stockItem){
        persistenceUtil.remove(stockItem);
    }
}
