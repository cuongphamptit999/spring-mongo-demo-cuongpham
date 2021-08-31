package vn.ptit.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.ptit.documents.Product;
import vn.ptit.repositories.CategoryRepository;
import vn.ptit.repositories.ProductRepository;

@Controller
public class HomeController {
	@Autowired CategoryRepository categoryRepository;
	@Autowired ProductRepository productRepsitory;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model, HttpServletRequest req, HttpServletResponse resp) {
		
		model.addAttribute("categories", categoryRepository.findAll());
		model.addAttribute("productWallets", productRepsitory.findByCategoryId("612618e2d584622e45640131"));
		model.addAttribute("productBackpacks", productRepsitory.findByCategoryId("612618a3d584622e45640130"));
		
		return "index";
	}
}
