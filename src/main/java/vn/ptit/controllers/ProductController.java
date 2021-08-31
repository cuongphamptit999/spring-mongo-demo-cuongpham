package vn.ptit.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.ptit.repositories.CategoryRepository;
import vn.ptit.repositories.ProductRepository;
import vn.ptit.services.ProductServices;
import vn.ptit.ultils.FilterMap;

@Controller
public class ProductController {
	@Autowired
	ProductRepository productRepsitory;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	ProductServices productServices;

	@RequestMapping(value = { "/all-product" }, method = { RequestMethod.GET })
	public String getAllProduct(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		String material = req.getParameter("material");
		String brand = req.getParameter("brand");
		String sort = req.getParameter("sort");

		if (material != null) {
			model.addAttribute("products", productRepsitory.findByMaterial(material));
			model.addAttribute("material", material);
		}
		else if (brand != null) {
			model.addAttribute("products", productRepsitory.findByBrand(brand));
			model.addAttribute("brand", brand);
		} else if(sort !=null) {
			if(sort.equalsIgnoreCase("low-to-high")) {
				model.addAttribute("products", productServices.findSortProductLowToHigh());
			}
			else model.addAttribute("products", productServices.findSortProductHighToLow());
			model.addAttribute("sort", sort);
		}
		else model.addAttribute("products", productRepsitory.findAll());
		
		model.addAttribute("categories", categoryRepository.findAll());
		return "all_product";
	}

	@RequestMapping(value = { "/all-product/{slug}" }, method = { RequestMethod.GET })
	public String getProductByCate(@PathVariable String slug, ModelMap model, HttpServletRequest req,
			HttpServletResponse resp) {
		model.addAttribute("products", productRepsitory.findByCategoryId(categoryRepository.findBySlug(slug).get(0).getId()));
		model.addAttribute("categories", categoryRepository.findAll());
		return "all_product";
	}
	
	@RequestMapping(value = { "/product-detail/{slug}" }, method = { RequestMethod.GET })
	public String getProductBySlug(@PathVariable String slug, ModelMap model, HttpServletRequest req,
			HttpServletResponse resp) {
		model.addAttribute("product", productRepsitory.findBySlug(slug).get(0));
		model.addAttribute("categories", categoryRepository.findAll());
		return "product_detail";
	}
}
