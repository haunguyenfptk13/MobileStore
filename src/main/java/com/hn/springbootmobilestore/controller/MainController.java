package com.hn.springbootmobilestore.controller;

import com.hn.springbootmobilestore.cart.CartObject;
import com.hn.springbootmobilestore.entity.Category;
import com.hn.springbootmobilestore.entity.Manufacturer;
import com.hn.springbootmobilestore.entity.Product;
import com.hn.springbootmobilestore.entity.StatusProduct;
import com.hn.springbootmobilestore.service.category.CategoryService;
import com.hn.springbootmobilestore.service.manufacturer.ManufacturerService;
import com.hn.springbootmobilestore.service.product.ProductService;
import com.hn.springbootmobilestore.service.statusProduct.StatusProductService;
import com.hn.springbootmobilestore.service.user.UserService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class MainController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ManufacturerService manufacturerService;

    @Autowired
    private StatusProductService statusProductService;

    @GetMapping("/")
    public String viewHome(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "products";
    }

    @GetMapping("/detail")
    public String viewDetail(@RequestParam("id")Integer id, Model model) {
        Product product = productService.findByProductID(id);
        model.addAttribute("product", product);
        return "detail";
    }

    @GetMapping("/viewAddProduct")
    public String viewNewProduct(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "newProduct";
    }

    @GetMapping("/addProduct")
    public String addNewProduct(@ModelAttribute("product")Product product){
        Category category = categoryService.findByName(product.getCategory().getName());
        Manufacturer manufacturer = manufacturerService.findByName(product.getManufacturer().getName());
        StatusProduct statusProduct = statusProductService.findByName(product.getStatusProduct().getName());
        product.setCategory(category);
        product.setManufacturer(manufacturer);
        product.setStatusProduct(statusProduct);
        product.setImage("../image/" + product.getImage());
        productService.save(product);
        return "products";
    }

    @GetMapping("/cart")
    public String viewCart(HttpSession session, HttpServletRequest request){
        session = request.getSession();
        CartObject cart = (CartObject) session.getAttribute("CART");
        if(cart == null){
            cart = new CartObject();
        }
        session.setAttribute("CART", cart);
        return "cart";
    }

    @GetMapping("/addToCart")
    public String addToCart(@RequestParam("id")Integer id, HttpSession session, HttpServletRequest request){
        session = request.getSession();
        CartObject cart = (CartObject) session.getAttribute("CART");
        if(cart == null){
            cart = new CartObject();
        }
        Product product = productService.findByProductID(id);
        cart.addItemToCart(product);
        session.setAttribute("CART", cart);
        return "redirect:/";
    }

    @GetMapping("/removeItemCart")
    public String removeItemCart(@RequestParam("id")Integer id, HttpSession session, HttpServletRequest request){
        session = request.getSession();
        CartObject cart = (CartObject) session.getAttribute("CART");
        if(cart != null){
            cart.removeItemCart(id);
        }
        session.setAttribute("CART", cart);
        return "redirect:/cart";
    }

    @GetMapping("/clearCart")
    public String clearCart(HttpServletRequest request, HttpSession session){
        session = request.getSession();
        session.removeAttribute("CART");
        return "redirect:/cart";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/403")
    public String accessDenied() {
        return "403";
    }

    @GetMapping("/loginPage")
    public String getLogin() {
        return "login";
    }



}
