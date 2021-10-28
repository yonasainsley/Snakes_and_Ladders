package finalProject;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	Random r = new Random();
	Scanner sc = new Scanner(System.in);
	Random random=new Random();
	ArrayList<snakesandLadders> arrSNL=new ArrayList<snakesandLadders>();
	snakesandLadders SNL;
	Players P1=new playerOne(); 
	Players P2=new playerTwo(); 

	String p1,p2;
	int opt;
	int optTic;
	
//	0 = kertas
//	1 = batu
//	2 = gunting
	
	
	public int Suit(){
		int suitP1,suitP2;
		System.out.print("Tekan enter untuk melakukan suit...");
		do {
			sc.nextLine();
			suitP1 = r.nextInt(3);
			suitP2 = r.nextInt(3);
		if(suitP1==0){
			if(suitP2==1){
				System.out.println("P1 mendapatkan Kertas\nP2 mendapatkan Batu\n");
				return 1;
			}else if(suitP2==2){
				System.out.println("P1 mendapatkan Kertas\nP2 mendapatkan Gunting\n");
				return 2;
			}else{
				System.out.println("P1 mendapatkan Kertas\nP2 mendapatkan Kertas\n");
			}
		}else if(suitP1==1){
			if(suitP2==2){
				System.out.println("P1 mendapatkan Batu\nP2 mendapatkan Gunting\n");
				return 1;
			}else if(suitP2==0){
				System.out.println("P1 mendapatkan Batu\nP2 mendapatkan Kertas\n");
				return 2;
			}else{
				System.out.println("P1 mendapatkan Batu\nP2 mendapatkan Batu\n");
			}
		}else{
			if(suitP2==0){
				System.out.println("P1 mendapatkan Gunting\nP2 mendapatkan Kertas\n");
				return 1;
			}else if(suitP2==1){
				System.out.println("P1 mendapatkan Gunting\nP2 mendapatkan Batu\n");
				return 2;
			}else{
				System.out.println("P1 mendapatkan Gunting\nP2 mendapatkan Gunting\n");
			}
		}
		System.out.println("Seri");
		System.out.print("Tekan enter untuk suit ulang...");
		sc.nextLine();
		} while (suitP1==suitP2);
		return -1;
	}
	
	public void Jebot(){							//Menu Jebot
		newPage();
		int optJebot;
		int score,urutan;
		do {
			newPage();
			try {
				titleThread t1=new titleThread();
				t1.join();
				System.out.println("     ___  _______  _______  _______  _______ ");
				titleThread t2=new titleThread();
				t2.join();
				System.out.println("    |   ||       ||  _    ||       ||       |");
				titleThread t3=new titleThread();
				t3.join();
				System.out.println("    |   ||    ___|| |_|   ||   _   ||_     _|");
				titleThread t4=new titleThread();
				t4.join();
				System.out.println("    |   ||   |___ |       ||  | |  |  |   |  ");
				titleThread t5=new titleThread();
				t5.join();
				System.out.println(" ___|   ||    ___||  _   | |  |_|  |  |   |  ");
				titleThread t6=new titleThread();
				t6.join();
				System.out.println("|       ||   |___ | |_|   ||       |  |   |  ");
				titleThread t7=new titleThread();
				t7.join();
				System.out.println("|_______||_______||_______||_______|  |___|  ");
				titleThread t8=new titleThread();
				t8.join();
				System.out.print("1. Play\n2. Instruction\n3. Exit\n>> ");
			} catch (InterruptedException e) {
				System.out.println("Tolong restart aplikasi.");
			}
			optJebot = sc.nextInt();
			sc.nextLine();
			if(optJebot==1){
				urutan = Suit();
				if(urutan==1){
					System.out.println(p1+" jalan terlebih dahulu");
				}else{
					System.out.println(p2+" jalan terlebih dahulu");
				}
				score = jebotPlay(urutan);
				if(score==1){
					P1.addPoint();
				}else{
					P2.addPoint();
				}
			}
			else if(optJebot==2){
				newPage();
				System.out.println("CARA MAIN");
				System.out.println("================================");
				System.out.println("- Setiap pemain mempunyai 2 jari");
				System.out.println("- Pada satu giliran suatu pemain, masing-masing");
				System.out.println("  pemain akan menginput satu angka yang tidak");
				System.out.println("  lebih dari jumlah jari yang dimiliki");
				System.out.println("- Suatu angka akan digenerate, dan jika jumlah jari");
				System.out.println("  kedua pemain sama dengan angka tersebut, pemain");
				System.out.println("  yang sedang dalam giliran boleh menghilangkan satu jari");
				System.out.println();
				System.out.println();
				System.out.println("CARA MENANG");
				System.out.println("================================");
				System.out.println("- Jadilah pemain yang pertama");
				System.out.println("  yang menghabiskan semua jari!");
				System.out.println();
				System.out.print("Tekan enter...");
				sc.nextLine();
			}
		} while (optJebot!=3);
		
		
	}
	
	public int jebotPlay(int giliran){				  // Jebot Game Logic
		int value1=2,value2=2,nilai;
		int jwb1,jwb2;
		int i=1;
		do{
			if(giliran%2==1){
				System.out.println("Game "+i+" giliran "+p1);
			}else{
				System.out.println("Game "+i+" giliran "+p2);				
			}
			do {
				try {
					System.out.print("P1 mau keluarin berapa? ");
					jwb1 = sc.nextInt();
				} catch (Exception e) {
					jwb1 = 5;
				}
				sc.nextLine();
			} while (jwb1>value1);
			do {
				try {
					System.out.print("P2 mau keluarin berapa? ");
					jwb2 = sc.nextInt();
				} catch (Exception e) {
					jwb2 = 5;
				}
				sc.nextLine();
			} while (jwb2>value2);
			nilai=r.nextInt(value1+value2+1);
			System.out.println("Nilainya adalah "+nilai);
			if(nilai==jwb1+jwb2){
				if(giliran%2==1){
					System.out.println("Jari "+p1+" berkurang 1\n\n");
					value1--;
				}else{
					System.out.println("Jari "+p2+" berkurang 1\n\n");
					value2--;
				}
			}else{
				System.out.println("Nilai belum sesuai\n\n");
			}
			i++;
			giliran++;
			if(value1==0){
				System.out.println(p1+" memenangkan permainan Jebot");
				return 1;
			}else if(value2==0){
				System.out.println(p2+" memenangkan permainan Jebot");
				return 2;
			}
		}while(value1!=0||value2!=0);
		return -1;
	}
	
	public void TicTacToe(){
		int optTic,urutan,score;
		 do {
			newPage();
			try {
				titleThread t1=new titleThread();
				t1.join();
				System.out.println(" _______  ___   _______  _______  _______  _______  _______  _______  _______ ");
				titleThread t2=new titleThread();
				t2.join();
				System.out.println("|       ||   | |       ||       ||   _   ||       ||       ||       ||       |");
				titleThread t3=new titleThread();
				t3.join();
				System.out.println("|_     _||   | |       ||_     _||  |_|  ||       ||_     _||   _   ||    ___|");
				titleThread t4=new titleThread();
				t4.join();
				System.out.println("  |   |  |   | |       |  |   |  |       ||       |  |   |  |  | |  ||   |___ ");
				titleThread t5=new titleThread();
				t5.join();
				System.out.println("  |   |  |   | |      _|  |   |  |       ||      _|  |   |  |  |_|  ||    ___|");
				titleThread t6=new titleThread();
				t6.join();
				System.out.println("  |   |  |   | |     |_   |   |  |   _   ||     |_   |   |  |       ||   |___ ");
				titleThread t7=new titleThread();
				t7.join();
				System.out.println("  |___|  |___| |_______|  |___|  |__| |__||_______|  |___|  |_______||_______|");
				titleThread t8=new titleThread();
				t8.join();
				System.out.print("1. Play\n2. Instruction\n3. Exit\n>> ");
			} catch (InterruptedException e) {
				System.out.println("Tolong restart aplikasi.");
			}
			optTic = sc.nextInt();
			sc.nextLine();
			if (optTic == 1) {
				urutan = Suit();
				if (urutan == 1) {
					System.out.println(p1 + " jalan terlebih dahulu");
				} else {
					System.out.println(p2 + " jalan terlebih dahulu");
				}
				score = tictacPlay(urutan);
				if (score == 1) {
					System.out.println(p1 + " memenangkan game TicTacToe");
					P1.addPoint();
				} else if(score==2) {
					System.out.println(p2 + " memenangkan game TicTacToe");
					P2.addPoint();
				}else{
					System.out.println("Permainan Seri");
				}
				System.out.println("Tekan enter...");
				sc.nextLine();
				sc.nextLine();
			}
			else if(optTic==2){
				newPage();
				System.out.println("CARA MENANG");
				System.out.println("================================");
				System.out.println("- Tempatlah tiga X / O tanpa dihalangin oleh musuh");
				System.out.println();
				System.out.print("Tekan enter...");
				sc.nextLine();
			}
		} while (optTic!=3);
	}
	
	public int tictacPlay(int giliran){
		int total=0;
		int a;
		int choose;
		int win=0;
		String x[]={"1","2","3","4","5","6","7","8","9"};
		do {
			a = 0;
			System.out.println("=============");
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					System.out.printf("| %s ", x[a]);
					a++;
				}
				System.out.print("|\n");
				System.out.println("=============");
			}
			if (giliran % 2 == 1) {
				do {
					do {
						try {
							System.out.print(p1 + " memilih angka -> ");
							choose = sc.nextInt();
						} catch (Exception e) {
							choose = 10;
						} 
					} while (choose<1||choose>9);
				} while (x[choose - 1].equals("X") || x[choose - 1].equals("O"));
				x[choose - 1] = "X";
			} else {
				do {
					do {
						try {
							System.out.print(p2 + " memilih angka -> ");
							choose = sc.nextInt();
						} catch (Exception e) {
							choose = 10;
						}
					} while (choose<1||choose>9);
				} while (x[choose - 1].equals("X") || x[choose - 1].equals("O"));
				x[choose - 1] = "O";
			}
			total++;
			System.out.println();
			giliran++;
			win = tesTicTacToe(x);
		} while (win==0&&total<9);
		a = 0;
		System.out.println("=============");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.printf("| %s ", x[a]);
				a++;
			}
			System.out.print("|\n");
			System.out.println("=============");
		}
		return win;
	}
	
	public int tesTicTacToe(String[] x){
		if(x[0].equals(x[1])&&x[0].equals(x[2])){
			if(x[0].equals("X")){
				return 1;
			}else{
				return 2;				
			}
		}else if(x[3].equals(x[4])&&x[3].equals(x[5])){
			if(x[3].equals("X")){
				return 1;
			}else{
				return 2;				
			}
		}else if(x[6].equals(x[7])&&x[6].equals(x[8])){
			if(x[6].equals("X")){
				return 1;
			}else{
				return 2;				
			}
		}else if(x[0].equals(x[3])&&x[0].equals(x[6])){
			if(x[0].equals("X")){
				return 1;
			}else{
				return 2;				
			}
		}else if(x[1].equals(x[4])&&x[1].equals(x[7])){
			if(x[1].equals("X")){
				return 1;
			}else{
				return 2;				
			}
		}else if(x[2].equals(x[5])&&x[2].equals(x[8])){
			if(x[2].equals("X")){
				return 1;
			}else{
				return 2;				
			}
		}else if(x[0].equals(x[4])&&x[0].equals(x[8])){
			if(x[0].equals("X")){
				return 1;
			}else{
				return 2;				
			}
		}else if(x[2].equals(x[4])&&x[2].equals(x[6])){
			if(x[2].equals("X")){
				return 1;
			}else{
				return 2;				
			}
		}
		return 0;
	}
	
	void newPage(){
		for(int i=0;i<70;i++){
			System.out.println();
		}
	}
	
	int rollDice(){
		int dice;
		dice=Math.abs(random.nextInt()%6)+1;
		return dice;
	}
	
	void printRules(){
		newPage();
		System.out.println("PERATURAN");
		System.out.println("================================");
		System.out.println("1. Step 13 akan jatuh ke 7");
		System.out.println("2. Step 25 akan naik ke 40");
		System.out.println("3. Step 50 akan jatuh ke 38");
		System.out.println("4. Step 63 akan naik ke 78");
		System.out.println("5. Step 83 akan naik ke 97");
		System.out.println("6. Step 95 akan jatuh ke 76");
		System.out.println("7. Jika angka 6 muncul pada dadunya,");
		System.out.println("   maka pemain boleh jalan lagi.");
		System.out.println();
		System.out.println();
		System.out.println("CARA MENANG");
		System.out.println("================================");
		System.out.println("- Pemain harus mencapai 100 steps!");
		System.out.println("               ATAU");
		System.out.println("- Jadilah pemain dengan step terbanyak");
		System.out.println("  pada akhir ronde ke 25!");
		System.out.println();
		System.out.println();
		System.out.println("CATATAN");
		System.out.println("================================");
		System.out.println("Jika hasil dari permainan ini tidak muncul,");
		System.out.println("Restart aplikasi eclipse Anda.");
		System.out.println("Jika masih tidak muncul,");
		System.out.println("Terus mencoba sampai muncul.");
		System.out.println();
		System.out.print("Tekan enter...");
	}
	
	int twoplayerOrder(){
		newPage();
		int dice1,dice2;
		System.out.println("Kocoklah dadu untuk menentukan urutan main!");
		System.out.println("==========================================");
		System.out.print(p1+", tekan enter untuk mengocok dadu...");
		sc.nextLine();
		dice1=rollDice();
		System.out.println("Dice : "+dice1);
		System.out.println("==========================================");
		System.out.print(p2+", tekan enter untuk mengocok dadu...");
		sc.nextLine();
		dice2=rollDice();
		System.out.println("Dice : "+dice2);
		System.out.println("==========================================");
		if(dice1==dice2){
			System.out.println("Both players will roll the dice lagi!");
			System.out.println("Tekan enter...");
			sc.nextLine();
			return twoplayerOrder();
		}
		else if(dice1>dice2){
			System.out.println("Urutan bermain adalah: "+p1+" -> "+p2);
			System.out.print("Tekan enter...");
			sc.nextLine();
			return 0;
		}
		else{
			System.out.println("Urutan bermain adalah: "+p2+" -> "+p1);
			System.out.print("Tekan enter...");
			sc.nextLine();
			return 1;
		}
	}
	
	int Special(int newStep){
		if(newStep==13){
			System.out.println("Steps Anda berkurang dari 13 to 7!");
			return 7;
		}
		else if(newStep==25){
			System.out.println("Steps Anda bertambah dari 25 to 40!");
			return 40;
		}
		else if(newStep==50){
			System.out.println("Steps Anda berkurang dari 50 to 38!");
			return 38;
		}
		else if(newStep==63){
			System.out.println("Steps Anda bertambah dari 63 to 78!");
			return 78;
		}
		else if(newStep==83){
			System.out.println("Steps Anda bertambah dari 83 to 97!");
			return 97;
		}
		else if(newStep==95){
			System.out.println("Steps Anda berkurang dari 95 to 76!");
			return 76;
		}
		else{
			return newStep;
		}
	}
	
	int moreThan100(int newStep,int oldStep,int dice){
		if(newStep>100){
			while(oldStep!=100){
				oldStep++;
				dice--;
			}
			newStep=100-dice;
		}
		return newStep;
	}
	
	void gameOver2(int newStep1,int newStep2){
		System.out.println("Game Over!");
		System.out.println();
		System.out.println("Ranking");
		System.out.println("================================");
		if(newStep1>newStep2){
			System.out.println("1. "+p1+" -> "+newStep1+" Steps");
			System.out.println("2. "+p2+" -> "+newStep2+" Steps");
			System.out.println();
			P1.addPoint();
			System.out.println("Tekan enter...");
			sc.nextLine();
		}
		else{
			System.out.println("1. "+p2+" -> "+newStep2+" Steps");
			System.out.println("2. "+p1+" -> "+newStep1+" Steps");
			System.out.println();
			P2.addPoint();
			System.out.println("Tekan enter...");
			sc.nextLine();
		}
	}
	
	int doubleDice(String name,int dice){
		int doubleDice=0;
		if(dice==6){
			while(dice==6||doubleDice==6){
				System.out.print(name+", tekan enter untuk mengocok dadu lagi...");
				sc.nextLine();
				doubleDice=rollDice();
				System.out.println("Dadu : "+doubleDice);
				dice+=doubleDice;
			}
			System.out.println("Total Dadu : "+dice);
		}
		return dice;
	}
	
	void printTable2(){
		System.out.println("=================================================================================================================");
		System.out.println("|		|			"+p1+"			|			"+p2+"			|");
		System.out.println("|	Round	|-----------------------------------------------------------------------------------------------|");
		System.out.println("|		|Step Lama	|	Dadu	|Step Baru	|Step Lama	|	Dadu	|Step Baru	|");
		for (snakesandLadders SNL : arrSNL) {
			System.out.println("|---------------|-----------------------------------------------------------------------------------------------|");
			System.out.println("|	"+SNL.getRound()+"	|	"+SNL.getOldStep1()+"	|	"+SNL.getDice1()+"	|	"+SNL.getNewStep1()+"	|	"+SNL.getOldStep2()+"	|	"+SNL.getDice2()+"	|	"+SNL.getNewStep2()+"	|");
		}
		System.out.println("=================================================================================================================");
		System.out.println("Tekan enter...");
		sc.nextLine();
	}
	
	void snakesandLadders(){
		int menuSNL;
		do {
			int oldStep1=0,oldStep2=0,newStep1=0,newStep2=0,dice1=0,dice2=0,round=0,order=0;
			do {
				try {
					newPage();
					try {
						titleThread t1=new titleThread();
						t1.join();
						System.out.println(" _______  __    _  _______  ___   _  _______  _______ ");
						titleThread t2=new titleThread();
						t2.join();
						System.out.println("|       ||  |  | ||   _   ||   | | ||       ||       |");
						titleThread t3=new titleThread();
						t3.join();
						System.out.println("|  _____||   |_| ||  |_|  ||   |_| ||    ___||  _____|");
						titleThread t4=new titleThread();
						t4.join();
						System.out.println("| |_____ |       ||       ||      _||   |___ | |_____ ");
						titleThread t5=new titleThread();
						t5.join();
						System.out.println("|_____  ||  _    ||       ||     |_ |    ___||_____  |");
						titleThread t6=new titleThread();
						t6.join();
						System.out.println(" _____| || | |   ||   _   ||    _  ||   |___  _____| |");
						titleThread t7=new titleThread();
						t7.join();
						System.out.println("|_______||_|  |__||__| |__||___| |_||_______||_______|");
						titleThread t8=new titleThread();
						t8.join();
						System.out.println(" _______  __    _  ______");
						titleThread t9=new titleThread();
						t9.join();
						System.out.println("|   _   ||  |  | ||      |");
						titleThread t10=new titleThread();
						t10.join();
						System.out.println("|  |_|  ||   |_| ||  _    |");
						titleThread t11=new titleThread();
						t11.join();
						System.out.println("|       ||       || | |   |");
						titleThread t12=new titleThread();
						t12.join();
						System.out.println("|       ||  _    || |_|   |");
						titleThread t13=new titleThread();
						t13.join();
						System.out.println("|   _   || | |   ||       |");
						titleThread t14=new titleThread();
						t14.join();
						System.out.println("|__| |__||_|  |__||______|");
						titleThread t15=new titleThread();
						t15.join();
						System.out.println(" ___      _______  ______   ______   _______  ______    _______ ");
						titleThread t16=new titleThread();
						t16.join();
						System.out.println("|   |    |   _   ||      | |      | |       ||    _ |  |       |");
						titleThread t17=new titleThread();
						t17.join();
						System.out.println("|   |    |  |_|  ||  _    ||  _    ||    ___||   | ||  |  _____|");
						titleThread t18=new titleThread();
						t18.join();
						System.out.println("|   |    |       || | |   || | |   ||   |___ |   |_||_ | |_____" );
						titleThread t19=new titleThread();
						t19.join();
						System.out.println("|   |___ |       || |_|   || |_|   ||    ___||    __  ||_____  |");
						titleThread t20=new titleThread();
						t20.join();
						System.out.println("|       ||   _   ||       ||       ||   |___ |   |  | | _____| |");
						titleThread t21=new titleThread();
						t21.join();
						System.out.println("|_______||__| |__||______| |______| |_______||___|  |_||_______|");
						titleThread t22=new titleThread();
						t22.join();
						System.out.println();
						titleThread t23=new titleThread();
						t23.join();
						System.out.print("1. Play\n2. Instruction\n3. Exit\n>> ");
					} catch (InterruptedException e) {
						System.out.println("Tolong restart aplikasi.");
					}
					menuSNL = sc.nextInt();
				} catch (Exception e) {
					menuSNL = 0;
					sc.nextLine();
				}
			} while (menuSNL > 3 || menuSNL < 1);
			sc.nextLine();
			if (menuSNL == 1) {
				order = twoplayerOrder();
				newPage();
				
				if (order == 0) {
					while (round < 25 && newStep1 != 100 && newStep2 != 100) {
						round++;
						oldStep1 = newStep1;
						oldStep2 = newStep2;
						System.out.println("Round " + round);
						System.out.println("========================================");
						System.out.println();
						System.out.print(p1 + ", tekan enter untuk mengocok dadu...");
						sc.nextLine();
						dice1 = rollDice();
						if(dice1==1){
							dice1++;
						}
						System.out.println("Dice : " + dice1);
						dice1 = doubleDice(p1, dice1);
						newStep1 = oldStep1 + dice1;
						newStep1 = Special(newStep1);
						newStep1 = moreThan100(newStep1, oldStep1, dice1);
						if (newStep1 == 100) {
							SNL = new snakesandLadders(round, oldStep1, dice1, newStep1, oldStep2, 0, newStep2);
							arrSNL.add(SNL);
							printTable2();
							break;
						}
						System.out.println("----------------------------------------");
						System.out.print(p2 + ", tekan enter untuk mengocok dadu...");
						sc.nextLine();
						dice2 = rollDice();
						if(dice2==1){
							dice2++;
						}
						System.out.println("Dice : " + dice2);
						dice2 = doubleDice(p2, dice2);
						newStep2 = oldStep2 + dice2;
						newStep2 = Special(newStep2);
						newStep2 = moreThan100(newStep2, oldStep2, dice2);
						System.out.println("----------------------------------------");
						System.out.println();
						System.out.println("Round telah berakhir!!");
						SNL = new snakesandLadders(round, oldStep1, dice1, newStep1, oldStep2, dice2, newStep2);
						arrSNL.add(SNL);
						System.out.println("Tekan enter...");
						sc.nextLine();
						System.out.println();
						printTable2();
					}
					gameOver2(newStep1, newStep2);
					arrSNL.removeAll(arrSNL);
				} else {
					while (round < 25 && newStep1 != 100 && newStep2 != 100) {
						round++;
						System.out.println("Round " + round);
						System.out.println("========================================");
						System.out.println();
						System.out.print(p2 + ", tekan enter untuk mengocok dadu...");
						sc.nextLine();
						dice2 = rollDice();
						if(dice2==1){
							dice2++;
						}
						System.out.println("Dice : " + dice2);
						dice2 = doubleDice(p2, dice2);
						newStep2 = oldStep2 + dice2;
						newStep2 = Special(newStep2);
						newStep2 = moreThan100(newStep2, oldStep2, dice2);
						if (newStep2 == 100) {
							SNL = new snakesandLadders(round, oldStep1, 0, newStep1, oldStep2, dice2, newStep2);
							arrSNL.add(SNL);
							printTable2();
							break;
						}
						System.out.println("----------------------------------");
						System.out.print(p1 + ", tekan enter untuk mengocok dadu...");
						sc.nextLine();
						dice1 = rollDice();
						if(dice1==1){
							dice1++;
						}
						System.out.println("Dice : " + dice1);
						dice1 = doubleDice(p1, dice1);
						newStep1 = oldStep1 + dice1;
						newStep1 = Special(newStep1);
						newStep1 = moreThan100(newStep1, oldStep1, dice1);
						System.out.println("----------------------------------");
						System.out.println();
						System.out.println("Round telah berakhir!!");
						System.out.println("Tekan enter...");
						System.out.println();
						printTable2();
					}
					gameOver2(newStep1, newStep2);
					arrSNL.removeAll(arrSNL);
				}
				newStep1 = 0;
				newStep2=0;
			} else if (menuSNL == 2) {
				newPage();
				printRules();
				sc.nextLine();
				newPage();
			} 
		} while (menuSNL!=3);
	}
	
	void printTitle(){
		try {
			titleThread t1=new titleThread();
			t1.join();
			System.out.println(" _______  _______  __   __  _______    _______  __   __  _______  _______  _______  __   __");
			titleThread t2=new titleThread();
			t2.join();
			System.out.println("|       ||   _   ||  |_|  ||       |  |       ||  | |  ||       ||       ||       ||  |_|  |");
			titleThread t3=new titleThread();
			t3.join();
			System.out.println("|    ___||  |_|  ||       ||    ___|  |  _____||  |_|  ||  _____||_     _||    ___||       |");
			titleThread t4=new titleThread();
			t4.join();
			System.out.println("|   | __ |       ||       ||   |___   | |_____ |       || |_____   |   |  |   |___ |       |");
			titleThread t5=new titleThread();
			t5.join();
			System.out.println("|   ||  ||       ||       ||    ___|  |_____  ||_     _||_____  |  |   |  |    ___||       |");
			titleThread t6=new titleThread();
			t6.join();
			System.out.println("|   |_| ||   _   || ||_|| ||   |___    _____| |  |   |   _____| |  |   |  |   |___ | ||_|| |");
			titleThread t7=new titleThread();
			t7.join();
			System.out.println("|_______||__| |__||_|   |_||_______|  |_______|  |___|  |_______|  |___|  |_______||_|   |_|\n");
			titleThread t8=new titleThread();
			t8.join();
		} catch (InterruptedException e) {
			System.out.println("Tolong restart aplikasi.");
		}
	}
	
	void scoreBoard(){
		newPage();
		try {
			titleThread t1=new titleThread();
			t1.join();
			System.out.println(" _______  _______  _______  ______    _______ ");
			titleThread t2=new titleThread();
			t2.join();
			System.out.println("|       ||       ||       ||    _ |  |       |");
			titleThread t3=new titleThread();
			t3.join();
			System.out.println("|  _____||       ||   _   ||   | ||  |    ___|");
			titleThread t4=new titleThread();
			t4.join();
			System.out.println("| |_____ |       ||  | |  ||   |_||_ |   |___ ");
			titleThread t5=new titleThread();
			t5.join();
			System.out.println("|_____  ||      _||  |_|  ||    __  ||    ___|");
			titleThread t6=new titleThread();
			t6.join();
			System.out.println(" _____| ||     |_ |       ||   |  | ||   |___ ");
			titleThread t7=new titleThread();
			t7.join();
			System.out.println("|_______||_______||_______||___|  |_||_______|");
			titleThread t8=new titleThread();
			t8.join();
		} catch (InterruptedException e) {
			System.out.println("Tolong restart aplikasi.");
		}
		System.out.println("\n");
		System.out.println("=================================");
		System.out.println("|	"+p1+"	|	"+p2+"	|");
		System.out.println("|-------------------------------|");
		System.out.println("|	"+P1.getPoint1()+"	|	"+P2.getPoint2()+"	|");
		System.out.println("=================================");
		System.out.println();
		System.out.println("Tekan enter...");
		sc.nextLine();
	}
	
	public Main(){
		printTitle();
		do {
			System.out.print("Input nama P1 [3-7 chars]: ");
			p1 = sc.nextLine();
		} while (p1.length()>7||p1.length()<3);
		do {
			System.out.print("Input nama P2 [3-7 chars]: ");
			p2 = sc.nextLine();
			if(p2.equals(p1)){
				System.out.println("Nama tidak boleh sama!");
				p2="a";
			}
		} while (p2.length()>7||p2.length()<3);
		do {
			do {
				try {
					newPage();
					printTitle();
					System.out.println("\n*Bacalah instruksi permainan sebelum main*\n");
					System.out.print("Games: \n1. Jebot\n2. TicTacToe\n3. Snakes and Ladders\n4. Score\n5. Exit\n>>");
					opt = sc.nextInt();
				} catch (Exception e) {
					opt=0;
					sc.nextLine();
				}
			} while (opt>5||opt<1);
			sc.nextLine();
			switch(opt){
			case 1:
				Jebot();
				break;
			case 2:
				TicTacToe();
				break;
			case 3:
				newPage();
				snakesandLadders();
				break;
			case 4:
				scoreBoard();
				break;
			}				
			
		} while (opt!=5);
	}
	public static void main(String[] args) {
		new Main();
	}

}
