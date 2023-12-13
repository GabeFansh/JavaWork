import java.util.*;
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Client <hostname> <port number>");
            System.exit(1);
        }

        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);

        try (Socket echoSocket = new Socket(hostName, portNumber);
             PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {
            String userInput;
            String line;

            while (true) {
                if (stdIn.ready()) {
                    userInput = stdIn.readLine();
                    if (userInput != null) {
                        //if user inputs "exit" close the connection
                        if (userInput.equals("exit")) {
                            System.out.println("closing connection");
                            echoSocket.close();
                            System.exit(1);
                        } else {
                            out.println(userInput);
                        }
                    }
                }

                // Give time to get output from Server
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                while (in.ready()) {
                    line = in.readLine();
                    System.out.println(line);
                    if (line.equals("Game Over! Thank you for playing!")) {
                        System.out.println("closing connection");
                        echoSocket.close();
                        System.exit(1);
                    }

                }


                // Sleep for 500
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }



        } catch (UnknownHostException e) {
            System.err.println("who is " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for " + hostName);
            System.exit(1);
        }
    }
}