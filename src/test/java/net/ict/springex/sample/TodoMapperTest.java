package net.ict.springex.sample;

import lombok.extern.log4j.Log4j2;
import net.ict.d1110_springex.domain.TodoVO;
import net.ict.d1110_springex.dto.PageRequestDTO;
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

    @Test
    public void testPage() {
        PageRequestDTO dto = PageRequestDTO.builder().
                    page(2).
                    size(10).build();
        List<TodoVO> voList = tM.selectList(dto);
        voList.forEach(vo -> log.info(vo));
    }

    @Test
    public void testSelectSearch() {
        PageRequestDTO dto = PageRequestDTO.builder().
                page(1).
                size(1).
                types(new String[]{"t","w"}).
                keyword("스프링").
                finished(true).
                from(LocalDate.of(2022,11,14)).
                to(LocalDate.of(2022,12,1)).
                build();
        List<TodoVO> voList = tM.selectList(dto);
        voList.forEach(vo -> log.info(vo));
        log.info(tM.getCount(dto));
    }

}
