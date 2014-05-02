var UMapUS = UMapUS || {};

function guid() {
	function _p8(s) {
		var p = (Math.random().toString(16) + "000000000").substr(2, 8);
		return s ? "-" + p.substr(0, 4) + "-" + p.substr(4, 4) : p;
	}

	return _p8() + _p8(true) + _p8(true) + _p8();
}


function enableDatePicker(btnpickerid,inputboxid)
{
	$(btnpickerid)
	.datepicker(
			{
				format : 'mm/dd/yyyy',
				onRender : function(date) {
					return date.valueOf() > new Date()
							.valueOf() ? 'disabled' : '';
				}
			}).on(
			'changeDate',
			function(event) {
				$(inputboxid).val(
						$(btnpickerid).data('date'));
			});	

}

UMapUS.RefData = function()
{
	var self = this;
	
	self.getListofFamilyNames = function(event)
    {
    	var url = "/UMapUSUI/listoffamilies";
    	var formdata = null;
    	$.ajax({
			type : "GET",
			url : url,
			contentType : "application/json",
			data : JSON.stringify(formdata),
			success : function(data, textStatus, jqXHR) {
				var optionstring = "";
				for(var i=0;i<data.length;i++)
					{
					    if(data[i].aliasName == null)
					           optionstring=optionstring+'<option>'+data[i].familyName+'</option>';
					    else
					    	   optionstring=optionstring+'<option data-subtext="'+data[i].aliasName+ '">'+data[i].familyName+'</option>';
					}
				    $('.selectpicker').append(optionstring);
				    $('.selectpicker').selectpicker('refresh');
			},
			error : function(data) {
				alert("getList" + data);
			}
		});
    };
};

UMapUS.refdata = new UMapUS.RefData();