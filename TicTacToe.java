package TicTacToeGame;
import java.util.Scanner;
public class TicTacToe {
	private static Players player1,player2;
	private Board board;
	public static void main(String args[]) {
		TicTacToe t=new TicTacToe();
		t.startGame();
	}
	public void startGame() {
		Scanner sc=new Scanner(System.in);
		//input lena hain players ka:
		player1=takeInput(1);
		player2=takeInput(2);

		while(player1.getSymbol()== player2.getSymbol()) {
			System.out.println("This symbol is taken !! plaese choose another !!");
			char symbol=sc.next().charAt(0);
			player2.setSymbol(symbol);
		}

		//board ko create karna hain:
		board=new Board(player1.getSymbol(),player2.getSymbol());
		//conduct the game:
		boolean player1turn=true;
		int status=Board.Incomplete;
		while(status==Board.Incomplete || status==Board.Invalid) {
			if(player1turn) {
				System.out.println("player1-"+" "+ player1.getName()+" "+"'s turn");
				//				Scanner sc=new Scanner(System.in);
				System.out.println("Enter the x coordinate");
				int x=sc.nextInt();
				System.out.println("Enter the y coordinate");
				int y=sc.nextInt();
				status=board.move(player1.getSymbol(),x,y);
				if(status!=Board.Invalid) {
					player1turn=false;
					board.print();
				}
			}else {
				System.out.println("player2-"+" "+ player2.getName()+" "+"'s turn");
				//				Scanner sc=new Scanner(System.in);
				System.out.println("Enter the x coordinate");
				int x=sc.nextInt();
				System.out.println("Enter the y coordinate");
				int y=sc.nextInt();
				status=board.move(player2.getSymbol(),x,y);
				if(status!=Board.Invalid) {
					player1turn=true;
					board.print();
				}
			}
		}
		if(status==Board.Player1_Win) {
			System.out.println("Player1 "+player1.getName()+" wins");
		}else if(status==Board.Player2_Win) {
			System.out.println("Player1 "+player2.getName()+" wins");
		}else {
			System.out.println("Draw !!");
		}

	}
	private static Players takeInput(int num) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter palyer"+" "+num+" "+"name");
		String name=sc.nextLine();
		System.out.println("Enter palyer"+" "+num+" "+"symbol");
		char symbol=sc.next().charAt(0);
		Players p=new Players(name,symbol);
		return p;
	}
}
