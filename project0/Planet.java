public class Planet{
	public double xxPos,yyPos;
	public double xxVel,yyVel,mass;
	public String imgFileName;
	
	public Planet(double xP, double yP, double xV,double yV, double m, String img){
		xxPos=xP;
		yyPos=yP;
		xxVel=xV;
		yyVel=yV;
		mass=m;
		imgFileName=img;
	}
	
	public Planet(Planet p){
		xxPos=p.xxPos;
		yyPos=p.yyPos;
		xxVel=p.xxVel;
		yyVel=p.yyVel;
		mass=p.mass;
		imgFileName=p.imgFileName;
	}
	
	public double calcDistance(Planet p){
		double xDistance = xxPos-p.xxPos; 
		double yDistance = yyPos-p.yyPos;
		double distance = Math.sqrt(xDistance*xDistance+yDistance*yDistance);
		return distance;
	}
	
	public double calcForceExertedBy(Planet p){
		double distance =calcDistance(p)*calcDistance(p);
		double force = 6.67e-11* mass * p.mass/distance;
		return force;
	}
	
	public double calcForceExertedByX(Planet p){
		
		return calcForceExertedBy(p)*(p.xxPos-xxPos)/calcDistance(p);
	}
	
	public double calcForceExertedByY(Planet p){
		return calcForceExertedBy(p)*(p.yyPos-yyPos)/calcDistance(p);
	}	
	
	public double calcNetForceExertedByX(Planet[] allPlanets){
		double netForce=0.0;
		for(int i=0;i<allPlanets.length;i++){
			if(!Double.isNaN(calcForceExertedByX(allPlanets[i]))){
				netForce+=calcForceExertedByX(allPlanets[i]);
			}
		}
		return netForce;
	}
	
	public double calcNetForceExertedByY(Planet[] allPlanets){
		double netForce=0.0;
		for(int i=0;i<allPlanets.length;i++){
			if(!Double.isNaN(calcForceExertedByY(allPlanets[i]))){
				netForce+=calcForceExertedByY(allPlanets[i]);
			}
		}
		return netForce;
	}
	
	public void update(double dt,double fX,double fY){
		double accX=fX/mass;
		double accY=fY/mass;
		xxVel+=dt*accX;
		yyVel+=dt*accY;
		xxPos+=dt*xxVel;
		yyPos+=dt*yyVel;	
	}
	
	public void draw(){
		String imageToDraw = "./images/" + imgFileName;
		StdDraw.picture(xxPos,yyPos,imageToDraw);
	}
}