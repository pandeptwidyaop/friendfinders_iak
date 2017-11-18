package id.pandeptwidyaop.friendfinders;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.pandeptwidyaop.friendfinders.Adapters.UserAdapter;
import id.pandeptwidyaop.friendfinders.Adapters.UserClickListener;
import id.pandeptwidyaop.friendfinders.Models.User;

public class MainActivity extends AppCompatActivity implements UserClickListener {

    @BindView(R.id.rvUsers) RecyclerView recyclerViewUser;
    private UserAdapter userAdapter;
    private List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        userList = new ArrayList<>();
        userAdapter = new UserAdapter(this,userList);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerViewUser.setLayoutManager(layoutManager);
        recyclerViewUser.setAdapter(userAdapter);

        userAdapter.setItemClickListener(this);
        seedUsers();
    }

    private void seedUsers(){
        List<User> tempUserList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            User user = new User("User "+i,"https://randomuser.me/api/portraits/men/"+i+".jpg");
            tempUserList.add(user);
        }
        userAdapter.setUsers(tempUserList);
    }

    @Override
    public void onUserItemCliked(User user) {
        DetailActivity.start(this,user.toJson());
    }
}
