package cn.springcloud.book.util.result;

public class DataWrapper extends Metadata {

	/**
	 * 版本序列化ID
	 */
	private static final long serialVersionUID = -3416458067471205703L;

	public DataWrapper() {
		super(ReturnCode.OK);
	}
	
	public DataWrapper(Object t) {
		super(ReturnCode.OK);
		this.data = t;
	}
	
	public DataWrapper(ReturnCode code, Object t) {
		super(code);
		this.data = t;
	}

	public DataWrapper(ReturnCode code, String message, Object t) {
		super(code, message);
		this.data = t;
	}

	// 数据模型
	private Object data;

	public Object getData() {
		return data;
	}
}
