package io.renren.modules.generator.controller;

import com.baomidou.mybatisplus.plugins.Page;
import io.renren.common.utils.R;
import io.renren.modules.generator.entity.PProductCategory;
import io.renren.modules.generator.service.PProductCategoryService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


/**
 * 商品分类表
 *
 * @author kun
 * @email 707069921@qq.com
 * @date 2018-01-05 17:29:26
 */
@RestController
@RequestMapping("/generator/pproductcategory")
public class PProductCategoryController {
    @Autowired
    private PProductCategoryService pProductCategoryService;

//	/**
//	 * 列表
//	 */
//	@RequestMapping("/list")
//	@RequiresPermissions("generator:pproduct:list")
//	public R list(@RequestParam Map<String, Object> params){
//		//查询列表数据
//		Query query = new Query(params);
//
//		List<PProductCategory> pProductList = pProductCategoryService.queryList(query);
//		int total = pProductCategoryService.queryTotal(query);
//
//		PageUtils pageUtil = new PageUtils(pProductList, total, query.getLimit(), query.getPage());
//
//		return R.ok().put("page", pageUtil);
//	}


    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("generator:pproduct:list")
    public R list(Page pageable) {
        Page<PProductCategory> page = pProductCategoryService.selectPage(pageable);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:pproductcategory:info")
    public R info(@PathVariable("id") Integer id) {
        PProductCategory pProductCategory = pProductCategoryService.selectById(id);

        return R.ok().put("pProductCategory", pProductCategory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:pproductcategory:save")
    public R save(@RequestBody PProductCategory pProductCategory) {
        pProductCategoryService.insert(pProductCategory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:pproductcategory:update")
    public R update(@RequestBody PProductCategory pProductCategory) {
        pProductCategoryService.updateById(pProductCategory);

        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:pproductcategory:delete")
    public R delete(@RequestBody Integer[] ids) {
        pProductCategoryService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
