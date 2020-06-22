package org.ddd.yzf.dto;

import org.ddd.yzf.util.MyTool;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: RequestDTO
 * @Description: 请求DTO
 * @author 袁泽锋
 * @date 2019年9月23日
 *
 */
public class RequestDTO<obj> implements Serializable {

	private List<obj> objList;

	private Map<String, Object> msg;

	public void putMsgData(String key, Object obj) {
		if (msg == null) {
			msg = new HashMap<String, Object>();
		}
		msg.put(key, obj);
	}
	
	public Integer getInteger(String key) {
		if (msg == null) {
			return null;
		}
		Object value = msg.get(key);
		if (value != null && !(value instanceof Integer)) {
			try {
				value = Integer.valueOf(value.toString());
			} catch (NumberFormatException e) {
				System.out.println("org.ddd.yzf.dto.RequestDTO<obj>.getInteger() has error");
			}
		}
		return MyTool.cast(value);
	}

	public Long getLong(String key) {
		if (msg == null) {
			return null;
		}
		Object value = msg.get(key);
		if (value != null && !(value instanceof Long)) {
			try {
				value = Long.valueOf(value.toString());
			} catch (NumberFormatException e) {
				System.out.println("org.ddd.yzf.dto.RequestDTO<obj>.getLong() has error");
			}
		}
		return MyTool.cast(value);
	}
	
	public Float getFloat(String key) {
		if (msg == null) {
			return null;
		}
		Object value = msg.get(key);
		if (value != null && !(value instanceof Float)) {
			try {
				value = Float.valueOf(value.toString());
			} catch (NumberFormatException e) {
				System.out.println("org.ddd.yzf.dto.RequestDTO<obj>.getFloat() has error");
			}
		}
		return MyTool.cast(value);
	}
	
	public Double getDouble(String key) {
		if (msg == null) {
			return null;
		}
		Object value = msg.get(key);
		if (value != null && !(value instanceof Double)) {
			try {
				value = Double.valueOf(value.toString());
			} catch (NumberFormatException e) {
				System.out.println("org.ddd.yzf.dto.RequestDTO<obj>.getDouble() has error");
			}
		}
		return MyTool.cast(value);
	}
	
	public Boolean getBoolean(String key) {
		if (msg == null) {
			return null;
		}
		Object value = msg.get(key);
		if (value != null && !(value instanceof Boolean)) {
			try {
				value = Boolean.valueOf(value.toString());
			} catch (NumberFormatException e) {
				System.out.println("org.ddd.yzf.dto.RequestDTO<obj>.getBoolean() has error");
			}
		}
		return MyTool.cast(value);
	}
	
	public String getString(String key) {
		if (msg == null) {
			return null;
		}
		Object value = msg.get(key);
		if (value != null && !(value instanceof String)) {
			value = value.toString();
		}
		return MyTool.cast(value);
	}

	/**
	 * @return the objList
	 */
	public List<obj> getObjList() {
		return objList;
	}

	/**
	 * @param objList the objList to set
	 */
	public void setObjList(List<obj> objList) {
		this.objList = objList;
	}

	/**
	 * @return the msg
	 */
	public Map<String, Object> getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(Map<String, Object> msg) {
		this.msg = msg;
	}

}
