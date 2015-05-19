package com.hanson.checkdevice.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

import com.hanson.checkdevice.R;
import com.hanson.checkdevice.view.InputMethodRelativeLayout;
import com.hanson.checkdevice.view.InputMethodRelativeLayout.OnSizeChangedListenner;

public class LoginActivity extends Activity implements OnSizeChangedListenner{

	private InputMethodRelativeLayout layout;  
    private LinearLayout login_logo_layout_small ;
    private LinearLayout login_logo_layout_big ,login_container ;
    private EditText userName;
    private EditText password;
    private Button logIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.login_layout);
    	
		layout = (InputMethodRelativeLayout) this.findViewById(R.id.loginpage) ;
        layout.setOnSizeChangedListenner(this) ;
        
        login_logo_layout_big = (LinearLayout) this.findViewById(R.id.login_logo_layout_big) ; //取得大LOGO布局
        login_logo_layout_small = (LinearLayout) this.findViewById(R.id.login_logo_layout_small) ; //取得小LOGO布局
        login_container = (LinearLayout) this.findViewById(R.id.login_container) ;
        userName = (EditText)this.findViewById(R.id.edit_login_id);
        password = (EditText)this.findViewById(R.id.edit_password);
        logIn = (Button)this.findViewById(R.id.login_btn);
        
        logIn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				longInMehtod();
			}
		});
    }
    
    public void longInMehtod(){
    	final Intent intent = new Intent(this, MainActivity.class);
    	BmobUser user = new BmobUser();
        user.setUsername(userName.getText().toString());
        user.setPassword(password.getText().toString());
        
        //((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)). 
        //hideSoftInputFromWindow(userName.getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS); 

        //收起键盘
        InputMethodManager imm =  (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);   
        if(imm != null) {
        	imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);   
        } 
        
        user.login(this, new SaveListener() {
            @Override
            public void onSuccess() {
    			startActivity(intent);
    			showToast("登录成功！");
    			endActivity();
            }
            @Override
            public void onFailure(int code, String msg) {
            	showToast("登录失败！");
            }
        });
    }
    
    public void showToast(String msg){
    	Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    
    public void endActivity(){
    	this.finish();
    }
    
    /**
	 * 在Activity中实现OnSizeChangedListener，原理是设置该布局的paddingTop属性来控制子View的偏移
	 */
	@Override
	public void onSizeChange(boolean flag,int w ,int h) {  
        if(flag){//键盘弹出时
        	Animation anim=AnimationUtils.loadAnimation(LoginActivity.this, R.anim.login_anim);
    		anim.setFillAfter(true);
    		login_container.startAnimation(anim);
            login_logo_layout_big.setVisibility(View.GONE) ;
            login_logo_layout_small.setVisibility(View.VISIBLE) ;
        }else{ //键盘隐藏时
            layout.setPadding(0, 0, 0, 0); 
            login_logo_layout_big.setVisibility(View.VISIBLE) ;
            login_logo_layout_small.setVisibility(View.GONE) ;
        }
    }  

}
