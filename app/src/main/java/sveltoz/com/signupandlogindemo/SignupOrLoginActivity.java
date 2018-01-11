package sveltoz.com.signupandlogindemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static sveltoz.com.signupandlogindemo.Constant.Constants.isNetworkAvailable;

public class SignupOrLoginActivity extends AppCompatActivity {
    EditText EdtSignInEmailId, EdtSignUpEmailId, EdtSignInPassword, EdtSignUPPassword;
    TextView tvForgotLogin;
    LinearLayout ll_SignIn, ll_SignUP;
    Button BtnHideShow, BtnSignIn, BtnSignUp;
    boolean hideshow = true;
    String EmailId, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_or_login);

        //Sign In Decleration
        ll_SignIn = (LinearLayout) findViewById(R.id.ll_sign_in);
        EdtSignInEmailId = (EditText) findViewById(R.id.edt_sigin_emailid);
        EdtSignInPassword = (EditText) findViewById(R.id.edt_sign_in_password);
        tvForgotLogin = (TextView) findViewById(R.id.textviewForgotpass);
        tvForgotLogin.setText(Html.fromHtml("<u>Forgot Password</u>"));
        BtnSignIn = (Button) findViewById(R.id.btn_sign_in);

        //Sign Up Decleration
        ll_SignUP = (LinearLayout) findViewById(R.id.ll_sign_up);
        EdtSignUpEmailId = (EditText) findViewById(R.id.edt_sigup_emailid);
        EdtSignUPPassword = (EditText) findViewById(R.id.edt_sign_up_password);
        BtnSignUp = (Button) findViewById(R.id.btn_sign_up);

        BtnHideShow = (Button) findViewById(R.id.btn_hideshow);
        BtnHideShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (hideshow) {
                    ll_SignUP.setVisibility(View.VISIBLE);
                    ll_SignIn.setVisibility(View.GONE);
                    hideshow = false;
                    BtnHideShow.setText("Existing USer? Sign In");
                } else {

                    BtnHideShow.setText("New to Grocery Shop? SIGNUP");

                    ll_SignUP.setVisibility(View.GONE);
                    ll_SignIn.setVisibility(View.VISIBLE);
                    hideshow = true;
                }

            }
        });

        BtnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmailId = EdtSignInEmailId.getText().toString();
                Password = EdtSignInPassword.getText().toString();
                if (EmailId.equals("") || EmailId.equals(null) || EmailId.isEmpty()) {
                    EdtSignInEmailId.setError("Enter Email-Id");
                    EdtSignInEmailId.requestFocus();
                } else if (!isValidEmail(EmailId)) {
                    EdtSignInEmailId.setError("Enter valid Email-Id");
                    EdtSignInEmailId.requestFocus();

                } else if (Password.equals("") || Password.equals(null) || Password.isEmpty()) {
                    EdtSignInPassword.setError("Enter PIN");
                    EdtSignInPassword.requestFocus();
                } else if (Password.length() < 4) {
                    EdtSignInPassword.setError("Enter 4 Digit PIN");
                    EdtSignInPassword.requestFocus();
                } else {
                    if (isNetworkAvailable(SignupOrLoginActivity.this)) {
                        //  progressDialog(progress, "Loading", "Please wait...");
                        //Send email id and password to server and check login
                        Toast.makeText(SignupOrLoginActivity.this, "SignIn Success", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(SignupOrLoginActivity.this, "Check Your Network Connection", Toast.LENGTH_SHORT).show();
                        //      }
                    }
                }
            }
        });
        BtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EmailId = EdtSignUpEmailId.getText().toString();
                Password = EdtSignUPPassword.getText().toString();
                if (EmailId.equals("") || EmailId.equals(null) || EmailId.isEmpty()) {
                    EdtSignUpEmailId.setError("Enter Email-Id");
                    EdtSignUpEmailId.requestFocus();
                } else if (!isValidEmail(EmailId)) {
                    EdtSignUpEmailId.setError("Enter valid Email-Id");
                    EdtSignUpEmailId.requestFocus();

                } else if (Password.equals("") || Password.equals(null) || Password.isEmpty()) {
                    EdtSignUPPassword.setError("Enter PIN");
                    EdtSignUPPassword.requestFocus();
                } else if (Password.length() < 4) {
                    EdtSignUPPassword.setError("Enter 4 Digit PIN");
                    EdtSignUPPassword.requestFocus();
                } else {
                    if (isNetworkAvailable(SignupOrLoginActivity.this)) {
                        //  progressDialog(progress, "Loading", "Please wait...");
                        //Send all details to server and check signup
                        Toast.makeText(SignupOrLoginActivity.this, "SignUp Success", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(SignupOrLoginActivity.this, "Check Your Network Connection", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        tvForgotLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // sendOtp();
                Toast.makeText(SignupOrLoginActivity.this, "Need to send OTP to email id.", Toast.LENGTH_SHORT).show();

            }
        });

    }

    public final static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }
}
