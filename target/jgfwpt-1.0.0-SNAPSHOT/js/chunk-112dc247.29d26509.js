(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-112dc247"],{"0bfb":function(t,e,r){"use strict";var n=r("cb7c");t.exports=function(){var t=n(this),e="";return t.global&&(e+="g"),t.ignoreCase&&(e+="i"),t.multiline&&(e+="m"),t.unicode&&(e+="u"),t.sticky&&(e+="y"),e}},"11e9":function(t,e,r){var n=r("52a7"),a=r("4630"),o=r("6821"),i=r("6a99"),c=r("69a8"),s=r("c69a"),l=Object.getOwnPropertyDescriptor;e.f=r("9e1e")?l:function(t,e){if(t=o(t),e=i(e,!0),s)try{return l(t,e)}catch(r){}if(c(t,e))return a(!n.f.call(t,e),t[e])}},3846:function(t,e,r){r("9e1e")&&"g"!=/./g.flags&&r("86cc").f(RegExp.prototype,"flags",{configurable:!0,get:r("0bfb")})},"454f":function(t,e,r){r("46a7");var n=r("584a").Object;t.exports=function(t,e,r){return n.defineProperty(t,e,r)}},"456d":function(t,e,r){var n=r("4bf8"),a=r("0d58");r("5eda")("keys",(function(){return function(t){return a(n(t))}}))},"46a7":function(t,e,r){var n=r("63b6");n(n.S+n.F*!r("8e60"),"Object",{defineProperty:r("d9f6").f})},"5dbc":function(t,e,r){var n=r("d3f4"),a=r("8b97").set;t.exports=function(t,e,r){var o,i=e.constructor;return i!==r&&"function"==typeof i&&(o=i.prototype)!==r.prototype&&n(o)&&a&&a(t,o),t}},"5eda":function(t,e,r){var n=r("5ca1"),a=r("8378"),o=r("79e5");t.exports=function(t,e){var r=(a.Object||{})[t]||Object[t],i={};i[t]=e(r),n(n.S+n.F*o((function(){r(1)})),"Object",i)}},"699f":function(t,e,r){"use strict";var n=function(){var t=this,e=t.$createElement,r=t._self._c||e;return 1===t.systemFault?r("div",{staticStyle:{"text-align":"center"}},[r("span",{class:t.formatSystemReviewClassName(t.systemFault)},[t._v("故障:")]),r("div",{staticStyle:{display:"inline-block",width:"100px","text-align":"center"}},[0===t.fault?r("div",[r("el-button",{staticClass:"tw-table-button",attrs:{size:"mini"},on:{click:function(e){return t.handleReviewClick(t.item)}}},[t._v("属实")]),r("el-button",{staticClass:"tw-table-button",attrs:{size:"mini"},on:{click:function(e){return t.handleNoReviewClick(t.item)}}},[t._v("不属实")])],1):r("span",{class:t.formatReviewClassName(t.fault)},[t._v(t._s(t.formatReviewType(t.fault)))])])]):r("div",{staticStyle:{"text-align":"center"}},[r("span",{class:t.formatSystemReviewClassName(t.systemFault)},[t._v("无故障")])])},a=[],o=(r("c5f6"),{name:"FaultReview",data:function(){return{}},props:{item:Object,fault:Number,systemFault:Number,type:String},methods:{handleReviewClick:function(t){var e=this,r=this.fault,n=this.systemFault,a=this.type;this.$confirm("是否确定?","提示",{confirmButtonText:"是",cancelButtonText:"否",cancelButtonClass:"el-button--danger",closeOnClickModal:!1,type:"info",center:!0}).then((function(){e.$emit("true-review-click",{id:t.id,fault:r,systemFault:n,type:a})})).catch((function(){}))},handleNoReviewClick:function(){var t=this,e=this.fault,r=this.systemFault,n=this.type;this.$confirm("是否确定?","提示",{confirmButtonText:"是",cancelButtonText:"否",cancelButtonClass:"el-button--danger",closeOnClickModal:!1,type:"info",center:!0}).then((function(){t.$emit("false-review-click",{id:item.id,fault:e,systemFault:r,type:n})})).catch((function(){}))},formatReviewType:function(t){switch(t){case 0:return"未审核";case 1:return"故障";case 2:return"无故障"}},formatReviewClassName:function(t){switch(t){case 0:return"tw-text-info";case 1:return"tw-text-error";case 2:return"tw-text-success"}},formatSystemReviewClassName:function(t){switch(t){case 0:return"tw-text-success";case 1:return"tw-text-error"}}}}),i=o,c=r("2877"),s=Object(c["a"])(i,n,a,!1,null,"7ee9a7fa",null);e["a"]=s.exports},"6b54":function(t,e,r){"use strict";r("3846");var n=r("cb7c"),a=r("0bfb"),o=r("9e1e"),i="toString",c=/./[i],s=function(t){r("2aba")(RegExp.prototype,i,t,!0)};r("79e5")((function(){return"/a/b"!=c.call({source:"a",flags:"b"})}))?s((function(){var t=n(this);return"/".concat(t.source,"/","flags"in t?t.flags:!o&&t instanceof RegExp?a.call(t):void 0)})):c.name!=i&&s((function(){return c.call(this)}))},"85f2":function(t,e,r){t.exports=r("454f")},"8b97":function(t,e,r){var n=r("d3f4"),a=r("cb7c"),o=function(t,e){if(a(t),!n(e)&&null!==e)throw TypeError(e+": can't set as prototype!")};t.exports={set:Object.setPrototypeOf||("__proto__"in{}?function(t,e,n){try{n=r("9b43")(Function.call,r("11e9").f(Object.prototype,"__proto__").set,2),n(t,[]),e=!(t instanceof Array)}catch(a){e=!0}return function(t,r){return o(t,r),e?t.__proto__=r:n(t,r),t}}({},!1):void 0),check:o}},"8e6e":function(t,e,r){var n=r("5ca1"),a=r("990b"),o=r("6821"),i=r("11e9"),c=r("f1ae");n(n.S,"Object",{getOwnPropertyDescriptors:function(t){var e,r,n=o(t),s=i.f,l=a(n),u={},f=0;while(l.length>f)r=s(n,e=l[f++]),void 0!==r&&c(u,e,r);return u}})},9093:function(t,e,r){var n=r("ce10"),a=r("e11e").concat("length","prototype");e.f=Object.getOwnPropertyNames||function(t){return n(t,a)}},"990b":function(t,e,r){var n=r("9093"),a=r("2621"),o=r("cb7c"),i=r("7726").Reflect;t.exports=i&&i.ownKeys||function(t){var e=n.f(o(t)),r=a.f;return r?e.concat(r(t)):e}},aa77:function(t,e,r){var n=r("5ca1"),a=r("be13"),o=r("79e5"),i=r("fdef"),c="["+i+"]",s="​",l=RegExp("^"+c+c+"*"),u=RegExp(c+c+"*$"),f=function(t,e,r){var a={},c=o((function(){return!!i[t]()||s[t]()!=s})),l=a[t]=c?e(p):i[t];r&&(a[r]=l),n(n.P+n.F*c,"String",a)},p=f.trim=function(t,e){return t=String(a(t)),1&e&&(t=t.replace(l,"")),2&e&&(t=t.replace(u,"")),t};t.exports=f},ac6a:function(t,e,r){for(var n=r("cadf"),a=r("0d58"),o=r("2aba"),i=r("7726"),c=r("32e9"),s=r("84f2"),l=r("2b4c"),u=l("iterator"),f=l("toStringTag"),p=s.Array,m={CSSRuleList:!0,CSSStyleDeclaration:!1,CSSValueList:!1,ClientRectList:!1,DOMRectList:!1,DOMStringList:!1,DOMTokenList:!0,DataTransferItemList:!1,FileList:!1,HTMLAllCollection:!1,HTMLCollection:!1,HTMLFormElement:!1,HTMLSelectElement:!1,MediaList:!0,MimeTypeArray:!1,NamedNodeMap:!1,NodeList:!0,PaintRequestList:!1,Plugin:!1,PluginArray:!1,SVGLengthList:!1,SVGNumberList:!1,SVGPathSegList:!1,SVGPointList:!1,SVGStringList:!1,SVGTransformList:!1,SourceBufferList:!1,StyleSheetList:!0,TextTrackCueList:!1,TextTrackList:!1,TouchList:!1},y=a(m),d=0;d<y.length;d++){var b,w=y[d],h=m[w],g=i[w],v=g&&g.prototype;if(v&&(v[u]||c(v,u,p),v[f]||c(v,f,w),s[w]=p,h))for(b in n)v[b]||o(v,b,n[b],!0)}},bbd5:function(t,e,r){"use strict";r.d(e,"a",(function(){return o})),r.d(e,"b",(function(){return i})),r.d(e,"c",(function(){return c})),r.d(e,"d",(function(){return s})),r.d(e,"e",(function(){return l}));var n=r("c1df"),a=r.n(n);function o(t,e){return a()(t).format(e)}function i(t){return a()(t).format("YYYY-MM-DD")}function c(t){return a()(t).format("YYYY-MM-DD HH-mm-ss")}function s(t){return a()(t).format("YYYY-MM")}function l(t){return a()(t).format("YYYY")}},bd86:function(t,e,r){"use strict";r.d(e,"a",(function(){return o}));var n=r("85f2"),a=r.n(n);function o(t,e,r){return e in t?a()(t,e,{value:r,enumerable:!0,configurable:!0,writable:!0}):t[e]=r,t}},c403:function(t,e,r){"use strict";r.r(e);var n=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",{staticClass:"tw-template-wrapper"},[r("el-form",{staticClass:"tw-query-bar",attrs:{inline:!0,model:t.query,size:"small"}},[r("el-form-item",[r("el-autocomplete",{staticClass:"inline-input",attrs:{placeholder:"车牌号码","fetch-suggestions":t.getLPNumberRemoteMethod,"trigger-on-focus":!1},model:{value:t.query.lPNumber,callback:function(e){t.$set(t.query,"lPNumber",e)},expression:"query.lPNumber"}})],1),r("el-form-item",[r("el-select",{attrs:{placeholder:"区域"},model:{value:t.query.area,callback:function(e){t.$set(t.query,"area",e)},expression:"query.area"}},t._l(t.getRegionReal,(function(t){return r("el-option",{key:t.value,attrs:{label:t.label,value:t.value}})})),1)],1),r("el-form-item",[r("el-date-picker",{attrs:{"arrow-control":"",type:"date",placeholder:"选择时间点"},model:{value:t.query.time,callback:function(e){t.$set(t.query,"time",e)},expression:"query.time"}})],1),r("el-form-item",[r("tree-select",{staticClass:"tw-tree-select tw-line",attrs:{multiple:!0,options:t.getFaultType,placeholder:"故障类型"},model:{value:t.query.faultType,callback:function(e){t.$set(t.query,"faultType",e)},expression:"query.faultType"}})],1),r("el-form-item",[r("el-button",{attrs:{type:"primary"},on:{click:t.handleQueryClick}},[t._v("查询")]),r("el-button",{attrs:{type:"primary"},on:{click:t.handleExportClick}},[t._v("导出")])],1)],1),r("div",{staticClass:"tw-query-panel"},[r("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.table.loading,expression:"table.loading"}],staticStyle:{width:"100%","margin-bottom":"10px"},attrs:{data:t.table.data,border:"",size:"small",height:"calc(100% - 42px)"}},[r("el-table-column",{attrs:{type:"index",label:"序号",width:"60"}}),r("el-table-column",{attrs:{prop:"cphm",label:"车牌号码","min-width":"180"}}),r("el-table-column",{attrs:{prop:"qy",label:"公司",width:"240"}}),r("el-table-column",{attrs:{prop:"area",label:"区域",width:"240"}}),r("el-table-column",{attrs:{prop:"time",label:"时间","min-width":"180"}}),r("el-table-column",{attrs:{prop:"ydwwyy",label:"有定位无营运",width:"180"},scopedSlots:t._u([{key:"default",fn:function(e){return[r("span",{class:t.formatSystemReviewClassName(e.row.ydwwyy),domProps:{textContent:t._s(t.formatError(e.row.ydwwyy))}})]}}])}),r("el-table-column",{attrs:{prop:"yyywdw",label:"有营运无定位",width:"180"},scopedSlots:t._u([{key:"default",fn:function(e){return[r("span",{class:t.formatSystemReviewClassName(e.row.yyywdw),domProps:{textContent:t._s(t.formatError(e.row.yyywdw))}})]}}])}),r("el-table-column",{attrs:{prop:"yzpwdwwyy",label:"有抓拍无定位无营运",width:"180"},scopedSlots:t._u([{key:"default",fn:function(e){return[r("span",{class:t.formatSystemReviewClassName(e.row.yzpwdwwyy),domProps:{textContent:t._s(t.formatError(e.row.yzpwdwwyy))}})]}}])}),r("el-table-column",{attrs:{prop:"sevenwdwwyy",label:"7天无定位无营运",width:"180"},scopedSlots:t._u([{key:"default",fn:function(e){return[r("span",{class:t.formatSystemReviewClassName(e.row.sevenwdwwyy),domProps:{textContent:t._s(t.formatError(e.row.sevenwdwwyy))}})]}}])}),r("el-table-column",{attrs:{prop:"wkcwbh",label:"空重车无变化",width:"180"},scopedSlots:t._u([{key:"default",fn:function(e){return[r("span",{class:t.formatSystemReviewClassName(e.row.wkcwbh),domProps:{textContent:t._s(t.formatError(e.row.wkcwbh))}})]}}])}),r("el-table-column",{attrs:{prop:"sphp",label:"视频黑屏",width:"180"},scopedSlots:t._u([{key:"default",fn:function(e){return[r("span",{class:t.formatSystemReviewClassName(e.row.sphp),domProps:{textContent:t._s(t.formatError(e.row.sphp))}})]}}])}),r("el-table-column",{attrs:{prop:"spyw",label:"视频移位",width:"180"},scopedSlots:t._u([{key:"default",fn:function(e){return[r("span",{class:t.formatSystemReviewClassName(e.row.spyw),domProps:{textContent:t._s(t.formatError(e.row.spyw))}})]}}])}),r("el-table-column",{attrs:{prop:"spdx",label:"视频断线",width:"180"},scopedSlots:t._u([{key:"default",fn:function(e){return[r("span",{class:t.formatSystemReviewClassName(e.row.spdx),domProps:{textContent:t._s(t.formatError(e.row.spdx))}})]}}])})],1),r("el-pagination",{attrs:{background:"","page-size":t.table.pageSize,"current-page":t.table.currentPage,total:t.table.total,layout:"prev, pager, next ,total"},on:{"current-change":t.handleTablePageCurrentChange}})],1)],1)},a=[],o=(r("8e6e"),r("ac6a"),r("456d"),r("6b54"),r("bd86")),i=r("17fb"),c=r.n(i),s=r("bc3a"),l=r.n(s),u=r("c1df"),f=r.n(u),p=r("7026"),m=r.n(p),y=r("699f"),d=r("2f62"),b=r("bbd5");function w(t,e){var r=Object.keys(t);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(t);e&&(n=n.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),r.push.apply(r,n)}return r}function h(t){for(var e=1;e<arguments.length;e++){var r=null!=arguments[e]?arguments[e]:{};e%2?w(r,!0).forEach((function(e){Object(o["a"])(t,e,r[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(r)):w(r).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(r,e))}))}return t}var g={name:"HostFailure",data:function(){return{query:{lPNumber:"",area:"",time:"",faultType:[]},table:{loading:!1,data:[],pageSize:20,currentPage:1,total:0}}},mounted:function(){var t=this;this.$nextTick((function(){t.query.time=f()().subtract(1,"day"),t.getHostFailureHistory()}))},computed:h({},Object(d["b"])(["getLPNumber","getFaultType","getRegionReal"]),{filterVehicleList:function(){var t=this.table,e=t.data,r=t.pageSize,n=t.currentPage,a=n-1;return c.a.filter(e,(function(t,e){return e>=a*r&&e<n*r}))}}),methods:{getLPNumberRemoteMethod:function(t,e){t.length<3?e(null):e(c.a.filter(this.getLPNumber,(function(e){return e.label.indexOf(t)>-1})))},getHostFailureHistory:function(){var t=this;this.table.loading=!0;var e=this.query,r=e.lPNumber,n=e.area,a=e.time,o=e.faultType,i=this.table,s=i.currentPage,u=i.pageSize;l.a.get("terminal/hostfailurehistory",{baseURL:this.baseURL,params:{lPNumber:r,area:n,time:a&&Object(b["b"])(a),faultType:o.toString(),currentPage:s,pageSize:u}}).then((function(e){console.log(e.data.datas),t.table.data=c.a.map(e.data.datas,(function(t){return{cphm:t.VEHICLE_NO,qy:t.COMP_NAME,area:t.AREA_NAME,time:t.TIME,ydwwyy:t.NO_GPS,yyywdw:t.NO_JJQ,yzpwdwwyy:t.NO_GPS_JJQ,sevenwdwwyy:t.SEVEN_GPS_JJQ,wkcwbh:t.EMPTY_HEAVY,sphp:t.SCREEN_BLACK,spyw:t.MOVE_ON,spdx:t.BREAK_OFF,sh:t.IF_CHECK,order:t.ORDER_RESULT}})),t.table.total=e.data.count,t.table.loading=!1})).catch((function(t){console.log(t)}))},handleQueryClick:function(){this.table.currentPage=1,this.getHostFailureHistory()},handleExportClick:function(){var t=this,e=this.query,r=e.lPNumber,n=e.area,a=e.time,o=e.faultType;this.$confirm("是否需要导出?","提示",{confirmButtonText:"是",cancelButtonText:"否",cancelButtonClass:"el-button--danger",closeOnClickModal:!1,type:"info",center:!0}).then((function(){window.open("".concat(t.baseURL,"terminal/hostfailurehistorydc?lPNumber=").concat(r,"&area=").concat(n,"&time=").concat(a&&Object(b["b"])(a),"&faultType=").concat(o.toString()))})).catch((function(){}))},handleTablePageCurrentChange:function(t){this.table.currentPage=t,this.getHostFailureHistory()},formatError:function(t){return"1"===t?"故障":"0"===t?"无故障":""},formatSystemReviewClassName:function(t){switch(t){case"0":return"tw-text-success";case"1":return"tw-text-error"}}},components:{"tree-select":m.a,FaultReview:y["a"]}},v=g,S=r("2877"),C=Object(S["a"])(v,n,a,!1,null,"6e3b922b",null);e["default"]=C.exports},c5f6:function(t,e,r){"use strict";var n=r("7726"),a=r("69a8"),o=r("2d95"),i=r("5dbc"),c=r("6a99"),s=r("79e5"),l=r("9093").f,u=r("11e9").f,f=r("86cc").f,p=r("aa77").trim,m="Number",y=n[m],d=y,b=y.prototype,w=o(r("2aeb")(b))==m,h="trim"in String.prototype,g=function(t){var e=c(t,!1);if("string"==typeof e&&e.length>2){e=h?e.trim():p(e,3);var r,n,a,o=e.charCodeAt(0);if(43===o||45===o){if(r=e.charCodeAt(2),88===r||120===r)return NaN}else if(48===o){switch(e.charCodeAt(1)){case 66:case 98:n=2,a=49;break;case 79:case 111:n=8,a=55;break;default:return+e}for(var i,s=e.slice(2),l=0,u=s.length;l<u;l++)if(i=s.charCodeAt(l),i<48||i>a)return NaN;return parseInt(s,n)}}return+e};if(!y(" 0o1")||!y("0b1")||y("+0x1")){y=function(t){var e=arguments.length<1?0:t,r=this;return r instanceof y&&(w?s((function(){b.valueOf.call(r)})):o(r)!=m)?i(new d(g(e)),r,y):g(e)};for(var v,S=r("9e1e")?l(d):"MAX_VALUE,MIN_VALUE,NaN,NEGATIVE_INFINITY,POSITIVE_INFINITY,EPSILON,isFinite,isInteger,isNaN,isSafeInteger,MAX_SAFE_INTEGER,MIN_SAFE_INTEGER,parseFloat,parseInt,isInteger".split(","),C=0;S.length>C;C++)a(d,v=S[C])&&!a(y,v)&&f(y,v,u(d,v));y.prototype=b,b.constructor=y,r("2aba")(n,m,y)}},f1ae:function(t,e,r){"use strict";var n=r("86cc"),a=r("4630");t.exports=function(t,e,r){e in t?n.f(t,e,a(0,r)):t[e]=r}},fdef:function(t,e){t.exports="\t\n\v\f\r   ᠎             　\u2028\u2029\ufeff"}}]);
//# sourceMappingURL=chunk-112dc247.29d26509.js.map