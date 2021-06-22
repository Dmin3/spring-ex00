package core.test3;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // 우선적으로 등록이 된다.
public class FireSword implements Sword {

}
