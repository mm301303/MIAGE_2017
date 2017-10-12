
//Un fonction appelée quand la page est chargée
//declarations:
let canvas1, context;
let Langle=0, Rangle=0;
let xBonhomme=30, yBonhomme=30, xSmile= 5;
value = 0.1;
window.onload=init;

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

	drawBonhomme(30,30);
	animeBonhomme();

	
}
function drawHead(x,y){
	debug("drawHead");
	context.save();
	//on dessine en x,y, on veut un repere relatif
	context.translate(x,y);
	context.fillStyle = "red";
	context.beginPath();
	context.arc(0, 10, 20, 0, 2*Math.PI, false);
	context.fill();
	context.restore();
	
}
function drawLEye(x,y){
	debug("drawLEye");
	context.save();
	//on dessine en x,y, on veut un repere relatif
	context.translate(x,y);
	context.fillStyle = "white";
	context.beginPath();
	context.arc(-8+(xSmile/2), 0, 5+(xSmile/2), 0, 2*Math.PI, false);	
	context.fill();
	context.restore();
}
function drawREye(x,y){
	debug("drawREye");
	context.save();
	//on dessine en x,y, on veut un repere relatif
	context.translate(x,y);
	context.fillStyle = "white";
	context.beginPath();
	context.arc(8+(xSmile/2), 0, 4+(xSmile/2), 0, 2*Math.PI, false);	
	context.fill();
	context.restore();
}
function drawSmile(x,y){
	debug("drawEye");
	context.save();
	//on dessine en x,y, on veut un repere relatif
	context.translate(x+xSmile,y+15);
	context.fillStyle = "white";
	context.fillRect(-7,0,15,6+xSmile);
	context.fill();
	context.restore();
}
function drawBody(x,y){
	debug("drawBody");
	context.save();
	context.translate(x,y);
	context.fillStyle = "white";
	context.beginPath();
	context.arc(0, 60, 30, 0, 2*Math.PI, false);
	context.lineTo(0, 50);
	context.fill();
	context.restore();
}

function drawLArm(x,y){
	debug("drawLArm");

	context.save();
	//on dessine en x,y, on veut un repere relatif
		context.fillStyle = "orange";

	context.translate(x-15,y+30);
	context.rotate(Rangle+Math.PI/6);
	context.fillRect(0,0,10,50);
	context.restore();
}
function drawRArm(x,y){
	debug("drawRArm");
	context.save();
	context.fillStyle = "orange";
	context.translate(x+15,y+35);
	context.rotate(Rangle-Math.PI/6);
	context.fillRect(0,0,10,50);
	context.restore();
}


function drawLLeg(x,y){
	debug("drawLLeg");
	context.save();
	//on dessine en x,y, on veut un repere relatif
	context.translate(x-15,y+80);
	context.fillStyle = "green";
	context.rotate(Langle);
	context.fillRect(0,0,10,50);
	context.restore();
}
function drawRLeg(x,y){
	debug("drawRLeg");

	context.save();
	context.fillStyle = "green";
	context.translate(x+12,y+80);
	context.rotate(Langle);
	context.fillRect(0,0,10,50);
	context.fill();
	context.restore();
}

function drawBonhomme(x, y){
	debug("drawBonhomme");
	context.save();
	context.translate(x,y);
	drawHead(x,y);

	drawLArm(x,y);
	drawRArm(x,y);

	drawBody(x,y);	
	drawLLeg(x,y);
	drawRLeg(x,y);
	drawLEye(x,y);
	drawREye(x,y);
	drawSmile(x,y);

	context.restore();
}


function animeBonhomme() {
debug("animeBonhomme");
  // 1 - on efface le canvas
  context.clearRect(0, 0, canvas1.width, canvas1.height);
  
  // 2 - on dessine dans le canvas
  drawBonhomme(xBonhomme, yBonhomme);
  
  // 3 - on met à jour les objets à dessiner
  Rangle += value;
  Langle += value;

  if(Rangle>Math.PI/4||Rangle<-Math.PI/4) {
  	value = - value;
  	xSmile = -xSmile;
  }

  requestAnimationFrame(animeBonhomme);
}