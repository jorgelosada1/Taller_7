
package co.edu.sena.projectv2687350.model;

public class Category {
    private Integer category_id;
    private String category_name;

    public Category() {
    }

    public Category(Integer category_id, String category_name) {
        this.category_id = category_id;
        this.category_name = category_name;
    }

    public Integer getCategory_id() {
        return this.category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return this.category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String toString() {
        return "Category{category_id=" + this.category_id + ", category_name='" + this.category_name + "'}";
    }
}
