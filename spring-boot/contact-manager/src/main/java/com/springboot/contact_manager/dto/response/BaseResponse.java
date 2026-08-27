package com.springboot.contact_manager.dto.response;

import com.springboot.contact_manager.dto.StatusDetail;
import lombok.Data;

@Data
public class BaseResponse {

    private int status;
    private StatusDetail statusDetail;

}
