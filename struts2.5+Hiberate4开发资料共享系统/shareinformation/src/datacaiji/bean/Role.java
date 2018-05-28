package datacaiji.bean;

import java.util.HashSet;
import java.util.Set;

public class Role {
	private String roleid;  //普通用户001 管理员002 超级管理员003 主键
	private String rolepermission;  //用户   管理员 超级管理员
	private int rolegrade;  // 1  2   3
	private Set<User> user = new HashSet<User>();
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Role){
			Role role = (Role) obj;
			if (role.getRoleid().equals(this.roleid)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.roleid.hashCode();
	}
	
	public String getRoleid() {
		return roleid;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	public String getRolepermission() {
		return rolepermission;
	}
	public void setRolepermission(String rolepermission) {
		this.rolepermission = rolepermission;
	}
	public int getRolegrade() {
		return rolegrade;
	}
	public void setRolegrade(int rolegrade) {
		this.rolegrade = rolegrade;
	}
	public Set<User> getUser() {
		return user;
	}
	public void setUser(Set<User> user) {
		this.user = user;
	}
}
