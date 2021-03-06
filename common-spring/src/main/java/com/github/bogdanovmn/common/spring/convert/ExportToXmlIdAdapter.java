package com.github.bogdanovmn.common.spring.convert;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class ExportToXmlIdAdapter extends XmlAdapter<String, Integer> {
	@Override
	public Integer unmarshal(String v) throws Exception {
		return Integer.valueOf(v);
	}

	@Override
	public String marshal(Integer v) throws Exception {
		if (v != null) {
			return String.valueOf(v);
		}
		return null;
	}
}