package test;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;


@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"}) 
public class TestM {
	private Logger logger = Logger.getLogger(TestM.class);  
   private ApplicationContext ac = null;  
     @Resource
//    	@Before
//	  public static void before() {  
//	      ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");  
//	      testService = (TestService) ac.getBean("testService");  
//	  }  
   @Test
    public void test1() {  
//        Company cp = testService.get(8);  
        // System.out.println(user.getUserName());  
        // logger.info("值："+user.getUserName());  
//        logger.info(JSON.toJSONString(cp)); 
    }  
    

}
