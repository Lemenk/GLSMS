package top.lemenk.sys.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 树
 */
public class TreeNode {

	/**
	 * 菜单id
	 */
	private Integer id;

	/**
	 * 父菜单id
	 */
	private Integer parentId;

	/**
	 * 菜单名称
	 */
	private String title;

	/**
	 * 路径
	 */
	private String href;

	/**
	 * 图标
	 */
	private String icon;

	private Boolean spread;

	private List<TreeNode> children = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Boolean getSpread() {
		return spread;
	}

	public void setSpread(Boolean spread) {
		this.spread = spread;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}

	/**
	 * 首页左边树的构造器
	 * @param id
	 * @param parentId
	 * @param title
	 * @param href
	 * @param icon
	 * @param spread
	 */
	public TreeNode(Integer id, Integer parentId, String title, String href, String icon, Boolean spread) {
		this.id = id;
		this.parentId = parentId;
		this.title = title;
		this.href = href;
		this.icon = icon;
		this.spread = spread;
	}
}
