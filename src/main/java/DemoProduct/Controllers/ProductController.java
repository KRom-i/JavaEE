package DemoProduct.Controllers;


import DemoProduct.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

//    Поиск продукта по ID
    @RequestMapping(path = "/showProductById/{id}", method = RequestMethod.GET)
    public String showStudentById(Model uiModel, @PathVariable("id") Long id) {

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


    /*
    Задание 2.
    Сделать страницу, в которую будут выведены эти записи.
      */

    @RequestMapping("/showProducts")
    public String showProducts(Model uiModel){

        uiModel.addAttribute("products", service.getProducts());

        return "products";
    }



}
