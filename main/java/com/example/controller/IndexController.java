package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.controller.form.Form;
import com.example.entity.Product;

@Controller
public class IndexController {

	@RequestMapping("/index")
	public String index(@ModelAttribute("index") Form form, Model model) {
		// プルダウンの内容を作成
		// (実際はDaoを使ってDBから取得)
		List<Product> productList = new ArrayList<>();
		productList.add(new Product(101, "鉛筆", 50));
		productList.add(new Product(102, "消しゴム", 100));

		// プルダウンの内容をmodelにセット
		model.addAttribute("productList", productList);
		// 入力画面へ
		return "index";
	}

	@RequestMapping(value="/result", method=RequestMethod.POST)
	public String post(@ModelAttribute("index") Form form, Model model) {

		int id = form.getId();
		System.out.println("id = " +  id);
//		model.addAttribute("msg", 
//				form.getName() + "さんが下記の商品を選択しました。");
		model.addAttribute("name", form.getName());
//		model.addAttribute("id", form.getId());

		Product product = null;
		switch (id) {
		case 101:
			product = new Product(101, "鉛筆", 50);
			break;
		case 102:
			product = new Product(102, "消しゴム", 100);
			break;
		}

		// productオブジェクトをmodelにセット
		model.addAttribute("product", product);

		// 結果画面へ
		return "result";
	}
}