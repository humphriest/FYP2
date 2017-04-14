package Services;

import entities.Comment;
import entities.StockItem;

import java.util.List;


public interface CommentDAOInterface {

    public void createComment(Comment comment);

    public List<Comment> getProductByItem(StockItem item);
}
