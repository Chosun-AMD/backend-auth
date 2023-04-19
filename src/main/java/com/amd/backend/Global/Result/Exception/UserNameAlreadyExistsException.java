package com.amd.backend.Global.Result.Exception;

import com.amd.backend.Global.Result.Error.ErrorCode;

public class UserNameAlreadyExistsException extends BusinessException{
    public UserNameAlreadyExistsException(){
        super(ErrorCode.USER_NAME_ALREADY_EXISTS);
    }
}
