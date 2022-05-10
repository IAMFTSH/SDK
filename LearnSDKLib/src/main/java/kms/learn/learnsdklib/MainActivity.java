package kms.learn.learnsdklib;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.unity3d.player.UnityPlayer;


public class MainActivity extends UnityPlayerActivity {

    private static MainActivity instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        instance = this;
    }

    /**
     * 供Unity调用的求和函数
     * @param x
     * @param y
     * @return
     */
    public int Sum(int x, int y) {
        return x + y;
    }

    /**供Unity调用的比较最大值函数
     * @param x
     * @param y
     * @return
     */
    public int Max(int x, int y) {
        return Math.max(x, y);
    }


    /**供Unity调用的显示吐司的函数
     * @param str
     */
    public void MakeToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }


    /**供Unity调用的自加一函数
     * @param x
     * @return
     */
    public int AddOne(int x) {
        return x + 1;
    }


    /**供Unity调用的静态方法，单例类，返回当前的Activity对象
     * @return
     */
    public static MainActivity GetInstance() {
        return instance;
    }


    /**供Unity调用的函数，此函数会回调指定的一个Unity中的方法，完成数据的双向交互
     * @param str
     */
    public void CallUnityFunc(String str){
        str=str+"Android Call Unity.";
        String ReceiveObject="MessageHandler";
        String ReceiverMethod="Receive";
        UnityPlayer.UnitySendMessage(ReceiveObject, ReceiverMethod, str);
    }
}