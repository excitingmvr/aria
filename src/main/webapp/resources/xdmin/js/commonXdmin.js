document.write("<script src='/resources/common/js/common.js'></script>");
document.write("<script src='/resources/xdmin/js/constantsXdmin.js'></script>");
document.write("<script src='/resources/xdmin/js/validationXdmin.js'></script>");


divSearchControl = function() {
    var screenWidth = $(window).width();
    if (screenWidth < BOOTSTRAP5_SM_DIMENSIONS) {
        $('#divSearch').hide();
        $('#iSearchControlUp').hide();
        $('#iSearchControlDown').show();
    } else {
        // by pass
    }
}
 
 
$('#divSearchControl').on('click', function() {
    if ($('#divSearch').is(':visible')) {
         $('#divSearch').hide();
         $('#iSearchControlUp').hide();
         $('#iSearchControlDown').show();
    } else {
         $('#divSearch').show();
         $('#iSearchControlUp').show();
         $('#iSearchControlDown').hide();
    }
 });


checkUploadedTotalFileNumber = function(obj, allowedMaxTotalFileNumber, fileCount) {
	if(allowedMaxTotalFileNumber < fileCount){
		alert("전체 파일 갯수는 "+ allowedMaxTotalFileNumber +"개 까지 허용됩니다.");
//		$("#file"+seq).val("");
//		obj.val("");
		return false;
	}
}


checkUploadedExt = function(objName, seq, div) {
	var ext = objName.split('.').pop().toLowerCase();
	var extArray = eval("extArray" + div);
	
	if(extArray.indexOf(ext) == -1) {
		alert("허용된 확장자가 아닙니다.");
//		$("#file"+seq).val("");
		return false;
	}
}


checkUploadedEachFileSize = function(obj, seq, allowedEachFileSize) {

	if(obj.size > allowedEachFileSize){
		alert("각 첨부 파일 사이즈는 "+kbToMb(allowedEachFileSize)+"MB 이내로 등록 가능합니다.");
		$("#file"+seq).val("");
		return false;
	}
}


checkUploadedTotalFileSize = function(seq, totalSize, allowedTotalFileSize) {
	if(totalSize > allowedTotalFileSize){
		alert("전체 용량은 "+kbToMb(allowedTotalFileSize)+"M를 넘을 수 없습니다.");
		$("#file"+seq).val("");
		return false;
	}
}





