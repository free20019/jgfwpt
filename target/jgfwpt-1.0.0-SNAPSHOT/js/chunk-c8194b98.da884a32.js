(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-c8194b98"],{"0bfb":function(t,e,n){"use strict";var r=n("cb7c");t.exports=function(){var t=r(this),e="";return t.global&&(e+="g"),t.ignoreCase&&(e+="i"),t.multiline&&(e+="m"),t.unicode&&(e+="u"),t.sticky&&(e+="y"),e}},"11e9":function(t,e,n){var r=n("52a7"),a=n("4630"),o=n("6821"),i=n("6a99"),s=n("69a8"),c=n("c69a"),l=Object.getOwnPropertyDescriptor;e.f=n("9e1e")?l:function(t,e){if(t=o(t),e=i(e,!0),c)try{return l(t,e)}catch(n){}if(s(t,e))return a(!r.f.call(t,e),t[e])}},3846:function(t,e,n){n("9e1e")&&"g"!=/./g.flags&&n("86cc").f(RegExp.prototype,"flags",{configurable:!0,get:n("0bfb")})},"454f":function(t,e,n){n("46a7");var r=n("584a").Object;t.exports=function(t,e,n){return r.defineProperty(t,e,n)}},"456d":function(t,e,n){var r=n("4bf8"),a=n("0d58");n("5eda")("keys",(function(){return function(t){return a(r(t))}}))},"46a7":function(t,e,n){var r=n("63b6");r(r.S+r.F*!n("8e60"),"Object",{defineProperty:n("d9f6").f})},"5dbc":function(t,e,n){var r=n("d3f4"),a=n("8b97").set;t.exports=function(t,e,n){var o,i=e.constructor;return i!==n&&"function"==typeof i&&(o=i.prototype)!==n.prototype&&r(o)&&a&&a(t,o),t}},"5eda":function(t,e,n){var r=n("5ca1"),a=n("8378"),o=n("79e5");t.exports=function(t,e){var n=(a.Object||{})[t]||Object[t],i={};i[t]=e(n),r(r.S+r.F*o((function(){n(1)})),"Object",i)}},"699f":function(t,e,n){"use strict";var r=function(){var t=this,e=t.$createElement,n=t._self._c||e;return 1===t.systemFault?n("div",{staticStyle:{"text-align":"center"}},[n("span",{class:t.formatSystemReviewClassName(t.systemFault)},[t._v("故障:")]),n("div",{staticStyle:{display:"inline-block",width:"100px","text-align":"center"}},[0===t.fault?n("div",[n("el-button",{staticClass:"tw-table-button",attrs:{size:"mini"},on:{click:function(e){return t.handleReviewClick(t.item)}}},[t._v("属实")]),n("el-button",{staticClass:"tw-table-button",attrs:{size:"mini"},on:{click:function(e){return t.handleNoReviewClick(t.item)}}},[t._v("不属实")])],1):n("span",{class:t.formatReviewClassName(t.fault)},[t._v(t._s(t.formatReviewType(t.fault)))])])]):n("div",{staticStyle:{"text-align":"center"}},[n("span",{class:t.formatSystemReviewClassName(t.systemFault)},[t._v("无故障")])])},a=[],o=(n("c5f6"),{name:"FaultReview",data:function(){return{}},props:{item:Object,fault:Number,systemFault:Number,type:String},methods:{handleReviewClick:function(t){var e=this,n=this.fault,r=this.systemFault,a=this.type;this.$confirm("是否确定?","提示",{confirmButtonText:"是",cancelButtonText:"否",cancelButtonClass:"el-button--danger",closeOnClickModal:!1,type:"info",center:!0}).then((function(){e.$emit("true-review-click",{id:t.id,fault:n,systemFault:r,type:a})})).catch((function(){}))},handleNoReviewClick:function(){var t=this,e=this.fault,n=this.systemFault,r=this.type;this.$confirm("是否确定?","提示",{confirmButtonText:"是",cancelButtonText:"否",cancelButtonClass:"el-button--danger",closeOnClickModal:!1,type:"info",center:!0}).then((function(){t.$emit("false-review-click",{id:item.id,fault:e,systemFault:n,type:r})})).catch((function(){}))},formatReviewType:function(t){switch(t){case 0:return"未审核";case 1:return"故障";case 2:return"无故障"}},formatReviewClassName:function(t){switch(t){case 0:return"tw-text-info";case 1:return"tw-text-error";case 2:return"tw-text-success"}},formatSystemReviewClassName:function(t){switch(t){case 0:return"tw-text-success";case 1:return"tw-text-error"}}}}),i=o,s=n("2877"),c=Object(s["a"])(i,r,a,!1,null,"7ee9a7fa",null);e["a"]=c.exports},"6b54":function(t,e,n){"use strict";n("3846");var r=n("cb7c"),a=n("0bfb"),o=n("9e1e"),i="toString",s=/./[i],c=function(t){n("2aba")(RegExp.prototype,i,t,!0)};n("79e5")((function(){return"/a/b"!=s.call({source:"a",flags:"b"})}))?c((function(){var t=r(this);return"/".concat(t.source,"/","flags"in t?t.flags:!o&&t instanceof RegExp?a.call(t):void 0)})):s.name!=i&&c((function(){return s.call(this)}))},"85f2":function(t,e,n){t.exports=n("454f")},"8b97":function(t,e,n){var r=n("d3f4"),a=n("cb7c"),o=function(t,e){if(a(t),!r(e)&&null!==e)throw TypeError(e+": can't set as prototype!")};t.exports={set:Object.setPrototypeOf||("__proto__"in{}?function(t,e,r){try{r=n("9b43")(Function.call,n("11e9").f(Object.prototype,"__proto__").set,2),r(t,[]),e=!(t instanceof Array)}catch(a){e=!0}return function(t,n){return o(t,n),e?t.__proto__=n:r(t,n),t}}({},!1):void 0),check:o}},"8e6e":function(t,e,n){var r=n("5ca1"),a=n("990b"),o=n("6821"),i=n("11e9"),s=n("f1ae");r(r.S,"Object",{getOwnPropertyDescriptors:function(t){var e,n,r=o(t),c=i.f,l=a(r),u={},f=0;while(l.length>f)n=c(r,e=l[f++]),void 0!==n&&s(u,e,n);return u}})},9093:function(t,e,n){var r=n("ce10"),a=n("e11e").concat("length","prototype");e.f=Object.getOwnPropertyNames||function(t){return r(t,a)}},"990b":function(t,e,n){var r=n("9093"),a=n("2621"),o=n("cb7c"),i=n("7726").Reflect;t.exports=i&&i.ownKeys||function(t){var e=r.f(o(t)),n=a.f;return n?e.concat(n(t)):e}},aa77:function(t,e,n){var r=n("5ca1"),a=n("be13"),o=n("79e5"),i=n("fdef"),s="["+i+"]",c="​",l=RegExp("^"+s+s+"*"),u=RegExp(s+s+"*$"),f=function(t,e,n){var a={},s=o((function(){return!!i[t]()||c[t]()!=c})),l=a[t]=s?e(p):i[t];n&&(a[n]=l),r(r.P+r.F*s,"String",a)},p=f.trim=function(t,e){return t=String(a(t)),1&e&&(t=t.replace(l,"")),2&e&&(t=t.replace(u,"")),t};t.exports=f},ac6a:function(t,e,n){for(var r=n("cadf"),a=n("0d58"),o=n("2aba"),i=n("7726"),s=n("32e9"),c=n("84f2"),l=n("2b4c"),u=l("iterator"),f=l("toStringTag"),p=c.Array,d={CSSRuleList:!0,CSSStyleDeclaration:!1,CSSValueList:!1,ClientRectList:!1,DOMRectList:!1,DOMStringList:!1,DOMTokenList:!0,DataTransferItemList:!1,FileList:!1,HTMLAllCollection:!1,HTMLCollection:!1,HTMLFormElement:!1,HTMLSelectElement:!1,MediaList:!0,MimeTypeArray:!1,NamedNodeMap:!1,NodeList:!0,PaintRequestList:!1,Plugin:!1,PluginArray:!1,SVGLengthList:!1,SVGNumberList:!1,SVGPathSegList:!1,SVGPointList:!1,SVGStringList:!1,SVGTransformList:!1,SourceBufferList:!1,StyleSheetList:!0,TextTrackCueList:!1,TextTrackList:!1,TouchList:!1},m=a(d),y=0;y<m.length;y++){var b,w=m[y],h=d[w],g=i[w],v=g&&g.prototype;if(v&&(v[u]||s(v,u,p),v[f]||s(v,f,w),c[w]=p,h))for(b in r)v[b]||o(v,b,r[b],!0)}},bbd5:function(t,e,n){"use strict";n.d(e,"a",(function(){return o})),n.d(e,"b",(function(){return i})),n.d(e,"c",(function(){return s})),n.d(e,"d",(function(){return c})),n.d(e,"e",(function(){return l}));var r=n("c1df"),a=n.n(r);function o(t,e){return a()(t).format(e)}function i(t){return a()(t).format("YYYY-MM-DD")}function s(t){return a()(t).format("YYYY-MM-DD HH-mm-ss")}function c(t){return a()(t).format("YYYY-MM")}function l(t){return a()(t).format("YYYY")}},bd86:function(t,e,n){"use strict";n.d(e,"a",(function(){return o}));var r=n("85f2"),a=n.n(r);function o(t,e,n){return e in t?a()(t,e,{value:n,enumerable:!0,configurable:!0,writable:!0}):t[e]=n,t}},c5a6:function(t,e,n){"use strict";n.r(e);var r=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"tw-template-wrapper"},[n("el-form",{staticClass:"tw-query-bar",attrs:{inline:!0,model:t.query,size:"small"}},[n("el-form-item",[n("el-autocomplete",{staticClass:"inline-input",attrs:{placeholder:"车牌号码","fetch-suggestions":t.getLPNumberRemoteMethod,"trigger-on-focus":!1},model:{value:t.query.lPNumber,callback:function(e){t.$set(t.query,"lPNumber",e)},expression:"query.lPNumber"}})],1),n("el-form-item",[n("tree-select",{staticClass:"tw-tree-select tw-line",attrs:{multiple:!0,options:t.getFaultType,placeholder:"故障类型"},model:{value:t.query.faultType,callback:function(e){t.$set(t.query,"faultType",e)},expression:"query.faultType"}})],1),n("el-form-item",[n("el-select",{attrs:{placeholder:"区域"},model:{value:t.query.area,callback:function(e){t.$set(t.query,"area",e)},expression:"query.area"}},t._l(t.getRegionReal,(function(t){return n("el-option",{key:t.value,attrs:{label:t.label,value:t.value}})})),1)],1),n("el-form-item",[n("el-button",{attrs:{type:"primary"},on:{click:t.handleQueryClick}},[t._v("查询")]),n("el-button",{attrs:{type:"primary"},on:{click:t.handleAlarmIssuedClick}},[t._v("告警下发")]),n("el-button",{attrs:{type:"primary"},on:{click:t.handleExportClick}},[t._v("导出")])],1),n("el-form-item",[n("span",{domProps:{textContent:t._s(t.updateTime)}})])],1),n("div",{staticClass:"tw-query-panel"},[n("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.table.loading,expression:"table.loading"}],staticStyle:{width:"100%","margin-bottom":"10px"},attrs:{data:t.filterVehicleList,border:"",size:"small",height:"calc(100% - 42px)"}},[n("el-table-column",{attrs:{type:"index",label:"序号",width:"60"}}),n("el-table-column",{attrs:{prop:"cphm",label:"车牌号码","min-width":"100"}}),n("el-table-column",{attrs:{prop:"qy",label:"公司",width:"240"}}),n("el-table-column",{attrs:{prop:"area",label:"区域",width:"140"}}),n("el-table-column",{attrs:{prop:"ydwwyy",label:"有定位无营运",width:"100"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("span",{class:t.formatSystemReviewClassName(e.row.ydwwyy),domProps:{textContent:t._s(t.formatError(e.row.ydwwyy))}})]}}])}),n("el-table-column",{attrs:{prop:"yyywdw",label:"有营运无定位",width:"100"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("span",{class:t.formatSystemReviewClassName(e.row.yyywdw),domProps:{textContent:t._s(t.formatError(e.row.yyywdw))}})]}}])}),n("el-table-column",{attrs:{prop:"yzpwdwwyy",label:"有抓拍无定位无营运",width:"140"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("span",{class:t.formatSystemReviewClassName(e.row.yzpwdwwyy),domProps:{textContent:t._s(t.formatError(e.row.yzpwdwwyy))}})]}}])}),n("el-table-column",{attrs:{prop:"sevenwdwwyy",label:"7天无定位无营运",width:"120"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("span",{class:t.formatSystemReviewClassName(e.row.sevenwdwwyy),domProps:{textContent:t._s(t.formatError(e.row.sevenwdwwyy))}})]}}])}),n("el-table-column",{attrs:{prop:"wkcwbh",label:"空重车无变化",width:"100"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("span",{class:t.formatSystemReviewClassName(e.row.wkcwbh),domProps:{textContent:t._s(t.formatError(e.row.wkcwbh))}})]}}])}),n("el-table-column",{attrs:{prop:"sphp",label:"视频黑屏",width:"80"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("span",{class:t.formatSystemReviewClassName(e.row.sphp),domProps:{textContent:t._s(t.formatError(e.row.sphp))}})]}}])}),n("el-table-column",{attrs:{prop:"spyw",label:"视频移位",width:"80"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("span",{class:t.formatSystemReviewClassName(e.row.spyw),domProps:{textContent:t._s(t.formatError(e.row.spyw))}})]}}])}),n("el-table-column",{attrs:{prop:"spdx",label:"视频断线",width:"80"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("span",{class:t.formatSystemReviewClassName(e.row.spdx),domProps:{textContent:t._s(t.formatError(e.row.spdx))}})]}}])}),n("el-table-column",{attrs:{label:"审核",width:"140"},scopedSlots:t._u([{key:"default",fn:function(e){return["0"===e.row.sh?n("div",[n("span",[t._v("不属实")])]):n("div",["0"!==e.row.order?n("el-button",{staticClass:"tw-table-button",attrs:{size:"mini"},on:{click:function(n){return t.handleReviewClick(e.row)}}},[t._v("属实")]):t._e(),"0"!==e.row.order?n("el-button",{staticClass:"tw-table-button",attrs:{size:"mini"},on:{click:function(n){return t.handleNoReviewClick(e.row)}}},[t._v("不属实")]):n("span",[t._v("等待工单结束")])],1)]}}])})],1),n("el-pagination",{attrs:{background:"","page-size":t.table.pageSize,"current-page":t.table.currentPage,total:t.table.total,layout:"prev, pager, next, total"},on:{"current-change":t.handleTablePageCurrentChange}})],1)],1)},a=[],o=(n("8e6e"),n("ac6a"),n("456d"),n("6b54"),n("bd86")),i=n("17fb"),s=n.n(i),c=n("bc3a"),l=n.n(c),u=n("c1df"),f=n.n(u),p=n("7026"),d=n.n(p),m=n("699f"),y=n("2f62");n("bbd5");function b(t,e){var n=Object.keys(t);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(t);e&&(r=r.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),n.push.apply(n,r)}return n}function w(t){for(var e=1;e<arguments.length;e++){var n=null!=arguments[e]?arguments[e]:{};e%2?b(n,!0).forEach((function(e){Object(o["a"])(t,e,n[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(n)):b(n).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(n,e))}))}return t}var h={name:"HostFailure",data:function(){return{query:{lPNumber:"",faultType:[],area:""},updateTime:"",table:{loading:!1,data:[],pageSize:20,currentPage:1,total:0}}},mounted:function(){var t=this;this.$nextTick((function(){t.updateTime="更新时间："+f()().subtract(1,"days").format("YYYY年MM月DD日"),t.query.time=f()(),t.$route.params.id&&(t.query.faultType=[t.$route.params.id]),t.getHostFailure()}))},computed:w({},Object(y["b"])(["getLPNumber","getFaultType","getRegionReal"]),{filterVehicleList:function(){var t=this.table,e=t.data,n=t.pageSize,r=t.currentPage,a=r-1;return s.a.filter(e,(function(t,e){return e>=a*n&&e<r*n}))}}),methods:{getLPNumberRemoteMethod:function(t,e){t.length<3?e(null):e(s.a.filter(this.getLPNumber,(function(e){return e.label.indexOf(t)>-1})))},getHostFailure:function(){var t=this;this.table.loading=!0;var e=this.query,n=e.lPNumber,r=e.faultType,a=e.area;l.a.get("terminal/hostfailure",{baseURL:this.baseURL,params:{lPNumber:n,faultType:r.toString(),area:a}}).then((function(e){console.log(e.data),t.table.data=s.a.map(e.data,(function(t){return{cphm:t.VEHICLE_NO,qy:t.COMP_NAME,area:t.AREA_NAME,ydwwyy:t.NO_GPS,yyywdw:t.NO_JJQ,yzpwdwwyy:t.NO_GPS_JJQ,sevenwdwwyy:t.SEVEN_GPS_JJQ,wkcwbh:t.EMPTY_HEAVY,sphp:t.SCREEN_BLACK,spyw:t.MOVE_ON,spdx:t.BREAK_OFF,sh:t.IF_CHECK,order:t.ORDER_RESULT}})),t.table.total=t.table.data.length,t.table.currentPage=1,t.table.loading=!1})).catch((function(t){console.log(t)}))},getAudit:function(t,e){var n=this,r=this.getAllErrorFields(t);l.a.get("terminal/audit",{baseURL:this.baseURL,params:{vehicle:t.cphm,fields:r,type:e}}).then((function(t){t.data>0?(n.$message({message:"审核成功!",type:"success"}),n.getHostFailure()):n.$message.error("审核失败！")})).catch((function(t){console.error(t)}))},getAllErrorFields:function(t){var e=[];return"1"===t.ydwwyy&&e.push("有定位无营运"),"1"===t.yyywdw&&e.push("有营运无定位"),"1"===t.yzpwdwwyy&&e.push("有抓拍无定位无营运"),"1"===t.sevenwdwwyy&&e.push("7天无定位无营运"),"1"===t.wkcwbh&&e.push("空重车无变化"),"1"===t.sphp&&e.push("视频黑屏"),"1"===t.spyw&&e.push("视频移位"),"1"===t.spdx&&e.push("视频断线"),e.toString()},handleQueryClick:function(){this.getHostFailure()},handleReviewClick:function(t){var e=this;this.$confirm("是否确定?","提示",{confirmButtonText:"是",cancelButtonText:"否",cancelButtonClass:"el-button--danger",closeOnClickModal:!1,type:"info",center:!0}).then((function(){e.getAudit(t,1)})).catch((function(){}))},handleNoReviewClick:function(t){var e=this;this.$confirm("是否确定?","提示",{confirmButtonText:"是",cancelButtonText:"否",cancelButtonClass:"el-button--danger",closeOnClickModal:!1,type:"info",center:!0}).then((function(){e.getAudit(t,0)})).catch((function(){}))},handleAlarmIssuedClick:function(){},handleExportClick:function(){var t=this,e=this.query,n=e.lPNumber,r=e.faultType,a=e.area;this.$confirm("是否需要导出?","提示",{confirmButtonText:"是",cancelButtonText:"否",cancelButtonClass:"el-button--danger",closeOnClickModal:!1,type:"info",center:!0}).then((function(){window.open("".concat(t.baseURL,"terminal/hostfailuredc?lPNumber=").concat(n,"&faultType=").concat(r.toString(),"&area=").concat(a))})).catch((function(){}))},handleTablePageCurrentChange:function(t){this.table.currentPage=t},formatError:function(t){return"1"===t?"故障":"0"===t?"无故障":""},formatSystemReviewClassName:function(t){switch(t){case"0":return"tw-text-success";case"1":return"tw-text-error"}}},components:{"tree-select":d.a,FaultReview:m["a"]}},g=h,v=n("2877"),C=Object(v["a"])(g,r,a,!1,null,"5c112072",null);e["default"]=C.exports},c5f6:function(t,e,n){"use strict";var r=n("7726"),a=n("69a8"),o=n("2d95"),i=n("5dbc"),s=n("6a99"),c=n("79e5"),l=n("9093").f,u=n("11e9").f,f=n("86cc").f,p=n("aa77").trim,d="Number",m=r[d],y=m,b=m.prototype,w=o(n("2aeb")(b))==d,h="trim"in String.prototype,g=function(t){var e=s(t,!1);if("string"==typeof e&&e.length>2){e=h?e.trim():p(e,3);var n,r,a,o=e.charCodeAt(0);if(43===o||45===o){if(n=e.charCodeAt(2),88===n||120===n)return NaN}else if(48===o){switch(e.charCodeAt(1)){case 66:case 98:r=2,a=49;break;case 79:case 111:r=8,a=55;break;default:return+e}for(var i,c=e.slice(2),l=0,u=c.length;l<u;l++)if(i=c.charCodeAt(l),i<48||i>a)return NaN;return parseInt(c,r)}}return+e};if(!m(" 0o1")||!m("0b1")||m("+0x1")){m=function(t){var e=arguments.length<1?0:t,n=this;return n instanceof m&&(w?c((function(){b.valueOf.call(n)})):o(n)!=d)?i(new y(g(e)),n,m):g(e)};for(var v,C=n("9e1e")?l(y):"MAX_VALUE,MIN_VALUE,NaN,NEGATIVE_INFINITY,POSITIVE_INFINITY,EPSILON,isFinite,isInteger,isNaN,isSafeInteger,MAX_SAFE_INTEGER,MIN_SAFE_INTEGER,parseFloat,parseInt,isInteger".split(","),S=0;C.length>S;S++)a(y,v=C[S])&&!a(m,v)&&f(m,v,u(y,v));m.prototype=b,b.constructor=m,n("2aba")(r,d,m)}},f1ae:function(t,e,n){"use strict";var r=n("86cc"),a=n("4630");t.exports=function(t,e,n){e in t?r.f(t,e,a(0,n)):t[e]=n}},fdef:function(t,e){t.exports="\t\n\v\f\r   ᠎             　\u2028\u2029\ufeff"}}]);
//# sourceMappingURL=chunk-c8194b98.da884a32.js.map