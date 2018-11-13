package com.wr.mapper;

import com.wr.entity.Customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 王睿 on 2018/5/27.
 */
public interface CustomerMapper {
    void save(Customer customer);

    int findLastId();

    int selectCount();

    List<Customer> findByPage(HashMap<String,Object> map);

    List<Customer> findCondition(Map<String,Object> conMap);

    int delete(int c_id);

    Customer findById(int c_id);

    int update(Customer customer);
}
