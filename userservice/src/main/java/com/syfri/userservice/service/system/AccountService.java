package com.syfri.userservice.service.system;

import com.syfri.baseapi.service.BaseService;
import com.syfri.userservice.model.system.AccountVO;
import com.syfri.userservice.model.system.RoleVO;

import java.util.List;

public interface AccountService  extends BaseService<AccountVO>{

	/*--采用MD5对密码进行加密.--*/
	AccountVO getPasswordEncry(AccountVO accountVO);

	/*--新增：向账户表中增加账户.--*/
	int doInsertAccountByVO(AccountVO accountVO);

	/*--修改：修改账户表.--*/
	int doUpdateAccountByVO(AccountVO accountVO);

	/*--批量向账户角色中间表中插入数据(中间表).--*/
	int doInsertAccountRolesBatch(String userid, List<RoleVO> roles);

	/*--删除：删除账户同时删除其角色(中间表).--*/
	int doDeleteAccountRoles(String pkid);

	/*--根据不同deptid查询用户账户 by li.xue 2018/10/17 10:11.--*/
	List<AccountVO> doSearchListByVO2(AccountVO accountVO);

	int doUpdateByUsername(AccountVO accountVO);
}