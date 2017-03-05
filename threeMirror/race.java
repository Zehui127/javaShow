import java.util.*;
public class race{	
	public static void main(String[] args){
		chessBoard game = new chessBoard(1,-1);
		game.print();
		int i =0;
		Scanner input = new Scanner(System.in);
 		while(true){
			String p;
			int player;
			if(i%2==0){
				player=1;
				p = "X";
			}else{
				player=2;
				p = "O";
			}
			System.out.print("Player " + p + ":");
			if(i<6){
				int x = input.nextInt();
				game.play(x,player);
			}else{
				int x = input.nextInt();
				int y = input.nextInt();
				game.play(x,y,player);
			}
			game.print();
			if(game.check(player)){
				System.out.println(p+" Win!");
				break;
			}
			i++;
		} 
	}
}