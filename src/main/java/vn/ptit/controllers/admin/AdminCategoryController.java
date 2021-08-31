package vn.ptit.controllers.admin;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.ptit.documents.Category;
import vn.ptit.repositories.CategoryRepository;
import vn.ptit.ultils.CreateSlug;

@Controller
public class AdminCategoryController {
	@Autowired CategoryRepository categoryRepository;

	@RequestMapping(value = { "/admin/add-category" }, method = {RequestMethod.GET})
	public String addCategory(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		
		model.addAttribute("category", new Category());
		return "admin/add_category";
	}
	
	@RequestMapping(value = { "/admin/add-category" }, method = {RequestMethod.POST})
	public String addCategory1(@ModelAttribute("category") Category category, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		category.setDateCreate(new Date());
		category.setSlug(new CreateSlug().createSlug(category.getName()));
		category = categoryRepository.save(category);
		System.out.println(category.getId());
		return "admin/add_category";
	}


}
