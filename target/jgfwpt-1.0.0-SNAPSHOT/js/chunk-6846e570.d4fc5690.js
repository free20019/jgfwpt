(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-6846e570"],{bbd5:function(t,e,a){"use strict";a.d(e,"a",(function(){return l})),a.d(e,"b",(function(){return i})),a.d(e,"c",(function(){return o})),a.d(e,"d",(function(){return u})),a.d(e,"e",(function(){return c}));var n=a("c1df"),r=a.n(n);function l(t,e){return r()(t).format(e)}function i(t){return r()(t).format("YYYY-MM-DD")}function o(t){return r()(t).format("YYYY-MM-DD HH-mm-ss")}function u(t){return r()(t).format("YYYY-MM")}function c(t){return r()(t).format("YYYY")}},cff5:function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"tw-template-wrapper"},[a("div",{staticClass:"tw-template-body"},[a("el-form",{staticClass:"tw-query-bar",attrs:{inline:!0,model:t.query,size:"small"}},[a("el-form-item",[a("el-date-picker",{attrs:{type:"year",placeholder:"日期"},model:{value:t.query.time,callback:function(e){t.$set(t.query,"time",e)},expression:"query.time"}})],1),a("el-form-item",[a("el-select",{attrs:{placeholder:"日期类型"},model:{value:t.query.type,callback:function(e){t.$set(t.query,"type",e)},expression:"query.type"}},t._l(t.yearType,(function(t){return a("el-option",{key:t.value,attrs:{label:t.label,value:t.value}})})),1)],1),a("el-form-item",[a("el-button",{attrs:{type:"primary"},on:{click:t.handleQueryClick}},[t._v("查询")]),a("el-button",{attrs:{type:"primary"},on:{click:t.handleExportClick}},[t._v("导出")])],1)],1),a("div",{staticClass:"tw-query-panel"},[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.table.loading,expression:"table.loading"}],staticStyle:{width:"100%","margin-bottom":"10px"},attrs:{data:t.filterTableList,border:"",size:"small",height:"calc(100% - 42px)"}},[a("el-table-column",{attrs:{prop:"DAY",label:"时间/总计",width:"300","show-overflow-tooltip":""}}),a("el-table-column",{attrs:{prop:"WZ_PERCENT",label:"完整性百分比",width:"300"}}),a("el-table-column",{attrs:{prop:"CX_PERCENT",label:"连续性百分比",width:"300"}}),a("el-table-column",{attrs:{prop:"ZQ_PERCENT",label:"正确性百分比","min-width":"300"}})],1),a("el-pagination",{attrs:{background:"","page-size":t.table.pageSize,"current-page":t.table.currentPage,total:t.table.total,layout:"prev, pager, next, total"},on:{"current-change":t.handleTablePageCurrentChange}})],1)],1)])},r=[],l=a("17fb"),i=a.n(l),o=a("bc3a"),u=a.n(o),c=a("c1df"),s=a.n(c),p=a("7026"),m=a.n(p),d=(a("2f62"),a("bbd5")),f={name:"SemiAnnualDataQualityReport",data:function(){return{query:{time:"",type:""},yearType:[{label:"上半年",value:"1"},{label:"下半年",value:"2"}],table:{loading:!1,data:[],pageSize:500,currentPage:1,total:0}}},mounted:function(){var t=this;parseInt(s()().format("MM"))<7?this.query.type="1":this.query.type="2",this.$nextTick((function(){t.query.time=s()(s()().format("YYYY-MM")),t.getSemiAnnualDataQualityReport()}))},computed:{filterTableList:function(){var t=this.table,e=t.data,a=t.pageSize,n=t.currentPage,r=n-1;return i.a.filter(e,(function(t,e){return e>=r*a&&e<n*a}))}},methods:{getSemiAnnualDataQualityReport:function(){var t=this,e=this.query,a=e.time,n=e.type;if(!a)return this.$message.error("请选择时间！");this.table.loading=!0,u.a.get("keyArea/getSemiAnnualDataQualityReport",{baseURL:this.baseURL,params:{time:a&&Object(d["e"])(a),type:n}}).then((function(e){t.table.data=e.data,t.table.total=t.table.data.length,t.table.currentPage=1,t.table.loading=!1})).catch((function(t){console.log(t)}))},handleQueryClick:function(){this.getSemiAnnualDataQualityReport()},handleExportClick:function(){var t=this,e=this.query,a=e.time,n=e.type;if(!a)return this.$message.error("请选择时间！");this.$confirm("是否需要导出?","提示",{confirmButtonText:"是",cancelButtonText:"否",cancelButtonClass:"el-button--danger",closeOnClickModal:!1,type:"info",center:!0}).then((function(){window.open("".concat(t.baseURL,"keyArea/getSemiAnnualDataQualityReportExcel?time=").concat(a&&Object(d["e"])(a),"&type=").concat(n))})).catch((function(){}))},handleTablePageCurrentChange:function(t){this.table.currentPage=t}},components:{"tree-select":m.a}},b=f,y=a("2877"),h=Object(y["a"])(b,n,r,!1,null,null,null);e["default"]=h.exports}}]);
//# sourceMappingURL=chunk-6846e570.d4fc5690.js.map