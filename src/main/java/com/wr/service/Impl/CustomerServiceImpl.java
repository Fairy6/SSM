package com.wr.service.Impl;

import com.wr.entity.Customer;
import com.wr.entity.PageBean;
import com.wr.mapper.CustomerMapper;
import com.wr.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 王睿 on 2018/5/27.
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    /**
     * 注入
     */
    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 客户信息保存的方法
     */
    public void save(Customer customer) {
        customerMapper.save(customer);
    }
    /**
     * 查询最后customer表中最后一个主键值，那么下一个默认就是新增客户的主键值
     */
    public int findLastId() {
        return customerMapper.findLastId();
    }

    /**
     * 分页查询的方法
     */
    public PageBean<Customer> findByPage(int pageCode, int pageSize, Map<String, Object> conMap) {
        HashMap<String,Object> map = new HashMap<String, Object>();
        PageBean<Customer> pageBean = new PageBean<Customer>();

        //封装当前页
        pageBean.setPageCode(pageCode);
        pageBean.setPagesize(pageSize);

        // 封装总记录数（从数据库中查询）
        int totalCount = customerMapper.selectCount();
        System.out.println("查询到总的记录数："+totalCount);
        pageBean.setTotalCount(totalCount);

        //封装总页数
        double tc = totalCount;
        Double num = Math.ceil(tc/pageSize);   //向上取整
        pageBean.setTotalPage(num.intValue());

        // 设置limit分页查询的起始位置和终止位置
        map.put("start",(pageCode -1)*pageSize);
        map.put("size",pageBean.getPagesize());

        //封装每页显示的数据
        List<Customer> list = customerMapper.findByPage(map);
        pageBean.setBeanList(list);

        // 分页查询功能也要封装显示起始页和终止页
        conMap.put("start",(pageCode - 1) * pageSize);
        conMap.put("size",pageBean.getPagesize());

        //封装
        List<Customer> customerList = customerMapper.findCondition(conMap);
        pageBean.setBeanList(customerList);

        return pageBean;
    }

    /**
     * 根据id删除信息的方法
     */
    public int delete(int c_id) {
        return customerMapper.delete(c_id);
    }

    /**
     * 根据客户id查询客户信息的方法
     */
    public Customer findById(int c_id) {
        return customerMapper.findById(c_id);
    }

    /**
     * 更新客户信息的方法
     */
    public int update (Customer customer) {
        return customerMapper.update(customer);
    }
}
