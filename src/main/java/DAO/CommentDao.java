package DAO;

import entities.Cart;
import entities.Comment;
import entities.StockItem;
import entities.User;
import persistence.persistenceUtil;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Tim on 06/04/2017.
 */
public class CommentDao {
    public void createComment(Comment comment){
        persistenceUtil.persist(comment);
    }

    public List<Comment> getProductByItem(StockItem item){
        EntityManager em = persistenceUtil.createEM();
        List<Comment> comments = (List<Comment>)
                em.createNamedQuery("comment.findByItem").
                        setParameter("item", item).getResultList();
        em.close();

        if(comments.size() == 0){
            return null;
        } else
            return comments;
    }
}
