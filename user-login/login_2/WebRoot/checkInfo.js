
function check(f){
	if(f.username.value=="" || f.password.value=="" || f.city.value=="" ||f.phone.value==""){
		alert("please enter all information");
		f.username.focus();
		return;
	}else{
		f.submit();
	}
    
}
