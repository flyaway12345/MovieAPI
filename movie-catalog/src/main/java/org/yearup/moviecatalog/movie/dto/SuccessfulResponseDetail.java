package org.yearup.moviecatalog.movie.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuccessfulResponseDetail {

    private int code;
    private String message;
    private Object data;

    public SuccessfulResponseDetail() {}

    public SuccessfulResponseDetail(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public SuccessfulResponseDetail(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


}
