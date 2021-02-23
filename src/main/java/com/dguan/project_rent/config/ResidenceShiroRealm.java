package com.dguan.project_rent.config;

import com.dguan.project_rent.dto.ResidenceLogin;
import com.dguan.project_rent.service.ResidenceLoginService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * residence shiro realm
 * handle the token (username and password)
 * @author dguan
 * @date 1/19/2021 10:24 PM
 */
public class ResidenceShiroRealm extends AuthorizingRealm {

    @Autowired
    private ResidenceLoginService residenceLoginService;

    /**
     * 登录权限 residence authorization
     * in this scenario, no need for residence to set up authorization
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 登录认证 login authentication
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //obtain the username
        String username = (String) authenticationToken.getPrincipal();

        //query the database of username info
        List<ResidenceLogin> list = residenceLoginService.queryByUsername(username);

        //determine whether username exists in the database
        //if not, throw UnknownAccountException(username does not exit)
        if (list.size() == 0){
            throw new UnknownAccountException();
        }

        //determine whether the username state is locked
        //if the state does not equal to 1, then throw LockedAccountException(user is locked)
        if (!list.get(0).getResidence_state().equals("1")){
            throw new LockedAccountException();
        }

        ResidenceLogin residenceLogin = list.get(0);

        //use salt and algorithm to check the username and password
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                residenceLogin,residenceLogin.getResidence_password(),
                ByteSource.Util.bytes(residenceLogin.getResidence_salt()),  getName()
        );

        return simpleAuthenticationInfo;
    }
}
