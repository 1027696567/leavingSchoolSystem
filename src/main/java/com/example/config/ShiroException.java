package com.example.config;

import com.example.model.Result;
import com.example.model.ResultCode;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class ShiroException {

    @ExceptionHandler(AuthorizationException.class)
    public Result authorizationException (){
        return Result.failure(ResultCode.PERMISSION_NO_ACCESS);
    }

     @ExceptionHandler(UnauthenticatedException.class)
    public Result authenticatedException(){
         return Result.failure(ResultCode.USER_NOT_LOGGED_IN);
     }

     @ExceptionHandler(LockedAccountException.class)
    public Result lockedAccountException(){
        return Result.failure(ResultCode.USER_ACCOUNT_FORBIDDEN);
     }
     @ExceptionHandler(UnknownAccountException.class)
    public Result unknownAccountException(){
        return Result.failure(ResultCode.USER_LOGIN_ERROR);
     }
     @ExceptionHandler(IncorrectCredentialsException.class)
    public Result incorrectCredentialsException(){
        return Result.failure(ResultCode.USER_LOGIN_ERROR);
     }
/*    @ExceptionHandler(Exception.class)
    public String handleException(Exception e){
        return e.getMessage()+"系统异常!";
    }
*/
}
