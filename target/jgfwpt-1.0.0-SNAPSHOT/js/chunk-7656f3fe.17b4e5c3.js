(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-7656f3fe"],{"11e9":function(e,t,n){var r=n("52a7"),a=n("4630"),i=n("6821"),c=n("6a99"),l=n("69a8"),o=n("c69a"),u=Object.getOwnPropertyDescriptor;t.f=n("9e1e")?u:function(e,t){if(e=i(e),t=c(t,!0),o)try{return u(e,t)}catch(n){}if(l(e,t))return a(!r.f.call(e,t),e[t])}},"454f":function(e,t,n){n("46a7");var r=n("584a").Object;e.exports=function(e,t,n){return r.defineProperty(e,t,n)}},"456d":function(e,t,n){var r=n("4bf8"),a=n("0d58");n("5eda")("keys",(function(){return function(e){return a(r(e))}}))},"46a7":function(e,t,n){var r=n("63b6");r(r.S+r.F*!n("8e60"),"Object",{defineProperty:n("d9f6").f})},"562c":function(e,t,n){"use strict";var r=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",[n("span",[e._v(e._s(e.data))]),e.unit?n("span",[e._v(e._s(e.unit))]):n("span",[e._t("default")],2)])},a=[],i={name:"Unit",props:{data:"",unit:""},computed:{}},c=i,l=n("2877"),o=Object(l["a"])(c,r,a,!1,null,"efe364cc",null);t["a"]=o.exports},"5eda":function(e,t,n){var r=n("5ca1"),a=n("8378"),i=n("79e5");e.exports=function(e,t){var n=(a.Object||{})[e]||Object[e],c={};c[e]=t(n),r(r.S+r.F*i((function(){n(1)})),"Object",c)}},"85f2":function(e,t,n){e.exports=n("454f")},"8e6e":function(e,t,n){var r=n("5ca1"),a=n("990b"),i=n("6821"),c=n("11e9"),l=n("f1ae");r(r.S,"Object",{getOwnPropertyDescriptors:function(e){var t,n,r=i(e),o=c.f,u=a(r),s={},f=0;while(u.length>f)n=o(r,t=u[f++]),void 0!==n&&l(s,t,n);return s}})},9064:function(e,t,n){"use strict";n.r(t);var r=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"tw-template-wrapper"},[n("el-form",{staticClass:"tw-query-bar",attrs:{inline:!0,model:e.query,size:"small"}},[n("el-form-item",[n("el-autocomplete",{staticClass:"inline-input",attrs:{placeholder:"车牌号码","fetch-suggestions":e.queryVehicleSearch,"trigger-on-focus":!1},model:{value:e.query.vehicle,callback:function(t){e.$set(e.query,"vehicle",t)},expression:"query.vehicle"}})],1),n("el-form-item",[n("el-autocomplete",{staticClass:"inline-input",attrs:{placeholder:"公司名称","fetch-suggestions":e.queryCompanyNameSearch,"trigger-on-focus":!1},model:{value:e.query.companyName,callback:function(t){e.$set(e.query,"companyName",t)},expression:"query.companyName"}})],1),n("el-form-item",[n("el-select",{attrs:{placeholder:"区域"},model:{value:e.query.area,callback:function(t){e.$set(e.query,"area",t)},expression:"query.area"}},e._l(e.getRegionReal,(function(e){return n("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})})),1)],1),n("el-form-item",[n("el-input",{attrs:{placeholder:"回场次数"},model:{value:e.query.count,callback:function(t){e.$set(e.query,"count",t)},expression:"query.count"}})],1),n("el-form-item",[n("el-date-picker",{attrs:{type:"datetime",placeholder:"开始日期"},model:{value:e.query.stime,callback:function(t){e.$set(e.query,"stime",t)},expression:"query.stime"}})],1),n("el-form-item",[n("el-date-picker",{attrs:{type:"datetime",placeholder:"结束日期"},model:{value:e.query.etime,callback:function(t){e.$set(e.query,"etime",t)},expression:"query.etime"}})],1),n("el-form-item",[n("el-button",{attrs:{type:"primary"},on:{click:e.handleQueryClick}},[e._v("查询")])],1)],1),n("div",{staticClass:"tw-query-panel"},[n("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.table.loading,expression:"table.loading"}],staticStyle:{width:"100%","margin-bottom":"10px"},attrs:{data:e.filterTableList,border:"",size:"small",height:"calc(100% - 42px)"}},[n("el-table-column",{attrs:{type:"index",label:"序号",width:"60",resizable:!1,fixed:""}}),n("el-table-column",{attrs:{prop:"cphm",label:"车牌号码",width:"140",fixed:""}}),n("el-table-column",{attrs:{prop:"ssgs",label:"所属公司",width:"280","show-overflow-tooltip":""}}),n("el-table-column",{attrs:{prop:"hcqy",label:"回场区域",width:"240"}}),n("el-table-column",{attrs:{prop:"area",label:"区域",width:"240"}}),n("el-table-column",{attrs:{prop:"hcss",label:"回场时间",width:"150"}}),n("el-table-column",{attrs:{label:"回场间隔",width:"150"},scopedSlots:e._u([{key:"default",fn:function(e){return[n("tw-unit",{attrs:{data:e.row.hcjg,unit:"天"}})]}}])}),n("el-table-column",{attrs:{prop:"hccs",label:"回场次数","min-width":"160",resizable:!1}})],1),n("el-pagination",{attrs:{background:"","page-size":e.table.pageSize,"current-page":e.table.currentPage,total:e.table.total,layout:"prev, pager, next, total"},on:{"current-change":e.handleTablePageCurrentChange}})],1)],1)},a=[],i=(n("8e6e"),n("ac6a"),n("456d"),n("bd86")),c=n("17fb"),l=n.n(c),o=n("bc3a"),u=n.n(o),s=n("c1df"),f=n.n(s),p=n("2f62"),m=n("562c"),b=n("bbd5");function d(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);t&&(r=r.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),n.push.apply(n,r)}return n}function h(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{};t%2?d(n,!0).forEach((function(t){Object(i["a"])(e,t,n[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):d(n).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(n,t))}))}return e}var y={name:"ReturnVehicleInquiry",data:function(){return{query:{vehicle:"",companyName:"",area:"",count:"",stime:"",etime:""},companyList:[],table:{loading:!1,data:[],pageSize:20,currentPage:1,total:0}}},mounted:function(){var e=this;this.$nextTick((function(){e.query.stime=f()().format("YYYY-MM-DD 00:00:00"),e.query.etime=f()().format("YYYY-MM-DD 23:59:59"),e.getReturnVehicleInquiry()}))},computed:h({},Object(p["b"])(["getLPNumber","getCompanyName","getRegionReal"]),{filterTableList:function(){var e=this.table,t=e.data,n=e.pageSize,r=e.currentPage,a=r-1;return l.a.filter(t,(function(e,t){return t>=a*n&&t<r*n}))}}),methods:{queryVehicleSearch:function(e,t){e.length<3?t(null):t(l.a.filter(this.getLPNumber,(function(t){return t.label.indexOf(e)>-1})))},queryCompanyNameSearch:function(e,t){t(l.a.filter(this.getCompanyName,(function(t){return t.label.indexOf(e)>-1})))},getReturnVehicleInquiry:function(){var e=this;this.table.loading=!0;var t=this.query,n=t.vehicle,r=t.companyName,a=t.area,i=t.count,c=t.stime,o=t.etime;u.a.get("area/returnvehicleinquiry",{baseURL:this.baseURL,params:{vehicle:n,companyName:r,area:a,count:i,stime:c&&Object(b["c"])(c),etime:o&&Object(b["c"])(o)}}).then((function(t){console.log(t.data),e.table.data=l.a.map(t.data,(function(e){return{cphm:e.VEHICLE_NO,ssgs:e.COMPANY_NAME,hcss:e.HCSJ,hcqy:e.AREA_NAME,area:e.AREA,hcjg:e.RETURN_TIME,hccs:e.HCCS}})),e.table.total=e.table.data.length,e.table.currentPage=1,e.table.loading=!1})).catch((function(e){console.log(e)}))},handleQueryClick:function(){this.getReturnVehicleInquiry()},handleTablePageCurrentChange:function(e){this.table.currentPage=e}},components:{"tw-unit":m["a"]}},g=y,v=n("2877"),O=Object(v["a"])(g,r,a,!1,null,"c6513e3e",null);t["default"]=O.exports},9093:function(e,t,n){var r=n("ce10"),a=n("e11e").concat("length","prototype");t.f=Object.getOwnPropertyNames||function(e){return r(e,a)}},"990b":function(e,t,n){var r=n("9093"),a=n("2621"),i=n("cb7c"),c=n("7726").Reflect;e.exports=c&&c.ownKeys||function(e){var t=r.f(i(e)),n=a.f;return n?t.concat(n(e)):t}},ac6a:function(e,t,n){for(var r=n("cadf"),a=n("0d58"),i=n("2aba"),c=n("7726"),l=n("32e9"),o=n("84f2"),u=n("2b4c"),s=u("iterator"),f=u("toStringTag"),p=o.Array,m={CSSRuleList:!0,CSSStyleDeclaration:!1,CSSValueList:!1,ClientRectList:!1,DOMRectList:!1,DOMStringList:!1,DOMTokenList:!0,DataTransferItemList:!1,FileList:!1,HTMLAllCollection:!1,HTMLCollection:!1,HTMLFormElement:!1,HTMLSelectElement:!1,MediaList:!0,MimeTypeArray:!1,NamedNodeMap:!1,NodeList:!0,PaintRequestList:!1,Plugin:!1,PluginArray:!1,SVGLengthList:!1,SVGNumberList:!1,SVGPathSegList:!1,SVGPointList:!1,SVGStringList:!1,SVGTransformList:!1,SourceBufferList:!1,StyleSheetList:!0,TextTrackCueList:!1,TextTrackList:!1,TouchList:!1},b=a(m),d=0;d<b.length;d++){var h,y=b[d],g=m[y],v=c[y],O=v&&v.prototype;if(O&&(O[s]||l(O,s,p),O[f]||l(O,f,y),o[y]=p,g))for(h in r)O[h]||i(O,h,r[h],!0)}},bbd5:function(e,t,n){"use strict";n.d(t,"a",(function(){return i})),n.d(t,"b",(function(){return c})),n.d(t,"c",(function(){return l})),n.d(t,"d",(function(){return o})),n.d(t,"e",(function(){return u}));var r=n("c1df"),a=n.n(r);function i(e,t){return a()(e).format(t)}function c(e){return a()(e).format("YYYY-MM-DD")}function l(e){return a()(e).format("YYYY-MM-DD HH-mm-ss")}function o(e){return a()(e).format("YYYY-MM")}function u(e){return a()(e).format("YYYY")}},bd86:function(e,t,n){"use strict";n.d(t,"a",(function(){return i}));var r=n("85f2"),a=n.n(r);function i(e,t,n){return t in e?a()(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}},f1ae:function(e,t,n){"use strict";var r=n("86cc"),a=n("4630");e.exports=function(e,t,n){t in e?r.f(e,t,a(0,n)):e[t]=n}}}]);
//# sourceMappingURL=chunk-7656f3fe.17b4e5c3.js.map