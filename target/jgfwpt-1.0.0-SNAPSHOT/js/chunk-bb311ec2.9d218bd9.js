(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-bb311ec2"],{"02f4":function(e,t,n){var a=n("4588"),r=n("be13");e.exports=function(e){return function(t,n){var i,o,l=String(r(t)),c=a(n),s=l.length;return c<0||c>=s?e?"":void 0:(i=l.charCodeAt(c),i<55296||i>56319||c+1===s||(o=l.charCodeAt(c+1))<56320||o>57343?e?l.charAt(c):i:e?l.slice(c,c+2):o-56320+(i-55296<<10)+65536)}}},"0390":function(e,t,n){"use strict";var a=n("02f4")(!0);e.exports=function(e,t,n){return t+(n?a(e,t).length:1)}},"0bfb":function(e,t,n){"use strict";var a=n("cb7c");e.exports=function(){var e=a(this),t="";return e.global&&(t+="g"),e.ignoreCase&&(t+="i"),e.multiline&&(t+="m"),e.unicode&&(t+="u"),e.sticky&&(t+="y"),t}},"11e9":function(e,t,n){var a=n("52a7"),r=n("4630"),i=n("6821"),o=n("6a99"),l=n("69a8"),c=n("c69a"),s=Object.getOwnPropertyDescriptor;t.f=n("9e1e")?s:function(e,t){if(e=i(e),t=o(t,!0),c)try{return s(e,t)}catch(n){}if(l(e,t))return r(!a.f.call(e,t),e[t])}},"214f":function(e,t,n){"use strict";n("b0c5");var a=n("2aba"),r=n("32e9"),i=n("79e5"),o=n("be13"),l=n("2b4c"),c=n("520a"),s=l("species"),u=!i((function(){var e=/./;return e.exec=function(){var e=[];return e.groups={a:"7"},e},"7"!=="".replace(e,"$<a>")})),f=function(){var e=/(?:)/,t=e.exec;e.exec=function(){return t.apply(this,arguments)};var n="ab".split(e);return 2===n.length&&"a"===n[0]&&"b"===n[1]}();e.exports=function(e,t,n){var p=l(e),d=!i((function(){var t={};return t[p]=function(){return 7},7!=""[e](t)})),g=d?!i((function(){var t=!1,n=/a/;return n.exec=function(){return t=!0,null},"split"===e&&(n.constructor={},n.constructor[s]=function(){return n}),n[p](""),!t})):void 0;if(!d||!g||"replace"===e&&!u||"split"===e&&!f){var m=/./[p],b=n(o,p,""[e],(function(e,t,n,a,r){return t.exec===c?d&&!r?{done:!0,value:m.call(t,n,a)}:{done:!0,value:e.call(n,t,a)}:{done:!1}})),h=b[0],y=b[1];a(String.prototype,e,h),r(RegExp.prototype,p,2==t?function(e,t){return y.call(e,this,t)}:function(e){return y.call(e,this)})}}},"28a5":function(e,t,n){"use strict";var a=n("aae3"),r=n("cb7c"),i=n("ebd6"),o=n("0390"),l=n("9def"),c=n("5f1b"),s=n("520a"),u=n("79e5"),f=Math.min,p=[].push,d="split",g="length",m="lastIndex",b=4294967295,h=!u((function(){RegExp(b,"y")}));n("214f")("split",2,(function(e,t,n,u){var y;return y="c"=="abbc"[d](/(b)*/)[1]||4!="test"[d](/(?:)/,-1)[g]||2!="ab"[d](/(?:ab)*/)[g]||4!="."[d](/(.?)(.?)/)[g]||"."[d](/()()/)[g]>1||""[d](/.?/)[g]?function(e,t){var r=String(this);if(void 0===e&&0===t)return[];if(!a(e))return n.call(r,e,t);var i,o,l,c=[],u=(e.ignoreCase?"i":"")+(e.multiline?"m":"")+(e.unicode?"u":"")+(e.sticky?"y":""),f=0,d=void 0===t?b:t>>>0,h=new RegExp(e.source,u+"g");while(i=s.call(h,r)){if(o=h[m],o>f&&(c.push(r.slice(f,i.index)),i[g]>1&&i.index<r[g]&&p.apply(c,i.slice(1)),l=i[0][g],f=o,c[g]>=d))break;h[m]===i.index&&h[m]++}return f===r[g]?!l&&h.test("")||c.push(""):c.push(r.slice(f)),c[g]>d?c.slice(0,d):c}:"0"[d](void 0,0)[g]?function(e,t){return void 0===e&&0===t?[]:n.call(this,e,t)}:n,[function(n,a){var r=e(this),i=void 0==n?void 0:n[t];return void 0!==i?i.call(n,r,a):y.call(String(r),n,a)},function(e,t){var a=u(y,e,this,t,y!==n);if(a.done)return a.value;var s=r(e),p=String(this),d=i(s,RegExp),g=s.unicode,m=(s.ignoreCase?"i":"")+(s.multiline?"m":"")+(s.unicode?"u":"")+(h?"y":"g"),v=new d(h?s:"^(?:"+s.source+")",m),x=void 0===t?b:t>>>0;if(0===x)return[];if(0===p.length)return null===c(v,p)?[p]:[];var C=0,w=0,S=[];while(w<p.length){v.lastIndex=h?w:0;var R,k=c(v,h?p:p.slice(w));if(null===k||(R=f(l(v.lastIndex+(h?0:w)),p.length))===C)w=o(p,w,g);else{if(S.push(p.slice(C,w)),S.length===x)return S;for(var L=1;L<=k.length-1;L++)if(S.push(k[L]),S.length===x)return S;w=C=R}}return S.push(p.slice(C)),S}]}))},3846:function(e,t,n){n("9e1e")&&"g"!=/./g.flags&&n("86cc").f(RegExp.prototype,"flags",{configurable:!0,get:n("0bfb")})},"454f":function(e,t,n){n("46a7");var a=n("584a").Object;e.exports=function(e,t,n){return a.defineProperty(e,t,n)}},"456d":function(e,t,n){var a=n("4bf8"),r=n("0d58");n("5eda")("keys",(function(){return function(e){return r(a(e))}}))},"46a7":function(e,t,n){var a=n("63b6");a(a.S+a.F*!n("8e60"),"Object",{defineProperty:n("d9f6").f})},"520a":function(e,t,n){"use strict";var a=n("0bfb"),r=RegExp.prototype.exec,i=String.prototype.replace,o=r,l="lastIndex",c=function(){var e=/a/,t=/b*/g;return r.call(e,"a"),r.call(t,"a"),0!==e[l]||0!==t[l]}(),s=void 0!==/()??/.exec("")[1],u=c||s;u&&(o=function(e){var t,n,o,u,f=this;return s&&(n=new RegExp("^"+f.source+"$(?!\\s)",a.call(f))),c&&(t=f[l]),o=r.call(f,e),c&&o&&(f[l]=f.global?o.index+o[0].length:t),s&&o&&o.length>1&&i.call(o[0],n,(function(){for(u=1;u<arguments.length-2;u++)void 0===arguments[u]&&(o[u]=void 0)})),o}),e.exports=o},"5eda":function(e,t,n){var a=n("5ca1"),r=n("8378"),i=n("79e5");e.exports=function(e,t){var n=(r.Object||{})[e]||Object[e],o={};o[e]=t(n),a(a.S+a.F*i((function(){n(1)})),"Object",o)}},"5f1b":function(e,t,n){"use strict";var a=n("23c6"),r=RegExp.prototype.exec;e.exports=function(e,t){var n=e.exec;if("function"===typeof n){var i=n.call(e,t);if("object"!==typeof i)throw new TypeError("RegExp exec method returned something other than an Object or null");return i}if("RegExp"!==a(e))throw new TypeError("RegExp#exec called on incompatible receiver");return r.call(e,t)}},"6b54":function(e,t,n){"use strict";n("3846");var a=n("cb7c"),r=n("0bfb"),i=n("9e1e"),o="toString",l=/./[o],c=function(e){n("2aba")(RegExp.prototype,o,e,!0)};n("79e5")((function(){return"/a/b"!=l.call({source:"a",flags:"b"})}))?c((function(){var e=a(this);return"/".concat(e.source,"/","flags"in e?e.flags:!i&&e instanceof RegExp?r.call(e):void 0)})):l.name!=o&&c((function(){return l.call(this)}))},"85f2":function(e,t,n){e.exports=n("454f")},"8e6e":function(e,t,n){var a=n("5ca1"),r=n("990b"),i=n("6821"),o=n("11e9"),l=n("f1ae");a(a.S,"Object",{getOwnPropertyDescriptors:function(e){var t,n,a=i(e),c=o.f,s=r(a),u={},f=0;while(s.length>f)n=c(a,t=s[f++]),void 0!==n&&l(u,t,n);return u}})},9093:function(e,t,n){var a=n("ce10"),r=n("e11e").concat("length","prototype");t.f=Object.getOwnPropertyNames||function(e){return a(e,r)}},"990b":function(e,t,n){var a=n("9093"),r=n("2621"),i=n("cb7c"),o=n("7726").Reflect;e.exports=o&&o.ownKeys||function(e){var t=a.f(i(e)),n=r.f;return n?t.concat(n(e)):t}},aae3:function(e,t,n){var a=n("d3f4"),r=n("2d95"),i=n("2b4c")("match");e.exports=function(e){var t;return a(e)&&(void 0!==(t=e[i])?!!t:"RegExp"==r(e))}},ac6a:function(e,t,n){for(var a=n("cadf"),r=n("0d58"),i=n("2aba"),o=n("7726"),l=n("32e9"),c=n("84f2"),s=n("2b4c"),u=s("iterator"),f=s("toStringTag"),p=c.Array,d={CSSRuleList:!0,CSSStyleDeclaration:!1,CSSValueList:!1,ClientRectList:!1,DOMRectList:!1,DOMStringList:!1,DOMTokenList:!0,DataTransferItemList:!1,FileList:!1,HTMLAllCollection:!1,HTMLCollection:!1,HTMLFormElement:!1,HTMLSelectElement:!1,MediaList:!0,MimeTypeArray:!1,NamedNodeMap:!1,NodeList:!0,PaintRequestList:!1,Plugin:!1,PluginArray:!1,SVGLengthList:!1,SVGNumberList:!1,SVGPathSegList:!1,SVGPointList:!1,SVGStringList:!1,SVGTransformList:!1,SourceBufferList:!1,StyleSheetList:!0,TextTrackCueList:!1,TextTrackList:!1,TouchList:!1},g=r(d),m=0;m<g.length;m++){var b,h=g[m],y=d[h],v=o[h],x=v&&v.prototype;if(x&&(x[u]||l(x,u,p),x[f]||l(x,f,h),c[h]=p,y))for(b in a)x[b]||i(x,b,a[b],!0)}},aedb:function(e,t,n){"use strict";n.r(t);var a=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"tw-template-wrapper"},[n("el-form",{staticClass:"tw-query-bar",attrs:{inline:!0,model:e.query,size:"small"}},[n("el-form-item",[n("el-autocomplete",{staticClass:"inline-input",attrs:{placeholder:"公司名称","fetch-suggestions":e.queryCompanyNameSearch,"trigger-on-focus":!1},model:{value:e.query.companyName,callback:function(t){e.$set(e.query,"companyName",t)},expression:"query.companyName"}})],1),n("el-form-item",[n("el-select",{attrs:{filterable:"",placeholder:"回场区域"},model:{value:e.query.type,callback:function(t){e.$set(e.query,"type",t)},expression:"query.type"}},e._l(e.getReturnArea,(function(e){return n("el-option",{key:e.id,attrs:{label:e.label,value:e.id}})})),1)],1),n("el-form-item",[n("el-button",{attrs:{type:"primary"},on:{click:e.handleQueryClick}},[e._v("查询")])],1)],1),n("div",{staticClass:"tw-query-panel"},[n("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.table.loading,expression:"table.loading"}],staticStyle:{width:"100%","margin-bottom":"10px"},attrs:{data:e.filterTableList,border:"",size:"small",height:"calc(100% - 42px)"}},[n("el-table-column",{attrs:{type:"index",label:"序号",width:"60",resizable:!1,fixed:""}}),n("el-table-column",{attrs:{prop:"gsmc",label:"公司名称",width:"280",fixed:"","show-overflow-tooltip":""}}),n("el-table-column",{attrs:{prop:"hcqy",label:"回场区域",width:"180","show-overflow-tooltip":""}}),n("el-table-column",{attrs:{prop:"hcjg",label:"回场间隔",width:"150"}}),n("el-table-column",{attrs:{prop:"remarks",label:"备注","min-width":"160",resizable:!1,"show-overflow-tooltip":""}}),n("el-table-column",{attrs:{resizable:!1,width:"100",align:"center"},scopedSlots:e._u([{key:"header",fn:function(t){return[n("el-button",{attrs:{size:"mini",icon:"el-icon-plus"},on:{click:e.handleTableAddClick}})]}},{key:"default",fn:function(t){return[n("el-button",{attrs:{size:"mini",icon:"el-icon-edit",type:"text"},on:{click:function(n){return e.handleTableEditClick(t.row)}}}),n("el-button",{attrs:{size:"mini",icon:"el-icon-delete",type:"text"},on:{click:function(n){return e.handleTableDeleteClick(t.row)}}})]}}])})],1),n("el-pagination",{attrs:{background:"","page-size":e.table.pageSize,"current-page":e.table.currentPage,total:e.table.total,layout:"prev, pager, next, total"},on:{"current-change":e.handleTablePageCurrentChange}})],1),n("el-dialog",{attrs:{title:e.dialog.title,visible:e.dialog.display,width:"400px"},on:{"update:visible":function(t){return e.$set(e.dialog,"display",t)},closed:e.handleDialogClosed}},[n("el-form",{ref:"form",attrs:{model:e.dialog.form,size:"small","label-width":"80px"}},[n("el-form-item",{attrs:{label:"公司名称"}},[n("el-autocomplete",{staticClass:"inline-input",staticStyle:{width:"260px"},attrs:{placeholder:"公司名称","fetch-suggestions":e.queryDialogCompanyNameSearch,"trigger-on-focus":!1},model:{value:e.dialog.form.companyName,callback:function(t){e.$set(e.dialog.form,"companyName",t)},expression:"dialog.form.companyName"}})],1),n("el-form-item",{attrs:{label:"回场区域"}},[n("tree-select",{staticClass:"tw-tree-select tw-line",staticStyle:{width:"260px"},attrs:{multiple:!0,options:e.filterReturnArea,placeholder:"回场区域"},model:{value:e.dialog.form.region,callback:function(t){e.$set(e.dialog.form,"region",t)},expression:"dialog.form.region"}})],1),n("el-form-item",{attrs:{label:"回场间隔"}},[n("el-input",{staticStyle:{width:"260px"},attrs:{placeholder:"回场间隔"},model:{value:e.dialog.form.interval,callback:function(t){e.$set(e.dialog.form,"interval",t)},expression:"dialog.form.interval"}})],1)],1),n("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[n("el-button",{on:{click:function(t){e.dialog.display=!1}}},[e._v("取 消")]),n("el-button",{attrs:{type:"primary"},on:{click:e.handleDialogSaveClick}},[e._v("提 交")])],1)],1)],1)},r=[],i=(n("8e6e"),n("ac6a"),n("456d"),n("28a5"),n("6b54"),n("bd86")),o=n("17fb"),l=n.n(o),c=n("bc3a"),s=n.n(c),u=n("c1df"),f=n.n(u),p=n("7026"),d=n.n(p),g=n("2f62");function m(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(e);t&&(a=a.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),n.push.apply(n,a)}return n}function b(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{};t%2?m(n,!0).forEach((function(t){Object(i["a"])(e,t,n[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):m(n).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(n,t))}))}return e}var h={name:"ReturnCompanySettings",data:function(){return{query:{companyName:"",type:""},companyList:[],table:{loading:!1,selectItem:{},data:[{gsmc:"杭州通悟科技有限公司",hcqy:"下场区",hcjg:2,remarks:"北冥有鱼，其名为鲲。鲲之大，不知其几千里也。化而为鸟，其名为鹏。鹏之背，不知其几千里也。怒而飞，其翼若垂天之云。是鸟也，海运则将徙于南冥。南冥者，天池也。"}],pageSize:20,currentPage:1,total:0},dialog:{title:"",display:!1,form:{companyName:"",region:[],interval:""}}}},mounted:function(){var e=this;this.$nextTick((function(){e.query.stime=f()().format("YYYY-MM-DD 00:00:00"),e.query.etime=f()().format("YYYY-MM-DD 23:59:59"),e.getReturnCompany()}))},computed:b({},Object(g["b"])(["getCompanyName","getReturnArea"]),{filterTableList:function(){var e=this.table,t=e.data,n=e.pageSize,a=e.currentPage,r=a-1;return l.a.filter(t,(function(e,t){return t>=r*n&&t<a*n}))},filterReturnArea:function(){return l.a.map(l.a.filter(this.getReturnArea,(function(e){return e.id})),(function(e){return{id:e.id,label:e.label}}))}}),methods:{queryDialogCompanyNameSearch:function(e,t){t(l.a.filter(this.getCompanyName,(function(t){return t.label.indexOf(e)>-1})))},queryCompanyNameSearch:function(e,t){t(l.a.filter(this.getCompanyName,(function(t){return t.label.indexOf(e)>-1})))},getReturnCompany:function(){var e=this;this.table.loading=!0;var t=this.query,n=t.companyName,a=t.type;s.a.get("area/returncompany",{baseURL:this.baseURL,params:{company:n,area:a}}).then((function(t){console.log(t.data),e.table.data=l.a.map(t.data,(function(e){return{id:e.ID,area_id:e.AREA_ID,gsmc:e.COMPANY_NAME,hcqy:e.AREA_NAME,hcjg:e.RETURN_TIME,remarks:e.REMARKS}})),e.table.total=e.table.data.length,e.table.currentPage=1,e.table.loading=!1})).catch((function(e){console.log(e)}))},getAddReturnCompany:function(){var e=this,t=this.dialog.form,n=t.companyName,a=t.region,r=t.interval;if(""===n||""===a.toString()||""===r)return this.$message.error("请填写完整信息！"),!1;s.a.get("area/addreturncompany",{baseURL:this.baseURL,params:{company:n,area:a.toString(),time:r}}).then((function(t){t.data>0?(e.$message({message:"操作成功!",type:"success"}),e.dialog.display=!1,e.getReturnCompany()):0===t.data?e.$message.error("操作失败！"):-1===t.data&&e.$message.error("该公司已添加！")})).catch((function(e){console.error(e)}))},getUpdateReturnCompany:function(){var e=this,t=this.table.selectItem,n=this.dialog.form,a=n.companyName,r=n.region,i=n.interval;if(""===a||""===r.toString()||""===i)return this.$message.error("请填写完整信息！"),!1;s.a.get("area/updatereturncompany",{baseURL:this.baseURL,params:{id:t.id,company:a,area:r.toString(),time:i}}).then((function(t){t.data>0?(e.$message({message:"操作成功!",type:"success"}),e.dialog.display=!1,e.getReturnCompany()):0===t.data?e.$message.error("操作失败！"):-1===t.data&&e.$message.error("该公司已添加！")})).catch((function(e){console.error(e)}))},handleQueryClick:function(){this.getReturnCompany()},handleTableAddClick:function(){this.dialog.title="添加回场",this.dialog.display=!0},handleTableEditClick:function(e){this.dialog.title="修改回场",this.dialog.display=!0,this.table.selectItem=e,this.dialog.form.companyName=e.gsmc,this.dialog.form.region=e.area_id.split(","),this.dialog.form.interval=e.hcjg},handleTableDeleteClick:function(e){var t=this;this.$confirm("是否删除?","提示",{confirmButtonText:"是",cancelButtonText:"否",cancelButtonClass:"el-button--danger",closeOnClickModal:!1,type:"info",center:!0}).then((function(){s.a.get("area/deletereturncompany",{baseURL:t.baseURL,params:{id:e.id}}).then((function(e){e.data>0?(t.$message({message:"操作成功!",type:"success"}),t.getReturnCompany()):t.$message.error("操作失败！")})).catch((function(e){console.error(e)}))}))},handleDialogSaveClick:function(){"修改回场"===this.dialog.title?this.getUpdateReturnCompany():"添加回场"===this.dialog.title&&this.getAddReturnCompany()},handleDialogClosed:function(){this.dialog.title="",this.dialog.form.companyName="",this.dialog.form.region=[],this.dialog.form.interval="",this.table.selectItem={}},handleTablePageCurrentChange:function(e){this.table.currentPage=e}},components:{"tree-select":d.a}},y=h,v=n("2877"),x=Object(v["a"])(y,a,r,!1,null,"37b34f20",null);t["default"]=x.exports},b0c5:function(e,t,n){"use strict";var a=n("520a");n("5ca1")({target:"RegExp",proto:!0,forced:a!==/./.exec},{exec:a})},bd86:function(e,t,n){"use strict";n.d(t,"a",(function(){return i}));var a=n("85f2"),r=n.n(a);function i(e,t,n){return t in e?r()(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}},f1ae:function(e,t,n){"use strict";var a=n("86cc"),r=n("4630");e.exports=function(e,t,n){t in e?a.f(e,t,r(0,n)):e[t]=n}}}]);
//# sourceMappingURL=chunk-bb311ec2.9d218bd9.js.map