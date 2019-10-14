package com.thingjs.soho.common;

import com.thingjs.soho.common.Result;
import com.thingjs.soho.common.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.List;

/**
 * @author mumh@2423528736@qq.com
 * @date 2019/10/14 14:17
 */
@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

    /**
     * 自定义统一异常返回
     * @param e
     * @return
     */
    @ExceptionHandler({Exception.class})    /**申明捕获那个异常类*/
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result test(Exception e) {
        log.error(e.getMessage(), e);
        return Result.instanceFailResult("自定义异常返回");
    }

//    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public Result illegalParamsExceptionHandler(MethodArgumentNotValidException ex) {
//        BindingResult bindingResult = ex.getBindingResult();
//        FieldError fieldError = bindingResult.getFieldError();
//        return processBindingError(fieldError);
//    }
//
//    @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class})
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public Result illegalParamsExceptionHandler(MethodArgumentTypeMismatchException ex) {
//        log.error("Error code -10001: {}", ex.getMessage());
//        return Result.instanceResult(ResultCodeEnum.PARAM_ERROR);
//    }
//
//    @ExceptionHandler(value = {NoHandlerFoundException.class})
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public Result noHandlerFoundException(Exception ex) {
//        log.error("Error code 404: {}", ex.getMessage());
//        return Result.instanceResult(ResultCodeEnum.NOT_RESOURCE,"Resource Not Found");
//    }
//
//    @ExceptionHandler(value = {HttpMediaTypeNotSupportedException.class})
//    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
//    public Result handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex) {
//        StringBuilder builder = new StringBuilder();
//        builder.append(ex.getContentType());
//        builder.append(" media type is not supported. Supported media types are ");
//        List<MediaType> typeList = ex.getSupportedMediaTypes();
//        for (MediaType type : typeList) {
//            builder.append(type + ", ");
//        }
//        return Result.instanceResult(ResultCodeEnum.PARAM_ERROR, builder.toString());
//    }
//
//    @ExceptionHandler(value = {HttpRequestMethodNotSupportedException.class})
//    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
//    public Result httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
//        log.error("Error code 405: {}", ex.getMessage());
//        return Result.instanceResult(ResultCodeEnum.METHOD_NOT_SUPPORTED, ex.getMessage());
//    }
//
//    @ExceptionHandler(value = {Exception.class})
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public Result unknownException(Exception ex) {
//        log.error("Error code 500：{}", ex);
//        return Result.instanceResult(ResultCodeEnum.UNKNOWN_EXCEPTION, ex.getMessage());
//    }
//
//    /**
//     * 处理错误编码
//     *
//     * @param fieldError
//     * @return
//     */
//    private Result processBindingError(FieldError fieldError) {
//        String code = fieldError.getCode();
//        log.info(fieldError.getField() + ":" + code);
//        switch (code) {
//            case "NotEmpty":case "NotBlank":case "NotNull":case "Pattern":case "Min":
//            case "Max":  case "Length":case "Range":case "Size":case "Email":
//            case "Digits":
//                return Result.instanceFailResult(ResultCodeEnum.PARAM_NOT_EMPTY);
//            default:
//                return Result.instanceFailResult(ResultCodeEnum.SYSTEM_ERROR);
//        }
//    }

}
