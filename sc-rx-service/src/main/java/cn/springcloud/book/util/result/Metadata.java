package cn.springcloud.book.util.result;

public class Metadata implements java.io.Serializable {

	/**
	 * 版本序列化ID
	 */
	private static final long serialVersionUID = -1877040265666970258L;

	/**
	 * 时间戳
	 */
	private Long timestamp = System.currentTimeMillis();
	
	/**
	 * 返回消息结果
	 */
	private String message;
	
	/**
	 * 构造函数
	 * @param code ReturnCode
	 */
	public Metadata(ReturnCode code) {
		this.code = code;
		// 返回操作码的短语形式
		this.message = code.getReasonPhrase();
	}

	/**
	 * 构造函数
	 * @param code ReturnCode
	 */
	public Metadata(ReturnCode code, String message) {
		this.code = code;
		this.message = message;
	}
	/**
	 * 操作码
	 */
	private ReturnCode code = ReturnCode.OK;
	
	/**
	 * 返回操作码
	 * @return 操作码
	 */
	public int getCode() {
		return code.getValue();
	}
	
//	/**
//	 * 返回操作码的短语形式
//	 * @return 操作码
//	 */
//	public String getCodePhrase() {
//		return code.getReasonPhrase();
//	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
