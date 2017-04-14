package Factory;


import DAO.CartDao;
import DAO.PurchaseDao;
import DAO.Services.CartDAOInterface;

public class CartFactory {

    public CartDAOInterface getMethod(boolean purchased){

        if(purchased){
            return new PurchaseDao();
        }else if(!purchased){
            return new CartDao();
        }

        return null;
    }

}
