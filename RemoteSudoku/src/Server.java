import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {


    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            System.err.println("Usage: java EchoServer <port number>");
            System.exit(1);
        }

        System.out.println("Game Started. Waiting for users to join.");
        Sudoku sudokuBoard = new Sudoku();
        sudokuBoard.fillValues();

        ArrayList<ServerThread> clients = new ArrayList<>();

        int portNumber = 8000;

        try {
            ServerSocket serverSocket = new ServerSocket(8000);


            // infinite loop to connect clients
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected" + clientSocket.getInetAddress().getHostAddress());

                // server thread
                ServerThread serverThread = new ServerThread(clientSocket, sudokuBoard, clients, serverSocket);
                clients.add(serverThread);
                serverThread.start();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}

class ServerThread extends Thread {

    private Socket clientSocket;
    public Sudoku sudokuBoard;
    public ArrayList<ServerThread> clients;
    PrintWriter out;
    ServerSocket serverSocket;


    //Constructor
    public ServerThread(Socket socket, Sudoku board, ArrayList<ServerThread> clients, ServerSocket serverSocket) throws IOException {

        this.clientSocket = socket;
        this.sudokuBoard = board;
        this.clients = clients;
        this.out = new PrintWriter(clientSocket.getOutputStream(), true);
        this.serverSocket = serverSocket;

    }

    public void run() {
        try {
            // get input of client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String userInput;

            // print instructions
            out.println("\nYou have joined the game.\n\nOptions:\n1) Enter 'show' to view board\n2) Enter 'update <row> <column> <number> to play'\n3) Enter 'exit' to leave game\n4) Enter 'help' to see instructions\n(NOTE: Your input will not show on screen. Just type and hit enter.\n");

            // infinite loop to get client guesses
            while (true) {

                // if the board is full, end prompt the clients to disconnect and close the server
                synchronized (sudokuBoard) {
                    if (sudokuBoard.isBoardFull()) {
                        // end game
                        endGame();
                        Thread.sleep(1000);
                        System.exit(0);
                        break;

                    }
                }
                userInput = in.readLine();
                // if client asks to see the board
                if (userInput != null && userInput.equals("show")) {
                    out.println(sudokuBoard.getSudokuString());
                    out.flush();


                }
                // if client submits a guess
                else if (userInput != null) {

                    // if guess is in format of "rowNumber colNumber guessNumber"
                    String[] parts = userInput.split(" ");
                    if (parts.length == 4 && parts[0].equals("update")) {
                        int row = Integer.parseInt(parts[1]);
                        int col = Integer.parseInt(parts[2]);
                        int value = Integer.parseInt(parts[3]);
                        // if guess is valid, board is updated and sent to all clients
                        synchronized (sudokuBoard) {
                            if (sudokuBoard.enterNumber(row, col, value)) {
                                out.println("\nValid input. Updating board with your guess\n");
                                sudokuBoard.mat[row][col] = value;
                                sudokuBoard.R -= 1;
                                printToAll();

                            }
                            else {
                                out.println("Incorrect. Try another guess");
                            }

                        }

                    }
                    // if client asks for instructions
                    else if (userInput.equals("help")) {
                        // print instructions
                        out.println("\nOptions:\n1) Enter 'show' to view board\n2) Enter 'update <row> <column> <number> to play'\n3) Enter 'exit' to leave game\n4) Enter 'help' to see instructions\n(NOTE: Your input will not show on screen. Just type and hit enter.\n");
                    }

                    // if input is not a valid command
                    else {
                        out.println("ENTER VALID COMMAND");
                    }

                }
                // if input was null
                else {
                    out.println("ENTER VALID COMMAND");
                }


            }



        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    // send updated board to all clients
    public void printToAll() {
        //send to all clients
        for (ServerThread client : clients) {
            client.out.print("Another value in the board has been updated\n");
            client.out.println(sudokuBoard.getSudokuString());
            client.out.println();

        }
    }

    // send game over message to all clients to prompt them to disconnect
    public void endGame() {
        //send to all clients
        for (ServerThread client : clients) {
            client.out.print("Game Over! Thank you for playing!");
            client.out.println();

        }
    }



}
