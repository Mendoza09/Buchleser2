package ujcv.edu.hn.buchleser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private int RC_SIGN_IN = 42;

    FirebaseAuth mAuth;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Registrarse (View  view){
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build());


        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .build(),
                RC_SIGN_IN);
    }

    public void botoning (View view){
        startActivity(new Intent(MainActivity.this,LoginActivity.class));
        //finish();
    }

    @Override
    protected void onStart(){
        super.onStart();

        if (mAuth.getCurrentUser() != null){
            startActivity(new Intent(MainActivity.this,ProfileActivity.class));
            finish();
        }
    }
}
