package io.renren.modules.sys.service.impl;

import io.renren.common.utils.RedisUtils;
import io.renren.modules.sys.dao.SysUserTokenDao;
import io.renren.modules.sys.entity.SysUserTokenEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RedisService {
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private SysUserTokenDao sysUserTokenDao;
    //token 有效期  7天
    public static final long EXPIRED = 60 * 60 * 24 * 7;

    public SysUserTokenEntity queryByToken(String token) {
        String key = "user-token:" + token;
        if (redisUtils.exists(key)) {
            return ((SysUserTokenEntity) redisUtils.get(key));
        } else {
            SysUserTokenEntity sysUserTokenEntity = sysUserTokenDao.queryByToken(token);
            if (sysUserTokenEntity != null) {
                redisUtils.put(key, sysUserTokenEntity, EXPIRED);
            }
            return sysUserTokenEntity;
        }
    }
}
