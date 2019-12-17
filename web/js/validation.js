$(document).ready(function(){
	
	$("#btn").click(function(){
	
			var regyhm=/^[\u2E80-\u9FFF]+$/;
				var yhm=$("#user").val();
				if (yhm==""){
					$("#user_prompt").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;姓名不能为空");
					return false;
				}
				
				if (regyhm.test(yhm)==false){
					$("#user_prompt").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;姓名必须是中文");
					return false; 
				}else{
					$("#user_prompt").html("");
				
				}
				
				
				
				
				var regmima=/^[0-9]{18}$/;
				var mima = $("#ID").val();
				if (mima == "") {
					$("#card_id").html("身份证号不能为空");
					return false;
				}
			
				if (regmima.test(mima)==false) {
					$("#card_id").html("身份证号是18位数字组成的"+"\b"+"如身份证带有x请去本银行线下办理贷款");
					
					return false;
				}else{
					$("#card_id").html("");
				
				}
				
				
				
				
				
				var numbe=/^[0-9]{16}$/;
				var ber = $("#number").val();
				if (ber == "") {
					$("#number_id").html("银行卡号不能为空");
					return false;
				}
				if (numbe.test(ber)==false) {
					$("#number_id").html("银行卡号是16位数字组成的");
					return false;
				}else{
					$("#number_id").html("");
				
				}
				
		
			var reghm=/^1[0-9]{10}$/;
			var hm=$("#mobile").val();
			if (hm == "") {
				$("#mobile_prompt").html("手机号码不能为空");
				return false;
			}
			
			if (reghm.test(hm)==false) {
				$("#mobile_prompt").html("手机号码由1开头的11位数字");
				return false;
			}
			else{
					$("#mobile_prompt").html("");
				
				}
			return true;
			
	});
	
});
