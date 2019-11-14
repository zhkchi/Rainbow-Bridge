package com.zhkchi.rainbowbridge.common.util;

import com.zhkchi.rainbowbridge.common.constants.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author zhkchi
 *
 * @param <T>
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "响应信息主体")
public class R<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	@ApiModelProperty(value = "返回标记：成功标记=0，失败标记=1")
	private int code;

	@Getter
	@Setter
	@ApiModelProperty(value = "返回信息")
	private String msg;

	@Getter
	@Setter
	@ApiModelProperty(value = "数据")
	private T data;

	public static <T> R<T> ok() {
		return restResult(null, ResultCodeEnum.SUCCESS.getCode(), "success");
	}

	public static <T> R<T> ok(T data) {
		return restResult(data, ResultCodeEnum.SUCCESS.getCode(), "success");
	}

	public static <T> R<T> ok(T data, String msg) {
		return restResult(data, ResultCodeEnum.SUCCESS.getCode(), msg);
	}

	public static <T> R<T> failed() {
		return restResult(null, ResultCodeEnum.ERROR.getCode(), null);
	}

	public static <T> R<T> failed(String msg) {
		return restResult(null, ResultCodeEnum.ERROR.getCode(), msg);
	}

	public static <T> R<T> failed(T data) {
		return restResult(data, ResultCodeEnum.ERROR.getCode(), null);
	}

	public static <T> R<T> failed(T data, String msg) {
		return restResult(data, ResultCodeEnum.ERROR.getCode(), msg);
	}

	private static <T> R<T> restResult(T data, int code, String msg) {
		R<T> apiResult = new R<>();
		apiResult.setCode(code);
		apiResult.setData(data);
		apiResult.setMsg(msg);
		return apiResult;
	}

}
