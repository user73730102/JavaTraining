package test.ex3;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex3.MyLife;

public class TestMyLife {
	@Test
	public void testLifeCycle() {
			ApplicationContext Ctx=new ClassPathXmlApplicationContext("ex3-context.xml");
			Ctx.getBean(MyLife.class);
	}
}
