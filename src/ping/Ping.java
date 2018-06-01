/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ping;
import java.io.IOException;
import java.net.InetAddress;

/**
 *
 * @autho
 */
public class Ping {
    
  private static void pingar(String host) {
        try {
          if (InetAddress.getByName(host).isReachable(5000))
            System.out.println("Ping OK: " + host);
          else
            System.out.println("Ping falhou: " + host);
        } catch (IOException e) {
          System.err.println("Ping falhou: " + host + " - " + e);
        }
        
        
         try {
            if (InetAddress.getByName(host).isReachable(5000)) {
              long nanos = 0;
              long millis = 0;
              int iterations = 0;
              
              while (iterations < 10) {
                iterations++;
                try {
                  nanos = System.nanoTime();
                  InetAddress.getByName(host).isReachable(5000); 
                  nanos = System.nanoTime()-nanos;
                } catch (IOException e) {
                  System.out.println("Falhou");
                }
                millis = Math.round(nanos/Math.pow(10,6));
                System.out.println("Resposta do IP: "+InetAddress.getByName(host).getHostAddress()+" com de tempo="+millis+" ms");
                try {
                  Thread.sleep(Math.max(0, 1000-millis));
                } catch (InterruptedException e) {
                  break;
                }
              }
              System.out.println("Iterations: "+iterations);
         
            
            } else {
              System.out.println("Host "+InetAddress.getByName(host).getHostName()+" não foi alcançado.");
            }
      } catch (IOException e) {
        System.err.println("deu erro na rede");
      }
     
    }

 
    public static void main(String[] args) {
        pingar("www.google.com");
        
    }
}

     