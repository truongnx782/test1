package com.example.demo;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.models.Category;
import com.example.demo.models.Product;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/sell")
public class SellController {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	UserService userService;
	
	//load lên danh mục CATEGORYS
	@ModelAttribute(name = "CATEGORYS")
	public List<Category> getAllCategory() {
		return categoryService.findAll();
	}
	
	
	//màn hình nhập xuất
	@RequestMapping("/ListSell")
	public String ListSell(ModelMap map, HttpSession session) {
		if (session.getAttribute("USERNAME") != null) {
			String username = (String) session.getAttribute("USERNAME");
			map.addAttribute("PRODUCT", productService.findAllByUsername(username));
			return "Sell";
		} else {
			return "redirect:/user/login";
		}
	}
	
	
	//lọc
	@RequestMapping("/search/{id}")
	public String search(@PathVariable("id") Long id, ModelMap map, HttpSession session) {
		if (id == null) {
			return ListSell(map, session); // Gọi lại phương thức list() để hiển thị danh sách người dùng
		}
		String username = (String) session.getAttribute("USERNAME");
		List<Product> search = productService.findByCategory(username,id);
		map.addAttribute("PRODUCT", search);
		return "Sell";
	}

	
	//xuat
	@GetMapping("/xuat/{productId}/{query}")
	public String handleProductExport(
	    @PathVariable("productId") Long productId, 
	    @PathVariable("query") int query ,ModelMap map , RedirectAttributes redirectAttributes) {
		Optional<Product> pro = productService.findById(productId);
		Product updateQuantity  = pro.get();
		int bandau =updateQuantity.getQuantity();
		if(query>updateQuantity.getQuantity()||query<0) {
	        redirectAttributes.addFlashAttribute("ERROR", "Giá trị xuất không thoả mãn");
			map.addAttribute("ERROR", "Giá trị xuất không thoả mãn ");

			  return "redirect:/sell/ListSell"; 
		}
		int tinh = bandau-query;
		updateQuantity.setQuantity(tinh);
		productService.save(updateQuantity);
	    System.out.println("Product ID: " + productId);
	    System.out.println("xuat");
	    System.out.println("Query: " + query);
	    return "redirect:/sell/ListSell";
	}
	
	
	//nhap
	@GetMapping("/nhap/{productId}/{query}")
	public String nhap(
	    @PathVariable("productId") Long productId, 
	    @PathVariable("query") int query, ModelMap map,RedirectAttributes redirectAttributes) {
		Optional<Product> pro = productService.findById(productId);
		Product updateQuantity  = pro.get();
		int bandau =updateQuantity.getQuantity();
		if(query<0) {
	        redirectAttributes.addFlashAttribute("ERROR", "Giá trị nhập không thoả mãn");

			  return "redirect:/sell/ListSell"; 
		}
		int tinh = bandau+query;
		updateQuantity.setQuantity(tinh);
		productService.save(updateQuantity);
	    System.out.println("Product ID: " + productId);
	    System.out.println("nhap");
	    System.out.println("Query: " + query);
	    return "redirect:/sell/ListSell";
	}
	@RequestMapping("/tets")
	public String test() {
		return"role/staff";
	}

}
