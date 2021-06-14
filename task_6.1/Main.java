//Записать в файл good_ip.txt рабочие ip адреса
//В файле good_ip, адреса должны быть в следующем виде ip:port
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        StringBuilder valid_proxy_list = new StringBuilder();
        try {
            FileInputStream fis = new FileInputStream("D://ip.txt");
            int i;
            String proxy = "";
            while((i=fis.read()) != -1){
                if(i==13) continue;
                else if(i==10){
                    String ip = proxy.split(":")[0];
                    String port = proxy.split(":")[1];
                    valid_proxy_list.append(checkProxy(ip, Integer.parseInt(port)));
                    proxy = "";
                }else if(i!=9){
                    proxy += (char) i;
                }else{
                    proxy += ":";
                }
            }
        } catch (IOException  e) {
            System.out.println("Файл не найден!");
        }
        // запись valid_proxy_list в файл
        try {
            FileOutputStream fos = new FileOutputStream("D://good_ip.txt", true);
            fos.write(valid_proxy_list.toString().getBytes(StandardCharsets.UTF_8));
            fos.close();
        } catch (IOException e) {
            System.out.println("Сохранить файл не удалось");
        }
    }

    public static String checkProxy(String ip, int port){
        try {
            Proxy proxy = new Proxy(Proxy.Type.HTTP,new InetSocketAddress(ip,port));
            URL url = new URL("https://vozhzhaev.ru/test.php");
            URLConnection urlConnection = url.openConnection(proxy);
            urlConnection.setConnectTimeout(5000); // 5 seconds
            InputStream is = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(is);
            int i;
            StringBuilder result = new StringBuilder();
            while ((i=reader.read()) != -1){
                result.append((char)i);
            }
            System.out.println(result);
            return ip+":"+port+"\n";
        } catch (IOException exception) {
            System.out.println(ip+" - не работает!");
            return "";
        }
    }
}