package com.syfri.userservice.dao.system;

import com.syfri.baseapi.dao.BaseDAO;
import com.syfri.userservice.model.system.AccountRoleVO;
import com.syfri.userservice.model.system.AccountVO;

import java.util.List;

public interface AccountDAO extends BaseDAO<AccountVO>{

	/*--新增账户时批量插入账户角色.--*/
	int doBatchInsertAccountRoles(List<AccountRoleVO> accountRoles);

	/*--.新增账户时插入初始角色信息--*/
	int doInsertAccoutRoleInitial(AccountRoleVO accountRoleVO);

	/*--修改用户时删除用户中间表数据.--*/
	int doDeleteAccountRoles(String userid);

	/*--根据不同deptid查询用户账户 by li.xue 2018/10/17 10:11.--*/
	List<AccountVO> doSearchListByVO2(AccountVO accountVO);

	//暂存明文密码 用于系统迁移 add by yushch 20190219
	int doUpdateByUsername(AccountVO accountVO);
}