package businesslogic;

import dataAccess.ProductDAO;
import model.Client;
import model.Product;

import java.util.List;
import java.util.Vector;

public class ProductBLL {

    private ProductDAO productDAO;

    public ProductBLL() {
        this.productDAO = new ProductDAO();
    }

    public List<Product> findALL()
    {
        List<Product> products = productDAO.findAll();

        return products;
    }
    public void insertProduct(Product product)
    {
        productDAO.insert(product);
    }
    public Product findbyId(int id){
        return productDAO.findById(id);

    }
    public Product findbyNume(String nume){
        return productDAO.findByName(nume);

    }
    public void delete(int id,String chosenType)
    {
        productDAO.deleteById(id,chosenType);
    }
    public void update(Product product)
    {
        productDAO.update(product);
    }
}
