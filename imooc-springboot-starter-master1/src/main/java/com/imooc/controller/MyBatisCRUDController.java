package com.imooc.controller;

import java.util.Date;
import java.util.List;

import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imooc.pojo.IMoocJSONResult;
import com.imooc.pojo.SysUser;
import com.imooc.service.UserService;

@RestController
@RequestMapping("mybatis")
public class MyBatisCRUDController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private Sid sid;
	/**
	 * 添加
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/saveUser")
	public IMoocJSONResult saveUser() throws Exception{
		String userId = sid.nextShort();
		SysUser user = new SysUser();
		user.setId(userId);
		user.setUsername("imooc" + new Date());
		user.setNickname("imooc" + new Date());
		user.setPassword("abc123");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		userService.saveUser(user);
		return IMoocJSONResult.ok("保存成功");
	}
	/**
	 * 修改
	 * @return
	 */
	@RequestMapping("/updateUser")
	public IMoocJSONResult updateUser() {
		
		SysUser user = new SysUser();
		user.setId("171020FWN55RS5AW");
		user.setUsername("171020FWN55RS5AW-updated" + new Date());
		user.setNickname("171020FWN55RS5AW-updated" + new Date());
		user.setPassword("171020FWN55RS5AW-updated");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		userService.updateUser(user);
		
		return IMoocJSONResult.ok("保存成功");
	}
	/**
	 * 根据id删除
	 * @param userId
	 * @return
	 */
	@RequestMapping("/deleteUser")
	public IMoocJSONResult deleteUser(String userId) {
		
		userService.deleteUser(userId);
		
		return IMoocJSONResult.ok("删除成功");
	}
	/**
	 * 根据id查询
	 * @param userId
	 * @return
	 */
	@RequestMapping("/queryUserById")
	public IMoocJSONResult queryUserById(String userId) {
		
		return IMoocJSONResult.ok(userService.queryUserById(userId));
	}
	/**
	 * 查询所有
	 * @return
	 */
	@RequestMapping("/queryUserList")
	public IMoocJSONResult queryUserList() {
		
		SysUser user = new SysUser();
//		user.setUsername("imooc");
//		user.setNickname("lee");
		
		List<SysUser> userList = userService.queryUserList(user);
		
		return IMoocJSONResult.ok(userList);
	}
	/**
	 * 分页
	 * @param page
	 * @return
	 */
	@RequestMapping("/queryUserListPaged")
	public IMoocJSONResult queryUserListPaged(Integer page) {
		
		if (page == null) {
			page = 1;
		}
	
		int pageSize = 10;
		
		SysUser user = new SysUser();
	//	user.setNickname("lee");
		
		List<SysUser> userList = userService.queryUserListPaged(user, page, pageSize);
		
		return IMoocJSONResult.ok(userList);
	}
	/**
	 * 自定义查询
	 * @param userId
	 * @return
	 */
	@RequestMapping("/queryUserByIdCustom")
	public IMoocJSONResult queryUserByIdCustom(String userId) {
		
		return IMoocJSONResult.ok(userService.queryUserByIdCustom(userId));
	}
	
	@RequestMapping("/saveUserTransactional")
	public IMoocJSONResult saveUserTransactional() {
		
		String userId = sid.nextShort();
		
		SysUser user = new SysUser();
		user.setId(userId);
		user.setUsername("lee" + new Date());
		user.setNickname("lee" + new Date());
		user.setPassword("abc123");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		
		userService.saveUserTransactional(user);
		
		return IMoocJSONResult.ok("保存成功");
	}
}