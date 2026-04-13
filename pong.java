
void setup(){
    size(640,640);
    background(55,55,55);
}
class Paddle{
  float PosX;
  float PosY;
  float Width;
  float Height;
  float SpeedY;
  Paddle(float x,float y,float w,float h,float speedy){
    PosX=x;
    PosY=y;
    Width=w;
    Height=h;
    SpeedY=speedy;
   }
  void Draw(){
    rect(this.PosX,this.PosY,this.Width,this.Height);
  }
  
  void Move(){
    this.PosY+=this.SpeedY;
  }
  
  void Reverse(){
    this.SpeedY*=-1;
  }
}

class Ball{
   float PosX;
   float PosY;
   float R;
   float SpeedX;
   float SpeedY;
   Ball(float posx,float posy,float r,float speedx,float speedy){
     PosX=posx;
     PosY=posy;
     R=r;
     SpeedX=speedx;
     SpeedY=speedy;
   }
   void DrawBall(){
      circle(this.PosX,this.PosY,this.R);
   }
   void Bound(){
     if (this.PosX>width||this.PosX<0){
       this.SpeedX*=-1;
     }
     if(this.PosY>height||this.PosY<0){
       this.SpeedY*=-1;
     }
   }
   
   void Move(){
     this.PosX+=this.SpeedX;
     this.PosY+=this.SpeedY;
   }
}

float circleDistanceX(Ball ball,Paddle paddle){
   float circldisx=ball.PosX-paddle.PosX-paddle.Width/2;
   return Math.abs(circldisx);
}


float circleDistanceY(Ball ball,Paddle paddle){
   float circledisy=ball.PosY-paddle.PosY-paddle.Height/2;
   return Math.abs(circledisy);
}

boolean hitPaddleX(Ball ball,Paddle paddle){
   if(circleDistanceX(ball,paddle)>(paddle.Width/2+ball.R/2)){
     return false;
   }

   return true;
}

boolean hitPaddleY(Ball ball,Paddle paddle){

   if(circleDistanceY(ball,paddle)>(paddle.Height/2+ball.R/2)){
     return false;
   }
   return true;
}


Ball ball=new Ball(width/2,height/2,25,13.2,4);
Paddle PaddleLeft=new Paddle(40,280,10,150,1);
Paddle PaddleRight=new Paddle(600,280,10,150,1);
void draw(){
    background(51);
    ball.DrawBall();
    ball.Move();
    ball.Bound();
    PaddleLeft.Draw();
    PaddleRight.Draw();
    if(hitPaddleX(ball,PaddleLeft)){
      ball.Bound();
    }
    if(hitPaddleY(ball,PaddleLeft)){
      ball.Bound();   
    }
}
