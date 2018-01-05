package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.modules.generator.dao.PProductCategoryMapper;
import io.renren.modules.generator.entity.PProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class PProductCategoryService extends ServiceImpl<PProductCategoryMapper, PProductCategory> {
    public List<PProductCategory> queryList(Map<String, Object> map) {
        return baseMapper.queryList(map);
    }

    public int queryTotal(Map<String, Object> map) {
        return baseMapper.queryTotal(map);
    }

}
