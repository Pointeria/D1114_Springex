package net.ict.d1110_springex.dto;
/*페이지 처리 요청이 올 때 처리하는 DTO
    현재 페이지 번호 page
    한 페이지 당 데이터 수 size
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.Arrays;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {

    @Builder.Default
    @Min(value = 1)
    @Positive //양수값만 사용하겠다
    private int page = 1;

    @Builder.Default
    @Min(value = 10) //최소10개
    @Max(value = 100) //최대100개 처리하겠다
    @Positive
    private int size = 10;

    public int getSkip() { //전 단계(preview)할 수 있는 메소드=limit 한계 극복
        return (page-1)*10;
    }

    private String[] types;
    private String keyword;
    private boolean finished;
    private LocalDate from;
    private LocalDate to;

    public boolean checkType(String type){
        if(types == null || types.length == 0){
            return false;
        }
        return Arrays.stream(types).anyMatch(type::equals);
    }

    public String getLink(){
        StringBuilder builder = new StringBuilder();
        builder.append("page=" + this.page);
        builder.append("&size=" + this.size);
        if (finished){
            builder.append("&finished=on");
        }
        if (types != null && types.length > 0){
            for (int i = 0; i < types.length; i++){
                builder.append("&types=" + types[i]);
            }
        }
        if (keyword != null){
            try {
                builder.append("&keyword=" + URLEncoder.encode(keyword, "UTF-8"));
            }catch (UnsupportedEncodingException e){
                e.printStackTrace();
            }
        }
        if(from != null){
            builder.append("&from=" + from.toString());
        }
        if(to != null){
            builder.append("&to=" + to.toString());
        }

        return builder.toString();

    }

}