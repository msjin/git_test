package com.mianShiTi.suanfa;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 使用Socket经行网络通信时，客户端和服务器端流程
 * @author Administrator
 *
 *服务器，使用ServerSocket监听指定的端口，端口可以随意指定（由于1024以下的端口通常属于保留端口，
 *在一些操作系统中不可以随意使用，所以建议使用大于1024的端口），等待客户连接请求，客户连接后，
 *会话产生；在完成会话后，关闭连接。
 *客户端，使用Socket对网络上某一个服务器的某一个端口发出连接请求，一旦连接成功，打开会话；
 *会话完成后，关闭Socket。客户端不需要指定打开的端口，通常临时的、动态的分配一个1024以上的端口。
 */
public class SocketTest {

	public static void main(String[] args) {
		SocketServer.start();
	}
}

class StartClient{
	public static void main(String[] args) {
		SocketClient.start();
	}
}

//服务端
class SocketServer{
	public static void start(){
		try {
			ServerSocket ss = new ServerSocket(8998);
			Socket socket = ss.accept();//创建一个socket
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());//获取客户端输入流
			DataInputStream dis = new DataInputStream(socket.getInputStream());//向客户端输出流
			System.out.println("服务器接收到客户端的连接请求："+dis.readUTF());//获取输入数据
			dos.writeUTF("接受连接请求，连接成功");//输入数据
			socket.close();//用完要关闭
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

//客户端
class SocketClient{
	public static void start(){
		try {
			Socket socket = new Socket("localhost",8998);
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			dos.writeUTF("客户端请求连接...");
			System.out.println(dis.readUTF());
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}