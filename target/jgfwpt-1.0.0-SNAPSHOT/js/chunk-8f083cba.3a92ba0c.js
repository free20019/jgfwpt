(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-8f083cba"],{"1cdc":function(a,t,e){"use strict";e.r(t);var n=function(){var a=this,t=a.$createElement,e=a._self._c||t;return e("div",{staticClass:"tw-template-wrapper"},[e("el-amap",{directives:[{name:"loading",rawName:"v-loading",value:a.table.loading,expression:"table.loading"}],ref:"map",attrs:{vid:"amap",center:a.map.center,zoom:a.map.zoom,plugin:a.map.plugin,events:a.map.events,"amap-manager":a.amapManager}}),e("div",{staticClass:"tw-map-query-panel"},[e("div",{staticClass:"tw-icon tw-map-query-show iconfont",staticStyle:{"font-size":"16px"},on:{click:a.handleMapPanelOpenClick}},[a._v("上车时间分布")])]),a.panel.display?e("div",{staticClass:"tw-map-panel tw-map-panel__float"},[e("v-chart",{directives:[{name:"loading",rawName:"v-loading",value:a.table.loading,expression:"table.loading"}],ref:"vehicleChart",staticClass:"vehicleChart",attrs:{options:a.vehicleChartOptions}}),e("div",{staticClass:"tw-map-panel-btn__close",on:{click:a.handleMapPanelCloseClick}},[a._v("×")])],1):a._e()],1)},i=[],s=e("17fb"),o=e.n(s),l=e("bc3a"),c=e.n(l),p=e("8f9b"),r=new p["AMapManager"],d={name:"CapacityDemandHotsPot",data:function(){return{table:{loading:!1},HotsPotList:[],heatmap:null,amapManager:r,map:{checked:!1,center:[120.170076,30.277559],zoom:14,plugin:[],events:{}},panel:{display:!1},vehicleChartOptions:{color:["#19d4ae","#5ab1ef","#fa6e86","#ffb980","#0067a6","#c4b4e4","#d87a80","#9cbbff","#d9d0c7","#87a997","#d49ea2","#5b4947","#7ba3a8"],tooltip:{trigger:"axis"},legend:{top:20,data:["上车数量"]},grid:[{top:60,left:20,right:20,bottom:40,containLabel:!0}],xAxis:{axisTick:{alignWithLabel:!0},type:"category",data:[]},yAxis:{type:"value"},series:[{name:"上车数量",type:"line",stack:"上车数量",data:[],markLine:{data:[{type:"average",name:"平均值"}]}}]}}},mounted:function(){var a=this;this.$nextTick((function(){window.onresize=function(){a.$refs.vehicleChart.resize()},a.getCapacityDemandHotsPot(),a.getCapacityDemandHotsPotDriver()}))},methods:{getCapacityDemandHotsPot:function(){var a=this;this.table.loading=!0,c.a.get("industryOperation/getcapacitydemandhotspot",{baseURL:this.baseURL,params:{}}).then((function(t){console.log("1111111111=",t.data),t.data.length>0&&a.rlt(t.data),a.table.loading=!1})).catch((function(a){console.error(a)}))},rlt:function(a){var t=this;function e(){var a=document.createElement("canvas");return!(!a.getContext||!a.getContext("2d"))}e()||alert("热力图仅对支持canvas的浏览器适用,您所使用的浏览器不能使用热力图功能,请换个浏览器试试~"),o.a.filter(a,(function(a,e){t.HotsPotList.push({lng:a.DEP_LATI,lat:a.DEP_LONGI,count:1})})),r.getMap().plugin(["AMap.Heatmap"],(function(){})),this.heatmap=new AMap.Heatmap(r.getMap(),{radius:50,opacity:[0,.8]}),this.heatmap.setDataSet({data:this.HotsPotList,max:100})},getCapacityDemandHotsPotDriver:function(){var a=this;c.a.get("industryOperation/getcapacitydemandhotspotdriver",{baseURL:this.baseURL,params:{}}).then((function(t){console.log("222222222222=",t.data),t.data.length>0&&(a.vehicleChartOptions.xAxis.data=[],a.vehicleChartOptions.series[0].data=[],o.a.map(t.data,(function(t){a.vehicleChartOptions.xAxis.data.push(t.DEP_TIME+"时"),a.vehicleChartOptions.series[0].data.push(t.C)})))})).catch((function(a){console.error(a)}))},handleMapPanelCloseClick:function(){this.panel.display=!1},handleMapPanelOpenClick:function(){this.panel.display=!0}}},h=d,m=(e("e8cd"),e("2877")),u=Object(m["a"])(h,n,i,!1,null,"265a4290",null);t["default"]=u.exports},db12:function(a,t,e){},e8cd:function(a,t,e){"use strict";var n=e("db12"),i=e.n(n);i.a}}]);
//# sourceMappingURL=chunk-8f083cba.3a92ba0c.js.map