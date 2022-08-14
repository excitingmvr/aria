document.write("<script src='/resources/common/js/constants.js'></script>");


$.datepicker.setDefaults({
	showMonthAfterYear: true,
    changeYear: true,
    changeMonth: true,
    dateFormat:'yy-mm-dd',
    closeText:'취소',
    currentText: '오늘',
    showButtonPanel: true,
    monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    dayNames: ['일', '월', '화', '수', '목', '금', '토'],
    dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
    dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
    onClose: function () {
        if ($(window.event.srcElement).hasClass('ui-datepicker-close')) {
            $(this).val('');
        }
    }

});


var extArrayImage = new Array();
extArrayImage = ["jpg","gif","png","jpeg","bmp","tif"];


var extArrayAll = new Array();
extArrayAll = ["txt","pdf","hwp","doc","docx","xls","xlsx","ppt","pptx"];




/*
$.datepicker.setDefaults({
    dateFormat: 'yy-mm-dd',
    prevText: '이전 달',
    nextText: '다음 달',
    monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    dayNames: ['일', '월', '화', '수', '목', '금', '토'],
    dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
    dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
    showMonthAfterYear: true,
    yearSuffix: '년'
});
*/    


 
 

