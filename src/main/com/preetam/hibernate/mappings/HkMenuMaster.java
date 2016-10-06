package com.preetam.hibernate.mappings;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

/**
 * HkMenuMaster entity. @author MyEclipse Persistence Tools
 */

public class HkMenuMaster implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer menuId;
	private String displayText;
	private Integer parentId;
	private String actionUrl;
	private String status;
	private String description;
	private List<HkMenuMaster> children=new ArrayList<HkMenuMaster>();
	private HkMenuMaster parent;
	// Constructors

	/** default constructor */
	public HkMenuMaster() {
	}

	/** minimal constructor */
	public HkMenuMaster(String displayText, Integer parentId, String status) {
		this.displayText = displayText;
		this.parentId = parentId;
		this.status = status;
	}

	/** full constructor */
	public HkMenuMaster(String displayText, Integer parentId, String actionUrl,
			String status, String description) {
		this.displayText = displayText;
		this.parentId = parentId;
		this.actionUrl = actionUrl;
		this.status = status;
		this.description = description;
	}

	// Property accessors

	public Integer getMenuId() {
		return this.menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getDisplayText() {
		return this.displayText;
	}

	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getActionUrl() {
		return this.actionUrl;
	}

	public void setActionUrl(String actionUrl) {
		this.actionUrl = actionUrl;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setChildren(List<HkMenuMaster> children) {
		this.children = children;
	}

	public List<HkMenuMaster> getChildren() {
		return children;
	}

	public void setParent(HkMenuMaster parent) {
		this.parent = parent;
	}

	public HkMenuMaster getParent() {
		return parent;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
}