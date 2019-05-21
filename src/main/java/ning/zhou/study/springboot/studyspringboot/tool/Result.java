package ning.zhou.study.springboot.studyspringboot.tool;

import lombok.Builder;
import lombok.Data;

import static java.net.HttpURLConnection.HTTP_INTERNAL_ERROR;
import static java.net.HttpURLConnection.HTTP_OK;

/**
 * @author 周宁
 * @Date 2019-05-17 10:36
 */
@Data
@Builder
public class Result<T> {

    private T result;

    private Integer code;

    private String msg;
    public static <T> Result<T> success() {
        return new ResultBuilder<T>().code(HTTP_OK).msg("success").build();
    }

    public static <T> Result<T> success(T result) {
        return new ResultBuilder<T>().code(HTTP_OK).msg("success").result(result).build();
    }

    public static <T> Result<T> fail(String msg) {
        return new ResultBuilder<T>().code(HTTP_INTERNAL_ERROR).msg(msg).build();
    }

    public static <T> Result<T> fail(Integer code, String msg) {
        return new ResultBuilder<T>().code(code).msg(msg).build();
    }

}
