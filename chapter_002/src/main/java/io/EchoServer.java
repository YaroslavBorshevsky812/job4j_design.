package io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.stream.Stream;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (true) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    if (!str.isEmpty()) {
                        str = Stream.of(str.split(" "))
                                .filter(s -> s.contains("msg"))
                                .findFirst()
                                .orElse("");
                    }
                    System.out.println("msg: " + str);
                    if (!str.isEmpty()) {
                        String[] arrStr = str.split("=");
                        str = arrStr[1];
                        out.write("HTTP/1.1 200 OK\r\n\r\n".concat(str).getBytes());
                        if (str.equals("Exit")) {
                            break;
                        }
                    }
                }
            }
        }
    }
}