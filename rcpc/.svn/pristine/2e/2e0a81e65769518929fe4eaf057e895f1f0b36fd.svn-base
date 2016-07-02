//调用数据 并赋值 暂时只实现select
//par :name="itypename" action，type：selcet;checkbox....;value1,value2 ：option value和text;
//par :gl: 联动赋值字段 :当name 为 “itypename”的 select值改变时 自动给页面上 gl 元素赋值 
		var type_val="";
		var name_val="";
		var value1_val="";
		var value2_val="";
		var gl_val="";
		function getColData(name,action,type,value1,value2,gl){
			type_val = type;
			name_val = name;
			value1_val = value1;
		 	value2_val = value2;
		 	gl_val = gl;
			$.ajax({
			   type: 'POST',
			   url:"/toOut/toOut!"+action+".action",
			   data: {type:type},
			   dataType: "json",
			   async:false,
			   success : function(d){
				if(!d){
				}else{
					if(type_val=="selcet"){
						initSelcetCol(name_val,d);
					}
					type_val="";
				}
				if(gl_val!=""&&gl_val!=null){
					var gl_key= "#"+ name;
					var bgl_key= "#"+ gl;
					$(gl_key).bind("change",function(){
						$(bgl_key).val($(gl_key).find("option:selected").text());
					})
				}
			   },
			   error:function(d){
			   	   alert("初始值错误")
			   }
		   });
			
		}
   		//selecet 初始化
   		function initSelcetCol(name,d){
	 		if(!d){
				return false;
			}else{
				
			var obj = eval(d);
			var datas = obj.data;
			var key = "#" + name;
			jQuery(key).html("");
			jQuery(key).html("<option value=''>请选择</option>");
			$.each(datas,function(i){
				var v1="";
				var v2=""; 
				data =datas[i];
				$.each(data,function(x){
					if(value1_val==x){
						v1=data[x];
					}
					if(value2_val==x){
						v2=data[x];
					}
				});
				if(v1!=""&&v2!=""){
				jQuery(key).append("<option value='"+v1+"'>"+v2+"</option>");
				}
			 });		 
			}
   		}
		//编辑开关 0关 1 开
	    function controlSet(obj,key){
	    	if(key==0){
			    $(obj).each(function() {
			        $(this).prop("disabled", "true");
			    });
			}else if(key==1){
			    $(obj).each(function() {
			         $(this).removeAttr("disabled");
			    });
			}    
	    }
		//转编辑状态
		$("#edit").click(function(){
			controlSet('input,select,textarea',1);
 			controlSet('#edit',0);	
 			controlSet('#save',1);
			//$("#actionName").val("edit");
		})	
		//通用型
		function setCV(key,value){
			var k = "#"+key;
			if($(k).length>0){
				if($(k)[0].nodeName=="INPUT"){
					if($(k).attr("type")=="text"||$(k).attr("type")=="textarea"){
						$(k).attr("value",value); 
					}else if($(k).attr("type")=="radio"){//要改
						//$("input[@type=radio]"+k).attr("checked",value);//设置value=2的项目为当前选中项
					}else if($(k).attr("checkbox")=="checkbox"){//要改
					// $(k).attr("checked",'true');
					}else if($(k).attr("type")=="hidden"){
					$(k).attr("value",value); 
				}
				}else if($(k)[0].nodeName=="SELECT"){
					k1= k+ " option";
					if($(k1).length>0){
						$(k).val(value);
					}
				}
			}
		}
		
		//原始数据记录 
   		var propertyNames = new Array();
   		var propertyValues = new Array();
   		function setPN(key){
   			propertyNames.push(key);
   		}
   		function setPV(value){
   			propertyValues.push(value);
   		}		
		//初始赋值
		function setData(d){
			if(!d){
				return false;
			}else{
				var jsonArray = d.data;		
				$.each(jsonArray,function(i){
                    var key = i;
                    var value =jsonArray[i];       
                     setPN(key);
                     setPV(value);  
                     setCV(key,value);
                }); 
			}
		}
		//记录修改数据
	    function setChangedProperty(){
	 	   var changedProperty = new Array();
	       var changedPropertyDate = new Array();
	       var oldDate = new Array();
	 	   for (var i = 0; i < document.form1.elements.length; i++) {
	 		    var e = document.form1.elements[i];
	 		    if (e.type == "text" || e.type == "textarea" || e.type == "select-one"||e.type == "hidden") {
	 		    	var index = propertyNames.indexOf(e.id);
					if(index>-1){
						if(e.value!=propertyValues[index]){
							if(e.id!=""){
								changedProperty.push(e.id);
							}else{
								changedProperty.push("null");
							}
							if(e.value!=""){
								changedPropertyDate.push(e.value);
							}else{
								changedPropertyDate.push("null");
							}							
							if(propertyValues[index]!=""){
								oldDate.push(propertyValues[index])	
							}else{
								oldDate.push("null");
							}
						}
					}
	 		    }
	 	   }
	 	   form1.changedProperty.value = changedProperty.join(',');
	 	   form1.changedPropertyDate.value = changedPropertyDate.join(',');
	 	   form1.oldDate.value = oldDate.join(',');
	    }
