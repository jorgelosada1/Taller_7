//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package co.edu.sena.project2687351.model.bean;

public class
Product {
    private static Integer product_id;
    private static String product_name;
    private static Float product_value;
    private static Integer category_id;

    public Product() {

    }

    public Product(Integer product_id, String product_name, Float product_value, Integer category_id) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_value = product_value;
        this.category_id = category_id;
    }

    public static Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public static String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public static Float getProduct_value() {
        return product_value;
    }

    public void setProduct_value(Float product_value) {
        this.product_value = product_value;
    }

    public static Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }
    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", product_value='" + product_value + '\'' +
                ", category_id='" + category_id + '\'' +
                '}';
    }
}
