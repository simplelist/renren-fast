package io.renren.modules.generator.dao;

import java.util.List;
import java.util.Map;

/**
 * 基础Dao(还需在XML文件里，有对应的SQL语句)
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:31:36
 */
public interface BaseDao<T> {

    List<T> queryList(Map<String, Object> map);


    int queryTotal(Map<String, Object> map);

}
