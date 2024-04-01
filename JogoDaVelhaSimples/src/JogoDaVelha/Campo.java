package JogoDaVelha;

public class Campo {
    private char simbolo;

    public Campo() {
        this.simbolo = ' ';
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        if (this.simbolo == ' ') {
            this.simbolo = simbolo;
        } else {
            System.out.println("Campo já usado");
        }
    }
}
