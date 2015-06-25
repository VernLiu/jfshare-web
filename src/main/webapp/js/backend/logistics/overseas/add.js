$(function() {
	$("#statusConfirm").click(function() {
		var time = $("#statusForm input[name='time']");
		var status = $("#statusForm textarea[name='status']");
		if(time.val() != "" && status.val() != "") {
			var detail = $("#detail tbody");
			var context = "<tr><td>" + time.val() + "</td><td>" + status.val()  +"</td></tr>";
			detail.append(context);
		}
	});
	$("#editForm").submit(function() {
		var data = [];
		var trs = $("#detail tr");
		for(i in trs) {
			var tds = $(trs[i]).children();
			for(d in tds) {
				var td = tds[d];
				alert(td);
			}
		}
		$("#editForm input[name='detail']").val(data);
	});
});