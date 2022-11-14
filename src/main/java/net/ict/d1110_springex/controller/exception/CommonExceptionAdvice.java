package net.ict.d1110_springex.controller.exception;

import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Arrays;
//SampleController ex8() 관련

@Log4j2
@ControllerAdvice
/*@ControllerAdvice 없으면 브라우저에서 확인 불가. 공통기능. Advice는 우선순위가 높다.*/
public class CommonExceptionAdvice {

//    @ResponseBody   //ResponseBody 태그 안에서 지정 외 데이터가 입력됐을 때 발동
//    @ExceptionHandler(NumberFormatException.class)
//    public String exceptionNumber(NumberFormatException numberFormatException) {
//        log.error("===============================");
//        log.error(numberFormatException.getMessage());
//        return "numberFormatException!";
//    }

    //범용적 예외처리 방식: 예외처리 최상위 타입인 Exception을 처리하도록 구성하기 exception(Exception exception)
    @ResponseBody   //ResponseBody 태그 안에서 지정 외 데이터가 입력됐을 때 발동
    @ExceptionHandler(Exception.class)
    public String exceptionCommon(Exception exception) {
        log.error("==============err=================");
        log.error(exception.getMessage());
        StringBuffer buffer = new StringBuffer("<ul>");
        buffer.append("<li>" + exception.getMessage() + "</li>");
        Arrays.stream(exception.getStackTrace()).forEach(stackTraceElement -> {
            buffer.append("<li>" + stackTraceElement + "</li>");
        });
        buffer.append("</ul>");
        return buffer.toString();
    }

    //해당 controller 없는 경우
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound() {
        return "custom404";
    }
    //이후 web.xml appServlet에 <init-param> 추가 설정
}
