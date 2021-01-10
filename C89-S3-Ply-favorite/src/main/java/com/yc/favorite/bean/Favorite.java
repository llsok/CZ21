package com.yc.favorite.bean;

import lombok.Data;

@Data
public class Favorite implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer fid;
	private String flabel;
	private String furl;
	private String fdesc;
	private String ftags;
}
