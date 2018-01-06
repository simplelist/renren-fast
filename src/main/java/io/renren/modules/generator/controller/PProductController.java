package io.renren.modules.generator.controller;

import com.baomidou.mybatisplus.plugins.Page;
import io.renren.common.utils.R;
import io.renren.modules.generator.entity.PProduct;
import io.renren.modules.generator.service.PProductService;
import io.renren.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * 商品表
 *
 * @author kun
 * @email 707069921@qq.com
 * @date 2018-01-05 14:18:42
 */
@RestController
@RequestMapping("/generator/pproduct")
public class PProductController extends AbstractController {
    @Autowired
    private PProductService pProductService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("generator:pproduct:list")
    public R list(Page pageable) {
        Page<PProduct> page = pProductService.selectPage(pageable);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/{id}")
    @RequiresPermissions("generator:pproduct:info")
    public R info(@PathVariable("id") Integer id) {
        PProduct pProduct = pProductService.selectById(id);
        return R.ok().put("pProduct", pProduct);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("generator:pproduct:save")
    public R save(@RequestBody PProduct pProduct) {
        pProductService.insert(pProduct);
        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @RequiresPermissions("generator:pproduct:update")
    public R update(@RequestBody PProduct pProduct) {
        pProductService.updateById(pProduct);
        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @RequiresPermissions("generator:pproduct:delete")
    public R delete(@RequestBody Integer[] ids) {
        pProductService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
