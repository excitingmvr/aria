validationTest = function() {
	alert("validationTest");
}


function checkNull (obj, value, message) {
// checkNull = function(obj, value, message) {
    if (value == "" || value == null) {
		validationOutput(obj, message);
        return false;
    } else {
        return true;
    }
}


function checkNullWithoutFocus (value, message) {
// checkNullWithoutFocus = function(value, message) {
    if (value == "" || value == null) {
        alert(message);
        return false;
    } else {
        return true;
    }
}


function checkOnlyKoreanEnglishNumber (objName, pattern, nullAllowedNy, message) {
// checkOnlyKoreanEnglishNumber = function(obj, value, message) {
    var regExp = /^[ㄱ-ㅎ가-힣A-Za-z0-9]+$/;
    return checkLogic (objName, pattern, nullAllowedNy, message, regExp);
}


function checkOnlyEnglishNumber (objName, pattern, nullAllowedNy, message) {
// checkOnlyEnglishNumber = function(obj, value, message) {
    var regExp = /^[A-Za-z0-9]+$/;
    return checkLogic (objName, pattern, nullAllowedNy, message, regExp);
}


function checkOnlyEnglish (objName, pattern, nullAllowedNy, message) {
// checkOnlyEnglish = function(obj, value, message) {
    var regExp = /^[A-Za-z]+$/;
	return checkLogic (objName, pattern, nullAllowedNy, message, regExp);
}


function checkOnlyKoreanNumber (objName, pattern, nullAllowedNy, message) {
// checkOnlyKoreanNumber = function(obj, value, message) {
    var regExp = /^[ㄱ-ㅎ가-힣0-9]+$/;
	return checkLogic (objName, pattern, nullAllowedNy, message, regExp);
}


function checkOnlyKorean (objName, pattern, nullAllowedNy, message) {
// checkOnlyKorean = function(obj, value, message) {
    var regExp = /^[ㄱ-ㅎ가-힣]+$/;
	return checkLogic (objName, pattern, nullAllowedNy, message, regExp);
}


function checkOnlyNumber (objName, pattern, nullAllowedNy, min, max, message) {
// checkOnlyNumber = function(obj, value, message) {
	var obj = document.getElementById(objName);
	var objValue = document.getElementById(objName).value.trim();
	var objFeedback = document.getElementById(objName+"Feedback");
    var regExp = /^[0-9]+$/;
	
	if(objValue >= min && objValue <= max) {
    	return checkLogic (objName, pattern, nullAllowedNy, message, regExp);
	} else {
		checkLogicExpression (obj, objFeedback, pattern, message);
		return fasle;
	}
}


function checkLogic (objName, pattern, nullAllowedNy, message, regExp) {
// checkLogic = function (obj, value, pattern, message, regExp) {
	
	var obj = document.getElementById(objName);
	var objValue = document.getElementById(objName).value.trim();
	var objFeedback = document.getElementById(objName+"Feedback");
	
	if(nullAllowedNy == 0) {
		if(regExp.test(objValue)){
			// obj.removeClass("is-invalid");
			obj.classList.remove('is-invalid');
			return true;
		} else {
			checkLogicExpression (obj, objFeedback, pattern, message);
			return false;
		}
	} else if (nullAllowedNy == 1) {
		if(objValue != "" && objValue != null) {
			if(regExp.test(objValue)) {
				// obj.removeClass("is-invalid");
				obj.classList.remove('is-invalid');
				return true;
			} else {
				checkLogicExpression (obj, objFeedback, pattern, message);
				return false;
			}			
		} else {
			obj.classList.remove('is-invalid');
			return true;
		}
	} else {
		alert("error: param nullAllowedNy in checkLogic");
		return false;
	}
}


function checkLogicExpression (obj, objFeedback, pattern, message) {
	switch(pattern) {
	case 1:	
	// alert
		alert(message);
		obj.focus();
		break;
	case 2:
	// bootstrap validation
		//obj.addClass("is-invalid");
		obj.classList.add('is-invalid');
		objFeedback.innerText = message;
		obj.focus();
		break;
	case 3:
	// bootstrap modal
		break;
	}
}




checkPasswordAndRe = function(password, passwordRe, message){
    if(password == passwordRe){
        return true;
    } else {
        alert(message);
        return false;
    }
}



checkId = function(obj, value, message) {
    var regExp = /^[A-Za-z0-9,_-]{4,20}$/;
    if(regExp.test(value)) {
		return true;
	} else {
		validationOutput(obj, message);
		return false;
	}
}

checkPassword = function(obj, value, message) {
	var regExp = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[!@#$%^&*]).{8,20}$/;
    /*var regExp = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,20}$/;*/
    if(regExp.test(value)) {
		return true;
	} else {
		validationOutput(obj, message);
		return false;
	}
}



checkDob = function(year, month, day, message) {
    if (Number(year) > 0 && Number(month) > 0 && Number(day) > 0){
        return true;
    } else {
        alert(message);
        return false;
    }
}

checkNullSelect = function(value, message) {
    if(Number(value) == 0){
        alert(message);
        return false;
    }
    else return true;
}

checkNullSelectNy = function(value, message) {
    if(Number(value) == 9){
        alert(message);
        return false;
    }
    else return true;
}

checkHhmm = function(obj, value, message) {
    var regExp = /^([01][0-9]|2[0-3]):([0-5][0-9])$/;
    if(regExp.test(value)) {
    	return true;
    } else {
		alert(message);
		obj.focus();
		return false;
	}
}

checkRadio = function(value, message) {
    if(value != "" && value != null) {
    	return true;
    } else {
		alert(message);
		return false;
	}
}

nullToEmpty = function(value) {
    if(value == null || value == 'null' || value.length === 0) {
           return "";
     } else{
            return value;
     }
}

checkEmail = function(obj, value, message) {
    var regExp = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
    if(regExp.test(value)) {
    	return true;
    } else {
		alert(message);
		obj.focus();
		return false;
	}
}

checkPhone = function(obj, value, message) {
    var regExp = /^\d{2,3}-\d{3,4}-\d{4}$/;
    if(regExp.test(value)) {
    	return true;
    } else {
		alert(message);
		obj.focus();
		return false;
	}
}

checkMobile = function(obj, value, message) {
    var regExp = /^\d{3}-\d{3,4}-\d{4}$/;
    if(regExp.test(value)) {
    	return true;
    } else {
		alert(message);
		obj.focus();
		return false;
	}
}

checkBizNumber = function(obj, value, message) {
    var regExp = /^\d{3}-\d{2}-\d{5}$/;
    if(regExp.test(value)) {
    	return true;
    } else {
		alert(message);
		obj.focus();
		return false;
	}
}

checkEstablishedYear = function(obj, value, message) {
    var regExp = /^\d{4}$/;
    if(regExp.test(value)) {
    	return true;
    } else {
		alert(message);
		obj.focus();
		return false;
	}
}