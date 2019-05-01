package com.ce.foolchat;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RadioGroup;

import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.easeui.ui.EaseConversationListFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity //implements m2Fra1.OnListFragmentInteractionListener
      //  , m2Fra2.OnListFragmentInteractionListener
        {

            private EMMessageListener emMessageListener = new EMMessageListener() {
                @Override
                public void onMessageReceived(List<EMMessage> list) {
                    Log.w("dsfdsf", "onMessageReceived: ");
                    messageListFra.refresh();
                }

                @Override
                public void onCmdMessageReceived(List<EMMessage> list) {

                }

                @Override
                public void onMessageRead(List<EMMessage> list) {

                }

                @Override
                public void onMessageDelivered(List<EMMessage> list) {

                }

                @Override
                public void onMessageRecalled(List<EMMessage> list) {

                }

                @Override
                public void onMessageChanged(EMMessage emMessage, Object o) {

                }
            };
    private ContactListFragment contactListFra;
    private MessageListFragment messageListFra;
//    private m2Fra2 fra2;
    private static final String[] FRAGMENT_TAG = {"fra1", "fra2"};
    private final int showfra1 = 0;
    private final int showfra2 = 1;
    private final int showfra3 = 2;
    private final int showfra4 = 3;
    private int mrIndex = showfra1;//默认选中碎片界面1
    private RadioGroup rg;
            boolean a;
            boolean b;

    private int index = -100;// 记录当前的选项
    FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        a = EMClient.getInstance().isConnected();
        b = EMClient.getInstance().isLoggedInBefore();

        setContentView(R.layout.activity_main);

//
//        fragmentManager.beginTransaction()
//                .replace(R.id.m2Fl, new ContactListFragment())
//                .commitNowAllowingStateLoss();

        rg = findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.rb1://福信
                        setTabSelection(showfra1);
                        break;
                    case R.id.rb2://福友
                        setTabSelection(showfra2);
                        break;
//                        case R.id.rb1://福信
//                        setTabSelection(showfra1);
//                        break;
                    default:
                        break;
                }
            }
        });

        setTabSelection(showfra1);
        EMClient.getInstance().chatManager().addMessageListener(emMessageListener);
    }

    private void setTabSelection(int id) {    //根据传入的index参数来设置选中的tab页。
        if (id == index) {
            return;
        }
        index = id;
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 设置切换动画
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index) {
            case showfra1:
                rg.check(R.id.rb1);
                if (messageListFra == null) {
                    messageListFra= new MessageListFragment();
                    transaction.add(R.id.m2Fl, messageListFra, FRAGMENT_TAG[index]);
                } else {
                    transaction.show(messageListFra);
                }
                transaction.commit();
                break;
            case showfra2://地图的fragment
                rg.check(R.id.rb2);
                if (contactListFra == null) {

                    contactListFra = new ContactListFragment();
                    transaction.add( R.id.m2Fl,contactListFra,FRAGMENT_TAG[index]);
                } else {
                    transaction.show(contactListFra);
                }
                transaction.commit();
                break;

            default:
                break;
        }
    }

    private void hideFragments(FragmentTransaction transaction) {
        if (messageListFra != null) {
            transaction.hide(messageListFra);
        }
        if (contactListFra != null) {
            transaction.hide(contactListFra);
        }
//        if (fraContact != null) {
//            transaction.hide(fraContact);
//        }
    }

//
//    @Override
//    public void onListFragmentInteraction(DummyContent.DummyItem item) {
//
//    }
}