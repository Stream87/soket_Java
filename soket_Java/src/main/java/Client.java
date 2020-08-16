import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
    private Socket clientSocket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    public void connect(){
        try {
            System.out.println("접속 시도");

            clientSocket = new Socket("192.168.35.4", 10002);
            System.out.println("접속 완료");
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

    public void streamSetting(){
        try {
            dataInputStream = new DataInputStream(clientSocket.getInputStream());
            dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
        }catch (Exception e){

        }
    }

    public Client(){
        connect();
        streamSetting();
        dataSend("안녕하세요. 클라이언트 입니다. ^^");
        System.out.println(dateRecv());
    }

    public static void main(String[] args) {
        new Client();
    }
}
