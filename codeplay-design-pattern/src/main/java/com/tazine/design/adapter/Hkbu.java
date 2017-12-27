package com.tazine.design.adapter;

/**
 * Created by lina on 2017/12/27.
 *
 * @author frank
 * @since 1.0.0
 */
public class Hkbu {

    private HkSocketInterface hkSocket;


    public Hkbu(HkSocketInterface hkSocket) {
        this.hkSocket = hkSocket;
    }

    public Hkbu() {
    }

    public HkSocketInterface getHkSocket() {
        return hkSocket;
    }

    public void setHkSocket(HkSocketInterface hkSocket) {
        this.hkSocket = hkSocket;
    }

    public void charge(){
        hkSocket.powerWithThree();
    }

    public static void main(String[] args) {

        HkSocketInterface hkSocket = new HkSocketImpl();

        Hkbu hkbu = new Hkbu(hkSocket);

        hkbu.charge();

        // 去香港上学，带的是双头的充电器
        GbSocketInterface gbSocket = new GbSocketImpl();
        // 到了学校后
        Hkbu bu = new Hkbu();
        // 由于没法充电，于是去买了转化插头，转化插头需要插上我的充电器
        HkSocketInterface adapter = new SocketAdapter(gbSocket);
        // 再把转化插头，插到学校的插座上
        bu.setHkSocket(adapter);

        // 充电（并没有改变原接口，却还能使用新接口的功能）
        bu.charge();
    }
}
