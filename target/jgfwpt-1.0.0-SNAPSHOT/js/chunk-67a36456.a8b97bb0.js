(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-67a36456"],{"11e9":function(e,t,n){var a=n("52a7"),r=n("4630"),i=n("6821"),o=n("6a99"),c=n("69a8"),l=n("c69a"),u=Object.getOwnPropertyDescriptor;t.f=n("9e1e")?u:function(e,t){if(e=i(e),t=o(t,!0),l)try{return u(e,t)}catch(n){}if(c(e,t))return r(!a.f.call(e,t),e[t])}},"454f":function(e,t,n){n("46a7");var a=n("584a").Object;e.exports=function(e,t,n){return a.defineProperty(e,t,n)}},"456d":function(e,t,n){var a=n("4bf8"),r=n("0d58");n("5eda")("keys",(function(){return function(e){return r(a(e))}}))},"46a7":function(e,t,n){var a=n("63b6");a(a.S+a.F*!n("8e60"),"Object",{defineProperty:n("d9f6").f})},"562c":function(e,t,n){"use strict";var a=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",[n("span",[e._v(e._s(e.data))]),e.unit?n("span",[e._v(e._s(e.unit))]):n("span",[e._t("default")],2)])},r=[],i={name:"Unit",props:{data:"",unit:""},computed:{}},o=i,c=n("2877"),l=Object(c["a"])(o,a,r,!1,null,"efe364cc",null);t["a"]=l.exports},"5eda":function(e,t,n){var a=n("5ca1"),r=n("8378"),i=n("79e5");e.exports=function(e,t){var n=(r.Object||{})[e]||Object[e],o={};o[e]=t(n),a(a.S+a.F*i((function(){n(1)})),"Object",o)}},"85f2":function(e,t,n){e.exports=n("454f")},"8e6e":function(e,t,n){var a=n("5ca1"),r=n("990b"),i=n("6821"),o=n("11e9"),c=n("f1ae");a(a.S,"Object",{getOwnPropertyDescriptors:function(e){var t,n,a=i(e),l=o.f,u=r(a),s={},f=0;while(u.length>f)n=l(a,t=u[f++]),void 0!==n&&c(s,t,n);return s}})},9093:function(e,t,n){var a=n("ce10"),r=n("e11e").concat("length","prototype");t.f=Object.getOwnPropertyNames||function(e){return a(e,r)}},"990b":function(e,t,n){var a=n("9093"),r=n("2621"),i=n("cb7c"),o=n("7726").Reflect;e.exports=o&&o.ownKeys||function(e){var t=a.f(i(e)),n=r.f;return n?t.concat(n(e)):t}},ac6a:function(e,t,n){for(var a=n("cadf"),r=n("0d58"),i=n("2aba"),o=n("7726"),c=n("32e9"),l=n("84f2"),u=n("2b4c"),s=u("iterator"),f=u("toStringTag"),p=l.Array,m={CSSRuleList:!0,CSSStyleDeclaration:!1,CSSValueList:!1,ClientRectList:!1,DOMRectList:!1,DOMStringList:!1,DOMTokenList:!0,DataTransferItemList:!1,FileList:!1,HTMLAllCollection:!1,HTMLCollection:!1,HTMLFormElement:!1,HTMLSelectElement:!1,MediaList:!0,MimeTypeArray:!1,NamedNodeMap:!1,NodeList:!0,PaintRequestList:!1,Plugin:!1,PluginArray:!1,SVGLengthList:!1,SVGNumberList:!1,SVGPathSegList:!1,SVGPointList:!1,SVGStringList:!1,SVGTransformList:!1,SourceBufferList:!1,StyleSheetList:!0,TextTrackCueList:!1,TextTrackList:!1,TouchList:!1},b=r(m),d=0;d<b.length;d++){var y,h=b[d],g=m[h],v=o[h],O=v&&v.prototype;if(O&&(O[s]||c(O,s,p),O[f]||c(O,f,h),l[h]=p,g))for(y in a)O[y]||i(O,y,a[y],!0)}},bbd5:function(e,t,n){"use strict";n.d(t,"a",(function(){return i})),n.d(t,"b",(function(){return o})),n.d(t,"c",(function(){return c})),n.d(t,"d",(function(){return l})),n.d(t,"e",(function(){return u}));var a=n("c1df"),r=n.n(a);function i(e,t){return r()(e).format(t)}function o(e){return r()(e).format("YYYY-MM-DD")}function c(e){return r()(e).format("YYYY-MM-DD HH-mm-ss")}function l(e){return r()(e).format("YYYY-MM")}function u(e){return r()(e).format("YYYY")}},bd86:function(e,t,n){"use strict";n.d(t,"a",(function(){return i}));var a=n("85f2"),r=n.n(a);function i(e,t,n){return t in e?r()(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}},c45e:function(e,t,n){"use strict";n.r(t);var a=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"tw-template-wrapper"},[n("el-form",{staticClass:"tw-query-bar",attrs:{inline:!0,model:e.query,size:"small"}},[n("el-form-item",[n("el-autocomplete",{staticClass:"inline-input",attrs:{placeholder:"公司名称","fetch-suggestions":e.queryCompanyNameSearch,"trigger-on-focus":!1},model:{value:e.query.companyName,callback:function(t){e.$set(e.query,"companyName",t)},expression:"query.companyName"}})],1),n("el-form-item",[n("el-date-picker",{attrs:{type:"datetime",placeholder:"开始日期"},model:{value:e.query.stime,callback:function(t){e.$set(e.query,"stime",t)},expression:"query.stime"}})],1),n("el-form-item",[n("el-date-picker",{attrs:{type:"datetime",placeholder:"结束日期"},model:{value:e.query.etime,callback:function(t){e.$set(e.query,"etime",t)},expression:"query.etime"}})],1),n("el-form-item",[n("el-button",{attrs:{type:"primary"},on:{click:e.handleQueryClick}},[e._v("查询")]),n("el-button",{attrs:{type:"primary"},on:{click:e.handleExportClick}},[e._v("导出")])],1)],1),n("div",{staticClass:"tw-query-panel"},[n("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.table.loading,expression:"table.loading"}],staticStyle:{width:"100%","margin-bottom":"10px"},attrs:{data:e.filterTableList,border:"",size:"small",height:"calc(100% - 42px)"}},[n("el-table-column",{attrs:{type:"index",label:"序号",width:"60"}}),n("el-table-column",{attrs:{prop:"ZGS",label:"公司","min-width":"240"}}),n("el-table-column",{attrs:{prop:"VEHINUMBER",label:"营运车辆数/辆",width:"240"}}),n("el-table-column",{attrs:{prop:"TJCS",label:"营运数/次",width:"180"}}),n("el-table-column",{attrs:{prop:"JINE",label:"营运金额/元",width:"180"}}),n("el-table-column",{attrs:{prop:"ZLC",label:"总里程/公里",width:"180"}}),n("el-table-column",{attrs:{prop:"SZLC",label:"载客里程/公里",width:"180"}}),n("el-table-column",{attrs:{prop:"KSLC",label:"空驶里程/公里",width:"180"}}),n("el-table-column",{attrs:{prop:"RATE",label:"实载率",width:"180"}}),n("el-table-column",{attrs:{prop:"YSSC",label:"载客时间/分钟",width:"180"}}),n("el-table-column",{attrs:{prop:"DHSJ",label:"载客等候时间/分钟",width:"180"}})],1),n("el-pagination",{attrs:{background:"","page-size":e.table.pageSize,"current-page":e.table.currentPage,total:e.table.total,layout:"prev, pager, next, total"},on:{"current-change":e.handleTablePageCurrentChange}})],1)],1)},r=[],i=(n("8e6e"),n("ac6a"),n("456d"),n("bd86")),o=n("17fb"),c=n.n(o),l=n("bc3a"),u=n.n(l),s=n("c1df"),f=n.n(s),p=n("562c"),m=n("bbd5"),b=n("2f62");function d(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(e);t&&(a=a.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),n.push.apply(n,a)}return n}function y(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{};t%2?d(n,!0).forEach((function(t){Object(i["a"])(e,t,n[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):d(n).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(n,t))}))}return e}var h={name:"EnterpriseVehicleOperation",data:function(){return{query:{companyName:"",stime:"",etime:""},lpNumberLoading:!1,lpNumberOption:[],table:{loading:!1,data:[{gosi:"临安众安客运出租汽车有限公司",clis:68,yyus:43,cclv:"63.24%",yycs:448,yyje:6998,zlic:3192,zklc:1743,kslc:1449,szlv:"54.60%",zksj:4948,zkdhsj:1990}],pageSize:20,currentPage:1,total:0}}},mounted:function(){var e=this;this.$nextTick((function(){e.query.stime=Object(m["a"])(f()(),"YYYY-MM-DD 00:00:00"),e.query.etime=Object(m["a"])(f()(),"YYYY-MM-DD 23:59:59"),e.getVehicleOperation(),e.getCompany()}))},computed:y({},Object(b["b"])(["getCompanyName"]),{filterTableList:function(){var e=this.table,t=e.data,n=e.pageSize,a=e.currentPage,r=a-1;return c.a.filter(t,(function(e,t){return t>=r*n&&t<a*n}))}}),methods:{getVehicleOperation:function(){var e=this;this.table.loading=!0;var t=this.query,n=t.companyName,a=t.stime,r=t.etime;u.a.get("industryOperation/getVehicleOperation",{baseURL:this.baseURL,params:{companyName:n,stime:a&&f()(a).format("YYYY-MM-DD HH:mm:ss"),etime:r&&f()(r).format("YYYY-MM-DD HH:mm:ss")}}).then((function(t){console.info(t.data),e.table.data=t.data||[],e.table.currentPage=1,e.table.total=e.table.data.length,e.table.loading=!1}))},queryCompanyNameSearch:function(e,t){t(c.a.filter(this.getCompanyName,(function(t){return t.label.indexOf(e)>-1})))},handleQueryClick:function(){this.table.currentPage=1,this.getVehicleOperation()},handleExportClick:function(){var e=this,t=this.query,n=t.companyName,a=t.stime,r=t.etime;this.$confirm("是否需要导出?","提示",{confirmButtonText:"是",cancelButtonText:"否",cancelButtonClass:"el-button--danger",closeOnClickModal:!1,type:"info",center:!0}).then((function(){window.open("".concat(e.baseURL,"industryOperation/getVehicleOperationExcel?companyName=").concat(n,"&stime=").concat(a&&f()(a).format("YYYY-MM-DD HH:mm:ss"),"&etime=").concat(r&&f()(r).format("YYYY-MM-DD HH:mm:ss")))})).catch((function(){}))},handleTablePageCurrentChange:function(e){this.table.currentPage=e}},components:{"tw-unit":p["a"]}},g=h,v=n("2877"),O=Object(v["a"])(g,a,r,!1,null,"31cebaae",null);t["default"]=O.exports},f1ae:function(e,t,n){"use strict";var a=n("86cc"),r=n("4630");e.exports=function(e,t,n){t in e?a.f(e,t,r(0,n)):e[t]=n}}}]);
//# sourceMappingURL=chunk-67a36456.a8b97bb0.js.map