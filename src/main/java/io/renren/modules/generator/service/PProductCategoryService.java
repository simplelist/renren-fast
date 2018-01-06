package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.modules.generator.dao.PProductCategoryMapper;
import io.renren.modules.generator.entity.PProductCategory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class PProductCategoryService extends ServiceImpl<PProductCategoryMapper, PProductCategory> {

    @Override
    public boolean insert(PProductCategory entity) {
        entity.setId(null);
        return super.insert(entity);
    }

    @Override
    public boolean updateById(PProductCategory entity) {
        entity.setUpdateDate(new Date());
        return super.updateById(entity);
    }

    public List<PProductCategory> selectAllFirstCategory() {
        EntityWrapper wrapper = new EntityWrapper();
        wrapper.eq("leaf", 1);
        return baseMapper.selectList(wrapper);
    }
}
