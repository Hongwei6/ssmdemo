package cn.itcast.controller;

import cn.itcast.domain.Orders;
import cn.itcast.service.OrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("orders")
public class OrderController {

    @Autowired
    private OrderService service;

    /*@RequestMapping("findAll")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = service.findAll();
        mv.addObject("ordersList",ordersList);
        mv.setViewName("orders-list");
        return mv;
    }*/

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "3") int size)  {
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = service.findAll(page, size);
        PageInfo pageInfo=new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }

}
