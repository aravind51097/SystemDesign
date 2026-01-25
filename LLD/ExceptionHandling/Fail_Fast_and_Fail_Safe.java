package LLD.ExceptionHandling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Product {
    private String productId;
    private String productName;

    public Product(String productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

}

class FailFastProduct {
    private Map<String, Product> plist = new HashMap<>();

    public Product getProduct(String productId) throws IllegalArgumentException {
        if (productId == null || plist.get(productId) == null) {
            // fail fast
            throw new IllegalArgumentException("Product id should not be null or product not exsit");
        }
        return plist.get(productId);

    }

    public void addProduct(Product product, String pId) {
        plist.put(pId, product);
    }

}

class FailSafe {

}

public class Fail_Fast_and_Fail_Safe {

    public static void main(String[] args) {
        Product p1 = new Product("1", "Sampoo");
        Product p2 = new Product("21", "Tooth Brush");
        Product p3 = new Product("211", "Car ");

        FailFastProduct failFast = new FailFastProduct();

        System.out.println(failFast.getProduct(null));
        failFast.addProduct(p1, p1.getProductId());
        failFast.addProduct(p2, p2.getProductId());

        try {
            System.out.println(failFast.getProduct(p3.getProductId()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
