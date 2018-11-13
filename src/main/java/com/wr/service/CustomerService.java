package com.wr.service;

import com.wr.entity.Customer;
import com.wr.entity.PageBean;

import java.util.Map;

/**
 * Created by 王睿 on 2018/5/27.
 */
public interface CustomerService {
    void save(Customer customer);
    int findLastId();

    // 这里要手动设置为pageBean
    PageBean<Customer> findByPage(int pageCode, int pageSize, Map<String,Object> conMap);

    int delete(int c_id);

    Customer findById(int c_id);

    int update(Customer customer);
}
