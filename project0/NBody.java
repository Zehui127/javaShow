public class NBody{
	public static double readRadius(String file){
		In in = new In(file);
		double size = 0.0;
		for(int i=0;i<2;i++){
			double temp=in.readDouble();
			if(i==1){
				size = temp;
			}
		}
		return size;
	}
	
	public static Planet[] readPlanets(String file){
		In in = new In(file);
		int lines = in.readInt();
		double size = in.readDouble();
		Planet[] planets  = new Planet[lines];
		for(int i=0;i<lines;i++){
			double tempXpos = in.readDouble();
			double tempYpos = in.readDouble();
			double tempXvel = in.readDouble();
			double tempYvel = in.readDouble();
			double tempMass = in.readDouble();
			String tempString=in.readString();
			
			Planet temp=new Planet(tempXpos,tempYpos,tempXvel,tempYvel,tempMass,tempString);
			planets[i] = temp;
		}
		return planets;
	}
	
	public static void main(String[] args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = readRadius(filename);
		Planet[] planets = readPlanets(filename);
		
		String imageToDraw = "./images/starfield.jpg";
		StdDraw.setScale(-radius,radius);
		StdDraw.clear();
		StdDraw.picture(0,0,imageToDraw);

		for(int i=0;i<planets.length;i++){
			planets[i].draw();
		}
		
		StdAudio.play("./audio/2001.mid");
		for (int i=0;i<T;i+=dt){
			double [] xForces = new double[planets.length];
			double [] yForces = new double[planets.length];
			for(int j=0;j<planets.length;j++){
				xForces[j] = planets[j].calcNetForceExertedByX(planets);
				yForces[j] = planets[j].calcNetForceExertedByY(planets);
			}
			for(int j=0;j<planets.length;j++){
				planets[j].update(dt,xForces[j],yForces[j]);
			}
			
			StdDraw.picture(0,0,imageToDraw);
			
			for(int j=0;j<planets.length;j++){
				planets[j].draw();
			}
			StdDraw.show(10);
		}
		
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
			planets[i].xxPos, planets[i].yyPos, planets[i].xxVel, planets[i].yyVel, planets[i].mass, planets[i].imgFileName);	
		}		
	}
}



















