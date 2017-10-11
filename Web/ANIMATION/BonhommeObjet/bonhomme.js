
//Un fonction appelée quand la page est chargée
//declarations:
window.onload=init;
let canvas1, context, bonhomme;

function debug(f){
	console.log("debug : "+f);
}

function init(){
	console.log("la page est chargee");
	//on ne peut récupérer le dom que s'il est "ready"
	canvas1 = document.querySelector("#canvas1");
	//on recupere le contexte graphique$
	//il a des methodes pour dessiner
	//voir cours
	context = canvas1.getContext("2d");
	bonhomme = new Bonhomme(50,50,canvas1,context);

	animeBonhomme(bonhomme);
	console.log("end init");


}

function animeBonhomme(timmeElapsed){
		debug("animeBonhomme");
	  	// 1 - on efface le canvas

	  	console.log('merde', bonhomme);
	 	
	 	bonhomme.contexte.clearRect(0, 0, bonhomme.canvas.width, bonhomme.canvas.height);
	  
	  	// 2 - on dessine dans le canvas
	 	 bonhomme.drawBonhomme();
	  
	 	 // 3 - on met à jour les objets à dessiner
	 	 bonhomme.Rangle += bonhomme.value;
		 bonhomme.Langle += bonhomme.value;

		  if(bonhomme.Rangle>Math.PI/4||bonhomme.Rangle<-Math.PI/4) {
		  	bonhomme.value = -bonhomme.value;
	 	 	bonhomme.xSmile = -bonhomme.xSmile;
	 	 }
	requestAnimationFrame(animeBonhomme);
};

class Bonhomme{

   	constructor(x, y, canvas, contexte){
   		debug("Un bonhomme se cree");
	   	this.Langle=0, this.Rangle=0;
		this.xBonhomme=x;
		this.yBonhomme=y;
		this.xSmile= 25-x;
		this.value = 0.2;
		this.canvas = canvas;
		this.contexte = contexte;
		debug("is there anybody in there ?");
		this.drawBonhomme();
		debug("Just nod if you can hear me");
	};

	beforeFunc(){
		this.contexte.save();
		this.contexte.translate(this.xBonhomme,this.yBonhomme);
	};
	
	afterFonc(){
		this.contexte.restore();
	};

    drawHead(){
		this.beforeFunc();
		this.contexte.fillStyle = "red";
		this.contexte.beginPath();
		this.contexte.arc(this.yBonhomme, this.yBonhomme+10, 20, 0, 2*Math.PI, false);
		this.contexte.fill();
		this.afterFonc();
		
	};

	drawLEye(){
		this.beforeFunc();
		this.contexte.fillStyle = "white";
		this.contexte.beginPath();
		this.contexte.arc(-8+(this.xSmile/2), 0, 5+(this.xSmile/2), 0, 2*Math.PI, false);	
		this.contexte.fill();
		this.afterFonc();
	};

	drawREye(){
		this.beforeFunc();
		this.contexte.beginPath();
		this.contexte.arc(8+(this.xSmile/2), 0, 4+(this.xSmile/2), 0, 2*Math.PI, false);	
		this.contexte.fill();
		this.afterFonc();
	};

	drawSmile(){
		this.beforeFunc();
		this.contexte.fillStyle = "white";
		this.contexte.fillRect(-7,0,15,6+this.xSmile);
		this.contexte.fill();
		this.afterFonc();
	};

	drawBody(){
		this.beforeFunc();
		this.contexte.fillStyle = "white";
		this.contexte.beginPath();
		this.contexte.arc(this.xBonhomme, this.yBonhomme+60, 30, 0, 2*Math.PI, false);
		this.contexte.lineTo(0, 50);
		this.contexte.fill();
		this.afterFonc();
	};
	drawRArm(){
		this.beforeFunc();
		this.contexte.fillStyle = "orange";
		this.contexte.translate(this.xBonhomme+15,this.yBonhomme+35);
		this.contexte.rotate(this.Rangle-Math.PI/6);
		this.contexte.fillRect(0,0,10,50);
		this.afterFonc();
	};

	drawLArm(){
		debug("drawLArm");
		this.beforeFunc();
		//on dessine en x,y, on veut un repere relatif
		this.contexte.fillStyle = "orange";
		this.contexte.translate(this.xBonhomme-15,this.yBonhomme+30);
		this.contexte.rotate(this.Rangle+Math.PI/6);
		this.contexte.fillRect(0,0,10,50);
		this.afterFonc();
	};


	drawLLeg(){
		this.beforeFunc();
		this.contexte.translate(this.xBonhomme-15,this.yBonhomme+80);
		this.contexte.fillStyle = "green";
		this.contexte.rotate(this.Langle);
		this.contexte.fillRect(0,0,10,50);
		this.afterFonc();
	};

	drawRLeg(){
		this.beforeFunc();
		this.contexte.fillStyle = "white";
		this.contexte.fillStyle = "green";
		this.contexte.translate(this.xBonhomme+12,this.yBonhomme+80);
		this.contexte.rotate(this.Langle);
		this.contexte.fillRect(0,0,10,50);
		this.contexte.fill();
		this.afterFonc();
	};

	drawBonhomme(){
		debug("drawBonhomme");
		this.drawHead();
		this.drawLArm();
		this.drawRArm();
		this.drawBody();	
		this.drawLLeg();
		this.drawRLeg();
		this.drawLEye();
		this.drawREye();
		this.drawSmile();
	};
}
