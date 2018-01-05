package io.renren.modules.generator.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.common.utils.R;
import io.renren.modules.generator.entity.PProduct;
import io.renren.modules.generator.service.PProductService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 商品表
 *
 * @author kun
 * @email 707069921@qq.com
 * @date 2018-01-05 14:18:42
 */
@RestController
@RequestMapping("/generator/pproduct")
public class PProductController {
    @Autowired
    private PProductService pProductService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:pproduct:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<PProduct> pProductList = pProductService.queryList(query);
        int total = pProductService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(pProductList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:pproduct:info")
    public R info(@PathVariable("id") Integer id) {
        PProduct pProduct = pProductService.selectById(id);
        return R.ok().put("pProduct", pProduct);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:pproduct:save")
    public R save(@RequestBody PProduct pProduct) {
        pProductService.insert(pProduct);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:pproduct:update")
    public R update(@RequestBody PProduct pProduct) {
        pProductService.updateById(pProduct);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:pproduct:delete")
    public R delete(@RequestBody Integer[] ids) {
        pProductService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
