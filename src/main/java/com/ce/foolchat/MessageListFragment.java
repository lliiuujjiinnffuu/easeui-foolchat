package com.ce.foolchat;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.easeui.EaseConstant;
import com.hyphenate.easeui.ui.EaseConversationListFragment;
import com.hyphenate.easeui.widget.EaseConversationList;

import java.util.List;


public class MessageListFragment extends EaseConversationListFragment {
    // TODO: Rename parameter arguments, choose names that match



    public MessageListFragment() {
           setConversationListItemClickListener(new EaseConversationListItemClickListener() {
               @Override
               public void onListItemClicked(EMConversation conversation) {
                   startActivity(new Intent(getActivity(), ChatActivity.class).putExtra(EaseConstant.EXTRA_USER_ID, conversation.conversationId()));
               }
           });
        // Required empty public constructor
    }





}
