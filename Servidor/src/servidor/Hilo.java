package servidor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Inet4Address;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hilo extends Thread{
    Socket sk;
    public Hilo(Socket sk){
        this.sk = sk;
    }

    @Override
    public void run() {
        InputStream is = null; 
        OutputStream os = null; 
        try {
        	
            is = sk.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            
            
            os = sk.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            
            Inet4Address ip = (Inet4Address) sk.getInetAddress();
            String laIP = ip.getHostAddress();
            
            while(true){
                System.out.println("El cliente ha decidido...\n");
                String linea = br.readLine();
                int clientOption = Integer.parseInt(linea);
                System.out.println("Dónde estará la bola...\n");
                int serverOption = new Random().nextInt(4-1+1)+1;
                switch(serverOption) {
	                case 1:System.out.println("¡La bola estaba en el vaso("+serverOption+")!\n");break;
	                case 2:System.out.println("¡La bola estaba en el vaso("+serverOption+")!\n");break;
	                case 3:System.out.println("¡La bola estaba en el vaso("+serverOption+")!\n");break;
	                case 4:System.out.println("¡La bola estaba en el vaso("+serverOption+")!\n");break;
                }
                switch(clientOption) {
                	case 1: System.out.print("¡El Cliente("+ laIP +") escogió el vaso("+ clientOption +")!\n");
                		if(serverOption == 1){
                			bw.write("¡LA BOLA ESTABA EN EL VASO - VICTORIA!\n");
                		}
                		if(serverOption != 1){
                			bw.write("¡LA BOLA NO ESTABA EN EL VASO - DERROTA!\n");
                		}
                		break;
                	case 2: System.out.print("¡El Cliente("+ laIP +") escogió el vaso("+ clientOption +")!\n"); 
	                	if(serverOption == 2){
	            			bw.write("¡LA BOLA ESTABA EN EL VASO - VICTORIA!\n");
	            		}
	            		if(serverOption != 2){
	            			bw.write("¡LA BOLA NO ESTABA EN EL VASO - DERROTA!\n");
	            		}
	            		break;
                	case 3: System.out.print("¡El Cliente("+ laIP +") escogió el vaso("+ clientOption +")!\n");
	                	if(serverOption == 3){
	            			bw.write("¡LA BOLA ESTABA EN EL VASO - VICTORIA!\n");
	            		}
	            		if(serverOption != 3){
	            			bw.write("¡LA BOLA NO ESTABA EN EL VASO - DERROTA!\n");
	            		}
	            		break;
                	case 4: System.out.print("¡El Cliente("+ laIP +") escogió el vaso("+ clientOption +")!\n");
	                	if(serverOption == 4){
	            			bw.write("¡LA BOLA ESTABA EN EL VASO - VICTORIA!\n");
	            		}
	            		if(serverOption != 4){
	            			bw.write("¡LA BOLA NO ESTABA EN EL VASO - DERROTA!\n");
	            		}
	            		break;
                }
                bw.newLine();
                bw.flush();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(is != null) is.close();
            } catch (IOException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
}
