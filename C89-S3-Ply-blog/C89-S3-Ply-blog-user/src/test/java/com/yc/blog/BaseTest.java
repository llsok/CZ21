package com.yc.blog;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.yc.blog.bean.Category;
import com.yc.blog.bean.CategoryExample;
import com.yc.blog.dao.CategoryMapper;

@SpringBootTest
public class BaseTest {
	
	@Resource
	private CategoryMapper cm;
	
	@Test
	void test1() {
		
		Category c = new Category();
		c.setName("测试");
		c.setSort(99);
		// 新增
		cm.insert(c);
		System.out.println("自增列的主键值是："+c.getId());
		c.setName("新的测试");
		// 修改所有字段
		cm.updateByPrimaryKey(c);
		// 修改非空字段
		cm.updateByPrimaryKeySelective(c);
		// 删除
		cm.deleteByPrimaryKey(c.getId());
		// 根据主键查
		cm.selectByPrimaryKey(1);
		// 根据实体对象查
		// 动态的构建条件
		CategoryExample ce = new CategoryExample();
		// Criteria 条件对象，支持链式调用
		ce.createCriteria().andNameEqualTo("test") // name = 'test'
			.andNameLike("%test%") // name like '%test%'
			.andSortGreaterThan(2)   // sort > 2
			.andSortGreaterThanOrEqualTo(3)  // sort >= 3
			.andIdIsNotNull();   // id not null
		ce.or(ce.createCriteria()
				.andIntroduceEqualTo("随便")
				.andIdBetween(1, 2));	
		// 条件查询
		cm.selectByExample(ce);
		// 条件删除
		cm.deleteByExample(ce);
		// 条件更新
		cm.updateByExample(c, ce);
		
	}
	

}
