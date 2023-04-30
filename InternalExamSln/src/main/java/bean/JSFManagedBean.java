/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import ejb.BusinessLogicBeanLocal;
import entities.BillDetail;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author maitr
 */
@Named(value = "jSFManagedBean")
@RequestScoped
public class JSFManagedBean {

    @EJB
    BusinessLogicBeanLocal ejb;

    Integer custId;

    List<BillDetail> Products = new ArrayList<>();
    List<BillDetail> Selectedproducts = new ArrayList<>();

    public JSFManagedBean() {
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public List<BillDetail> getSelectProducts() {
        Products = ejb.getAllBillDetails();
        return Products;
    }

    public void setSelectProducts(List<BillDetail> selectProducts) {
        this.Products = selectProducts;
    }

    public List<BillDetail> getProducts() {
        System.out.println(Products.size());
        if (Selectedproducts.isEmpty()) {
            for (int i = 0; i < Products.size(); i++) {
                if (Products.get(i).getQty() != null) {
                    Products.get(i).setTotal(Products.get(i).getQty() * Products.get(i).getProduct().getRate());
                    System.out.println(Products.get(i).getTotal());
                    Selectedproducts.add(Products.get(i));
                }
            }
        }
        return Selectedproducts;
    }

    public void setProducts(List<BillDetail> products) {
        this.Selectedproducts = products;
    }

    public String validateCustomer() {
        return "productsjsf";
    }

    public String getproductdata() {
        System.out.println(Products.size());
//        System.out.println(Products.size());
//        for(int i = 0; i < Products.size(); i++) {
//            if(Products.get(i).getQty() != null) {
//                Products.get(i).setTotal(Products.get(i).getQty() * Products.get(i).getProduct().getRate());
//                System.out.println(Products.get(i).getTotal());
//                Selectedproducts.add(Products.get(i));
//            }
//        }
        return "cartjsf.jsf";
    }

}
