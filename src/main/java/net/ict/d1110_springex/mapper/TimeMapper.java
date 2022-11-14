package net.ict.d1110_springex.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

    @Select("select now()") // Mapper interface. @select 안에 SQL문 입력. 세미콜론(;) 없음 주의!
    //Bean 설정해줘야지만 myBatis에 전달
    String getTime();
}
