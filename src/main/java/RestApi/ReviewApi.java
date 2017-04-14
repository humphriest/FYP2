package RestApi;

import DAO.CommentDao;
import DAO.StockItemDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Comment;
import entities.StockItem;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Path("/reviewApi")
public class ReviewApi {
    private CommentDao commentDao = new CommentDao();
    private StockItemDAO stockItemDAO = new StockItemDAO();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/createReview")
    public Comment createItem(String jsonItem){
        Comment comment = null;
        try {
            comment = mapComment(jsonItem);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Date date = new Date();
        if (comment != null) {
            comment.setTimestamp(date);
        }
        commentDao.createComment(comment);
        return comment;
    }

    @POST
    @Produces(value = {"application/json"})
    @Path("/getCommentByItem")
    public List<Comment> getCommentByItem(String itemJson){
        StockItem item = null;
        StockItem newItem = null;
        try {
            item = mapStockItem(itemJson);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (item != null) {
            newItem = stockItemDAO.getStockItemById(item.getStockItemId());
        }
        if(newItem != null){
            return commentDao.getProductByItem(newItem);
        }else{
            return null;
        }
    }

    private Comment mapComment(String jsonItem) throws IOException {
        Comment comment = null;
        comment = new ObjectMapper().readValue(jsonItem, Comment.class);

        return comment;
    }
    private StockItem mapStockItem(String jsonItem) throws IOException {
        StockItem item = null;
        item = new ObjectMapper().readValue(jsonItem, StockItem.class);
        return item;
    }
}

