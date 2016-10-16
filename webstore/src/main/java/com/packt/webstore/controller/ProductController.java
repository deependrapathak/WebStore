package com.packt.webstore.controller;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.packt.webstore.domain.Product;
import com.packt.webstore.service.ProductService;


@Controller
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	ServletContext servletContext;
	@InitBinder
	public void initialiseBinder(WebDataBinder binder){
		binder.setDisallowedFields("unitsInOrder", "discontinued");
		binder.setAllowedFields("productId",
				"name","unitPrice","description","manufacturer",
				"category","unitsInStock", "productImage","condition");
	}
	@RequestMapping()
	public String list(Model model){
	model.addAttribute("products", productService.getAllProducts());
		return "products";
		
	}
	@RequestMapping("/all")
	public String allProduct(Model model){
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}
	@RequestMapping("/{category}")
	public String getProductsByCategory(Model model,@PathVariable("category") String productCategory){
		model.addAttribute("products", productService.getProductsByCategory(productCategory));
		return "products";
	}
	
	@RequestMapping("/product")
	public String getProductById(@RequestParam("id") String productId,Model model){
		
		model.addAttribute("product", productService.getProductById(productId));
		return "product";
	}
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String getAddNewProductForm(Model model,@ModelAttribute("newProduct")Product newProduct){
		//Product newProduct=new Product();
		//model.addAttribute("newProduct", newProduct);
		return "addProduct";
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") Product newProduct,BindingResult result){
		String[] suppressedFields=result.getSuppressedFields();
		if(suppressedFields.length>0){
			throw new RuntimeException("Attempting to bind disallowed fields: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		MultipartFile productImage=newProduct.getProductImage();
		String rootDirectory=servletContext.getRealPath("/");
		if(productImage!=null &&!productImage.isEmpty()){
			try{
				productImage.transferTo(new File(rootDirectory+"resources\\images\\"+newProduct.getProductId()+".png"));
			}
			catch(Exception e){
				throw new RuntimeException("Product Image save failed",e);
			}
		}
		productService.addProduct(newProduct);
		return "redirect:/products";
	}
	@RequestMapping("/filter/{ByCriteria}")
	public String getProductsByFilter(@MatrixVariable(pathVar="ByCriteria") Map<String, List<String>> filterParams,Model model){
		model.addAttribute("products", productService.getProductsByFilter(filterParams));
		return "products";
	}
	
	

}
