package com.zhkchi.rainbowbridge.common.handler;

import com.zhkchi.rainbowbridge.common.constants.ResultCodeEnum;
import com.zhkchi.rainbowbridge.common.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.List;

/**
 * 统一异常处理器
 *
 * @author zhkchi
 * @date 2019-08-11
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
	/**
	 * 包装全局异常返回信息
	 *
	 * @param e 异常信息
	 * @return 包含错误信息的标准返回值
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public R exception(Exception e) {
		R result = new R();
		result.setCode(ResultCodeEnum.ERROR.getCode());
		String msg = "全局异常：" + e.toString();
		result.setMsg(msg);
		log.error(msg);
		return result;
	}

	/**
	 * 自定义全局参数参数绑定异常处理
	 *
	 * @param exception 异常类
	 * @return 包含错误信息的标准返回值
	 * @author 张克琪
	 */
	@ExceptionHandler({BindException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public R bindExceptionHandler(BindException exception) {
		List<FieldError> fieldErrors = exception.getBindingResult()
												.getFieldErrors();
		R result = new R();
		result.setCode(ResultCodeEnum.ERROR.getCode());
		String msg = "参数绑定异常：" + fieldErrors.get(0)
											.getField() + " " + fieldErrors.get(0)
																		   .getDefaultMessage();
		result.setMsg(msg);
		log.error(msg);
		return result;
	}

	/**
	 * 自定义方法参数验证不通过异常处理器
	 *
	 * @param exception
	 * @return R
	 * @author 张克琪
	 */
	@ExceptionHandler({MethodArgumentNotValidException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public R methodValidExceptionHandler(MethodArgumentNotValidException exception) {
		List<FieldError> fieldErrors = exception.getBindingResult()
												.getFieldErrors();
		R result = new R();
		result.setCode(ResultCodeEnum.ERROR.getCode());
		String msg = "参数验证不通过：" + fieldErrors.get(0)
											 .getField() + " " + fieldErrors.get(0)
																			.getDefaultMessage();
		result.setMsg(msg);
		log.error(msg);
		return result;
	}

	@ExceptionHandler({MissingServletRequestParameterException.class})
	@ResponseBody
	public R requestMissingServletRequest(MissingServletRequestParameterException ex) {
		R result = new R();
		result.setCode(ResultCodeEnum.ERROR.getCode());
		String msg = "缺少必要参数,参数名称为" + ex.getParameterName();
		result.setMsg(msg);
		log.error(msg);
		return result;
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoHandlerFoundException.class)
	public R noHandlerFoundException(NoHandlerFoundException ex) {
		R result = new R();
		result.setCode(ResultCodeEnum.ERROR.getCode());
		String msg = "调用路径不正确：" + ex.getMessage();
		result.setMsg(msg);
		log.error(msg);
		return result;
	}

	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public R handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
		R result = new R();
		result.setCode(ResultCodeEnum.ERROR.getCode());
		String msg = "当前调用的接口不支持这样的请求方式:" + ex.getMessage();
		result.setMsg(msg);
		log.error(msg);
		return result;
	}

}
