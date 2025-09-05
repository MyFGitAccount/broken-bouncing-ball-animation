const canvas = document.getElementById("canvas");
const height = 600;
const width = 600;
canvas.height = height;
canvas.width = width;
const ctx = canvas.getContext("2d");
let circlePosX=height/2;
let circlePosY=width/2;
let circleVecX=1;
let circleVecY=0.5;
let mass=20;
const massInput=document.getElementById("mass");
const speedx=document.getElementById("speedx");
const speedy=document.getElementById("speedy");
const posx=document.getElementById("posx");
const posy=document.getElementById("posy");
function drawCircle(){
ctx.beginPath()
ctx.arc(circlePosX,circlePosY,mass,Math.PI*2,false);
ctx.stroke();
ctx.closePath()
}

function setInput(setter,input,defaultValue){
  input.addEventListener("input",()=>{
   setter(parseFloat(input.value) || defaultValue);
  })
}

function setMass(mass,input,defaultValue){
  setInput(mass,input);
}
function setSpeedX(speedx,input,defaultValue){
  setInput(speedx,input);
}
function setSpeedY(speedy,input,defaultValue){
  setInput(speedy,input);
}
function setPosX(posx,input,defaultValue){
  setInput(posx,input);
}
function setPosY(posy,input,defaultValue){
  setInput(posy,input)
}
function bounceOffX(){
  if(circlePosX+mass/3>width){
    //circlePosX-=10-mass/2;
    circleVecX*=-1;
  }
  if(circlePosX-mass/3<0){
     //circlePosX+=10+mass/2;
     circleVecX*=-1;
   }
}

function bounceOffY(){
  if(circlePosY+mass/3>height){
    //circlePosY-=10-mass/2;
    circleVecY*=-1;
  }
  if(circlePosY-mass/3<0){
     //circlePosY+=10+mass/2;
     circleVecY*=-1;
   }
}

function move(){
  circlePosX+=circleVecX;
  circlePosY+=circleVecY;
}

function animate(){
   ctx.clearRect(0,0,width,height);
   drawCircle();
   move()
   bounceOffX();
   bounceOffY();
   requestAnimationFrame(animate);
}

function init(){
  setMass(ret=>mass=ret,massInput,20);
  setSpeedX(ret=>circleVecX=ret,speedx,1);
  setSpeedY(ret=>circleVecY=ret,speedy,0.85);
  setPosX(ret=>circlePosX=ret,posx,width/2);
  setPosY(ret=>circlePosY=ret,posy,height/2);
}

function run(){
  init();
  animate();
}

run();
