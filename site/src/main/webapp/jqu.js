$(document).ready(function() {
		  $("#sub").click(function(){
$.ajax({
url : 'Students/newstudent?',
data : { firstname : $('#firstname').val(), secondname : $('#secondname').val() } ,
success : function() {
	$("#select").load("Students/select");
	alert('Добавлено');	
}
});
});
	  });