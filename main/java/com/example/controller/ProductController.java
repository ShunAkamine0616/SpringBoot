package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.controller.form.Form;
import com.example.entity.Product;
import com.example.service.ProductService;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping({ "/", "/index" })
    public String index(@ModelAttribute("index") Form form, Model model) {
        return "top";
    }

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public String result(@ModelAttribute("index") Form form, HttpServletRequest req, Model model) {
    	List<Product> productList = null;
    	String btn = req.getParameter("btn");
    	
    	if(btn.equals("search")) {
    		if(!form.getProductName().equals("") && form.getPrice() == null) {
        		
        		productList = productService.findByName(form.getProductName());
        	} else if (form.getProductName().equals("") && form.getPrice() != null) {
        		System.out.println("priceだけ入力されたとき");
        		productList = productService.findByPrice(form.getPrice());
        	} else if (!form.getProductName().equals("") && form.getPrice() != null) {
        		productList = productService.findByNameAndPrice(form.getProductName(), form.getPrice());
        	} else {
        		productList = productService.findAll();
        	}
    		model.addAttribute("productList", productList);
            if(productList != null) {
            	return "searchResult";
            } else {
            	model.addAttribute("msg", "対象のデータはありません");
            	return "top";
            }
    	} else {
    		
    		productService.insert(form.getProductName(), form.getPrice());
    		return "insertResult";
    	}
        
    }

}
