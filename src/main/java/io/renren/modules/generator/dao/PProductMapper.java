package io.renren.modules.generator.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import io.renren.modules.generator.entity.PProduct;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品表
 *
 * @author kun
 * @email 707069921@qq.com
 * @date 2018-01-05 14:18:42
 */
@Mapper
public interface PProductMapper extends BaseMapper<PProduct> {

}
