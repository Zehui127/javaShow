import java.util.*;
public class obst{
	private Random random;
	public obst(int [][]map){
		random = new Random();
		int fX = random.nextInt(3)+1;
		int fY = random.nextInt(9)+1;
		int sX = random.nextInt(3)+1;
		int sY = random.nextInt(9)+1;
		int tX = random.nextInt(3)+1;
		int tY = random.nextInt(9)+1;
		map[fY][fX]=4;
		map[sY][sX]=4;
		map[tY][tX]=4;
		for(int i=0;i<10;i++){
			for(int j=0;j<5;j++){
				if(i==0||i==9||j==0||j==4){
					map[i][j]=4;
				}
			}
		}
	}
	
}