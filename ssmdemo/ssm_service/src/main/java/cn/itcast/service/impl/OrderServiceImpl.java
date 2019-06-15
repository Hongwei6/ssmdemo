package cn.itcast.service.impl;

import cn.itcast.dao.OrderDao;
import cn.itcast.domain.Orders;
import cn.itcast.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao dao;


    @Override
    public List<Orders> findAll(int page,int size) {
        PageHelper.startPage(page,size);
        return dao.findAll();
    }

}
