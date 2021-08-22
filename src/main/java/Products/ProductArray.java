package Products;

import Html.StringHtml;

public class ProductArray {

    private final String[] names = {"Apple", "Pear", "Orange", "Lemon",
            "Banana", "Watermelon", "Pomegranate", "Mardarin", "Kiwi", "Grapes"};

    private Product[] products;

    public ProductArray () {
        this.products = new Product[names.length];
        initArray();
    }

    private void initArray () {
        for (int i = 0; i < products.length; i++) {
            products[i] = new Product((i + 1), names[i]);
        }
    }

    public String getHtmlString(){

        if (products.length == 0) return StringHtml.get("No products found");

        return StringHtml.get("Products", products);
    }
}
