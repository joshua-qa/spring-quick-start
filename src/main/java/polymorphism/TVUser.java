package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
    public static void main(String[] args) {
        // 1. Spring 컨테이너를 구동한다.
        AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

        // 2. Spring 컨테이너로부터 필요한 객체를 요청(Lookup) 한다.
        // bean scope 설정을 prototype 으로 지정하면 해당 bean이 요청될 때마다 매번 새로운 객체를 생성해서 반환한다.
        TV tv = (TV)factory.getBean("tv"); // initMethod 호출
        tv.powerOn();
        tv.volumeUp();
        tv.volumeDown();
        tv.powerOff();

        // 3. Spring 컨테이너를 종료한다.
        factory.close();
        // destroyMethod 호출
    }
}
