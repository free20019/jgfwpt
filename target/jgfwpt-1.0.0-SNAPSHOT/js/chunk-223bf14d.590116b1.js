(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-223bf14d"],{"35d7":function(t,e,a){},"3c76":function(t,e,a){"use strict";var i=a("35d7"),l=a.n(i);l.a},e86e:function(t,e,a){"use strict";a.r(e);var i=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"tw-template-wrapper"},[a("div",{staticClass:"tw-template-body"},[a("el-form",{staticClass:"tw-query-bar",attrs:{inline:!0,model:t.query,size:"small"}},[a("el-form-item",[a("el-date-picker",{attrs:{type:"month",placeholder:"开始日期"},model:{value:t.query.stime,callback:function(e){t.$set(t.query,"stime",e)},expression:"query.stime"}})],1),a("el-form-item",[a("el-date-picker",{attrs:{type:"month",placeholder:"结束日期"},model:{value:t.query.etime,callback:function(e){t.$set(t.query,"etime",e)},expression:"query.etime"}})],1),a("el-form-item"),a("el-form-item",[a("el-button",{attrs:{type:"primary"},on:{click:t.handleQueryClick}},[t._v("查询")])],1)],1),a("div",{staticClass:"tw-query-panel"},[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.table.loading,expression:"table.loading"}],staticStyle:{width:"100%"},attrs:{data:t.table.data,border:"",size:"small",height:"100%"}},[a("el-table-column",{attrs:{type:"index",label:"序号",width:"60"}}),a("el-table-column",{attrs:{prop:"time",label:"月份",width:"120"}}),a("el-table-column",{attrs:{prop:"count1",label:"车辆总数/辆",width:"120"}}),a("el-table-column",{attrs:{prop:"count2",label:"已安装/辆",width:"120"}}),a("el-table-column",{attrs:{prop:"count3",label:"新增安装数/辆",width:"120"}}),a("el-table-column",{attrs:{prop:"count4",label:"新增占比",width:"120"}}),a("el-table-column",{attrs:{prop:"count5",label:"已安装占比","min-width":"120"}})],1)],1)],1),a("div",{staticClass:"tw-template-right"},[a("v-chart",{ref:"vehicleChart",staticClass:"vehicleChart",attrs:{options:t.vehicleChartOptions}})],1)])},l=[],s=a("17fb"),n=a.n(s),r=a("bc3a"),o=a.n(r),c=a("c1df"),h=a.n(c),d=a("9ca8"),m={name:"MonthlyInstallationAnalysis",data:function(){return{query:{stime:"",etime:""},table:{loading:!1,data:[]},vehicleChartOptions:{color:["#19d4ae","#5ab1ef","#fa6e86","#ffb980","#0067a6","#c4b4e4","#d87a80","#9cbbff","#d9d0c7","#87a997","#d49ea2","#5b4947","#7ba3a8"],tooltip:{trigger:"axis"},legend:{top:60,left:"center",data:["车辆总数","已安装数","新增数","不满意"]},grid:{top:90,left:20,right:40,bottom:20,containLabel:!0},xAxis:{type:"category",data:[]},yAxis:{type:"value"},series:[{name:"车辆总数",type:"line",smooth:!0,data:[]},{name:"已安装数",type:"line",smooth:!0,data:[]},{name:"新增数",type:"bar",smooth:!0,data:[]}]}}},mounted:function(){var t=this;this.$nextTick((function(){t.query.stime=h()().format("YYYY-MM"),t.query.etime=h()().format("YYYY-MM"),t.getMonthInstallAnalysis(),window.onresize=function(){t.$refs.vehicleChart.resize()}}))},methods:{getMonthInstallAnalysis:function(){var t=this;this.table.loading=!0;var e=this.query,a=e.stime,i=e.etime;o.a.get("servicePlatformUsage/getMonthInstallAnalysis",{baseURL:this.baseURL,params:{stime:a&&h()(a).format("YYYY-MM-DD HH:mm:ss"),etime:i&&h()(i).format("YYYY-MM-DD HH:mm:ss")}}).then((function(e){t.table.data=e.data||[],t.table.currentPage=1,t.table.total=t.table.data.length,t.vehicleChartOptions.xAxis.data=[],t.vehicleChartOptions.series[0].data=[],t.vehicleChartOptions.series[1].data=[],t.vehicleChartOptions.series[2].data=[],t.table.loading=!1,n.a.map(e.data,(function(e){t.vehicleChartOptions.xAxis.data.push(e.time),t.vehicleChartOptions.series[0].data.push(e.count1),t.vehicleChartOptions.series[1].data.push(e.count2),t.vehicleChartOptions.series[2].data.push(e.count3)}))}))},handleQueryClick:function(){this.table.currentPage=1,this.getMonthInstallAnalysis()}},components:{"v-chart":d["a"]}},u=m,p=(a("3c76"),a("2877")),b=Object(p["a"])(u,i,l,!1,null,"8feef7a2",null);e["default"]=b.exports}}]);
//# sourceMappingURL=chunk-223bf14d.590116b1.js.map