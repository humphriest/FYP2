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
    @Path("/createItem/{id}/{title}/{manuf}/{cat}/{img}/{price}")
    public String createUser(
            @PathParam("id") int id,
            @PathParam("title") String title,
            @PathParam("manuf") String manuf,
            @PathParam("cat") String cat,
            @PathParam("img") String img,
            @PathParam("price") double price
    ){
        StockItem item = new StockItem(id, title, manuf, cat, img, price);
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
