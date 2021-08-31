package vn.ptit.controllers.admin;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import vn.ptit.documents.ImgProduct;
import vn.ptit.documents.Product;
import vn.ptit.repositories.CategoryRepository;
import vn.ptit.repositories.ProductRepository;
import vn.ptit.ultils.CreateSlug;

@Controller
public class AdminProductController {
	@Value("${file.upload.product.path}")
	private String fileProduct;

	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	ProductRepository productRepsitory;
	@Autowired
	Cloudinary cloudinary;

	@RequestMapping(value = { "/admin/add-product" }, method = { RequestMethod.GET })
	public String addProduct(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {

		model.addAttribute("product", new Product());
		model.addAttribute("categories", categoryRepository.findAll());
		return "admin/add_product";
	}

	@RequestMapping(value = "/admin/add-product", method = RequestMethod.POST)
	public String add_laptop(@RequestParam("productImage") MultipartFile[] productImage,
			@ModelAttribute("product") Product product, ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws IllegalStateException, IOException {

		model.addAttribute("categories", categoryRepository.findAll());

		product.setSlug(new CreateSlug().createSlug(product.getName()));
		product.setDateCreate(new Date());

		Map uploadResult = null;

		if (productImage != null && productImage.length > 0) {
			for (MultipartFile multipartFile : productImage) {
				if (multipartFile.getSize() <= 0)
					continue;
				ImgProduct imgProduct = new ImgProduct();

				uploadResult = cloudinary.uploader().upload(multipartFile.getBytes(),
						ObjectUtils.asMap("resource_type", "auto", "folder", "HandBag"));
				imgProduct.setName((String) uploadResult.get("public_id") + '.'
						+ multipartFile.getContentType().substring(multipartFile.getContentType().indexOf('/') + 1));
				product.addImgProduct(imgProduct);
			}
		}

		productRepsitory.save(product);

		return "admin/add_product";
	}

}
