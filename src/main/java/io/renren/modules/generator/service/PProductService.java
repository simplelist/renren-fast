package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.modules.generator.dao.PProductMapper;
import io.renren.modules.generator.entity.PProduct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class PProductService extends ServiceImpl<PProductMapper, PProduct> {
    public List<PProduct> queryList(Map<String, Object> map) {
        return baseMapper.queryList(map);
    }

    public int queryTotal(Map<String, Object> map) {
        return baseMapper.queryTotal(map);
    }

}
