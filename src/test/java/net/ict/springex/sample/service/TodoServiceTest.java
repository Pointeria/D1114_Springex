package net.ict.springex.sample.service;

import lombok.extern.log4j.Log4j2;
import net.ict.d1110_springex.dto.TodoDTO;
import net.ict.d1110_springex.service.TodoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoServiceTest {

    @Autowired(required = false)
    private TodoService tS;

    @Test
    public void testRegist() {
        TodoDTO dto = TodoDTO.builder().
                title("test title").
                dueDate(LocalDate.now()).
                writer("testman").
                build();
        tS.register(dto);
    }
}
