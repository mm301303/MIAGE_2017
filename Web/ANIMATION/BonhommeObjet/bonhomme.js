


//TODO still.... Utiliser au moins 3 ou 4 elements input de HTML5 (color, range, number par exemple) pour paramétrer votre jeu (vitesse, taille, nombre, couleur etc)


window.onload=init;
let canvas1, context, bonhomme1, bonhomme2;

function debug(f){
	console.log("debug : "+f);
}

function init(){
	debug("la page est chargee");
	//est-il possible d'utiliser le meme canvas pour un objet autre sans que l'anim du premier ne l'écrase  ? 
	canvas1 = document.querySelector("#canvas1");
	canvas2 = document.querySelector("#canvas2");

	context = canvas1.getContext("2d");
	context2 = canvas2.getContext("2d");

	bonhomme1 = new Bonhomme(100,100,canvas1,context, 0.01);
	bonhomme2 = new Bonhomme(100,100,canvas2,context2, 0.3);

	animeBonhomme1();
	animeBonhomme2();

	debug("end init");


}

//comment ne pas faire de redondance ici ?
function animeBonhomme1(timeElapsed){
		debug("animeBonhomme");
	 	bonhomme1.contexte.clearRect(0, 0, bonhomme1.canvas.width, bonhomme1.canvas.height);
	 	bonhomme1.drawBonhomme();
	 	 bonhomme1.Rangle += bonhomme1.value;
		 bonhomme1.Langle += bonhomme1.value;

		  if(bonhomme1.Rangle>Math.PI/4||bonhomme1.Rangle<-Math.PI/4) {//shorter angle... not 100% duplicated lol
		  	bonhomme1.value = -bonhomme1.value;
	 	 	bonhomme1.xSmile = -bonhomme1.xSmile;
	 	 }
	requestAnimationFrame(animeBonhomme1);
};
function animeBonhomme2(timeElapsed){
		debug("animeBonhomme2");
	 	bonhomme2.contexte.clearRect(0, 0, bonhomme2.canvas.width, bonhomme2.canvas.height);
	 	bonhomme2.drawBonhomme();
	 	 bonhomme2.Rangle += bonhomme2.value;
		 bonhomme2.Langle += bonhomme2.value;

		  if(bonhomme2.Rangle>Math.PI/3||bonhomme2.Rangle<-Math.PI/3) {
		  	bonhomme2.value = -bonhomme2.value;
	 	 	bonhomme2.xSmile = -bonhomme2.xSmile;
	 	 }
	requestAnimationFrame(animeBonhomme2);
};

// Classes

// Avec ES5 / Javascript 5: on utilise des
// "fonction constructeur", plus puissant que les
// classes ES6 (pour faire des APIs)

// On nomme la fonction/classe avec une MAJUSCULE
// c'est une convention
class Bonhomme{ //en ES6
//function Bonhomme((x, y, canvas, contexte)){
   	
   	constructor(x, y, canvas, contexte, value){
   		debug("Un bonhomme se cree");
	   	this.Langle=0, this.Rangle=0;
		this.xBonhomme=x;
		this.yBonhomme=y;
		this.xSmile= 25-x;
		this.value = value;
		this.canvas = canvas;
		this.contexte = contexte;
		debug("is there anybody in there ?");
		this.drawBonhomme();
		debug("Just nod if you can hear me");
	}
	
	//for lisibility
	beforeFunc(){
		this.contexte.save();
	}
	
	afterFonc(){
		this.contexte.restore();
	}

   	//Head
	drawCasquette(){
		//la casquette
		debug("drawCasquette");
		this.beforeFunc();
		this.contexte.beginPath();
		this.contexte.fillStyle = "blue";
		this.contexte.arc(this.xBonhomme, this.yBonhomme+2+this.value*5, 23, Math.PI, 2*Math.PI, false);
		this.contexte.fill();
		this.afterFonc();
		//la visiere
		this.beforeFunc();
		this.contexte.fillStyle = "blue";
		this.contexte.fillRect(this.xBonhomme - 40, this.yBonhomme -4  +this.value*5, 40, 5);
		this.afterFonc();
		
	}
	drawPonpon(){
		//le ponpon
		this.beforeFunc();
		this.contexte.fillStyle = "red";
		this.contexte.fillRect(this.xBonhomme, this.yBonhomme -25  +this.value*5, 3, 5);
		this.afterFonc();
	}
	drawHead(){
		this.beforeFunc();
		this.contexte.fillStyle = "purple";
		this.contexte.beginPath();
		this.contexte.arc(this.xBonhomme, this.yBonhomme+8, 20, 0, 2*Math.PI, false);
		this.contexte.fill();
		this.afterFonc();		
	}

	drawLEye(){
		this.beforeFunc();
		this.contexte.fillStyle = (this.value>0)?"white":"red";
		this.contexte.beginPath();
		this.contexte.arc(this.xBonhomme - 10 +this.value*5, this.yBonhomme+7, 3, 0, 2*Math.PI, false);	
		//value changes sign
		this.contexte.fill();
		this.afterFonc();
	}
	drawREye(){
		this.beforeFunc();
		this.contexte.fillStyle = (this.value>0)?"white":"red";
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
	drawLowerBody(){
		this.beforeFunc();
		this.contexte.fillStyle = "blue";
		this.contexte.beginPath();
		this.contexte.arc(this.xBonhomme, this.yBonhomme+60, 30, 0, Math.PI, false);
		this.contexte.fill();
		this.afterFonc();
	}
	drawBody(){
		this.beforeFunc();
		this.contexte.fillStyle = (this.value>0)?"orange":"lightgreen";
		this.contexte.beginPath();
		this.contexte.arc(this.xBonhomme, this.yBonhomme+60, 30, Math.PI, 2*Math.PI, false);
		this.contexte.fill();
		this.afterFonc();
	}

	//Arms
	drawRArm(){
		this.beforeFunc();
		this.contexte.fillStyle = (this.value>0)?"orange":"lightgreen";;
		this.contexte.translate(this.xBonhomme+15,this.yBonhomme+35);
		this.contexte.rotate(this.Rangle-Math.PI/6);
		this.contexte.fillRect(0,0,10,50);
		this.afterFonc();
	}
	drawLArm(){
		debug("drawLArm");
		this.beforeFunc();
		//on dessine en x,y, on veut un repere relatif
		this.contexte.translate(this.xBonhomme-15,this.yBonhomme+30);
		this.contexte.fillStyle = (this.value>0)?"orange":"lightgreen";;
		this.contexte.rotate(this.Rangle+Math.PI/6);
		this.contexte.fillRect(0,0,10,50);
		this.afterFonc();
	}

	//Legs
	drawLLeg(){
		this.beforeFunc();
		this.contexte.translate(this.xBonhomme-15,this.yBonhomme+80);
		this.contexte.fillStyle = "blue";
		this.contexte.rotate(this.Langle);
		this.contexte.fillRect(0,0,10,50);
		this.afterFonc();
	}
	drawRLeg(){
		this.beforeFunc();
		this.contexte.translate(this.xBonhomme+12,this.yBonhomme+80);
		this.contexte.fillStyle = "blue";
		this.contexte.rotate(this.Langle);
		this.contexte.fillRect(0,0,10,50);
		this.afterFonc();
	}

	//point d'entree 
	drawBonhomme(){
		debug("drawBonhomme");
		this.drawHead();
		this.drawCasquette(); 
		this.drawLArm();
		this.drawRArm();
		this.drawBody();	
		this.drawLowerBody();	

		this.drawLLeg();
		this.drawRLeg();
		this.drawLEye();
		this.drawREye();
		this.drawSmile();
		this.drawPonpon();
	}

}
