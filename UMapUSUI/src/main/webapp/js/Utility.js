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