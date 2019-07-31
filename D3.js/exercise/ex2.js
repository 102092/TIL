window.addEventListener("load", function() {
	
	var dataSet = [];
	var num = 10;
	for (i =0; i < num; i++){
		dataSet[i] = Math.floor(Math.random() * 100) + 1;
		 
	}
	var svgWidth = 320;
	var svgHeight = 240;
	var margin = svgWidth/(dataSet.length - 1); // 꺽은 선 그래프 간격 계산
	var offsetX = 30;	// X 좌표의 오프셋(어긋남의 정도)
	var offsetY = 20;	// Y 좌표의 오프셋(어긋남의 정도)
	var scale = 2.0;
	
	
	var line = d3.line()
	.x(function(d,i){
		return (i * margin)+offsetX;
	})
	.y(function(d,i){
		return svgHeight - (d*scale) - offsetY;
	})
	
var lineElements = d3.select("#myGraph")
	.append("path") // 데이터 수만큼 path요소를 추가하고
	.attr("class","line")
	.attr("d",line(dataSet))
	
var yScale = d3.scaleLinear()  
 	.domain([0, 100])   
 	.range([scale*100, 0]) 

 var axis = d3.axisLeft(yScale)


d3.select("#myGraph").append("g")
	.attr("class", "axis")
	.attr("transform", "translate("+offsetX+", "+offsetY+")")
	.call(axis)
	
	
// 가로 방향의 선을 표시
d3.select("#myGraph")
	.append("rect")
	.attr("class", "axis_x")
	.attr("width", svgWidth)
	.attr("height", 1)
	.attr("transform", "translate("+offsetX+", "+(svgHeight-offsetY-0.5)+")")

	  
});