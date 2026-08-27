package com.springboot.contact_manager.exception;

import com.springboot.contact_manager.constants.StatusConstants;
import com.springboot.contact_manager.dto.StatusDetail;
import com.springboot.contact_manager.dto.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<BaseResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        StatusDetail statusDetail = new StatusDetail();
        statusDetail.setCode(StatusConstants.ERROR);
        statusDetail.setMessage(ex.getMessage());

        BaseResponse response = new BaseResponse();
        response.setStatus(StatusConstants.ERROR);
        response.setStatusDetail(statusDetail);

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }


}
