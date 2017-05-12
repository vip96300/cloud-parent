package org.cloud.packet.server.model;

import java.util.ArrayList;
import java.util.List;

public class PacketDTO{

	private Long pacid;

	private String name;//名称

	private String title;//标题

	private String depict;//描述

	private String surface;//封面

	private String banner;//横幅

	private Integer ispk;//是否主要

	private Long time;//时间

	private Integer isdel=0;//是否删除
	private List<PacPicture> pacPictures=new ArrayList<PacPicture>();
	public Long getPacid() {
		return pacid;
	}
	public void setPacid(Long pacid) {
		this.pacid = pacid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDepict() {
		return depict;
	}
	public void setDepict(String depict) {
		this.depict = depict;
	}
	public String getSurface() {
		return surface;
	}
	public void setSurface(String surface) {
		this.surface = surface;
	}
	public String getBanner() {
		return banner;
	}
	public void setBanner(String banner) {
		this.banner = banner;
	}
	public Integer getIspk() {
		return ispk;
	}
	public void setIspk(Integer ispk) {
		this.ispk = ispk;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	public Integer getIsdel() {
		return isdel;
	}
	public void setIsdel(Integer isdel) {
		this.isdel = isdel;
	}
	public List<PacPicture> getPacPictures() {
		return pacPictures;
	}
	public void setPacPictures(List<PacPicture> pacPictures) {
		this.pacPictures = pacPictures;
	}




}
