package com.cube.travel.user.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import com.alibaba.fastjson.JSONObject;
import com.cube.framework.constants.Operator;
import com.cube.framework.utils.WhereFilter;

public class RequestUtil {

	public static List<WhereFilter> getParametersStartingWith(JSONObject jsonObj) {
		Validate.notNull(jsonObj, "Request must not be null");
		Iterator<String> paramNames = jsonObj.keySet().iterator();
		List<WhereFilter> whereFilterList = new ArrayList<WhereFilter>();
		while (paramNames != null && paramNames.hasNext()) {
			String paramName = paramNames.next();
			Object value = jsonObj.get(paramName);
			if (value != null) {
				String[] names = StringUtils.split(paramName, "_");
				if (names.length != 2) {
					throw new IllegalArgumentException(paramName + " is not a valid search filter name");
				}
				WhereFilter filter = new WhereFilter(names[1], Operator.valueOf(names[0]), value);
				whereFilterList.add(filter);
			}
		}
		return whereFilterList;
	}

}
