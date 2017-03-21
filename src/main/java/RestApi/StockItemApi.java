package RestApi;

import DAO.StockItemDAO;
import entities.StockItem;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/stockApi")
public class StockItemApi {
    private StockItemDAO itemDao = new StockItemDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/createItem")
    public String createUser(){
        StockItem item = new StockItem(1,"TV", "LAVA", "electronics", "", 150);
        itemDao.createStockItem(item);
        return "Success";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllItems")
    public List<StockItem> getAllItems(){
        return itemDao.findAllItems();
    }
}
