(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-3c393306"],{"11e9":function(e,t,a){var r=a("52a7"),l=a("4630"),i=a("6821"),n=a("6a99"),o=a("69a8"),s=a("c69a"),c=Object.getOwnPropertyDescriptor;t.f=a("9e1e")?c:function(e,t){if(e=i(e),t=n(t,!0),s)try{return c(e,t)}catch(a){}if(o(e,t))return l(!r.f.call(e,t),e[t])}},"454f":function(e,t,a){a("46a7");var r=a("584a").Object;e.exports=function(e,t,a){return r.defineProperty(e,t,a)}},"456d":function(e,t,a){var r=a("4bf8"),l=a("0d58");a("5eda")("keys",(function(){return function(e){return l(r(e))}}))},"46a7":function(e,t,a){var r=a("63b6");r(r.S+r.F*!a("8e60"),"Object",{defineProperty:a("d9f6").f})},"5eda":function(e,t,a){var r=a("5ca1"),l=a("8378"),i=a("79e5");e.exports=function(e,t){var a=(l.Object||{})[e]||Object[e],n={};n[e]=t(a),r(r.S+r.F*i((function(){a(1)})),"Object",n)}},"718f":function(e,t,a){"use strict";a.r(t);var r=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"tw-template-wrapper"},[a("el-form",{staticClass:"tw-query-bar",attrs:{inline:!0,model:e.query,size:"small"}},[a("el-form-item",[a("el-autocomplete",{staticClass:"inline-input",attrs:{placeholder:"车牌号码","fetch-suggestions":e.queryVehicleSearch,"trigger-on-focus":!1},model:{value:e.query.vehicle,callback:function(t){e.$set(e.query,"vehicle",t)},expression:"query.vehicle"}})],1),a("el-form-item",[a("el-autocomplete",{staticClass:"inline-input",attrs:{placeholder:"原公司名称","fetch-suggestions":e.queryCompanyNameSearch,"trigger-on-focus":!1},model:{value:e.query.companyName,callback:function(t){e.$set(e.query,"companyName",t)},expression:"query.companyName"}})],1),a("el-form-item",[a("el-select",{attrs:{placeholder:"区域"},model:{value:e.query.area,callback:function(t){e.$set(e.query,"area",t)},expression:"query.area"}},e._l(e.getRegionReal,(function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})})),1)],1),a("el-form-item",[a("el-date-picker",{attrs:{type:"datetime",placeholder:"开始日期"},model:{value:e.query.stime,callback:function(t){e.$set(e.query,"stime",t)},expression:"query.stime"}})],1),a("el-form-item",[a("el-date-picker",{attrs:{type:"datetime",placeholder:"结束日期"},model:{value:e.query.etime,callback:function(t){e.$set(e.query,"etime",t)},expression:"query.etime"}})],1),a("el-form-item",[a("el-select",{attrs:{placeholder:"审核状态"},model:{value:e.query.type,callback:function(t){e.$set(e.query,"type",t)},expression:"query.type"}},e._l(e.getApprovalStatus,(function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})})),1)],1),a("el-form-item",[a("el-button",{attrs:{type:"primary"},on:{click:e.handleQueryClick}},[e._v("查询")])],1)],1),a("div",{staticClass:"tw-query-panel"},[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.table.loading,expression:"table.loading"}],staticStyle:{width:"100%","margin-bottom":"10px"},attrs:{data:e.filterTableList,border:"",size:"small",height:"calc(100% - 42px)"}},[a("el-table-column",{attrs:{type:"index",label:"序号",width:"60",align:"center",resizable:!1,fixed:""}}),a("el-table-column",{attrs:{prop:"cphm",label:"车牌号码",width:"140",align:"center",fixed:""}}),a("el-table-column",{attrs:{prop:"ygsmc",label:"原公司名称",width:"280","header-align":"center","show-overflow-tooltip":""}}),a("el-table-column",{attrs:{prop:"xgsmc",label:"现公司名称",width:"280","header-align":"center","show-overflow-tooltip":""}}),a("el-table-column",{attrs:{prop:"area",label:"区域",width:"240"}}),a("el-table-column",{attrs:{prop:"zrsj",label:"转入时间",width:"150",align:"center"}}),a("el-table-column",{attrs:{prop:"sqsj",label:"申请时间",width:"150",align:"center"}}),a("el-table-column",{attrs:{prop:"shzt",label:"审核状态",width:"140",align:"center"}}),a("el-table-column",{attrs:{prop:"shsj",label:"审核时间",width:"150",align:"center"}}),a("el-table-column",{attrs:{prop:"shyy",label:"审核原因",width:"380","header-align":"center","show-overflow-tooltip":""}}),a("el-table-column",{attrs:{prop:"shre",label:"审核人","min-width":"160",align:"center",resizable:!1}}),a("el-table-column",{attrs:{label:"操作",width:"80",resizable:!1,align:"center",fixed:"right"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-tooltip",{staticClass:"item",attrs:{effect:"dark",content:"审核通过",placement:"left","hide-after":700}},[a("el-button",{staticClass:"tw-table-button",attrs:{type:"text",size:"mini",icon:"el-icon-check"},on:{click:function(a){return e.handleReviewTrueClick(t.row)}}})],1),a("el-tooltip",{staticClass:"item",attrs:{effect:"dark",content:"审核不通过",placement:"left","hide-after":700}},[a("el-button",{staticClass:"tw-table-button",attrs:{type:"text",size:"mini",icon:"el-icon-close"},on:{click:function(a){return e.handleReviewFalseClick(t.row)}}})],1)]}}])})],1),a("el-pagination",{attrs:{background:"","page-size":e.table.pageSize,"current-page":e.table.currentPage,total:e.table.total,layout:"prev, pager, next, total"},on:{"current-change":e.handleTablePageCurrentChange}})],1),a("el-dialog",{attrs:{title:e.dialog.title,visible:e.dialog.display,width:"400px"},on:{"update:visible":function(t){return e.$set(e.dialog,"display",t)},closed:e.handleDialogClosed}},[a("el-form",{ref:"form",attrs:{model:e.dialog.form,"label-width":"100px"}},[a("el-form-item",{attrs:{label:"审核人工号"}},[a("el-autocomplete",{staticStyle:{width:"260px"},attrs:{placeholder:"审核人工号","fetch-suggestions":e.queryJobNumberSearch,"trigger-on-focus":!1},on:{select:e.handleJobNumberSelect},model:{value:e.dialog.form.jobNumber,callback:function(t){e.$set(e.dialog.form,"jobNumber",t)},expression:"dialog.form.jobNumber"}})],1),e.dialog.flag?e._e():a("el-form-item",{attrs:{label:"原因"}},[a("el-input",{staticStyle:{width:"260px"},attrs:{type:"textarea",rows:"4",placeholder:"原因"},model:{value:e.dialog.form.reason,callback:function(t){e.$set(e.dialog.form,"reason",t)},expression:"dialog.form.reason"}})],1)],1),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.dialog.display=!1}}},[e._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:e.handleDialogSaveClick}},[e._v("提 交")])],1)],1)],1)},l=[],i=(a("8e6e"),a("ac6a"),a("456d"),a("bd86")),n=a("17fb"),o=a.n(n),s=a("bc3a"),c=a.n(s),u=a("c1df"),f=a.n(u),d=a("2f62"),m=a("bbd5");function b(e,t){var a=Object.keys(e);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);t&&(r=r.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),a.push.apply(a,r)}return a}function p(e){for(var t=1;t<arguments.length;t++){var a=null!=arguments[t]?arguments[t]:{};t%2?b(a,!0).forEach((function(t){Object(i["a"])(e,t,a[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(a)):b(a).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(a,t))}))}return e}var h={name:"VehicleTransferApproval",data:function(){return{query:{vehicle:"",companyName:"",area:"",stime:"",etime:"",type:""},table:{loading:!1,data:[],selectItem:{},pageSize:20,currentPage:1,total:0},dialog:{display:!1,title:"",flag:!1,form:{jobNumber:"",jobNum:"",reason:""}}}},mounted:function(){var e=this;this.$nextTick((function(){e.query.stime=f()().format("YYYY-MM-DD 00:00:00"),e.query.etime=f()().format("YYYY-MM-DD 23:59:59"),e.getVehicleTransferApproval()}))},computed:p({},Object(d["b"])(["getLPNumber","getCompanyName","getApprovalStatus","getJobNumber","getRegionReal"]),{filterTableList:function(){var e=this.table,t=e.data,a=e.pageSize,r=e.currentPage,l=r-1;return o.a.filter(t,(function(e,t){return t>=l*a&&t<r*a}))}}),methods:{queryVehicleSearch:function(e,t){e.length<3?t(null):t(o.a.filter(this.getLPNumber,(function(t){return t.label.indexOf(e)>-1})))},queryCompanyNameSearch:function(e,t){t(o.a.filter(this.getCompanyName,(function(t){return t.label.indexOf(e)>-1})))},queryJobNumberSearch:function(e,t){t(o.a.filter(this.getJobNumber,(function(t){return t.label.indexOf(e)>-1})))},getVehicleTransferApproval:function(){var e=this,t=0;this.table.loading=!0;var a=this.query,r=a.vehicle,l=a.companyName,i=a.area,n=a.stime,s=a.etime,u=a.type;c.a.get("area/vehicletransfer",{baseURL:this.baseURL,params:{vehicle:r,companyName:l,area:i,stime:n&&Object(m["c"])(n),etime:s&&Object(m["c"])(s),type:u,status:t}}).then((function(t){console.log(t.data),e.table.data=o.a.map(t.data,(function(e){return{id:e.ID,userid:e.USER_ID,user:e.USER_NAME,cphm:e.VEHICLE_NO,ygsmc:e.OLD_COMPANY,xgsmc:e.NEW_COMPANY,area:e.AREA_NAME,zrsj:e.ZRSJ,sqsj:e.SQSJ,shzt:"0"===e.AUDIT_STATUS?"审核通过":"1"===e.AUDIT_STATUS?"审核不通过":"未审核",shsj:e.SHSJ,shyy:e.REASON,shre:e.REAL_NAME}})),e.table.total=e.table.data.length,e.table.currentPage=1,e.table.loading=!1})).catch((function(e){console.log(e)}))},getTransferAudit:function(){var e=this,t=this.dialog.form,a=t.jobNum,r=t.reason,l=this.table.selectItem;if(!a)return this.$message.error("请选择工号！");var i=this.dialog.flag;c.a.get("area/transferaudit",{baseURL:this.baseURL,params:{id:l.id,jobNum:a,reason:!0===i?"":r,issh:!0===i?"0":"1"}}).then((function(t){t.data>0?(e.$message({message:"操作成功!",type:"success"}),e.dialog.display=!1,e.getVehicleTransferApproval()):e.$message.error("操作失败！")})).catch((function(e){console.error(e)}))},handleJobNumberSelect:function(e){this.dialog.form.jobNum=e.id},handleQueryClick:function(){this.getVehicleTransferApproval()},handleDialogSaveClick:function(){this.getTransferAudit()},handleDialogClosed:function(){this.dialog.title="审批",this.dialog.flag=!1,this.dialog.form.jobNum="",this.dialog.form.jobNumber="",this.dialog.form.reason="",this.table.selectItem={}},handleReviewTrueClick:function(e){this.dialog.form.jobNum=e.userid,this.dialog.form.jobNumber=e.user,this.dialog.form.reason=e.shyy,this.table.selectItem=e,this.dialog.display=!0,this.dialog.title="审批",this.dialog.flag=!0},handleReviewFalseClick:function(e){this.dialog.form.jobNum=e.userid,this.dialog.form.jobNumber=e.user,this.dialog.form.reason=e.shyy,this.table.selectItem=e,this.dialog.display=!0,this.dialog.title="审批",this.dialog.flag=!1},handleTablePageCurrentChange:function(e){this.table.currentPage=e}}},g=h,y=a("2877"),v=Object(y["a"])(g,r,l,!1,null,"9cff2d3c",null);t["default"]=v.exports},"85f2":function(e,t,a){e.exports=a("454f")},"8e6e":function(e,t,a){var r=a("5ca1"),l=a("990b"),i=a("6821"),n=a("11e9"),o=a("f1ae");r(r.S,"Object",{getOwnPropertyDescriptors:function(e){var t,a,r=i(e),s=n.f,c=l(r),u={},f=0;while(c.length>f)a=s(r,t=c[f++]),void 0!==a&&o(u,t,a);return u}})},9093:function(e,t,a){var r=a("ce10"),l=a("e11e").concat("length","prototype");t.f=Object.getOwnPropertyNames||function(e){return r(e,l)}},"990b":function(e,t,a){var r=a("9093"),l=a("2621"),i=a("cb7c"),n=a("7726").Reflect;e.exports=n&&n.ownKeys||function(e){var t=r.f(i(e)),a=l.f;return a?t.concat(a(e)):t}},ac6a:function(e,t,a){for(var r=a("cadf"),l=a("0d58"),i=a("2aba"),n=a("7726"),o=a("32e9"),s=a("84f2"),c=a("2b4c"),u=c("iterator"),f=c("toStringTag"),d=s.Array,m={CSSRuleList:!0,CSSStyleDeclaration:!1,CSSValueList:!1,ClientRectList:!1,DOMRectList:!1,DOMStringList:!1,DOMTokenList:!0,DataTransferItemList:!1,FileList:!1,HTMLAllCollection:!1,HTMLCollection:!1,HTMLFormElement:!1,HTMLSelectElement:!1,MediaList:!0,MimeTypeArray:!1,NamedNodeMap:!1,NodeList:!0,PaintRequestList:!1,Plugin:!1,PluginArray:!1,SVGLengthList:!1,SVGNumberList:!1,SVGPathSegList:!1,SVGPointList:!1,SVGStringList:!1,SVGTransformList:!1,SourceBufferList:!1,StyleSheetList:!0,TextTrackCueList:!1,TextTrackList:!1,TouchList:!1},b=l(m),p=0;p<b.length;p++){var h,g=b[p],y=m[g],v=n[g],S=v&&v.prototype;if(S&&(S[u]||o(S,u,d),S[f]||o(S,f,g),s[g]=d,y))for(h in r)S[h]||i(S,h,r[h],!0)}},bbd5:function(e,t,a){"use strict";a.d(t,"a",(function(){return i})),a.d(t,"b",(function(){return n})),a.d(t,"c",(function(){return o})),a.d(t,"d",(function(){return s})),a.d(t,"e",(function(){return c}));var r=a("c1df"),l=a.n(r);function i(e,t){return l()(e).format(t)}function n(e){return l()(e).format("YYYY-MM-DD")}function o(e){return l()(e).format("YYYY-MM-DD HH-mm-ss")}function s(e){return l()(e).format("YYYY-MM")}function c(e){return l()(e).format("YYYY")}},bd86:function(e,t,a){"use strict";a.d(t,"a",(function(){return i}));var r=a("85f2"),l=a.n(r);function i(e,t,a){return t in e?l()(e,t,{value:a,enumerable:!0,configurable:!0,writable:!0}):e[t]=a,e}},f1ae:function(e,t,a){"use strict";var r=a("86cc"),l=a("4630");e.exports=function(e,t,a){t in e?r.f(e,t,l(0,a)):e[t]=a}}}]);
//# sourceMappingURL=chunk-3c393306.afdb4c93.js.map