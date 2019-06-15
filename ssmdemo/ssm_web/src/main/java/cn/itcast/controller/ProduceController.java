package cn.itcast.controller;

import cn.itcast.domain.Product;
import cn.itcast.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProduceController {

    @Autowired
    private ProductService productService;

    /*@RequestMapping("findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Product> products = productService.findAll();
        mv.addObject("productList",products);
        mv.setViewName("product-list");
        return mv;
    }*/

    @RequestMapping("findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")int page,@RequestParam(name = "size",required = true,defaultValue = "4")int size){
        ModelAndView mv = new ModelAndView();
        List<Product> productList = productService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(productList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("product-page-list");
        return mv;


    }

    @RequestMapping("save.do")
    public String save(Product product){
        productService.save(product);
        return "redirect:findAll.do";
    }
}
