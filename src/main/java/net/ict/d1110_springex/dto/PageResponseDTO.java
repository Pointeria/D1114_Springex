package net.ict.d1110_springex.dto;
/* PageResponseDTO 기능
    -TodoDTO 목록
    -전체 데이터 수
    -페이지 번호 처리를 위한 데이터(시작/끝 페이지 번호)
*/

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class PageResponseDTO<E> { //<E> : totalObject type 수용 가능
    /*제네릭 이용 이유: 다른 종류 객체를 이용해 pageResponseDTO를 구성할 수 있도록,
        ex 회원정보게시판, 공지사항 페이징 공통 처리를 위해 제너릭<E>로 처리!
     */

    private int page;
    public int size;
    private int total;

    //시작페이지 번호
    private int start;
    //끝 페이지 번호
    private int end;

    //이전 페이지 존재 여부
    private boolean prev;
    //다음 페이지 존재 여부
    private boolean next;

    private List<E> dtoList; //목록 출력 부분

    @Builder(builderMethodName = "withAll") //빌더 이름을 부여하여 그에 따른 책임 및 필수 인자값 명확히한다.
    public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total) {
        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();
        this.total = total;
        this.dtoList = dtoList;
        //시작 페이지 번호, 마지막 페이지 번호 계산
        this.end = (int)(Math.ceil((this.page)/10.0))*10;
        this.start = this.end-9;
        int last = (int)(Math.ceil((total/(double)size)));
        this.end = end>last ? last:end;
        //이전/다음페이지 계산
        this.prev = this.start>1;
        this.next = total > this.end * this.size;
    }
}
