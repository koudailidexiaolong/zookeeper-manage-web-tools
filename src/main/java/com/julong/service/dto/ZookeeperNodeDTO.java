package com.julong.service.dto;

import java.util.List;

public class ZookeeperNodeDTO  {

	
	/**
	 * 节点标题
	 * @author julong
	 * @date 2021年12月5日 下午10:02:05
	 */
	private String title;
	/**
	 * 节点唯一索引值，用于对指定节点进行各类操作 	String/Number 	任意唯一的字符或数字
	 * @author julong
	 * @date 2021年12月5日 下午10:02:15
	 */
	private String id;
	/**
	 * 节点字段名 	String 	一般对应表字段名
	 * @author julong
	 * @date 2021年12月5日 下午10:02:25
	 */
	private String field;
	/**
	 * 子节点。支持设定选项同父节点 	Array 	[{title: '子节点1', id: '111'}]
	 * @author julong
	 * @date 2021年12月5日 下午10:02:35
	 */
	private List<ZookeeperNodeDTO> children;
	/**
	 * 点击节点弹出新窗口对应的 url。需开启 isJump 参数 	String 	任意 URL
	 * @author julong
	 * @date 2021年12月5日 下午10:02:44
	 */
	private String href;
	/**
	 * 节点是否初始展开，默认 false 	Boolean 	true
	 * @author julong
	 * @date 2021年12月5日 下午10:02:51
	 */
	private boolean spread = false;
	/**
	 * 节点是否初始为选中状态（如果开启复选框的话），默认 false 	Boolean 	true
	 * @author julong
	 * @date 2021年12月5日 下午10:02:59
	 */
	private boolean checked = false;
	/**
	 * 节点是否为禁用状态。默认 false 	Boolean 	false
	 * @author julong
	 * @date 2021年12月5日 下午10:03:06
	 */
	private boolean disabled = false;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public List<ZookeeperNodeDTO> getChildren() {
		return children;
	}
	public void setChildren(List<ZookeeperNodeDTO> children) {
		this.children = children;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public boolean isSpread() {
		return spread;
	}
	public void setSpread(boolean spread) {
		this.spread = spread;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public boolean isDisabled() {
		return disabled;
	}
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	@Override
	public String toString() {
		return "ZookeeperNodeDTO [title=" + title + ", id=" + id + ", field=" + field + ", children=" + children
				+ ", href=" + href + ", spread=" + spread + ", checked=" + checked + ", disabled=" + disabled + "]";
	}
	
	
}
