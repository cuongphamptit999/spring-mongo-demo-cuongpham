package vn.ptit.controllers;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.ptit.documents.Product;
import vn.ptit.repositories.ProductRepository;
import vn.ptit.services.ProductServices;
import vn.ptit.ultils.AjaxResponse;

@RestController
@RequestMapping("/rest/api")
public class AjaxController {
	@Autowired
	ProductServices productServices;
	
	@Autowired
	ProductRepository productRepository;

	

}
