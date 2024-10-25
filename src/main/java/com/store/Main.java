package com.store;

import com.store.controllers.CategoryController;
import com.store.controllers.CustomerController;
import com.store.controllers.OrderController;
import com.store.controllers.ProductController;
import com.store.models.*;
import com.store.vo.ReportVo;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Category eletronics = new Category("Eletronics");
        Category officce = new Category("Officce");
        Product mobilePhone1 = new Product("Sansung Galaxy J5", new BigDecimal(899.99)
                , "Uma relíquia", eletronics);
        Product mobilePhone2 = new Product("Xiaomi", new BigDecimal(999.99)
                , "Ótimo", eletronics);
        Customer customer1 = new Customer("Josuel", "123456");

        CategoryController.create(eletronics);
        CategoryController.create(officce);
        ProductController.create(mobilePhone1);
        ProductController.create(mobilePhone2);
        CustomerController.create(customer1);

        Customer customerFound = CustomerController.findById(1L);
        Product productFound = ProductController.findById(1L);

        Order order1 = new Order(customerFound);
        order1.addItem(new ItemsOrdered(10, order1, productFound));

        OrderController.create(order1);

        BigDecimal totalValue = OrderController.getTotalValue();
        System.out.println("Total value order1: " + totalValue);

        List<ReportVo> report = OrderController.getReportInformation();
        report.forEach(System.out::println);
        Order orderFound = OrderController.findOrderAndCustomerById(1L);
        System.out.println("Name product for Order: "+ orderFound.getItems().get(0).getProduct().getName());
        System.out.println("Product for parametter: "+ ProductController.getProduct(null, "Sansung Galaxy J5", null).get(0).getName());
        System.out.println("Product for parametter Criteria: " + ProductController.getProductCriteria(null, "Sansung Galaxy J5", null).get(0).getName());

        //Category categoryFound = CategoryController.findById(1L);
        //System.out.println("Category name: " + categoryFound.getName());
        //List<Category> categories = CategoryController.list("Officce");
        //List<Product> products = ProductController.list("Eletronics");
        //categories.forEach(category -> System.out.println("Category: " + category.getName()));
        //products.forEach(product -> System.out.println("Product: " + product.getName()));
        //System.out.println("Price: "+ ProductController.getPriceByName("Xiaomi"));

    }
}