validationTest = function() {
	alert("validationTest");
}


validationOutput = function(obj, message) {
	// alert(message);
	obj.addClass("is-invalid");
	obj.focus();
}


checkNull = function(obj, value, message) {
    if (value == "" || value == null) {
		validationOutput(obj, message);
        return false;
    } else {
        return true;
    }
}


checkNullWithoutFocus = function(value, message) {
    if (value == "" || value == null) {
        alert(message);
        return false;
    } else {
        return true;
    }
}


checkOnlyEnglishNumber = function(obj, value, message) {
	alert("checkOnlyEnglishNumber");
    var regExp = /^[A-Z|a-z|0-9]+$/;
    if(regExp.test(value) && value != "" && value != null){
		return true;
	} else {
		validationOutput(obj, message);
		return false;
	}
}


checkOnlyKoreanEnglishNumber = function(obj, value, message) {
	alert("checkOnlyKoreanEnglishNumber");
	var feedback = "Feedback";
	var objFeedback = obj[feedback];
	alert(objFeedback);
    var regExp = /^[ㄱ-ㅎ|가-힣|A-Z|a-z|0-9]+$/;
    if(regExp.test(value) && value != "" && value != null){
		// objFeedback.style.display = "none";
		obj.removeClass("is-invalid");
		return true;
	} else {
		validationOutput(obj, message);
		return false;
	}
}


checkOnlyEnglish = function(obj, value, message) {
	alert("checkOnlyKorean");
    var regExp = /^[A-Z|a-z]+$/;
    if(regExp.test(value) && value != "" && value != null){
		return true;
	} else {
		validationOutput(obj, message);
		return false;
	}
}


checkOnlyKorean = function(obj, value, message) {
	alert("checkOnlyKorean");
    var regExp = /^[ㄱ-ㅎ|가-힣]+$/;
    if(regExp.test(value) && value != "" && value != null){
		return true;
	} else {
		validationOutput(obj, message);
		return false;
	}
}


checkOnlyNumber = function(obj, value, message) {
	alert("checkOnlyKorean");
    var regExp = /^[0-9]+$/;
    if(regExp.test(value) && value != "" && value != null){
		return true;
	} else {
		validationOutput(obj, message);
		return false;
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

checkOnlyNumber = function(obj, value, message) {
    var regExp = /^[0-9]+$/;
    if(regExp.test(value)) {
		return true;
	} else {
		validationOutput(obj, message);
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

checkOnlyEnglish = function(value) {
    var regExp = /^[A-Za-z]+$/ 
    if(regExp.test(value)) return true;
    else return false;
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