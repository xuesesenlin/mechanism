package org.ld.mechanism.config.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.ld.mechanism.util.responseResult.ResponseResult;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.exceptions.TemplateInputException;
import org.thymeleaf.exceptions.TemplateProcessingException;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

//import org.hibernate.JDBCException;

/**
 * 全局错误处理
 * LD
 */
@Slf4j
@ControllerAdvice
@ResponseBody
@RestController
public class GlobalExceptionHandler {

    /**
     * 非法参数
     *
     * @param request
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = ParseException.class)
    public ResponseResult<String> parseException(HttpServletRequest request,
                                                 Exception exception) throws Exception {
        exception.printStackTrace();
        log.debug("ERROR::::：" + exception.getLocalizedMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getCause() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getSuppressed()) + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getStackTrace()) + "::::::" + new Date());
        ResponseResult<String> result = new ResponseResult<>();
        result.setSuccess(false);
        result.setMessage("数据转换错误，请确认日期，数字等格式是否正确");
        return result;
    }

    @ExceptionHandler(value = AuthorizationException.class)
    public ResponseResult<String> authorizationException(HttpServletRequest request,
                                                         Exception exception) throws Exception {
        exception.printStackTrace();
        log.debug("ERROR::::：" + exception.getLocalizedMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getCause() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getSuppressed()) + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getStackTrace()) + "::::::" + new Date());
        ResponseResult<String> result = new ResponseResult<>();
        result.setSuccess(false);
        result.setMessage("权限不足或未登录");
        return result;
    }

    /**
     * @param request
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = PropertyReferenceException.class)
    public ResponseResult<String> propertyReferenceException(HttpServletRequest request,
                                                             Exception exception) throws Exception {
        exception.printStackTrace();
        log.debug("ERROR::::：" + exception.getLocalizedMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getCause() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getSuppressed()) + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getStackTrace()) + "::::::" + new Date());
        ResponseResult<String> result = new ResponseResult<>();
        result.setSuccess(false);
        result.setMessage("当前实体类中不存在该属性");
        return result;
    }

    /**
     * 非法参数
     *
     * @param request
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseResult<String> illegalArgumentException(HttpServletRequest request,
                                                           Exception exception) throws Exception {
        exception.printStackTrace();
        log.debug("ERROR::::：" + exception.getLocalizedMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getCause() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getSuppressed()) + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getStackTrace()) + "::::::" + new Date());
        ResponseResult<String> result = new ResponseResult<>();
        result.setSuccess(false);
        result.setMessage("非法参数错误，请确认数据准确性");
        return result;
    }


    /**
     * 不支持的字符集
     *
     * @param request
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = UnsupportedEncodingException.class)
    public ResponseResult<String> unsupportedEncodingException(HttpServletRequest request,
                                                               Exception exception) throws Exception {
        exception.printStackTrace();
        log.debug("ERROR::::：" + exception.getLocalizedMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getCause() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getSuppressed()) + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getStackTrace()) + "::::::" + new Date());
        ResponseResult<String> result = new ResponseResult<>();
        result.setSuccess(false);
        result.setMessage("不支持的字符集，当前方法所采用的字符集为UTF-8");
        return result;
    }


    /**
     * 类型强制转换错误
     *
     * @param request
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = ClassCastException.class)
    public ResponseResult<String> ClassCastException(HttpServletRequest request,
                                                     Exception exception) throws Exception {
//        exception.printStackTrace();
        log.debug("ERROR::::：" + exception.getLocalizedMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getCause() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getSuppressed()) + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getStackTrace()) + "::::::" + new Date());
        ResponseResult<String> result = new ResponseResult<>();
        result.setSuccess(false);
        result.setMessage("类型强制转换错误，请确认数据准确性");
        return result;
    }


    @ExceptionHandler(value = ArrayIndexOutOfBoundsException.class)
    public ResponseResult<String> ArrayIndexOutOfBoundsException(HttpServletRequest request,
                                                                 Exception exception) throws Exception {
//        exception.printStackTrace();
        log.debug("ERROR::::：" + exception.getLocalizedMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getCause() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getSuppressed()) + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getStackTrace()) + "::::::" + new Date());
        ResponseResult<String> result = new ResponseResult<>();
        result.setSuccess(false);
        result.setMessage("数组下标越界错误，请确认数据准确性");
        return result;
    }

    @ExceptionHandler(value = FileNotFoundException.class)
    public ResponseResult<String> FileNotFoundException(HttpServletRequest request,
                                                        Exception exception) throws Exception {
//        exception.printStackTrace();
        log.debug("ERROR::::：" + exception.getLocalizedMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getCause() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getSuppressed()) + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getStackTrace()) + "::::::" + new Date());
        ResponseResult<String> result = new ResponseResult<>();
        result.setSuccess(false);
        result.setMessage("文件未找到错误");
        return result;
    }

    @ExceptionHandler(value = SQLException.class)
    public ResponseResult<String> SQLException(HttpServletRequest request,
                                               Exception exception) throws Exception {
//        exception.printStackTrace();
        log.debug("ERROR::::：" + exception.getLocalizedMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getCause() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getSuppressed()) + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getStackTrace()) + "::::::" + new Date());
        ResponseResult<String> result = new ResponseResult<>();
        result.setSuccess(false);
        result.setMessage("操作数据库错误，请确认数据准确性");
        return result;
    }

    @ExceptionHandler(value = IOException.class)
    public ResponseResult<String> IOException(HttpServletRequest request,
                                              Exception exception) throws Exception {
//        exception.printStackTrace();
        log.debug("ERROR::::：" + exception.getLocalizedMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getCause() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getSuppressed()) + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getStackTrace()) + "::::::" + new Date());
        ResponseResult<String> result = new ResponseResult<>();
        result.setSuccess(false);
        result.setMessage("输入输出错误，请确认数据准确性");
        return result;
    }

    @ExceptionHandler(value = NoSuchMethodException.class)
    public ResponseResult<String> NoSuchMethodException(HttpServletRequest request,
                                                        Exception exception) throws Exception {
//        exception.printStackTrace();
        log.debug("ERROR::::：" + exception.getLocalizedMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getCause() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getSuppressed()) + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getStackTrace()) + "::::::" + new Date());
        ResponseResult<String> result = new ResponseResult<>();
        result.setSuccess(false);
        result.setMessage("方法未找到错误，请确认数据准确性");
        return result;
    }

    @ExceptionHandler(value = OutOfMemoryError.class)
    public ResponseResult<String> OutOfMemoryError(HttpServletRequest request,
                                                   Exception exception) throws Exception {
//        exception.printStackTrace();
        log.debug("ERROR::::：" + exception.getLocalizedMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getCause() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getSuppressed()) + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getStackTrace()) + "::::::" + new Date());
        ResponseResult<String> result = new ResponseResult<>();
        result.setSuccess(false);
        result.setMessage("内存不足错误，请确认数据准确性");
        return result;
    }

    @ExceptionHandler(value = StackOverflowError.class)
    public ResponseResult<String> StackOverflowError(HttpServletRequest request,
                                                     Exception exception) throws Exception {
        //exception.printStackTrace();
        log.debug("ERROR::::：" + exception.getLocalizedMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getCause() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getSuppressed()) + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getStackTrace()) + "::::::" + new Date());
        ResponseResult<String> result = new ResponseResult<>();
        result.setSuccess(false);
        result.setMessage("堆栈溢出错误，请确认数据准确性");
        return result;
    }

    @ExceptionHandler(value = VirtualMachineError.class)
    public ResponseResult<String> VirtualMachineError(HttpServletRequest request,
                                                      Exception exception) throws Exception {
        //exception.printStackTrace();
        log.debug("ERROR::::：" + exception.getLocalizedMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getCause() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getSuppressed()) + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getStackTrace()) + "::::::" + new Date());
        ResponseResult<String> result = new ResponseResult<>();
        result.setSuccess(false);
        result.setMessage("虚拟机错误，请确认数据准确性");
        return result;
    }

//    @ExceptionHandler(value = JDBCException.class)
//    @ResponseBody
//    public String JDBCException(HttpServletRequest request,
//                                Exception exception) throws Exception {
//        //exception.printStackTrace();
//        log.debug("ERROR::::：" + exception.getLocalizedMessage() + "::::::" + new Date());
//        log.debug("ERROR::::：" + exception.getCause() + "::::::" + new Date());
//        log.debug("ERROR::::：" + exception.getSuppressed() + "::::::" + new Date());
//        log.debug("ERROR::::：" + exception.getMessage() + "::::::" + new Date());
//        log.debug("ERROR::::：" + exception.getStackTrace() + "::::::" + new Date());
//        return "JDBCException，请确认数据准确性";
//    }

    @ExceptionHandler(value = NullPointerException.class)
    public ResponseResult<String> nullPointerException(HttpServletRequest request,
                                                       Exception exception) throws Exception {
        //exception.printStackTrace();
        log.debug("ERROR::::：" + exception.getLocalizedMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getCause() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getSuppressed()) + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getStackTrace()) + "::::::" + new Date());
        ResponseResult<String> result = new ResponseResult<>();
        result.setSuccess(false);
        result.setMessage("空指针错误，请确认数据准确性");
        return result;
    }

    @ExceptionHandler(value = org.xml.sax.SAXException.class)
    public ResponseResult<String> SAXException(HttpServletRequest request,
                                               Exception exception) throws Exception {
        //exception.printStackTrace();
        log.debug("ERROR::::：" + exception.getLocalizedMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getCause() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getSuppressed()) + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getStackTrace()) + "::::::" + new Date());
        ResponseResult<String> result = new ResponseResult<>();
        result.setSuccess(false);
        result.setMessage("页面存在多个<!DOCTYPE html>");
        return result;
    }

    @ExceptionHandler(value = org.xml.sax.SAXParseException.class)
    public ResponseResult<String> SAXParseException(HttpServletRequest request,
                                                    Exception exception) throws Exception {
        exception.printStackTrace();
        log.debug("ERROR::::：" + exception.getLocalizedMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getCause() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getSuppressed()) + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getStackTrace()) + "::::::" + new Date());
        ResponseResult<String> result = new ResponseResult<>();
        result.setSuccess(false);
        result.setMessage("class 重复");
        return result;
    }

    @ExceptionHandler(value = CannotGetJdbcConnectionException.class)
    public ResponseResult<String> CannotGetJdbcConnectionException(HttpServletRequest request,
                                                                   Exception exception) throws Exception {
        exception.printStackTrace();
        log.debug("ERROR::::：" + exception.getLocalizedMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getCause() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getSuppressed()) + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getStackTrace()) + "::::::" + new Date());
        ResponseResult<String> result = new ResponseResult<>();
        result.setSuccess(false);
        result.setMessage("数据库链接错误");
        return result;
    }

    @ExceptionHandler(value = TemplateInputException.class)
    public ResponseResult<String> templateInputException(HttpServletRequest request,
                                                         Exception exception) throws Exception {
        exception.printStackTrace();
        log.debug("ERROR::::：" + exception.getLocalizedMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getCause() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getSuppressed()) + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getStackTrace()) + "::::::" + new Date());
        ResponseResult<String> result = new ResponseResult<>();
        result.setSuccess(false);
        result.setMessage("页面书写错误");
        return result;
    }

    @ExceptionHandler(value = TemplateProcessingException.class)
    public ResponseResult<String> templateProcessingException(HttpServletRequest request,
                                                              Exception exception) throws Exception {
        exception.printStackTrace();
        log.debug("ERROR::::：" + exception.getLocalizedMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getCause() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getSuppressed()) + "::::::" + new Date());
        log.debug("ERROR::::：" + exception.getMessage() + "::::::" + new Date());
        log.debug("ERROR::::：" + Arrays.toString(exception.getStackTrace()) + "::::::" + new Date());
        ResponseResult<String> result = new ResponseResult<>();
        result.setSuccess(false);
        result.setMessage("页面书写错误");
        return result;
    }

}
