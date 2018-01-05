$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'generator/pproduct/list',
        datatype: "json",
        colModel: [
            {label: 'id', name: 'id', index: 'id', width: 50, key: true},
            {label: '名称', name: 'name', index: 'name', width: 80},
            {label: '编码', name: 'code', index: 'code', width: 80},
            {label: '进价', name: 'purchasePrice', index: 'purchase_price', width: 80},
            {label: '销售价', name: 'salePrice', index: 'sale_price', width: 80},
            {label: '差价', name: 'differencePrice', index: 'difference_price', width: 80},
            {label: '商品数量', name: 'productNum', index: 'product_num', width: 80},
            {label: '商品库存', name: 'stock', index: 'stock', width: 80},
            {label: '商品单位', name: 'unit', index: 'unit', width: 80},
            {label: '大图片地址', name: 'photoMaxUrl', index: 'photo_max_url', width: 80},
            {label: '所属分类', name: 'categoryCode', index: 'category_code', width: 80},
            {label: '所属商户', name: 'shopCode', index: 'shop_code', width: 80},
            {label: '商品描述', name: 'describe', index: 'describe', width: 80},
            {label: '是否启用：1启用，0禁用', name: 'status', index: 'status', width: 80},
            {label: '内容', name: 'content', index: 'content', width: 80},
            {label: '备注', name: 'remark', index: 'remark', width: 80},
            {label: '', name: 'createUser', index: 'create_user', width: 80},
            {label: '', name: 'createDate', index: 'create_date', width: 80},
            {label: '', name: 'updateUser', index: 'update_user', width: 80},
            {label: '', name: 'updateDate', index: 'update_date', width: 80}
        ],
        viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList: [10, 30, 50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth: true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader: {
            root: "page.records",
            page: "page.current",
            total: "page.pages",
            records: "page.total"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order"
        },
        gridComplete: function () {
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
    });
});

var vm = new Vue({
    el: '#rrapp',
    data: {
        showList: true,
        title: null,
        pProduct: {}
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.pProduct = {};
        },
        update: function (event) {
            var id = getSelectedRow();
            if (id == null) {
                return;
            }
            vm.showList = false;
            vm.title = "修改";

            vm.getInfo(id)
        },
        saveOrUpdate: function (event) {
            var url = vm.pProduct.id == null ? "generator/pproduct/save" : "generator/pproduct/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.pProduct),
                success: function (r) {
                    if (r.code === 0) {
                        alert('操作成功', function (index) {
                            vm.reload();
                        });
                    } else {
                        alert(r.msg);
                    }
                }
            });
        },
        del: function (event) {
            var ids = getSelectedRows();
            if (ids == null) {
                return;
            }

            confirm('确定要删除选中的记录？', function () {
                $.ajax({
                    type: "POST",
                    url: baseURL + "generator/pproduct/delete",
                    contentType: "application/json",
                    data: JSON.stringify(ids),
                    success: function (r) {
                        if (r.code == 0) {
                            alert('操作成功', function (index) {
                                $("#jqGrid").trigger("reloadGrid");
                            });
                        } else {
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        getInfo: function (id) {
            $.get(baseURL + "generator/pproduct/info/" + id, function (r) {
                vm.pProduct = r.pProduct;
            });
        },
        reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                page: page
            }).trigger("reloadGrid");
        }
    }
});