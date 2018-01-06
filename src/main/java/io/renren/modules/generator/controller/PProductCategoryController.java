package io.renren.modules.generator.controller;

import com.baomidou.mybatisplus.plugins.Page;
import io.renren.common.utils.R;
import io.renren.modules.generator.entity.PProductCategory;
import io.renren.modules.generator.service.PProductCategoryService;
import io.renren.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


/**
 * 商品分类表
 *
 * @author kun
 * @email 707069921@qq.com
 * @date 2018-01-05 17:29:26
 */
@RestController
@RequestMapping("/generator/pproductcategory")
public class PProductCategoryController extends AbstractController {
    @Autowired
    private PProductCategoryService pProductCategoryService;

    /**
     * 获取一级分类
     */
    @GetMapping("first_category")
    @RequiresPermissions("generator:pproductcategory:list")
    public R allFirstCategory() {
        List<PProductCategory> page = pProductCategoryService.selectAllFirstCategory();

        return R.ok().put("page", page);
    }
    /**
     * 列表
     */
    @GetMapping
    @RequiresPermissions("generator:pproductcategory:list")
    public R list(Page pageable) {
        Page<PProductCategory> page = pProductCategoryService.selectPage(pageable);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/{id}")
    @RequiresPermissions("generator:pproductcategory:info")
    public R info(@PathVariable("id") Integer id) {
        PProductCategory pProductCategory = pProductCategoryService.selectById(id);

        return R.ok().put("pProductCategory", pProductCategory);
    }

    /**
     * 保存
     */
    @PostMapping
    @RequiresPermissions("generator:pproductcategory:save")
    public R save(@RequestBody PProductCategory pProductCategory) {
        pProductCategoryService.insert(pProductCategory);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @RequiresPermissions("generator:pproductcategory:update")
    public R update(@RequestBody PProductCategory pProductCategory) {
        pProductCategoryService.updateById(pProductCategory);

        return R.ok();
    }


    /**
     * 删除
     */
    @DeleteMapping
    @RequiresPermissions("generator:pproductcategory:delete")
    public R delete(@RequestBody Integer[] ids) {
        pProductCategoryService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
