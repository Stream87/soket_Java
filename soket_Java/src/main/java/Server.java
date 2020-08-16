import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;



    public void serverSetiing(){

        try {
            //localhost, 10002
            serverSocket = new ServerSocket(10002); //바인드
            clientSocket = serverSocket.accept(); //어셉트.
            // 소켓이 접속 완료된 부분
            System.out.println("클라이언트 소켓 연결");
        }catch (Exception e){

        }
    }

    public void closeAll(){
        try {
            serverSocket.close();
            clientSocket.close();
            dataInputStream.close();
            ;
            dataOutputStream.close();
        }catch (Exception e){

        }
    }

    public void streamSetting(){
        try {
            dataInputStream = new DataInputStream(clientSocket.getInputStream());
            dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
        }catch (Exception e){

        }
    }

    public String dateRecv(){
        try {
            return dataInputStream.readUTF();
        }catch (Exception e){

        }
        return null;
    }

    public void dataSend(String sendData){
        try {
            dataOutputStream.writeUTF(sendData);
        }catch (Exception e){

        }

    }

    public Server(){
        serverSetiing();
        System.out.println(dateRecv());
        dataSend("잘 받았어요 ^^");
        closeAll();
    }

    public static void main(String[] args) {
        new Server();
    }

}
