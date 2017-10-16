


//TODO still.... Utiliser au moins 3 ou 4 elements input de HTML5 (color, range, number par exemple) pour paramétrer votre jeu (vitesse, taille, nombre, couleur etc)


window.onload=init;
let canvas1, context, bonhomme1;
var color1_b1 ;
var color2_b1 ;
var color3_b1 ;

function debug(f){
	console.log("debug : "+f);
}
//inputs
function change_color1_b1(){
	color1_b1 = document.getElementById("color1_b1").value;
}
function change_color2_b1(){
	color2_b1 = document.getElementById("color2_b1").value;
}
function change_color3_b1_1(){
	color3_b1 = document.getElementById("color3_b1_1").value;
}
function change_color3_b1_2(){
	color3_b1 = document.getElementById("color3_b1_2").value;
}

function init(){
	debug("la page est chargee");
	//est-il possible d'utiliser le meme canvas pour un objet autre sans que l'anim du premier ne l'écrase  ? 
	canvas1 = document.querySelector("#canvas1");

	context = canvas1.getContext("2d");

	bonhomme1 = new Bonhomme(100,100,canvas1,context, 0.01, color1_b1, color2_b1, color3_b1);
	//bonhomme2 = new Bonhomme(100,100,canvas2,context2, 0.3, color1_b2, color2_b2, color3_b2);

	animeBonhomme1();

	debug("end init");
}


//comment ne pas faire de redondance ici ?
function animeBonhomme1(timeElapsed){
	 	bonhomme1.contexte.clearRect(0, 0, bonhomme1.canvas.width, bonhomme1.canvas.height);
	 	bonhomme1.drawBonhomme(color1_b1, color2_b1, color3_b1);
	 	 bonhomme1.Rangle += bonhomme1.value;
		 bonhomme1.Langle += bonhomme1.value;

		  if(bonhomme1.Rangle>Math.PI/4||bonhomme1.Rangle<-Math.PI/4) {//shorter angle... not 100% duplicated lol
		  	bonhomme1.value = -bonhomme1.value;
	 	 	bonhomme1.xSmile = -bonhomme1.xSmile;
	 	 }
	requestAnimationFrame(animeBonhomme1);
};
function accelerate_b1(){
	bonhomme1.accelerate();
}
function decelerate_b1(){
	bonhomme1.decelerate();
}

// Classes

// Avec ES5 / Javascript 5: on utilise des
// "fonction constructeur", plus puissant que les
// classes ES6 (pour faire des APIs)

// On nomme la fonction/classe avec une MAJUSCULE
// c'est une convention
class Bonhomme{ //en ES6
//function Bonhomme((x, y, canvas, contexte)){
   	
   	constructor(x, y, canvas, contexte, value, color1, color2, color3){
   		debug("Un bonhomme se cree");
	   	this.Langle=0, this.Rangle=0;
		this.xBonhomme=x;
		this.yBonhomme=y;
		this.xSmile= 25-x;
		this.value = value;
		this.canvas = canvas;
		this.contexte = contexte;
		debug("new bonhomme "+this+" colors : "+ color1+";"+color2+";"+color3+";");
		this.drawBonhomme(color1, color2, color3);
	}
	
	//point d'entree 
	drawBonhomme(color1, color2, color3){
		this.drawHead(color3);
		this.drawCasquette(color1);	
		this.drawPonpon(color2);
		this.drawLEye();
		this.drawREye();
		this.drawSmile();
		this.drawLowerBody(color1);
		this.drawBody(color2);
		this.drawRArm(color1,color2);
		this.drawLArm(color1,color2);
		this.drawLLeg(color1);
		this.drawRLeg(color1);

	}

	//for lisibility
	beforeFunc(){
		this.contexte.save();
	}
	
	afterFonc(){
		this.contexte.restore();
	}

	//time
	accelerate(){
		this.value+=0.1;
	}
	decelerate(){
		this.value-=0.1;
	}

   	//Head
	drawCasquette(color1){
		//la casquette
		this.beforeFunc();
		this.contexte.beginPath();
		this.contexte.fillStyle = color1;
		this.contexte.arc(this.xBonhomme, this.yBonhomme+2+this.value*5, 23, Math.PI, 2*Math.PI, false);
		this.contexte.fill();
		this.afterFonc();
		//la visiere
		this.beforeFunc();
		this.contexte.fillStyle = color1;
		this.contexte.fillRect(this.xBonhomme - 40, this.yBonhomme -4  +this.value*5, 40, 5);
		this.afterFonc();
		
	}
	drawPonpon(color2){
		//le ponpon
		this.beforeFunc();
		this.contexte.fillStyle = color2;
		this.contexte.fillRect(this.xBonhomme, this.yBonhomme -25  +this.value*5, 3, 5);
		this.afterFonc();
	}
	drawHead(color3){
		this.beforeFunc();
		this.contexte.fillStyle = color3;
		this.contexte.beginPath();
		this.contexte.arc(this.xBonhomme, this.yBonhomme+8, 20, 0, 2*Math.PI, false);
		this.contexte.fill();
		this.afterFonc();		
	}

	drawLEye(){
		this.beforeFunc();
		this.contexte.fillStyle = "white";
		this.contexte.beginPath();
		this.contexte.arc(this.xBonhomme - 10 +this.value*5, this.yBonhomme+7, 3, 0, 2*Math.PI, false);	
		//value changes sign
		this.contexte.fill();
		this.afterFonc();
	}
	drawREye(){
		this.beforeFunc();
		this.contexte.fillStyle = "white";
		this.contexte.beginPath();
		this.contexte.arc(this.xBonhomme  + 10 +this.value*5, this.yBonhomme+7, 3, 0, 2*Math.PI, false);	
		this.contexte.fill();
		this.afterFonc();
	}
	drawSmile(){
		this.beforeFunc();
		this.contexte.fillStyle = "white";
		this.contexte.beginPath();
		this.contexte.arc(this.xBonhomme , this.yBonhomme+15, 10-this.value*5, 0, Math.PI, false);	
		this.contexte.fill();
		this.afterFonc();
	}

	//Body
	drawLowerBody(color1){
		this.beforeFunc();
		this.contexte.fillStyle = color1;
		this.contexte.beginPath();
		this.contexte.arc(this.xBonhomme, this.yBonhomme+60, 30, 0, Math.PI, false);
		this.contexte.fill();
		this.afterFonc();
	}
	drawBody(color1){
		this.beforeFunc();
		this.contexte.fillStyle = color1;
		this.contexte.beginPath();
		this.contexte.arc(this.xBonhomme, this.yBonhomme+60, 30, Math.PI, 2*Math.PI, false);
		this.contexte.fill();
		this.afterFonc();
	}

	//Arms
	drawRArm(color1,color2){
		this.beforeFunc();
		this.contexte.fillStyle = (this.value>0)?color1:color2;
		this.contexte.translate(this.xBonhomme+15,this.yBonhomme+35);
		this.contexte.rotate(this.Rangle-Math.PI/6);
		this.contexte.fillRect(0,0,10,50);
		this.afterFonc();
	}
	drawLArm(color1,color2){
		this.beforeFunc();
		//on dessine en x,y, on veut un repere relatif
		this.contexte.translate(this.xBonhomme-15,this.yBonhomme+30);
		this.contexte.fillStyle = (this.value>0)?color1:color2;
		this.contexte.rotate(this.Rangle+Math.PI/6);
		this.contexte.fillRect(0,0,10,50);
		this.afterFonc();
	}

	//Legs
	drawLLeg(color1){
		this.beforeFunc();
		this.contexte.translate(this.xBonhomme-15,this.yBonhomme+80);
		this.contexte.fillStyle = color1;
		this.contexte.rotate(this.Langle);
		this.contexte.fillRect(0,0,10,50);
		this.afterFonc();
	}
	drawRLeg(color1){
		this.beforeFunc();
		this.contexte.translate(this.xBonhomme+12,this.yBonhomme+80);
		this.contexte.fillStyle = color1;
		this.contexte.rotate(this.Langle);
		this.contexte.fillRect(0,0,10,50);
		this.afterFonc();
	}
	

}
