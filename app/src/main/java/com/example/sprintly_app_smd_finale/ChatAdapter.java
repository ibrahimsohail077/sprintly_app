package com.example.sprintly_app_smd_finale;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {

    private final List<Chat_message> chatMessages;

    public ChatAdapter(List<Chat_message> chatMessages) {
        this.chatMessages = chatMessages;
    }

    public static class ChatViewHolder extends RecyclerView.ViewHolder {
        TextView messageTextView, timeTextView;
        LinearLayout message_bg;

        public ChatViewHolder(View view) {
            super(view);
            messageTextView = view.findViewById(R.id.messageText);
            timeTextView = view.findViewById(R.id.messageTime);
            message_bg=view.findViewById(R.id.messageTextView);

        }
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chat_message, parent, false);
        return new ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        Chat_message chat = chatMessages.get(position);
        holder.messageTextView.setText(chat.getMessage());
        holder.timeTextView.setText(chat.getTime());
        if(chat.get_isCurrentUser()){
            holder.message_bg.setBackgroundResource(R.drawable.sender_chat_bg);
        }
    }

    @Override
    public int getItemCount() {
        return chatMessages.size();
    }
}
