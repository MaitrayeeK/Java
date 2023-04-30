/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */

package ejb;

import entities.BillDetail;
import entities.Product;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Maitrayee
 */
@Local
public interface BusinessLogicBeanLocal {
    boolean isCustomerExist(Integer custId);
    List<Product> getallproducts();
    List<BillDetail> getAllBillDetails();
}
