$(function() {
	var region = {
  		  	"华北":["北京","天津","河北","山西","内蒙古"],
  		  	"东北":["辽宁","吉林","黑龙江"],
  		  	"华东":["上海","江苏","浙江","安徽","福建","山东"],
  		  	"华中":["湖北","湖南","河南","江西"],
  		  	"华南":["广东","广西","海南"],
  		  	"西南":["重庆","四川","贵州","云南","西藏"],
  		  	"西北":["陕西","甘肃","青海","宁夏","新疆"],
  		  	"台港澳":["台湾","香港","澳门"]
			};
  		    var nameData = {"黑龙江":"heilongjiang", "吉林":"jilin", "辽宁":"liaoning", "河北":"hebei", "山东":"shandong", "江苏":"jiangsu", "浙江":"zhejiang", "安徽":"anhui", "河南":"henan", "山西":"shanxi", "陕西":"shaanxi", "甘肃":"gansu", "湖北":"hubei", "江西":"jiangxi", "福建":"fujian", "湖南":"hunan", "贵州":"guizhou", "四川":"sichuan", "云南":"yunnan", "青海":"qinghai", "海南":"hainan", "上海":"shanghai", "重庆":"chongqing", "天津":"tianjin", "北京":"beijing", "宁夏":"ningxia", "内蒙古":"neimenggu", "广西":"guangxi", "新疆":"xinjiang", "西藏":"xizang", "广东":"guangdong", "香港":"xianggang", "台湾":"taiwan", "澳门":"aomen"};
  		    var json = eval(region);
  		    var v_arr = new Array();
  		    
  		    	var typeName = 0;
  		    	$(".typeName").click(function(){//0 区域：1：省
  		    		$(this).prop("checked", true);
  		    		typeName=$(this).val();
  		    		allFillColor(1);
					$("#morris-bar-chart").html("");
					$("#data-show").html("");
						

  		    	})
  		      // 默认
  		      var mObj = $('#ChinaMap').SVGMap({
  		        mapName: 'china',
  		        mapWidth: 450,
  		        mapHeight:350,
  		        showTip:true,
  		        external: true,
  		    	clickColorChange: true, 
  		   		clickCallback: function(stateData, obj){
  		   			if(typeName == 0){
  						compareMapNames(obj,3);
  					}else if(typeName == 1){
  						v_arr.push(obj.name);
  					}
  		   			//showData();
  		   			showDataForHighcharts();
  			    }, 
  		 	    unClickCallback: function(stateData, obj){
  		 	    	if(typeName == 0){
  		       			compareMapNames(obj,4)
  		       		}else if(typeName == 1){
  		       			v_arr.remove(obj.name);
  		       		}
  		 	    	//showData();
  		 	    	showDataForHighcharts();
  		   		},
  			    hoverCallback: function(stateData, obj){ 
  			       
  			    },
  		      });
  		      $(".all-select").click(function(){
  		      	allFillColor(0);
  		      	//showData();
  		        showDataForHighcharts();
  		      });
  		      $(".no-select").click(function(){
  		      	allFillColor(1);
				$("#morris-bar-chart").html("");
				$("#data-show").html("");	  		      	
  		      }); 
  		      $(".reverse-select").click(function(){
  		      	allFillColor(2);
  		 		//showData();
  		      	showDataForHighcharts();
  		      });                
  		      //0全选    1 重置  2 反选
  		      function  allFillColor(lock){
  		 		$.each(region,function(cc){
  					 fillColors(region[cc],lock );		
  		 		})
  		      }      
  		      //根据省份选区域 
  		      function  compareMapNames(obj, lock ){
  		     	 for(x in region){
  					 for(y in region[x]){
  						if(region[x][y]==obj.name){
  							fillColors(region[x],lock );
  							return false;
  						}
  			 		 }
  				 }
  		      }
  		      //0全选    1 重置  2 反选 3 区域选中 4区域撤销选中
  		      function fillColors(fillNames, lock ){
  		      	 if( lock == 0){//all select
  		      	 	 $.each(fillNames,function(index){
  		      	 		var fillName =  nameData[fillNames[index]];
  		      	 		var fno = mObj.externalData[fillName];
  		      	 		fno.attr({fill: '#EC971F'});
  		      	 		fno['eventHoverLock'] = false; 
  		      	 		if(mObj.options.clickedRegion.indexOf(fno.id)==-1){
  		      	 			mObj.options.clickedRegion.push(fno.id);
  		      	 		}
  		      	 		if(v_arr.indexOf(fno.name)==-1){
  		      	 			v_arr.push(fno.name);
  		      	 		}
  		      	 	})
  		      	 }else if(lock == 1){// 重置
  		      	     $.each(fillNames,function(index){
  		      	   		var fillName =  nameData[fillNames[index]];
  		      	 		var fno = mObj.externalData[fillName];
  		      	 		fno.attr({fill: '#AAD5FF'});
  		      	 		fno['eventHoverLock'] = false; 
  		      	 		mObj.options.clickedRegion.remove(fno.id);
  		      	 		v_arr.remove(fno.name);
  		      	 	})
  		      	 }else if(lock == 2){//反选
  		      	     $.each(fillNames,function(index){
  		      	   		var fillName =  nameData[fillNames[index]];
  		      	   		var fno = mObj.externalData[fillName];
  		      	 		if(fno.attr("fill")=="#EC971F"){
  		      	 			fno.attr({fill: '#AAD5FF'});
  			      	 		fno['eventHoverLock'] = false; 
  		      	 			mObj.options.clickedRegion.remove(fno.id);
  		      	 			v_arr.remove(fno.name);
  		      	 		}else if(fno.attr("fill")=="#AAD5FF"){
  			      	 		fno.attr({fill: '#EC971F'});
  			      	 		fno['eventHoverLock'] = false; 
  			      	 		if(mObj.options.clickedRegion.indexOf(fno.id)==-1){
  		      	 				mObj.options.clickedRegion.push(fno.id);
  		      	 			}
  	  		      	 		if(v_arr.indexOf(fno.name)==-1){
  	  		      	 			v_arr.push(fno.name);   	 
  	  		      	 		}
  		      	 		}
  		      	 	})      	 
  		      	 }else if(lock == 3){//区域选中
  			      	  $.each(fillNames,function(index){ 
  		      	   		var fillName =  nameData[fillNames[index]];
  		      	   		var fno = mObj.externalData[fillName];      
  						fno.attr({fill: '#EC971F'});
  		      	 		fno['eventHoverLock'] = false; 
  		      	 		if(mObj.options.clickedRegion.indexOf(fno.id)==-1){
  		     	 			mObj.options.clickedRegion.push(fno.id);
  		     	 		}
  		      	 		if(v_arr.indexOf(fno.name)==-1){
  		      	 			v_arr.push(fno.name);      	  
  		      	 		}
  			          })   
  		      	 }else if(lock == 4){//区域撤销选中
  			      	  $.each(fillNames,function(index){ 
  		      	   		var fillName =  nameData[fillNames[index]];
  		      	   		var fno = mObj.externalData[fillName]; 
  		      	 		fno.attr({fill: '#AAD5FF'});
  		      	 		fno['eventHoverLock'] = false; 
  		     	 		mObj.options.clickedRegion.remove(fno.id);
  		     	 		v_arr.remove(fno.name);       	   		 	          	
  			          })   
  		      	 }
  		      }
  	  		//document.getElementById('startDate').addEventListener('onpropertychange', showData());
  	  		//document.getElementById('endDate').addEventListener('onpropertychange',showData());  		      
  		    //$("#startDate,#endDate").click(function(){
  		    //	var c = WdatePicker();
  		    //})
  		    //$("#startDate,#endDate").bind("click input propertychange",function(){
  		    $("#startDate,#endDate").bind("click",function(){
  		    	var obj = $(this);
  		    	WdatePicker({onpicking:function(dp){
  		    		var newData =$dp.cal.getNewDateStr()
  		    		obj.val(newData);
  	  		    	//if(!showDataCallBack(showData)){
  		    		if(!showDataCallBack(showDataForHighcharts)){
  	  		    		return false;
  	  		    	}  		    		
  		    	}});
  		    })

  		    function showDataCallBack(callback){
  		    	callback();
  		    }
  		    var myChart =""; 
  		    function showData(){
  		    	//if(!comparDate($("#startDate").val(),$("#endDate").val())){	
  		      	//	return false;
  		      	//}
  		      	if(v_arr.length>0){
  				 $.ajax({
  					   type: 'POST', 
  					   url:"/mapReport!getProjectReport.action?rand="+Math.random(),
  					   data: {
  					    "typeName":typeName,
  					    "v_arr":v_arr.join(','),	
  					    "startDate":$("#startDate").val(),
  					    "endDate":$("#endDate").val()
  					   },
  					   dataType: "json",
  					   async:false,
  					   success : function(d){ 
  					   var da = d.data;
  					   //var dd ="";
  				       var dd = new Array();
  					   var data_shwo="";
  						if(da.length==0){
  							$("#morris-bar-chart").html("");
  							$("#data-show").html("<p> 对不起，没有查询到相关信息！</p>");						
  						}else{
  							//dd="[";
  							var contractprice_sum=0;
  							var invoicecount_sum=0;
  							var refunds_sum=0;
  							$.each(da,function(dis){
  								//morris.min.js
  								//dd+="{a:'" + da[dis].a +"',contractprice:" + da[dis].contractprice+ ",invoicecount:" + da[dis].invoicecount + ",refunds:" + da[dis].refunds+"},";
  							 	//dd+="["+da[dis].a+","+ da[dis].contractprice+","+da[dis].invoicecount+","+da[dis].refunds+"],";
  								var ee = new Array();
  								ee.push(da[dis].a);
  								ee.push(da[dis].contractprice);
  								ee.push(da[dis].invoicecount);
  								ee.push(da[dis].refunds);
  								dd.push(ee);
  								contractprice_sum+=da[dis].contractprice;
  								invoicecount_sum+=da[dis].invoicecount;
  								refunds_sum+=da[dis].refunds;
  								data_shwo+="<tr><td>"+da[dis].a+"</td>"+"<td>"+ da[dis].contractprice.toFixed(2)+"</td>"+"<td>"+da[dis].invoicecount.toFixed(2)+"</td>"+"<td>"+da[dis].refunds.toFixed(2)+"</td>"+"</tr>";
  							 })
  								data_shwo+="<tr><td>合计(元)</td>"+"<td>"+ contractprice_sum.toFixed(2)+"</td>"+"<td>"+ invoicecount_sum.toFixed(2)+"</td>"+"<td>"+refunds_sum.toFixed(2)+"</td>"+"</tr>";
  						    //dd+="]"	; 
  						$("#morris-bar-chart").html("");
  						$("#data-show").html(data_shwo);
  						/**图表
  						var Mob =  Morris.Bar({
  					        element: 'morris-bar-chart',
  					        data: eval(dd),
  					        xkey: 'a',
  					        ykeys: ['contractprice', 'invoicecount','refunds'],
  					        labels: ['合同订单额','销售收入额','货款回收额'],
  					        hideHover: 'auto',
  					        resize: true,
  					        gridTextSize:8,
  					       // stacked: true // 多条转一条 以颜色区分
  					    }); 
						*/
  			  			var parentDiv = document.getElementById("morris-bar-chart");
  						myChart = new JSChart('morris-bar-chart', 'bar');
  						//var myData = new Array(eval(dd));
  						myChart.setTitle('数据汇总');
  						myChart.setTitleFontSize(14); 
  						myChart.setTitlePosition('top right');
  						myChart.setDataArray(dd);
  						myChart.setLegendForBar(1, '销售收入额');
  						myChart.setLegendForBar(2, '合同订单额');
  						myChart.setLegendForBar(3, '货款回收额');
  						myChart.setBarColor('#CD9B1D', 1);
  						myChart.setBarColor('#FA5E1F', 2);
  						myChart.setBarColor('#2D6b14', 3);
  						myChart.setLegendPosition('top right');
  						myChart.setLegendShow(true);
  						//myChart.setTooltipOffset(20);
  						myChart.setAxisNameX('');
  						//myChart.setAxisValuesAngle(30);
  						myChart.setAxisNameY('');
  						myChart.setAxisNameFontSize(16);
  						myChart.setAxisNameColor('#999');
  						myChart.setAxisValuesColor('#737373');
  						myChart.setAxisColor('#B5B5B5');
  						myChart.setAxisWidth(1);
  						myChart.setAxisPaddingLeft(60);
  						myChart.setBarBorderWidth(0);
  						//myChart.setBarSpacingRatio (50);
  						//myChart.setAxisPaddingRight(140);
  						myChart.setSize(610,300);
  						myChart.setBarValues(false)//设置是否在矩形顶端显示值。
  						myChart.setBarValuesFontSize(6);
  						myChart.setBarOpacity(0.8);
  						myChart.setGraphExtend(true);
  						//myChart.set3D(true);
  						myChart.draw();
  						mapReoprtResize();
  						//$("#JSChart_morris-bar-chart img").addClass("carousel-inner img-responsive img-rounded");
  						}
  					   },
  					   error:function(d){
  					   	   alert("数据错误，请联系相关人员！")
  					   }
  				 });	      	
  				}else{
					$("#morris-bar-chart").html("");
					$("#data-show").html("<p> 对不起，没有查询到相关信息！</p>");	
  				}	  		    	  
  		    	  
  		    }
  		    function showDataForHighcharts(){
  		      	if(v_arr.length>0){
  				 $.ajax({
  					   type: 'POST', 
  					   url:"/mapReport!getProjectReport.action?rand="+Math.random(),
  					   data: {
  					    "typeName":typeName,
  					    "v_arr":v_arr.join(','),	
  					    "startDate":$("#startDate").val(),
  					    "endDate":$("#endDate").val()
  					   },
  					   dataType: "json",
  					   async:false,
  					   success : function(d){ 
  					   var da = d.data;
  				       var dd = new Array();
  					   var data_shwo="";
  						if(da.length==0){
  							$("#morris-bar-chart").html("");
  							$("#data-show").html("<p> 对不起，没有查询到相关信息！</p>");						
  						}else{
  							var contractprice_sum=0;
  							var invoicecount_sum=0;
  							var refunds_sum=0;
  							var a1 = new Array();
  							var a2 = new Array();
  							var a3 = new Array();
  							var a4 = new Array();
  							$.each(da,function(dis){
  								var ee = new Array();
  								a1.push(da[dis].a);
  								a2.push(da[dis].contractprice);
  								a3.push(da[dis].invoicecount);
  								a4.push(da[dis].refunds);
  								dd.push(ee);
  								contractprice_sum+=da[dis].contractprice;
  								invoicecount_sum+=da[dis].invoicecount;
  								refunds_sum+=da[dis].refunds;
  								data_shwo+="<tr><td>"+da[dis].a+"</td>"+"<td>"+ da[dis].contractprice.toFixed(2)+"</td>"+"<td>"+da[dis].invoicecount.toFixed(2)+"</td>"+"<td>"+da[dis].refunds.toFixed(2)+"</td>"+"</tr>";
  							 })
  								data_shwo+="<tr><td>合计(元)</td>"+"<td>"+ contractprice_sum.toFixed(2)+"</td>"+"<td>"+ invoicecount_sum.toFixed(2)+"</td>"+"<td>"+refunds_sum.toFixed(2)+"</td>"+"</tr>";
  						$("#morris-bar-chart").html("");
  						$("#data-show").html(data_shwo);
  					    Highcharts.setOptions({
  					        lang: {
  					    		contextButtonTitle:"打印或输出",
  					    		printChart:"打印",
  					    		downloadJPEG:"导出为JPE图片",
  					    		downloadPDF:"导出为PDF文件",
  					    		downloadPNG:"导出为PNG图片",
  					    		downloadSVG:"导出为SVG文件",
  					    		
  					            //numericSymbols: [' k', ' w', ' y'],
  					            //resetZoom:'重置',
  					            //resetZoomTitle:'',
  					        }
  					    });
	  			  		$('#morris-bar-chart').highcharts({
	  			          chart: {
	  			            type: 'bar',
	  			  			//type: 'column',
	  			  			marginTop: 80,
	  			  			marginRight: 20,
	  			  			zoomType:'xy'
	  			          },
	  			          title: {
	  			              text: '数据汇总',
	  			              style:{
	  			        	  "fontSize": "16px"
	  			        	  
	  			          	  } 
	  			          },
	  			          subtitle: {
	  			              text: null
	  			          },
	  			          xAxis: {
	  			              categories: a1,
	  			              crosshair: true,
	  			              title: {
	  			                text: null,
	  			          	  }   
	  			          },
	  			          yAxis: { 
	  			              min: 0,
	  			              title: {
	  			                  text: null,
	  			                 
	  			              },
		  			          labels: {
		  			               overflow: 'justify',
		  			          }	  			              
	  			          },
	  			        legend: {
	  			            //layout: 'vertical',//垂直排列
	  			            align: 'center',//水平方向
	  			            verticalAlign: 'top',//垂直方向
	  			            x: 0,
	  			            y: 30,
	  			            floating: true,
	  			            borderWidth: 1,
	  			            backgroundColor: ((Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'),
	  			            shadow: true
	  			        },
	  			        credits: {
	  			            enabled: false
	  			        },	  			        
	  			        tooltip: {
	  			            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
	  			            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
	  			                '<td style="padding:0"><b>{point.y:.2f} 元</b></td></tr>',
	  			            footerFormat: '</table>',
	  			            shared: true,
	  			            useHTML: true
	  			        },
	  			        plotOptions: {
	  			            column: {
	  			                pointPadding: 0.2,
	  			                borderWidth: 0
	  			            }
	  			        },  			          
	  			          series: [{
	  			            name: '销售收入额',
	  			            data: a2,
	  			        }, {
	  			            name: '合同订单额',
	  			            data: a3,
	  			        }, {
	  			            name: '货款回收额',
	  			            data: a4,
	  			        }]
	  			      });
  						}
  					   },
  					   error:function(d){
  					   	   alert("数据错误，请联系相关人员！")
  					   }
  				 });	      	
  				}else{
					$("#morris-bar-chart").html("");
					$("#data-show").html("<p> 对不起，没有查询到相关信息！</p>");	
  				}	  		    	  
  		    	  
  		    }
  		    
	  		$(window).resize(function() { 
	  			if(myChart!=""){
	  				mapReoprtResize()
	  			}
	  			  
	  		})
	  		//for JSChart 自适应
  		    function mapReoprtResize(){
	  			var parentDiv = document.getElementById("morris-bar-chart");
	  				//myChart.resize(parentDiv.clientWidth,parentDiv.clientHeight); 
	  				if(parentDiv.clientWidth>350){
	  					$('canvas').width(parentDiv.clientWidth);
	  				}else{
	  					$('canvas').width(350);
	  				}
	  				if(parentDiv.clientWidth>250){
	  					$('canvas').height(parentDiv.clientHeight);
	  					}else{
	  						$('canvas').height(250);
	  				}
  		    }
  		    
  			function comparDate( startDate, endDate ) {
  				//alert(new Date());
  		        if(startDate==""){
  		         alert("开始日期不能为空");
  		        return false;
  		        }
  		        if(endDate==""){
  		         alert("结束日期不能为空");
  		        return false;
  		        }

  				if( (new Date(startDate.replace(/-/g,"\/"))) > (new Date(endDate.replace(/-/g,"\/")))){
  					alert("开始日期不能大于等于结束日期");
  					return false;
  				
  				}
  				return true;
  			}	
});