package cn.itcast.service;


import cn.itcast.domain.Product;

import java.util.List;

public interface ProductService {

    public List<Product> findAll(int size,int page);

    void save(Product product);
}
