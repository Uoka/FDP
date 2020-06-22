package org.ddd.yzf.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ddd.yzf.util.MyTool;

/**
 * @ClassName: RespondDTO
 * @Description: 响应DTO
 * @author 袁泽锋
 * @date 2019年9月23日
 *
 */
public class RespondDTO<Obj> {
	
	private List<Obj> objList;
	
	private Map<String, Object> msg;
	
	public void putMsgData(String key, Object obj) {
		if (msg == null) {
			msg = new HashMap<String, Object>();
		}
		msg.put(key, obj);
	}
	
	public <T> T getMsgData(String key) {
		if (msg == null) {
			return null;
		}
		return MyTool.cast(msg.get(key));
	}

	public void putObjToList(Obj obj) {
		if (this.objList == null) {
			objList = new ArrayList<>();
		}
		objList.add(obj);
	}

	/**
	 * @return the objList
	 */
	public List<Obj> getObjList() {
		return objList;
	}

	/**
	 * @param objList the objList to set
	 */
	public void setObjList(List<Obj> objList) {
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
