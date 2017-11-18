package id.pandeptwidyaop.friendfinders;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import id.pandeptwidyaop.friendfinders.Adapters.UserClickListener;
import id.pandeptwidyaop.friendfinders.Models.User;

public class DetailActivity extends AppCompatActivity {
    private static final String KEY_EXTRAS_USER = "user";

    @BindView(R.id.tvUserUsername) TextView txtUser;
    @BindView(R.id.ivUserCircle) ImageView imgUser;
    @BindView(R.id.tvUserFullName) TextView txtName;
    @BindView(R.id.tvUserEmail) TextView txtEmail;
    @BindView(R.id.tvUserDateBirth) TextView txtBirth;
    @BindView(R.id.tvUserPhone) TextView txtPhone;

    User user;

    public static void start(Context context, String userJson){
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(KEY_EXTRAS_USER,userJson);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        String userJson = getIntent().getStringExtra(KEY_EXTRAS_USER);
        user = new User().fromJson(userJson);
        setupUser();
    }

    private void setupUser(){
        txtUser.setText(user.getName());
        Glide.with(this).load(user.getImageUrl()).into(imgUser);
    }

}
