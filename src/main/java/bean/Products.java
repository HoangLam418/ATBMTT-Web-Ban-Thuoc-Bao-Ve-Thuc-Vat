package bean;

import dao.ProductsDao;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Products implements Serializable {
    private int id;
    private String product_name;
    private String picture;
    private int price;
    private int id_category;
    private int quantity;
    private int status;
    private String specifications;
    private String des;
    //SELECT id , product_name ,picture, price, id_category, quanitity, status, specifications,pro_desc FROM product


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public int getquantity() {
        return quantity;
    }

    public void setquantity(int quantity) {
        this.quantity = quantity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Products(int id, String product_name, String picture, int price, int id_category, int quantity, int status, String specifications, String des) {
        this.id = id;
        this.product_name = product_name;
        this.picture = picture;
        this.price = price;
        this.id_category = id_category;
        this.quantity = quantity;
        this.status = status;
        this.specifications = specifications;
        this.des = des;
    }

    public Products() {
    }

//    public Products(int id, String product_name, String picture, int price, int id_category) {
//        this.id = id;
//        this.product_name = product_name;
//        this.picture = picture;
//        this.price = price;
//        this.id_category = id_category;
//    }

    public Products(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", product_name='" + product_name + '\'' +
                ", picture='" + picture + '\'' +
                ", price=" + price +
                ", id_category=" + id_category +
                ", quantity=" + quantity +
                ", status=" + status +
                ", specifications='" + specifications + '\'' +
                ", pro_desc='" + des + '\'' +
                '}';
    }

    public String cateOfProduct(){
        String rs= ProductsDao.CateOfProduct(id);
        return rs;
    }

    public String formatPrice() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String formattedPrice = decimalFormat.format(price);
        return formattedPrice.replace(',', '.');
    }
    public String statusString(){
        if(this.status==1){
            return "Mở bán";
        }
        return "Hủy bán";
    }
    public static void main(String[] args) {
        Products a=new Products(4000000);
        System.out.println(a.formatPrice());

    }

}
