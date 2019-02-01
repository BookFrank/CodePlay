var fontSize = 10; 
var symbolSize = 40; 
var padding = 10; 

/*
 * new Topology(svg, option).render;
 */
class GatewayTopology {

/**/

constructor(svg, option) {

this.data = option.data; 

this.edges = option.edges; 

this.svg = d3.select(svg); 


}



//主渲染方法

render() {

this.scale = 1; 

this.width = this.svg.attr('width'); 

this.height = this.svg.attr('height'); 

this.container = this.svg.append('g')

.attr('transform', 'scale(' + this.scale + ')'); 





this.initPosition(); 

this.initDefineSymbol(); 

this.initLink(); 

this.initNode(); 

this.initZoom(); 



}



//初始化节点位置

initPosition() {

let origin = [this.width / 2, this.height / 2]; 

let points = this.getVertices(origin, Math.min(this.width, this.height) * 0.3, this.data.length); 

this.data.forEach((item, i) =>  {

item.x = points[i].x; 

item.y = points[i].y; 

})

}



//根据多边形获取定位点

getVertices(origin, r, n) {

if (typeof n !== 'number')return; 

var ox = origin[0]; 

var oy = origin[1]; 

var angle = 360 / n; 

var i = 0; 

var points = []; 

var tempAngle = 0; 

while (i < n) {

tempAngle = (i * angle * Math.PI)/180; 

points.push( {

x:ox + r * Math.sin(tempAngle), 

y:oy + r * Math.cos(tempAngle), 

}); 

i +  + ; 

}

return points; 

}



//两点的中心点

getCenter(x1, y1, x2, y2) {

return [(x1 + x2)/2, (y1 + y2)/2]

  }



//两点的距离

getDistance(x1, y1, x2, y2) {

return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)); 

}



//两点角度

getAngle(x1, y1, x2, y2) {

var x = Math.abs(x1 - x2); 

var y = Math.abs(y1 - y2); 

var z = Math.sqrt(x * x + y * y); 

return Math.round((Math.asin(y / z)/Math.PI * 180)); 

}





//初始化缩放器

initZoom() {

let self = this; 

let zoom = d3.zoom()

.scaleExtent([0.7, 3])

.on('zoom', function () {

self.onZoom(this)

}); 

this.svg.call(zoom)

}



//初始化图标

initDefineSymbol() {

let defs = this.container.append('svg:defs'); 



//箭头

const marker = defs

    .selectAll('marker')

.data(this.edges)

.enter()

.append('svg:marker')

.attr('id', (link, i) => 'marker-' + i)

.attr('markerUnits', 'userSpaceOnUse')

.attr('viewBox', '0 -5 10 10')

.attr('refX', symbolSize / 2 + padding)

.attr('refY', 0)

.attr('markerWidth', 14)

.attr('markerHeight', 14)

.attr('orient', 'auto')

.attr('stroke-width', 2)

.append('svg:path')

.attr('d', 'M2,0 L0,-3 L9,0 L0,3 M2,0 L0,-3')

.attr('class', 'arrow')





//数据库

let database = defs.append('g')

.attr('id', 'database')

.attr('transform', 'scale(0.042)'); 



database.append('path')

.attr('d', 'M512 800c-247.42 0-448-71.63-448-160v160c0 88.37 200.58 160 448 160s448-71.63 448-160V640c0 88.37-200.58 160-448 160z')



database.append('path')

.attr('d', 'M512 608c-247.42 0-448-71.63-448-160v160c0 88.37 200.58 160 448 160s448-71.63 448-160V448c0 88.37-200.58 160-448 160z'); 



database.append('path')

.attr('d', 'M512 416c-247.42 0-448-71.63-448-160v160c0 88.37 200.58 160 448 160s448-71.63 448-160V256c0 88.37-200.58 160-448 160z'); 



database.append('path')

.attr('d', 'M64 224a448 160 0 1 0 896 0 448 160 0 1 0-896 0Z'); 



//云

let cloud = defs.append('g')

.attr('id', 'cloud')

.attr('transform', 'scale(0.042)')

.append('path')

.attr('d', 'M709.3 285.8C668.3 202.7 583 145.4 484 145.4c-132.6 0-241 102.8-250.4 233-97.5 27.8-168.5 113-168.5 213.8 0 118.9 98.8 216.6 223.4 223.4h418.9c138.7 0 251.3-118.8 251.3-265.3 0-141.2-110.3-256.2-249.4-264.5z')







}



//初始化链接线

initLink() {

this.drawLinkLine(); 

this.drawLinkText(); 

}



//初始化节点

initNode() {

var self = this; 

//节点容器

this.nodes = this.container.selectAll(".node")

.data(this.data)

.enter()

.append("g")

.attr("transform", function (d) {

return "translate(" + d.x + "," + d.y + ")"; 

})

.call(d3.drag()

.on("drag", function (d) {

self.onDrag(this, d)

}))

.on('click', function () {

alert()

})



//节点背景默认覆盖层

this.nodes.append('circle')

.attr('r', symbolSize / 2 + padding)

.attr('class', 'node-bg'); 



//节点图标

this.drawNodeSymbol(); 

//节点标题

this.drawNodeTitle(); 

//节点其他说明

this.drawNodeOther(); 

this.drawNodeCode(); 



}



//画节点语言标识

drawNodeCode() {

this.nodeCodes = this.nodes.filter(item => item.type == 'app')

.append('g')

.attr('class', 'node-code')

.attr('transform', 'translate(' +  - symbolSize / 2 + ',' + symbolSize / 3 + ')')



this.nodeCodes

    .append('circle')

.attr('r', d => fontSize / 2 * d.code.length / 2 + 3)



this.nodeCodes

    .append('text')

.attr('dy', fontSize / 2)

.text(item => item.code); 



}



//画节点图标

drawNodeSymbol() {

//绘制节点

this.nodes.filter(item => item.type == 'app')

.append("circle")

.attr("r", symbolSize / 2)

.attr("fill", '#fff')

.attr('class', function (d) {

return 'health' + d.health; 

})

.attr('stroke-width', '5px')





this.nodes.filter(item => item.type == 'database')

.append('use')

.attr('xlink:href', '#database')

.attr('x', function () {

return - this.getBBox().width/2

    })

.attr('y', function () {

return - this.getBBox().height/2

    })



this.nodes.filter(item => item.type == 'cloud')

.append('use')

.attr('xlink:href', '#cloud')

.attr('x', function () {

return - this.getBBox().width/2

    })

.attr('y', function () {

return - this.getBBox().height/2

    })

}



//画节点右侧信息

drawNodeOther() {

//如果是应用的时候

this.nodeOthers = this.nodes.filter(item => item.type == 'app')

.append("text")

.attr("x", symbolSize / 2 + padding)

.attr("y", -5)

.attr('class', 'node-other')



this.nodeOthers.append('tspan')

.text(d => d.time + 'ms'); 



this.nodeOthers.append('tspan')

.text(d => d.rpm + 'rpm')

.attr('x', symbolSize / 2 + padding)

.attr('dy', '1em'); 



this.nodeOthers.append('tspan')

.text(d => d.epm + 'epm')

.attr('x', symbolSize / 2 + padding)

.attr('dy', '1em')

}



//画节点标题

drawNodeTitle() {

//节点标题

this.nodes.append("text")

.attr('class', 'node-title')

.text(function (d) {

return d.name; 

})

.attr("dy", symbolSize)



this.nodes.filter(item => item.type == 'app').append("text")

.text(function (d) {

return d.active + '/' + d.total; 

})

.attr('dy', fontSize / 2)

.attr('class', 'node-call')



}



//画节点链接线

drawLinkLine() {

let data = this.data; 

if (this.lineGroup) {

this.lineGroup.selectAll('.link')

.attr(

'd', link => genLinkPath(link), )

}else {

this.lineGroup = this.container.append('g')





this.lineGroup.selectAll('.link')

.data(this.edges)

.enter()

.append('path')

.attr('class', 'link')

.attr(

'marker-end', (link, i) => 'url(#' + 'marker-' + i + ')').attr(

'd', link => genLinkPath(link), ).attr(

'id', (link, i) => 'link-' + i)

.on('click', () =>  {alert()})

}



function genLinkPath(d) {

let sx = data[d.source].x; 

let tx = data[d.target].x; 

let sy = data[d.source].y; 

let ty = data[d.target].y; 

return 'M' + sx + ',' + sy + ' L' + tx + ',' + ty; 

}

}





drawLinkText() {

let data = this.data; 

let self = this; 

if (this.lineTextGroup) {

this.lineTexts

      .attr('transform', getTransform)



}else {

this.lineTextGroup = this.container.append('g')



this.lineTexts = this.lineTextGroup

      .selectAll('.linetext')

.data(this.edges)

.enter()

.append('text')

.attr('dy', -2)

.attr('transform', getTransform)

.on('click', () =>  {alert()})



this.lineTexts

      .append('tspan')

.text((d, i) => this.data[d.source].lineTime + 'ms,' + this.data[d.source].lineRpm + 'rpm'); 



this.lineTexts

      .append('tspan')

.text((d, i) => this.data[d.source].lineProtocol)

.attr('dy', '1em')

.attr('dx', function () {

return - this.getBBox().width / 2

      })

}



function getTransform(link) {

let s = data[link.source]; 

let t = data[link.target]; 

let p = self.getCenter(s.x, s.y, t.x, t.y); 

let angle = self.getAngle(s.x, s.y, t.x, t.y); 

if (s.x > t.x && s.y < t.y || s.x < t.x && s.y > t.y) {

angle =  - angle

      }

return 'translate(' + p[0] + ',' + p[1] + ') rotate(' + angle + ')'

}

}





update(d) {

this.drawLinkLine(); 

this.drawLinkText(); 

}



//拖拽方法

onDrag(ele, d) {

d.x = d3.event.x; 

d.y = d3.event.y; 

d3.select(ele)

.attr('transform', "translate(" + d3.event.x + "," + d3.event.y + ")")

this.update(d); 

}



//缩放方法

onZoom(ele) {

var transform = d3.zoomTransform(ele); 

this.scale = transform.k; 

this.container.attr('transform', "translate(" + transform.x + "," + transform.y + ")scale(" + transform.k + ")")

}

}