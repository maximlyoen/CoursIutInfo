package recursivite;

/**
 * Exercice Ping-Pong
 */
public class PingPong {
    
    static void ping(int n) {
        if(n==0)
        {
            System.out.println("Point Ping");
        }
        else 
        {
            ping(n-1);
            System.out.println("Ping");
        }
    }

    static void pong(int n) {
        if(n==0)
        {
            System.out.println("Point Pong");
        }
        else 
        {
            pong(n-1);
            System.out.println("Pong");
        }
    }

    public static void main(String[] args) {
        // TODO
    }
}
