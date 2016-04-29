package com.cube.travel.user.action;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import com.cube.framework.constants.Operator;
import com.cube.framework.utils.WhereFilter;

public class RequestUtil {
	
	public static List<WhereFilter> getParametersStartingWith(ServletRequest request, String prefix) {
		Validate.notNull(request, "Request must not be null");
		Enumeration<String> paramNames = request.getParameterNames();

		List<WhereFilter> whereFilterList = new ArrayList<WhereFilter>();
		if (prefix == null) {
			prefix = "";
		}
		while (paramNames != null && paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			
			if ("".equals(prefix) || paramName.startsWith(prefix)) {
				String[] values = request.getParameterValues(paramName);
				if (values == null || values.length == 0) {
					// Do nothing, no values found at all.
				} else {
					Object value = null;
					if (values.length > 1) {
						value = values;
					} else {
						value = values[0];
						if (value == null || value.equals("")) {
							continue;
						}
					}
					String[] names = StringUtils.split(paramName, "_");
					if (names.length != 3) {
						throw new IllegalArgumentException(paramName + " is not a valid search filter name");
					}
					WhereFilter filter = new WhereFilter(names[2], Operator.valueOf(names[1]), value);
					whereFilterList.add(filter);
				}
			}
		}
		return whereFilterList;
	}

}
