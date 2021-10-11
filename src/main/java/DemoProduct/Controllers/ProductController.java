package DemoProduct.Controllers;

import DemoProduct.Product.Product;
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
    @RequestMapping(path = "/findById/{id}", method = RequestMethod.GET)
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

    //    Удаление продукта по ID
    @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
    public String delete(Model uiModel, @PathVariable("id") Long id) {

        if (service.deleteProduct(id)) {
            uiModel.addAttribute("msg", "Product removed");
            return "msg";
        }

        uiModel.addAttribute("msg", String.format("By id %s product not found", id));
        return "msg";
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
    Сделать страницу, в которую будут выведены эти записи.
      */

    @RequestMapping("/showProducts")
    public String showProducts(Model uiModel){

        uiModel.addAttribute("products", service.getProducts());

        return "products";
    }

    /*
    С помощью GET-запроса указывать фильтрацию по:
    a. только минимальной,
    b. только максимальной,
    c. или минимальной и максимальной цене.
        */

    @RequestMapping(path = "/sortDesc/{property}", method = RequestMethod.GET)
    public String getSortDesc(Model uiModel, @PathVariable("property") String property) {
        uiModel.addAttribute("products", service.getSortDesc(property));
        return "products";
    }

    @RequestMapping(path = "/sortAsc/{property}", method = RequestMethod.GET)
    public String getSortAsc(Model uiModel, @PathVariable("property") String property) {
        uiModel.addAttribute("products", service.getSortAsc(property));
        return "products";
    }

     /*
    Добавить постраничное отображение (по 5 записей на странице)
      */

    @RequestMapping(path = "/showPage/{page}/{size}", method = RequestMethod.GET)
    public String getPage(Model uiModel, @PathVariable("page") Integer page, @PathVariable("size") Integer size) {

        uiModel.addAttribute("products", service.getPage(page, size));
        return "products";
    }


    /*
     К запросу всех товаров добавьте возможность фильтрации по минимальной и максимальной цене
     (в трех вариантах: товары дороже min цены, товары дешевле max цены, или товары,
      цена которых находится в пределах min-max).
     */

    @RequestMapping(path = "/min/{price}", method = RequestMethod.GET)
    public String getGreater(Model uiModel, @PathVariable("price") Integer price) {
        uiModel.addAttribute("products", service.getGreater (price));
        return "products";
    }

    @RequestMapping(path = "/max/{price}", method = RequestMethod.GET)
    public String getBefore(Model uiModel, @PathVariable("price") Integer price) {
        uiModel.addAttribute("products", service.getLess (price));
        return "products";
    }

    @RequestMapping(path = "/priceRange/{min}/{max}", method = RequestMethod.GET)
    public String getPriceRange(Model uiModel, @PathVariable("min") Integer minPrice, @PathVariable("max") Integer maxPrice) {
        uiModel.addAttribute("products", service.getPriceRange (minPrice, maxPrice));
        return "products";
    }


}