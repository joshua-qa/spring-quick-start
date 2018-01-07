package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// xml 설정, 어노테이션 설정 모두 해당 클래스에 기본 생성자는 있어야 한다.
// 그리고 클라이언트가 요청하는 것을 위해서 아이디 설정이 필요하다. (스프링 컨테이너가 생성한 객체를 요청하는 것)
@Component("tv")
public class LgTV implements TV {

    // 스프링 컨테이너는 멤버 변수 위에 붙은 Autowired 어노테이션을 확인하는 순간 해당 변수의 타입을 체크한다.
    // 그리고 그 타입의 객체가 메모리에 존재하는지를 확인한 후에 그 객체를 변수에 주입한다.
    // (만약 존재하지 않으면 NoSuchBeanDefinitionException 발생)
    @Autowired
    // 동일한 타입의 객체 2개 이상이 Component로 세팅되어 있는데 Autowired로 주입 시도하면 예외가 발생한다.
    // 무엇을 주입해야할지 모르기 때문이고, 이런 경우에는 Qualifier로 주입할 항목 이름을 세팅
    @Qualifier("apple")
    private Speaker speaker; // 해당 유형의 객체가 반드시 XML 이나 Component Annotation 으로 세팅되어 있어야 한다.

    public LgTV() {
        System.out.println("===> LgTV 객체 생성");
    }

    public void powerOn() {
        System.out.println("LgTV---전원 켠다.");
    }

    public void powerOff() {
        System.out.println("LgTV---전원 끈다.");
    }

    public void volumeUp() {
        speaker.volumeUp();
    }

    public void volumeDown() {
        speaker.volumeDown();
    }
}
