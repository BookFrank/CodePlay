package com.tazine.io.socket.cases.chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 聊天客户端
 *
 * @author frank
 * @since 1.0.0
 */
public class ChatTcpSocket extends JFrame implements ActionListener{

    private String name;
    private Socket socket;
    private JTextArea textReceiver; // 显示对话内容的文本区
    private JTextField textSender;  // 输入发送内容的文本行
    private JButton buttonSend, buttonLeave;
    private PrintWriter writer;

    public ChatTcpSocket(String name, Socket client) throws IOException {
        super("聊天室 " + name + InetAddress.getLocalHost());
        this.setBounds(320,240,360,240);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.textReceiver = new JTextArea();
        this.textReceiver.setEditable(false);
        this.getContentPane().add(new JScrollPane(this.textReceiver));

        JPanel panel = new JPanel();
        this.getContentPane().add(panel, "South");
        this.textSender = new JTextField(20);
        panel.add(this.textSender);
        buttonSend = new JButton("发送");
        panel.add(buttonSend);
        buttonSend.addActionListener(this);
        buttonLeave = new JButton("离线");
        panel.add(buttonLeave);
        buttonLeave.addActionListener(this);
        this.setVisible(true);

        this.name = name;
        this.socket = client;
        this.writer = new PrintWriter(socket.getOutputStream(), true);
        this.writer.println(name);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String line = br.readLine();
        textReceiver.append("连接" + line + " 成功\r\n");
        line = br.readLine();
        while (line != null && !line.equalsIgnoreCase("bye")){
            textReceiver.append(line + "\r\n");
            line = br.readLine();
        }
        br.close();
        writer.close();
        client.close();
        buttonLeave.setEnabled(false);
        buttonSend.setEnabled(false);
    }

    public ChatTcpSocket(String name,String host, int port) throws HeadlessException, IOException {
        this(name, new Socket(host,port));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonSend){
            this.writer.println(name + " 说： " + textSender.getText());
            textReceiver.append("我说：" + textSender.getText() + "\n");
            textSender.setText("");
        }
        if (e.getSource() == buttonLeave){
            textReceiver.append("我离开了会话\n");
            this.writer.println(name + "离开了会话\n bye");
            buttonSend.setEnabled(false);
            buttonLeave.setEnabled(false);
        }
    }

    public static void main(String[] args) throws IOException {
        new ChatTcpSocket("Frank", "127.0.0.1",2001);
    }
}
