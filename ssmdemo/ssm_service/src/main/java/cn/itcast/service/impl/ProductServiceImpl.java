package cn.itcast.service.impl;

import cn.itcast.dao.ProductDao;
import cn.itcast.domain.Product;
import cn.itcast.service.ProductService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao dao;

    /*@Override
    public List<Product> findAll() {
        return dao.findAll();
    }*/

    @Override
    public List<Product> findAll(int size,int page) {
        PageHelper.startPage(size,page);
        return dao.findAll();
    }

    @Override
    public void save(Product product) {
        dao.save(product);
    }
}
