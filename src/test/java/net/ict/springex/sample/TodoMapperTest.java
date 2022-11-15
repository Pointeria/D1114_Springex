package net.ict.springex.sample;

import lombok.extern.log4j.Log4j2;
import net.ict.d1110_springex.domain.TodoVO;
import net.ict.d1110_springex.dto.TodoDTO;
import net.ict.d1110_springex.mapper.TodoMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoMapperTest {

    @Autowired(required = false)
    private TodoMapper tM;

    @Test
    public void testTime() {
        log.info(tM.getTime());
    }

    @Test
    public void testInsert() {
        TodoVO tVO = TodoVO.builder().
                title("spring test").
                dueDate(LocalDate.now()).
                writer("ict05").
                build();
        tM.insert(tVO);
    }

    @Test
    public void testSelectAll() {
        List<TodoVO> list = tM.selectAll();
        list.forEach(vo -> log.info(vo));
    }

    @Test
    public void testDelete() {
        tM.delete((long)2);
    }

    @Test
    public void testUpdate() {
        TodoVO tVO = TodoVO.builder().
                tno(Long.valueOf("10")).
                title("update test").
                dueDate(LocalDate.now()).
                writer("ict05").
                build();
        tM.update(tVO);
    }

    @Test
    public void testSelectOne() {
        TodoVO list = tM.selectOne((long)2);
        log.info(list);
    }

}
