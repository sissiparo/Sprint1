function userStory4() {
	body = document.getElementById("body4");
	var tbl;
	var tblBody;
	$
			.ajax({
				type : "GET",
				url : "http://localhost:8080/Database3/rest/basedata/userStory4/"
						+ document.getElementById('imsi4').value,
				dataType : 'json',
				headers : {
					Accept : "application/json",
					"Access-Control-Allow-Origin" : "*",
				},
				success : function(resp) {
					tbl = document.createElement("table");
					tblBody = document.createElement("tbody");
					$(tblBody)
							.append(
							'<tr class="child"><td>imsi</td><td>Event ID</td><td>Cause Code</td></tr>');
					for (var i = 0; i < resp.length; i++) {
						$(tblBody).append(
								'<tr class="child"><td>' + resp[i][0]
										+ '</td><td>' + resp[i][1]
										+ '</td><td>' + resp[i][2]
										+ '</td></tr>');
					}
					$(tbl).append(tblBody);
					$("#results4").append(tbl);
					tbl.setAttribute("align", "center");
					tbl.setAttribute("id", "table4");
					tbl.setAttribute("class", "table");
					$('#imsi4').val('');
					alert("story 4");
				},
				error : function(e) {
					alert("Invalid or insufficient data - " + e);
				}
			});
	return false;
};

function userStory5() {
	body = document.getElementById("body5");
	var tbl;
	var tblBody;
	$
			.ajax({
				type : "GET",
				url : "http://localhost:8080/Database3/rest/basedata/userStory5/"
						+ document.getElementById('imsi5').value + "/" +
						document.getElementById('startDate5').value + "/" +
						document.getElementById('endDate5').value,
				dataType : 'json',
				headers : {
					Accept : "application/json",
					"Access-Control-Allow-Origin" : "*",
				},
				success : function(resp) {
					alert(resp);
					tbl = document.createElement("table");
					tblBody = document.createElement("tbody");
					$(tblBody)
							.append(
							'<tr class="child"><td>count</td></tr>');
					for (var i = 0; i < resp.length; i++) {
						$(tblBody).append(
								'<tr class="child"><td>' + resp[i][0]
										+ '</td></tr>');
					}
					$(tbl).append(tblBody);
					$("#results5").append(tbl);
					tbl.setAttribute("align", "center");
					tbl.setAttribute("id", "table5");
					tbl.setAttribute("class", "table");
					$('#imsi5').val('');
					alert("story 5");
				},
				error : function(e) {
					alert("Invalid or insufficient data - " + e);
				}
			});
	return false;
};

function userStory6() {
	body = document.getElementById("body6");
	var tbl;
	var tblBody;
	$
			.ajax({
				type : "GET",
				url : "http://localhost:8080/Database3/rest/basedata/userStory6/"
						+ document.getElementById('imsi6').value,
				dataType : 'json',
				headers : {
					Accept : "application/json",
					"Access-Control-Allow-Origin" : "*",
				},
				success : function(resp) {
					tbl = document.createElement("table");
					tblBody = document.createElement("tbody");
					$(tblBody)
							.append(
							'<tr class="child"><td>imsi</td><td>Event ID</td><td>Event Cause Code</td><td>Cause Code</td><td>Cause Description</td></tr>');
					for (var i = 0; i < resp.length; i++) {
						$(tblBody).append(
								'<tr class="child"><td>' + resp[i][0]
								+ '</td><td>' + resp[i][1]
								+ '</td><td>' + resp[i][2]
								+ '</td><td>' + resp[i][3]
								+ '</td><td>' + resp[i][4]
								+ '</td></tr>');
					}
					$(tbl).append(tblBody);
					$("#results6").append(tbl);
					tbl.setAttribute("align", "center");
					tbl.setAttribute("id", "table6");
					tbl.setAttribute("class", "table");
					$('#imsi6').val('');
					alert("story 6");
				},
				error : function(e) {
					alert("Invalid or insufficient data - " + e);
				}
			});
	return false;
};

function ericsson() {
	document.getElementById('bdy').src = 'http://www.ericsson.com/';
}

function queries() {
	document.getElementById('bdy').src = 'queries.jsp';
}

function combo() {
	document.getElementById('bdy').src = 'UserStory4.html';
}
