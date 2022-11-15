package net.ict.d1110_springex.service;

import net.ict.d1110_springex.domain.TodoVO;
import net.ict.d1110_springex.dto.TodoDTO;

import java.util.List;

public interface TodoService {

    void register(TodoDTO dto);

    List<TodoDTO> getAll();  //메소드명을 다르게 쓰는게 좋다

    TodoDTO getOne(Long tno);

    void delete(Long tno);

    void modify(TodoDTO dto);
}
