package com.example.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
	@Autowired
	MessageSource messageSource;
	
	@RequestMapping({ "/", "/index" })
	public String index(@ModelAttribute("index") Form form, Model model) {
		return "top";
	}

	@RequestMapping(value = "/result", params = "search", method = RequestMethod.POST)
	public String result(@Validated @ModelAttribute("index") Form form, BindingResult bindingResult, Model model) {
		List<Product> productList = null;
		if (bindingResult.hasErrors()) {
			return "top";
		}
		//    	String btn = req.getParameter("btn");

		//    	if(btn.equals("search")) {
		if(!form.getProductName().equals("") && form.getPrice() == null) {

			productList = productService.findByName(form.getProductName());
		} else if (form.getProductName().equals("") && form.getPrice() != null) {
			System.out.println("priceだけ入力されたとき");
			productList = productService.findByPrice(form.getPrice());
		} else if (!form.getProductName().equals("") && form.getPrice() != null) {
			productList = productService.findByNameAndPrice(form.getProductName(), form.getPrice());
		} else {
			return "top";
			//        		productList = productService.findAll();
		}
		model.addAttribute("productList", productList);
		if(productList != null) {
			return "searchResult";
		} else {
			String errMsg = messageSource.getMessage("select.error", null, Locale.getDefault());
			model.addAttribute("msg", errMsg);
			return "top";
		}
		//    	} else {
		//    		if (bindingResult.hasErrors()) {
		//                return "top";
		//            } else {
		//            	productService.insert(form.getProductName(), form.getPrice());
		//            	return "insertResult";
		//            }
		//    	}

	}

	@RequestMapping(value = "/result", params = "insert", method = RequestMethod.POST)
	public String insert(@Validated @ModelAttribute("index") Form form, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "top";
		} else {
			productService.insert(form.getProductName(), form.getPrice());
			return "insertResult";
		}
	}

}
