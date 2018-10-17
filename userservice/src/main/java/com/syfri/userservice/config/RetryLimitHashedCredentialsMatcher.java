package com.syfri.userservice.config;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 密码输入5次失败时锁定30分钟
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher{

	private Cache<String,AtomicInteger> passwordRetryCache;

	public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager){
		passwordRetryCache = cacheManager.getCache("passwordRetryCache");
	}

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info){
		//信息采集免密登陆 by li.xue 2018/10/16 17:04
		/**
		InfoCollectToken infoCollectToken = (InfoCollectToken) token;
		String loginType = infoCollectToken.getLoginType();
		if(LoginType.INFOCOLLECT.toString().equals(loginType)){
			return true;
		}
		*/

		//账户密码登陆
		String username = (String) token.getPrincipal();
		AtomicInteger  retryCount = passwordRetryCache.get(username);
		if (retryCount == null){
			retryCount = new AtomicInteger(0);
			passwordRetryCache.put(username, retryCount);
		}
		if(retryCount.incrementAndGet() > 5){
			throw new ExcessiveAttemptsException();
		}

		Boolean matchces = super.doCredentialsMatch(token,info);
		if(matchces){
			passwordRetryCache.remove(username);
		}
		return matchces;
	}

}
