/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.com;

/**
 *
 * @author giril
 */
public class ProductVO {

    private String productname;

    public String getProductname() {
        return productname;
    }

    @Override
    public String toString() {
        return "ProductVO{" + "productname=" + productname + '}';
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public ProductVO(String productname) {
        this.productname = productname;
    }

}
