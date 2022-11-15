package net.ict.d1110_springex.mapper;

import net.ict.d1110_springex.domain.TodoVO;
import net.ict.d1110_springex.dto.PageReqeustDTO;
import net.ict.d1110_springex.dto.TodoDTO;

import java.util.List;

//개발순서: TodoMapper-xml-TodoService-TodoController-jsp
public interface TodoMapper {

    String getTime();

    void insert(TodoVO vo);

    List<TodoVO> selectAll();

    TodoVO selectOne(Long tno);

    void delete(Long tno);

    void update(TodoVO vo);

    //page 처리
    List<TodoVO> selectList(PageReqeustDTO pageReqeustDTO);
    int getCount(PageReqeustDTO pageReqeustDTO);
}
