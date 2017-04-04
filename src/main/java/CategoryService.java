import org.springframework.messaging.support.ErrorMessage;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Maria on 29.03.2017.
 */
@RequestMapping(value = "http://testSpringREST")
public class CategoryService {
    private static final String baseURL = "http://testSpringREST";

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    public Category getCategoryById(@PathVariable Long id) {
        if (id == null) {
            throw new Error("Ошибка, отсутствует id");
        }
        RestTemplate restTemplate = new RestTemplate();
        String urlStr = baseURL + "/category/" + id;
        Category category = restTemplate.getForObject(urlStr, Category.class);
        return category;
    }

    @RequestMapping(value = "/category/{parentId}/categories", method = RequestMethod.GET)
    public Category[] getChildCategoriesByParentId(@PathVariable Long parentId) {
        if (parentId == null) {
            throw new Error("Ошибка, отсутствует parentId");
        }
        RestTemplate restTemplate = new RestTemplate();
        String urlStr = baseURL + "/category/" + parentId + "/categories";
        Category[] categories = restTemplate.getForObject(urlStr, Category[].class);
        return categories;
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public Category[] getCategoriesByName(@RequestParam String name) {
        if (name == "") {
            throw new Error("Ошибка, отсутствует name");
        }
        RestTemplate restTemplate = new RestTemplate();
        String urlStr = baseURL + "/category?name=" + name;
        Category[] categories = restTemplate.getForObject(urlStr, Category[].class);
        return categories;
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public Category[] getChildCategoriesByParentName(@RequestParam String parentName) {
        if (parentName == "") {
            throw new Error("Ошибка, отсутствует parentName");
        }
        RestTemplate restTemplate = new RestTemplate();
        String urlStr = baseURL + "/categories?parentName=" + parentName;
        Category[] categories = restTemplate.getForObject(urlStr, Category[].class);
        return categories;
    }
}