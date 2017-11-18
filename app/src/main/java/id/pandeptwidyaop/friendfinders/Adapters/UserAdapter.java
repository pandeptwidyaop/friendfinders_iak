package id.pandeptwidyaop.friendfinders.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.pandeptwidyaop.friendfinders.Models.User;
import id.pandeptwidyaop.friendfinders.R;

/**
 * Created by John Doe on 11/18/2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private Context mContext;
    private List<User> mList;

    private UserClickListener userClickListener;

    public UserAdapter(Context mContext, List<User> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_items,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, final int position) {
        User user = mList.get(position);
        holder.tvUsername.setText(user.getName());
        Glide.with(holder.ivUserAvatar.getContext()).load(user.getImageUrl()).into(holder.ivUserAvatar);
        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userClickListener != null){
                    userClickListener.onUserItemCliked(mList.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public static class UserViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvUserName) TextView tvUsername;
        @BindView(R.id.ivUserAvatar) ImageView ivUserAvatar;
        @BindView(R.id.btnDetails) Button btnDetail;

        public UserViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void bind(User userItem){
            tvUsername.setText(userItem.getName());

        }
    }

    public void setUsers(List<User> userList){
        mList.addAll(userList);
        notifyDataSetChanged();
    }

    public void setItemClickListener(UserClickListener clickListener) {
        if (clickListener != null) {
            userClickListener = clickListener;
        }
    }
}
