$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'generator/pproductcategory',
        datatype: "json",
        colModel: [
            {label: 'id', name: 'id', index: 'id', width: 50, key: true},
            {label: '名称', name: 'name', index: 'name', width: 80},
            {label: '编码', name: 'code', index: 'code', width: 80},
            {label: '层级 1：一级 2：级 ', name: 'leaf', index: 'leaf', width: 80},
            {label: '父id', name: 'parentId', index: 'parent_id', width: 80},
            {label: '是否启用：1启用，0禁用', name: 'status', index: 'status', width: 80},
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
        pProductCategory: {}
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.pProductCategory = {};
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
            var methodName = vm.pProductCategory.id == null ? "POST" : "PUT";
            $.ajax({
                type: methodName,
                url: baseURL + "generator/pproductcategory",
                contentType: "application/json",
                data: JSON.stringify(vm.pProductCategory),
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
                    type: "DELETE",
                    url: baseURL + "generator/pproductcategory",
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
            $.get(baseURL + "generator/pproductcategory/" + id, function (r) {
                vm.pProductCategory = r.pProductCategory;
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