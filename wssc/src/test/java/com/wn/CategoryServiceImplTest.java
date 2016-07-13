package com.wn;
import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.it.shop.model.Category;
import com.it.shop.service.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations="/applicationContext.xml")  
public class CategoryServiceImplTest {  
  
    @Resource  
    private CategoryService categoryService;  
  
    @Test  
    public void testQueryJoinAccount() {  
        for(Category c : categoryService.queryJoinAccount("",1,2)) { //显示第一页，每页2条数据  
            System.out.println(c + "," + c.getAccount());  
        }  
    }  
} 