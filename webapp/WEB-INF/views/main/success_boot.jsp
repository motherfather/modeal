<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>메인 페이지</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.9.0.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript" src="plugins/jqplot.pieRenderer.min.js"></script>
<script>
	// 각 통계 배열 저장 
	// 성별
		var genderlist = new Array();
		<c:forEach items="${genderlist }" var="vo">
			genderlist.push("${vo.gender }");
		</c:forEach>
		var genderlistcnt = new Array();
		<c:forEach items="${genderlist }" var="vo">
			genderlistcnt.push("${vo.count }");
		</c:forEach>
		
		var locationlist = new Array();
		<c:forEach items="${locationlist }" var="vo">
		locationlist.push("${vo.location }");
		</c:forEach>
		var locationlistcnt = new Array();
		<c:forEach items="${locationlist }" var="vo">
		locationlistcnt.push("${vo.count }");
		</c:forEach>
		
		//나이별
		var agelist = new Array();
		<c:forEach items="${agelist }" var="vo">
			agelist.push("${vo.age }");
		</c:forEach>
		
		var agelistcnt = new Array();
		<c:forEach items="${agelist }" var="vo">
			agelistcnt.push("${vo.count }");
		</c:forEach>
		
		google.load("visualization", "1", {
			packages : [ "corechart" ]
		});
		google.setOnLoadCallback(drawChart);
		
		function drawChart() {
			var data = google.visualization.arrayToDataTable([]);
			data.addColumn('string', 'Gender');
			data.addColumn('number', 'count');
			
			var data2 = google.visualization.arrayToDataTable([]);
			data2.addColumn('string', 'Age');
			data2.addColumn('number', 'count');
			
			var data3 = google.visualization.arrayToDataTable([]);
			data3.addColumn('string', 'Location');
			data3.addColumn('number', 'count');
			
			if (true) {
				data.addRows((genderlistcnt.length));
				data2.addRows((agelist.length));
				data3.addRows((locationlistcnt.length));
				for (i = 0; i < genderlistcnt.length; i++) {
					for (j = 0; j <= 1; j++) {
						if (j == 0) {
							data.setCell(i, 0, genderlist[i]);
						} else {
							data.setCell(i, 1, parseInt(genderlistcnt[i]));
						}
					}
				}
				
				for (i = 0; i < agelistcnt.length; i++) {
					for (j = 0; j <= 1; j++) {
						if (j == 0) {
							data2.setCell(i, 0, agelist[i]);
						} else {
							data2.setCell(i, 1, parseInt(agelistcnt[i]));
						}
					}
				}
				for (i = 0; i < locationlistcnt.length; i++) {
					for (j = 0; j <= 1; j++) {
						if (j == 0) {
							data3.setCell(i, 0, locationlist[i]);
						} else {
							data3.setCell(i, 1, parseInt(locationlistcnt[i]));
						}
					}
				}
			}
			
			var options = {
				title : ''
			};
			
			new google.visualization.PieChart(document.getElementById('my_chart1')).draw(data3, options);
			new google.visualization.BarChart(document.getElementById('my_chart2')).draw(data, options);
			new google.visualization.LineChart(document.getElementById('my_chart3')).draw(data2, options);
	}

	$(function() {
		drawChart();
		drawChart2();
	});
</script>
</head>
<body>
	<div id="wrapper">
		<div id="navigation">
			<c:import url="/WEB-INF/views/includes/newnavigation.jsp" />
		</div>
		<div id="page-wrapper">
			<!-- /.row -->
			<div class="row">
				<br>
				<!-- /.row -->
				<h2 style="margin-left: 150px">남녀 통계</h2>
				<div id="my_chart2" style="width: 500px; height: 300px"></div>
				<h2 style="margin-left: 150px">지역별 통계</h2>
				<div id="my_chart1" style="width: 500px; height: 300px"></div>
				<h2 style="margin-left: 150px">연령별 통계</h2>
				<div id="my_chart3" style="width: 500px; height: 300px"></div>
			</div>
		</div>
	</div>
</body>

</html>
