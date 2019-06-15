package cn.itcast.service;

import cn.itcast.domain.Orders;
import org.springframework.core.annotation.Order;

import java.util.List;

public interface OrderService {


    public List<Orders> findAll(int page,int size);
}
