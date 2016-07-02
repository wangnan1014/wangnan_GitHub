function check(formName,formTips){

	var $tips=formTips;
	var flag = true;
	
	$("#"+formName+" :input.required").each(function(){
		if(""==$.trim(this.value) ){
			$tips.find("p").empty().append($(this).attr("hint"));
			$tips.show(500);
			setTimeout(function(){$tips.hide(500)},5000);
			this.focus();
			flag = false;
			return flag;
		} 
	});
		
	$("#"+formName+" input.email").each(function(){ 
		if(( $.trim(this.value)!="" && !/.+@.+\.[a-zA-Z]{2,4}$/.test(this.value))){
			$tips.find("p").empty().append("请输入正确的E-Mail地址！");
			$tips.show(500);
			setTimeout(function(){$tips.hide(500)},5000);
			this.focus();
			flag = false;
			return flag;
		} 
		
		
	});

    return flag;
}


 