package HomeWork_4.java.com.example.spring_boot_product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;


//    Список всех продуктов
    @RequestMapping("/showProducts")
    public String showProducts(Model uiModel){

        uiModel.addAttribute("products", service.getProducts());

        return "products";
    }


//    Поиск продукта по ID
    @RequestMapping(path = "/showProductById/{sid}", method = RequestMethod.GET)
    public String showStudentById(Model uiModel, @PathVariable("sid") int id) {

        Product product = service.getProductById(id);

        if (product == null) {
            uiModel.addAttribute("msg", String.format("By id %s product not found", id));
            return "msg";
        }

        uiModel.addAttribute("headStr", "Product search result by id");
        uiModel.addAttribute("product", product);

        return "product-index";
    }

//    Форма для создания нового продукта
    @RequestMapping("/productForm")
    public String showSimpleForm(Model uiModel) {

        uiModel.addAttribute("product", service.getProduct());

        return "product-form";
    }


//    Добавлении нового продукта
    @RequestMapping("/addProduct")
    public String addProduct(Model uiModel, Product product) {

        service.addProduct(product);

        uiModel.addAttribute("headStr", "New product added");
        uiModel.addAttribute("product", product);

        return "product-index";
    }

    //    Добавлении нового продукта
    @RequestMapping("/test")
    public String test(Model uiModel) {
        return "product-index";
    }


}
