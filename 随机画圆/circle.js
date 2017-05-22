//根据id获得对象
	function $(id){
		return document.getElementById(id);
	}
	//获得画板的高度
	function getCanvasWidth(){
		
		var widthStr=window.getComputedStyle($("canvas"),null).getPropertyValue("width");
		return parseInt(widthStr.substr(0,widthStr.length-2));
	}

	//获得画板的高度
	function getCanvasHeight(){
		var heightStr=window.getComputedStyle($("canvas"),null).getPropertyValue("height");
		return parseInt(heightStr.substr(0,heightStr.length-2)); //这个是小写的
	}

	function disc(canvas,number){
		//圆上的数字
		this.number=number;
		//圆的半径
		this.radius=21+Math.floor(Math.random()*40);
		//圆的坐标
		this.centerX=Math.floor(getCanvasWidth()*Math.random());
		this.centerY=Math.floor(getCanvasHeight()*Math.random());

		//背景色
		this.bgColor=["pink","blue","orange","yellow","red","green"][Math.floor(Math.random()*6)];

		this.draw=function(){
			var discObj =document.createElement("SPAN");

			discObj.innerHTML=this.number;
			discObj.style.display="inline-block";
			discObj.style.width=this.radius*2+"px";
			discObj.style.height=this.radius*2+"px";
			discObj.style.borderRadius=this.radius+"px";

			discObj.style.border="3px solid red";
			discObj.style.backgroundColor=this.bgColor;
			discObj.style.fontSize=20+"px";
			discObj.style.textAlign="center";
			discObj.style.lineHeight=this.radius*2+"px";
			discObj.style.position="absolute";
			discObj.style.left=this.centerX-this.radius+"px";
			discObj.style.top=this.centerY-this.radius+"px";
			discObj.onclick=function (argument) {
				this.parentNode.removeChild(this);
			}

			canvas.appendChild(discObj);
			console.log(this.toString());
		}	

		//判断是否合法
		this.isValid=function (argument) {
			
			if (this.centerX-this.radius<122) {
				return false;
			}
			if(this.centerY-this.radius<83){
				return false;
			}
			

			return true;
		}


		this.toString=function (argument) {
			return "数字:"+this.number+"disc info:["+this.centerX+","+this.centerY+",]"+"颜色："+this.bgColor;
		}

	}