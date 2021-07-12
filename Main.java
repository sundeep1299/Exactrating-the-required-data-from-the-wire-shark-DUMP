package Http_Streams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;

import io.pkts.PacketHandler;
import io.pkts.Pcap;
import io.pkts.buffer.Buffer;
import io.pkts.packet.Packet;
import io.pkts.packet.TCPPacket;
import io.pkts.packet.UDPPacket;
import io.pkts.protocol.Protocol;

public class Main 
{
	
	static File f;
	static BufferedReader br;
	static BufferedWriter bw;

    public static void main(String[] args) throws IOException {

        final Pcap pcap = Pcap.openStream("/Users/vijayendrasai/Documents/TcpDump/httpdump.pcap");
        
        // Creating a File object that represents the disk file. 
        PrintStream o = new PrintStream(new File("/Users/vijayendrasai/Documents/TcpDump/FileJunk.txt")); 
  
        // Store current System.out before assigning a new value 
        PrintStream console = System.out; 
  
        // Assign o to output stream 
        System.setOut(o);  
        
        pcap.loop(new PacketHandler() {
        	@Override
            public boolean nextPacket(Packet packet) throws IOException {

                if (packet.hasProtocol(Protocol.TCP))
                {
                    TCPPacket tcpPacket = (TCPPacket) packet.getPacket(Protocol.TCP);
                    Buffer buffer = tcpPacket.getPayload();
                    
                    if (buffer != null) {
                        System.out.println("TCP: " + buffer);
                    }																													
                }
                return true;
            }
        });
        // Use stored value for output stream 
        System.setOut(console);
        o.close();
        
        // Creating a File object that represents the disk file. 
        o = new PrintStream(new File("/Users/vijayendrasai/Documents/TcpDump/HttpStreams.txt")); 
  
        // Store current System.out before assigning a new value 
        console = System.out; 
  
        // Assign o to output stream 
        System.setOut(o);
        
        FileReader fr = null;
		try {
			fr = new FileReader("/Users/vijayendrasai/Documents/TcpDump/FileJunk.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}    
        br=new BufferedReader(fr);    
        String strCurrentLine;

        boolean isAscii;

        while ((strCurrentLine = br.readLine()) != null) {
        	if(isAsciiPrintable(strCurrentLine))
        	{
        		System.out.println(strCurrentLine);
        	}
        }
        
        System.setOut(console);
        o.close();
        
        br.close();    
        fr.close();
    }
    
   public static boolean isAsciiPrintable(String str) {
	      if (str == null) {
	          return false;
	      }
	      int sz = str.length();
	      for (int i = 0; i < sz; i++) {
	          if (isAsciiPrintable(str.charAt(i)) == false) {
	              return false;
	          }
	      }
	      return true;
	  }
	public static boolean isAsciiPrintable(char ch) {
	      return ch >= 32 && ch < 127;
	  }
}