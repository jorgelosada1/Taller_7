
package co.edu.sena.project2687351.model.bean;

public class Category {

    private static Integer category_id;
    private static String category_name;

    public Category() {
    }

    public static Integer getCategory_id() {
        return category_id;
    }

    public static void setCategory_id(Integer category_id) {
        Category.category_id = category_id;
    }

    public static String getCategory_name() {
        return category_name;
    }

    public static void setCategory_name(String category_name) {
        Category.category_name = category_name;
    }

    @Override
    public String toString() {
        return "category{" +
                "category_id=" + category_id +
                ", category_name='" + category_name + '\'' +
                '}';
    }
}
