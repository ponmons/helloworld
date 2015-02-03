package test;

import model.domain.People;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		//1단계 - spring framework로 부터 xml 설정 정보 획득
		//2단계 - xml설정 정보로 부터 필요로 하는 객체를 획득 요청 
		//3단계 - 데이터 활용 
		ApplicationContext context =
			    new ClassPathXmlApplicationContext("kodb.xml");
		/*
		People p = context.getBean(People.class);
		System.out.println(p);
		이부분에 뭔가 오류가 있다. 이부분 주석 처리 하니까 실행이 됨*/
		
		People p2 = (People)context.getBean("p2");
		System.out.println(p2.getId()); //영석
		
		
		People p3 = (People)context.getBean("p3");
		System.out.println(p3.getId()); //보라
	}

}


/*http://docs.spring.io/spring/docs/3.2.13.RELEASE/spring-framework-reference/htmlsingle/#beans
  - 5.2.2 Instantiating a container 
 */
