package net.ict.d1110_springex.mapper;

//XML로 SQL분리방법 1. Mapper interface 메소드 선언 -> resources.xml 생성
public interface TimeMapper2 {

    //java.lang.String getNow();  원래 java.lang.입력돼야하나 기본 default니까 생략
    String getNow();
}
