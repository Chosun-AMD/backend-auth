package com.amd.backend.Domain.User.DTO;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * 응답 데이터를 전달할 때 사용되는 DTO입니다.
 * @param <T>
 * @aythor : 황시준
 * @since : 1.0
 */
public class ResponseDTO<T> {
    private boolean success;

    @JsonIgnore
    private HttpStatus status;
    private T data;
    private List<String> errorMessages;

    public static <T> ResponseDTOBuilder<T> builder(){
        return new ResponseDTOBuilder();
    }

    @JsonGetter
    public int getStatus(){
        return this.status.value();
    }

    public boolean isSuccess(){
        return this.success;
    }

    public T getData(){
        return this.data;
    }

    public List<String> getErrorMessages(){
        return this.errorMessages;
    }

    public ResponseDTO(){

    }

    public ResponseDTO(boolean success, HttpStatus status, T data, List<String> errorMessages){
        this.success = success;
        this.status = status;
        this.data = data;
        this.errorMessages = errorMessages;
    }
    public static class ResponseDTOBuilder<T> {
        private boolean success;
        private HttpStatus status;
        private T data;
        private List<String> erroeMessage;


        public ResponseDTOBuilder<T> success(boolean success) {
            this.success = success;
            return this;
        }

        public ResponseDTOBuilder<T> status(HttpStatus status) {
            this.status = status;
            return this;
        }

        public ResponseDTOBuilder<T> data(T data) {
            this.data = data;
            return this;
        }

        public ResponseDTOBuilder<T> errorMessages(List<String> errorMessages) {
            this.erroeMessage = errorMessages;
            return this;
        }

        public ResponseDTO<T> build() {
            return new ResponseDTO(this.success, this.status, this.data, this.erroeMessage);
        }

        public String toString() {
            return "ResponseDTO.ResponseDTOBuilder(success=" + this.success + ", status = " + this.status + ", data = " + this.data + " , erroeMessages = " + this.erroeMessage + ")";
        }
    }
}
