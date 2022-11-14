package net.ict.springex.sample;

import lombok.extern.log4j.Log4j2;
import net.ict.d1110_springex.mapper.TimeMapper;
import net.ict.d1110_springex.mapper.TimeMapper2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TimeMapperTest {

//    @Autowired(required = false) //매칭되는 bean이 없어도 exception 발생하지 않고 자동주입 실행하지 않는다. 책p122 참고.
//    private TimeMapper tM;
//
//    @Test
//    public void testGetTime() {
//        log.info(tM.getTime());
//    }

    @Autowired(required = false)
    private TimeMapper2 tM2;

    @Test
    public void testNow() {
        log.info(tM2.getNow());
    }
}
