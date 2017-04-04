import java.util.logging.Logger;

/**
 * Created by Maria on 29.03.2017.
 */
public class Application {
    public static void main(String[] args) {
        CategoryService service = new CategoryService();
        service.getCategoryById((long) 5);
        service.getChildCategoriesByParentId((long) 5);
        service.getCategoriesByName("Красота");
        service.getChildCategoriesByParentName("Красота");
    }
}
