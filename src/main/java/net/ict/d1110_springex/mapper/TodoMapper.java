package net.ict.d1110_springex.mapper;

import net.ict.d1110_springex.domain.TodoVO;

public interface TodoMapper {

    String getTime();

    void insert(TodoVO vo);
}
