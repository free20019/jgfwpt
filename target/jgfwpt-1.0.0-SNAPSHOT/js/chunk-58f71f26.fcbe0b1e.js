(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-58f71f26"],{"11e9":function(e,t,n){var a=n("52a7"),r=n("4630"),o=n("6821"),l=n("6a99"),i=n("69a8"),c=n("c69a"),u=Object.getOwnPropertyDescriptor;t.f=n("9e1e")?u:function(e,t){if(e=o(e),t=l(t,!0),c)try{return u(e,t)}catch(n){}if(i(e,t))return r(!a.f.call(e,t),e[t])}},3112:function(e,t,n){"use strict";n.r(t);var a=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"tw-template-wrapper"},[n("el-form",{staticClass:"tw-query-bar",attrs:{inline:!0,model:e.query,size:"small"}},[n("el-form-item",[n("el-autocomplete",{staticClass:"inline-input",attrs:{placeholder:"公司名称","fetch-suggestions":e.queryCompanyNameSearch,"trigger-on-focus":!1},model:{value:e.query.companyName,callback:function(t){e.$set(e.query,"companyName",t)},expression:"query.companyName"}})],1),n("el-form-item",[n("el-select",{attrs:{placeholder:"类型"},model:{value:e.query.type,callback:function(t){e.$set(e.query,"type",t)},expression:"query.type"}},e._l(e.getUserType,(function(e){return n("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})})),1)],1),n("el-form-item",[n("el-select",{attrs:{placeholder:"区域"},model:{value:e.query.region,callback:function(t){e.$set(e.query,"region",t)},expression:"query.region"}},e._l(e.getRegion,(function(e){return n("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})})),1)],1),n("el-form-item",[n("el-input",{attrs:{placeholder:"最小规模"},model:{value:e.query.minNum,callback:function(t){e.$set(e.query,"minNum",t)},expression:"query.minNum"}})],1),n("el-form-item",[n("el-input",{attrs:{placeholder:"最大规模"},model:{value:e.query.maxNum,callback:function(t){e.$set(e.query,"maxNum",t)},expression:"query.maxNum"}})],1),n("el-form-item",[n("el-button",{attrs:{type:"primary"},on:{click:e.handleQueryClick}},[e._v("查询")]),n("el-button",{attrs:{type:"primary"},on:{click:e.handleExportClick}},[e._v("导出")])],1)],1),n("div",{staticClass:"tw-query-panel"},[n("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.table.loading,expression:"table.loading"}],staticStyle:{width:"100%","margin-bottom":"10px"},attrs:{data:e.filterTableList,border:"",size:"small",height:"calc(100% - 42px)"}},[n("el-table-column",{attrs:{type:"index",label:"序号",width:"60"}}),n("el-table-column",{attrs:{prop:"NAME",label:"公司名称","min-width":"280"}}),n("el-table-column",{attrs:{prop:"VEHICLE_SUM",label:"规模",width:"140"}}),n("el-table-column",{attrs:{prop:"AREA_NAME",label:"区域",width:"180"}}),n("el-table-column",{attrs:{prop:"ECONOMIC_NAME",label:"性质",width:"180"}}),n("el-table-column",{attrs:{prop:"RESPONSIBLE_PERSON",label:"负责人",width:"100"}}),n("el-table-column",{attrs:{prop:"LICENSE_NUMBER",label:"经营许可证号",width:"120"}}),n("el-table-column",{attrs:{prop:"RESPONSIBLE_PERSON_PHONE",label:"联系方式",width:"120"}}),n("el-table-column",{attrs:{prop:"LICENSE_VALID_PERIOD_FROM",label:"许可证起",width:"120"}}),n("el-table-column",{attrs:{prop:"LICENSE_VALID_PERIOD_END",label:"许可证止",width:"120"}}),n("el-table-column",{attrs:{prop:"LICENSE_ISSUING_DATE",label:"发放日期",width:"100"}}),n("el-table-column",{attrs:{prop:"BUSINESS_SCOPE_NAME",label:"经营范围",width:"140"}}),n("el-table-column",{attrs:{prop:"BUSINESS_STATUS_NAME",label:"经营状态",width:"100"}}),n("el-table-column",{attrs:{prop:"COLOR",label:"车身颜色",width:"100"}}),n("el-table-column",{attrs:{prop:"AREA_NAME",label:"行政区划",width:"100"}}),n("el-table-column",{attrs:{prop:"IS_EXPIRED",label:"证照是否过期",width:"100"}}),n("el-table-column",{attrs:{prop:"FUEL_NAME",label:"燃料类型",width:"100"}}),n("el-table-column",{attrs:{prop:"EMISSION_STANDARD_NAME",label:"排放标准",width:"100"}})],1),n("el-pagination",{attrs:{background:"","page-size":e.table.pageSize,"current-page":e.table.currentPage,total:e.table.total,layout:"prev, pager, next, total"},on:{"current-change":e.handleTablePageCurrentChange}})],1)],1)},r=[],o=(n("8e6e"),n("ac6a"),n("456d"),n("bd86")),l=n("17fb"),i=n.n(l),c=n("bc3a"),u=n.n(c),s=(n("c1df"),n("2f62"));n("bbd5");function p(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(e);t&&(a=a.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),n.push.apply(n,a)}return n}function m(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{};t%2?p(n,!0).forEach((function(t){Object(o["a"])(e,t,n[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):p(n).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(n,t))}))}return e}var f={name:"CompanyInfo",data:function(){return{query:{companyName:"",type:"",region:"",minNum:"",maxNum:""},table:{loading:!1,data:[],pageSize:20,currentPage:1,total:0}}},mounted:function(){var e=this;this.$nextTick((function(){e.getCompanyInformation()}))},computed:m({},Object(s["b"])(["getCompanyName","getRegion","getUserType"]),{filterTableList:function(){var e=this.table,t=e.data,n=e.pageSize,a=e.currentPage,r=a-1;return i.a.filter(t,(function(e,t){return t>=r*n&&t<a*n}))}}),methods:{getCompanyInformation:function(){var e=this;this.table.loading=!0;var t=this.query,n=t.companyName,a=t.type,r=t.region,o=t.minNum,l=t.maxNum;u.a.get("transportationDataAccess/getCompanyInformation",{baseURL:this.baseURL,params:{companyName:n,region:r,type:a,minNum:o,maxNum:l}}).then((function(t){console.info(t.data),e.table.data=t.data||[],e.table.currentPage=1,e.table.total=e.table.data.length,e.table.loading=!1}))},queryCompanyNameSearch:function(e,t){t(i.a.filter(this.getCompanyName,(function(t){return t.label.indexOf(e)>-1})))},handleQueryClick:function(){this.table.currentPage=1,this.getCompanyInformation()},handleExportClick:function(){var e=this,t=this.query,n=t.companyName,a=t.region,r=t.type,o=t.minNum,l=t.maxNum;this.$confirm("是否需要导出?","提示",{confirmButtonText:"是",cancelButtonText:"否",cancelButtonClass:"el-button--danger",closeOnClickModal:!1,type:"info",center:!0}).then((function(){window.open("".concat(e.baseURL,"transportationDataAccess/getCompanyInformationExcel?companyName=").concat(n,"&type=").concat(r,"&region=").concat(a,"&minNum=").concat(o,"&maxNum=").concat(l))})).catch((function(){}))},handleTablePageCurrentChange:function(e){this.table.currentPage=e}}},b=f,d=n("2877"),y=Object(d["a"])(b,a,r,!1,null,"45dc8aaf",null);t["default"]=y.exports},"454f":function(e,t,n){n("46a7");var a=n("584a").Object;e.exports=function(e,t,n){return a.defineProperty(e,t,n)}},"456d":function(e,t,n){var a=n("4bf8"),r=n("0d58");n("5eda")("keys",(function(){return function(e){return r(a(e))}}))},"46a7":function(e,t,n){var a=n("63b6");a(a.S+a.F*!n("8e60"),"Object",{defineProperty:n("d9f6").f})},"5eda":function(e,t,n){var a=n("5ca1"),r=n("8378"),o=n("79e5");e.exports=function(e,t){var n=(r.Object||{})[e]||Object[e],l={};l[e]=t(n),a(a.S+a.F*o((function(){n(1)})),"Object",l)}},"85f2":function(e,t,n){e.exports=n("454f")},"8e6e":function(e,t,n){var a=n("5ca1"),r=n("990b"),o=n("6821"),l=n("11e9"),i=n("f1ae");a(a.S,"Object",{getOwnPropertyDescriptors:function(e){var t,n,a=o(e),c=l.f,u=r(a),s={},p=0;while(u.length>p)n=c(a,t=u[p++]),void 0!==n&&i(s,t,n);return s}})},9093:function(e,t,n){var a=n("ce10"),r=n("e11e").concat("length","prototype");t.f=Object.getOwnPropertyNames||function(e){return a(e,r)}},"990b":function(e,t,n){var a=n("9093"),r=n("2621"),o=n("cb7c"),l=n("7726").Reflect;e.exports=l&&l.ownKeys||function(e){var t=a.f(o(e)),n=r.f;return n?t.concat(n(e)):t}},ac6a:function(e,t,n){for(var a=n("cadf"),r=n("0d58"),o=n("2aba"),l=n("7726"),i=n("32e9"),c=n("84f2"),u=n("2b4c"),s=u("iterator"),p=u("toStringTag"),m=c.Array,f={CSSRuleList:!0,CSSStyleDeclaration:!1,CSSValueList:!1,ClientRectList:!1,DOMRectList:!1,DOMStringList:!1,DOMTokenList:!0,DataTransferItemList:!1,FileList:!1,HTMLAllCollection:!1,HTMLCollection:!1,HTMLFormElement:!1,HTMLSelectElement:!1,MediaList:!0,MimeTypeArray:!1,NamedNodeMap:!1,NodeList:!0,PaintRequestList:!1,Plugin:!1,PluginArray:!1,SVGLengthList:!1,SVGNumberList:!1,SVGPathSegList:!1,SVGPointList:!1,SVGStringList:!1,SVGTransformList:!1,SourceBufferList:!1,StyleSheetList:!0,TextTrackCueList:!1,TextTrackList:!1,TouchList:!1},b=r(f),d=0;d<b.length;d++){var y,g=b[d],h=f[g],N=l[g],S=N&&N.prototype;if(S&&(S[s]||i(S,s,m),S[p]||i(S,p,g),c[g]=m,h))for(y in a)S[y]||o(S,y,a[y],!0)}},bbd5:function(e,t,n){"use strict";n.d(t,"a",(function(){return o})),n.d(t,"b",(function(){return l})),n.d(t,"c",(function(){return i})),n.d(t,"d",(function(){return c})),n.d(t,"e",(function(){return u}));var a=n("c1df"),r=n.n(a);function o(e,t){return r()(e).format(t)}function l(e){return r()(e).format("YYYY-MM-DD")}function i(e){return r()(e).format("YYYY-MM-DD HH-mm-ss")}function c(e){return r()(e).format("YYYY-MM")}function u(e){return r()(e).format("YYYY")}},bd86:function(e,t,n){"use strict";n.d(t,"a",(function(){return o}));var a=n("85f2"),r=n.n(a);function o(e,t,n){return t in e?r()(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}},f1ae:function(e,t,n){"use strict";var a=n("86cc"),r=n("4630");e.exports=function(e,t,n){t in e?a.f(e,t,r(0,n)):e[t]=n}}}]);
//# sourceMappingURL=chunk-58f71f26.fcbe0b1e.js.map