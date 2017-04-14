package RestApi;

import DAO.StockItemDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.StockItem;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@Path("/stockApi")
public class StockItemApi {
    private StockItemDAO itemDao = new StockItemDAO();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/createItem")
    public StockItem createItem(String jsonItem){
        StockItem item = null;
        try {
            item = mapStockItem(jsonItem);
        } catch (IOException e) {
            e.printStackTrace();
        }

        itemDao.createStockItem(item);
        return item;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllItems")
    public List<StockItem> getAllItems(){
        return itemDao.findAllItems();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getItemById")
    public StockItem getItem(String itemJson){
        StockItem finalItem = itemDao.getStockItemById(Integer.parseInt(itemJson));
        if(finalItem == null)
            return null;
        else
            return finalItem;
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/updatePrice/{newPrice}/{id}")
    public StockItem updateItem(
            @PathParam("newPrice") String newPrice,
            @PathParam("id") String id){

        /*StockItem item = null;
        try {
            item = mapStockItem(itemJson);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        StockItem item = getItem(id);
        if(item != null) {
            Double number = item.getPrice(); //old price
            System.out.println("old number: "+number);
            item.setPrice(Double.parseDouble(newPrice)); //new price
            System.out.println("item: " + item.getPrice());
            itemDao.updateItem(item, number); //pass both through
            return item;
        }
        else
            return null;
    }

    private StockItem mapStockItem(String jsonItem) throws IOException {
        StockItem item = null;
        item = new ObjectMapper().readValue(jsonItem, StockItem.class);

        return item;
    }


}

