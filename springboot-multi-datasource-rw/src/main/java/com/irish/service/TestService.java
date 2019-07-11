package com.irish.service;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.irish.anno.DataSource;
import com.irish.constant.DataSourceType;
import com.irish.dao.MemberDao;
import com.irish.model.Member;

@Component
public class TestService{
 
    @Autowired
    private  MemberDao  memberDao;
 
    @DataSource(DataSourceType.SLAVE)
    public String save() {
    	Member member = new Member().withId(201L).withUsername("zhangsan").withNickname("张三")
    			.withCreateTime(new Date());
    	memberDao.insert(member);
        return null;
    }
 
   
    @DataSource(DataSourceType.MASTER)
    public String query() {
    	Member member = this.memberDao.selectByPrimaryKey(201L);
    	System.out.println(member);
        return null;
    }
}