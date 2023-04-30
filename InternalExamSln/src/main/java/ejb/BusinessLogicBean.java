/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */

package ejb;

import entities.BillDetail;
import entities.Customer;
import entities.Product;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Maitrayee
 */
@Stateless
public class BusinessLogicBean implements BusinessLogicBeanLocal {
    
    @PersistenceContext(unitName = "PU")
    EntityManager em;
    
    @Override
    public boolean isCustomerExist(Integer custId) {
        if(!em.createNamedQuery("Customer.findById",Customer.class).setParameter("id", custId).getResultList().isEmpty()){
            return true;
        }
        return false;
    }

    @Override
    public List<Product> getallproducts() {
        return em.createNamedQuery("Product.findAll", Product.class).getResultList();
    }
    
    @Override
    public List<BillDetail> getAllBillDetails() {
        List<BillDetail> selectProducts = new ArrayList<>();
        List<Product> products = em.createNamedQuery("Product.findAll", Product.class).getResultList();
        for (int i = 0; i < products.size(); i++) {
            BillDetail billDetail = new BillDetail();
            billDetail.setProduct(products.get(i));
            selectProducts.add(billDetail);
        }
        return selectProducts;
    }

}
