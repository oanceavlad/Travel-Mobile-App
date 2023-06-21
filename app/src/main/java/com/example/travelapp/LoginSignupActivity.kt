package com.example.travelapp

import android.content.Context
import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import com.example.travelapp.Dashboard.DashboardActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class LoginSignupActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient
    private val REQUEST_CODE = 9001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.requestFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.login_signup_activity)

        // Bindings

        // Animation
        val loginSignupAnimation = findViewById<MotionLayout>(R.id.login_signup_animation)
        // Firebase Authentication
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken("45429238886-e5fe252ci7potrvc92k9uhh0db33q37m.apps.googleusercontent.com").requestEmail().build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)
        firebaseAuth = FirebaseAuth.getInstance()
        // Buttons
        val signupButton = findViewById<MaterialButton>(R.id.signup)
        val loginButton = findViewById<MaterialButton>(R.id.login)
        val toLoginButton = findViewById<TextView>(R.id.to_login)
        val toSignupButton = findViewById<TextView>(R.id.to_signup)
        val googleLoginButton = findViewById<MaterialButton>(R.id.login_google)

        // Actions
        googleLoginButton.setOnClickListener {
            val signInIntent = googleSignInClient.signInIntent
            startActivityForResult(signInIntent, REQUEST_CODE)
        }

        loginButton.setOnClickListener {
            val emailContainer = findViewById<TextInputLayout>(R.id.login_email_container)
            val email = findViewById<TextInputEditText>(R.id.login_email).text?.toString()?.trim()
            val passwordContainer = findViewById<TextInputLayout>(R.id.login_password_container)
            val password = findViewById<TextInputEditText>(R.id.login_password).text?.toString()?.trim()

            val emptyError = "This field cannot be empty"

            var emailIsCorrect = false
            var passwordIsCorrect = false

            if (email.isNullOrEmpty()) {
                emailContainer.error = emptyError
            }
            else {
                emailIsCorrect = true
            }
            if (password.isNullOrEmpty()) {
                passwordContainer.error = emptyError
            }
            else {
                passwordIsCorrect = true
            }
            if (emailIsCorrect && passwordIsCorrect) {
                if (email != null && password != null) {
                    firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                        if (it.isSuccessful) {
                            val intent = Intent(this@LoginSignupActivity, DashboardActivity::class.java)
                            intent.putExtra("email", email)
                            startActivity(intent)
                            finish()
                        }
                        else {
                            Toast.makeText(this,it.exception?.message ,Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }

            toSignupButton.setOnClickListener {
                emailContainer.isErrorEnabled = false
                passwordContainer.isErrorEnabled = false
                emailContainer.editText?.text = null
                passwordContainer.editText?.text = null

                when (loginSignupAnimation.currentState) {
                    loginSignupAnimation.startState -> loginSignupAnimation.transitionToEnd()
                    loginSignupAnimation.endState -> loginSignupAnimation.transitionToStart()
                }
            }
        }

        signupButton.setOnClickListener {
            val emailContainer = findViewById<TextInputLayout>(R.id.signup_email_container)
            val email = findViewById<TextInputEditText>(R.id.signup_email).text?.toString()?.trim()
            val passwordContainer = findViewById<TextInputLayout>(R.id.signup_password_container)
            val password = findViewById<TextInputEditText>(R.id.signup_password).text?.toString()?.trim()
            val repasswordContainer = findViewById<TextInputLayout>(R.id.signup_repassword_container)
            val repassword = findViewById<TextInputEditText>(R.id.signup_repassword).text?.toString()?.trim()

            val emptyError = "This field cannot be empty"
            val passwordMatchError = "Password does not match"

            var emailIsCorrect = false
            var passwordIsCorrect = false
            var repasswordIsCorrect = false
            var passwordsMatch = false

            if (email.isNullOrEmpty()) {
                emailContainer.isErrorEnabled = true
                emailContainer.error = emptyError
            }
            else {
                emailIsCorrect = true
            }
            if (password.isNullOrEmpty()) {
                emailContainer.isErrorEnabled = true
                passwordContainer.error = emptyError
            }
            else {
                passwordIsCorrect = true
            }
            if (repassword.isNullOrEmpty()) {
                emailContainer.isErrorEnabled = true
                repasswordContainer.error = emptyError
            }
            else {
                repasswordIsCorrect = true
            }
            if (password != null && repassword != null) {
                if (password.isNotEmpty() && repassword.isNotEmpty() && password != repassword) {
                    passwordContainer.error = passwordMatchError
                    repasswordContainer.error = passwordMatchError
                }
                else {
                    passwordsMatch = true
                }
            }

            if (emailIsCorrect && passwordIsCorrect && repasswordIsCorrect && passwordsMatch) {
                if (email != null && password != null) {
                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                        if (it.isSuccessful) {
                            Toast.makeText(this,"Your account has been successfully created" ,Toast.LENGTH_SHORT).show()
                            toLoginButton.performClick()
                        }
                        else {
                            Toast.makeText(this, it.exception?.message ,Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }

            toLoginButton.setOnClickListener {
                emailContainer.isErrorEnabled = false
                passwordContainer.isErrorEnabled = false
                repasswordContainer.isErrorEnabled = false
                emailContainer.editText?.text = null
                passwordContainer.editText?.text = null
                repasswordContainer.editText?.text = null

                when (loginSignupAnimation.currentState) {
                    loginSignupAnimation.endState -> loginSignupAnimation.transitionToStart()
                    loginSignupAnimation.startState -> loginSignupAnimation.transitionToEnd()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)
                val idToken = account?.idToken

                val credential = GoogleAuthProvider.getCredential(idToken, null)
                firebaseAuth.signInWithCredential(credential).addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            val user = firebaseAuth.currentUser

                            val intent = Intent(this@LoginSignupActivity, DashboardActivity::class.java)
                            intent.putExtra("email", user?.email)
                            startActivity(intent)
                            finish()
                        }
                        else {
                            Toast.makeText(this, task.exception?.message, Toast.LENGTH_SHORT).show()
                        }
                    }
            } catch (e: ApiException) {
                Toast.makeText(this, task.exception?.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            val view: View? = currentFocus
            if (view is TextInputEditText) {
                val outRect = Rect()
                view.getGlobalVisibleRect(outRect)
                if (!outRect.contains(event.rawX.toInt(), event.rawY.toInt())) {
                    view.clearFocus()
                    val imm: InputMethodManager =
                        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0)
                }
            }
        }
        return super.dispatchTouchEvent(event)
    }
}