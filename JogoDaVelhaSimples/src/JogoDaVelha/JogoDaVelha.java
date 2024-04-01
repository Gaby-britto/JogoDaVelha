package JogoDaVelha;

import java.util.Scanner;

public class JogoDaVelha extends Campo {

    public static void main(String[] args) {
        Campo[][] velha = new Campo[3][3];
        char simboloAtual = 'X';
        boolean jogo = true;
        String vitoria = "";
        Scanner sc = new Scanner(System.in);
        
        iniciarJogo(velha);
        
        while (jogo) {
            desenhaJogo(velha);
            vitoria = verificaVitoria(velha);
            if (!vitoria.equals("")) {
                System.out.printf("Jogador %s venceu ", vitoria);
                break;
            }
            try {
                if (verificaJogada(velha, jogar(sc, simboloAtual), simboloAtual)) {
                    if (simboloAtual == 'X') {
                        simboloAtual = 'O';
                    } else {
                        simboloAtual = 'X';
                    }
                }
            } catch (Exception e) {
                System.out.printf("Erro");
            }
        }
        System.out.printf("Fim de Jogo");
    }

    public static void desenhaJogo(Campo[][] velha) {
        //limparTela();
        System.out.println("  0   1    2");
        System.out.printf("0 %c | %c | %c %n", velha[0][0].getSimbolo(), velha[0][1].getSimbolo(), velha[0][2].getSimbolo());
        System.out.println("  ------------");
        System.out.printf("1 %c | %c | %c %n", velha[1][0].getSimbolo(), velha[1][1].getSimbolo(), velha[1][2].getSimbolo());
        System.out.println("  ------------");
        System.out.printf("2 %c | %c | %c %n", velha[2][0].getSimbolo(), velha[2][1].getSimbolo(), velha[2][2].getSimbolo());
    }

    public static int[] jogar(Scanner sc, char simboloAtual) {
        int p[] = new int[2];
        System.out.printf("%s %c%n", "Quem joga: ", simboloAtual);
        System.out.print("Informe a linha: ");
        p[0] = sc.nextInt();
        System.out.print("Informe a coluna: "); // Corrigido
        p[1] = sc.nextInt();
        return p;
    }

    public static boolean verificaJogada(Campo[][] velha, int p[], char simboloAtual) {
        if (velha[p[0]][p[1]].getSimbolo() == ' ') {
            velha[p[0]][p[1]].setSimbolo(simboloAtual);
            return true;
        } else {
            return false;
        }
    }
    public static void iniciarJogo(Campo[][] velha) {
    	for(int linha = 0; linha < 3; linha++) {
    		for(int coluna = 0; coluna < 3; coluna++) {
    			velha[linha][coluna] = new Campo();
    		}
    	}
    }

    public static String verificaVitoria(Campo[][] velha) {
    	 
    	    for (int i = 0; i < 3; i++) {
    	        if (velha[i][0].getSimbolo() != ' ' && velha[i][0].getSimbolo() == velha[i][1].getSimbolo() && velha[i][1].getSimbolo() == velha[i][2].getSimbolo()) {
    	            return String.valueOf(velha[i][0].getSimbolo());
    	        }
    	    }

    	
    	    for (int i = 0; i < 3; i++) {
    	        if (velha[0][i].getSimbolo() != ' ' && velha[0][i].getSimbolo() == velha[1][i].getSimbolo() && velha[1][i].getSimbolo() == velha[2][i].getSimbolo()) {
    	            return String.valueOf(velha[0][i].getSimbolo());
    	        }
    	    }

    
    	    if (velha[0][0].getSimbolo() != ' ' && velha[0][0].getSimbolo() == velha[1][1].getSimbolo() && velha[1][1].getSimbolo() == velha[2][2].getSimbolo()) {
    	        return String.valueOf(velha[0][0].getSimbolo());
    	    }
    	    if (velha[0][2].getSimbolo() != ' ' && velha[0][2].getSimbolo() == velha[1][1].getSimbolo() && velha[1][1].getSimbolo() == velha[2][0].getSimbolo()) {
    	        return String.valueOf(velha[0][2].getSimbolo());
    	    }

    	    
    	    return "";
    	

    }

    public static void limparTela() {
        for (int i = 0; i < 200; i++) {
            System.out.println("");

        }
    }
}
