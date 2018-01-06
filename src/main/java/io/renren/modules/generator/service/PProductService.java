package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xiaoleilu.hutool.util.RandomUtil;
import io.renren.common.utils.HttpContextUtils;
import io.renren.modules.generator.dao.PProductMapper;
import io.renren.modules.generator.entity.PProduct;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class PProductService extends ServiceImpl<PProductMapper, PProduct> {

    @Override
    public Page<PProduct> selectPage(Page<PProduct> page) {
        //只取出商户自己的商品
        EntityWrapper wrapper = new EntityWrapper();
        wrapper.eq("create_user", HttpContextUtils.getUserId());
        return selectPage(page, wrapper);
    }

    @Override
    public boolean insert(PProduct entity) {
        entity.setId(null);
        entity.setCode(RandomUtil.simpleUUID());
        entity.setCreateUser(HttpContextUtils.getUserId());
        entity.setShopCode(HttpContextUtils.getUserId().toString());
        entity.setDifferencePrice(entity.getSalePrice().remainder(entity.getPurchasePrice()));
        return super.insert(entity);
    }

    @Override
    public boolean updateById(PProduct entity) {
        entity.setUpdateDate(new Date());
        entity.setCreateUser(HttpContextUtils.getUserId());
        return super.updateById(entity);
    }
}
