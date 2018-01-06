package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xiaoleilu.hutool.util.RandomUtil;
import io.renren.common.utils.HttpContextUtils;
import io.renren.modules.generator.dao.PProductCategoryMapper;
import io.renren.modules.generator.entity.PProductCategory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class PProductCategoryService extends ServiceImpl<PProductCategoryMapper, PProductCategory> {

    @Override
    public Page<PProductCategory> selectPage(Page<PProductCategory> page) {
        //只取出商户可以编辑的二级菜单
        EntityWrapper wrapper = new EntityWrapper();
        wrapper.eq("leaf", 2);
        wrapper.eq("create_user", HttpContextUtils.getUserId());
        return selectPage(page, wrapper);
    }

    @Override
    public boolean insert(PProductCategory entity) {
        entity.setId(null);
        entity.setCode(RandomUtil.simpleUUID());
        entity.setCreateUser(HttpContextUtils.getUserId());
        entity.setLeaf(2);
        return super.insert(entity);
    }

    @Override
    public boolean updateById(PProductCategory entity) {
        entity.setUpdateDate(new Date());
        entity.setCreateUser(HttpContextUtils.getUserId());
        return super.updateById(entity);
    }

    public List<PProductCategory> selectAllFirstCategory() {
        EntityWrapper wrapper = new EntityWrapper();
        wrapper.eq("leaf", 1);
        return baseMapper.selectList(wrapper);
    }
}
