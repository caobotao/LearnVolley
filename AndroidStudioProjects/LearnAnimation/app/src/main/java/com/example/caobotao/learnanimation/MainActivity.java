package com.example.caobotao.learnanimation;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import static com.example.caobotao.learnanimation.R.*;


public class MainActivity extends Activity implements OnClickListener {

	private ImageView image;
	private Button scale;
	private Button rotate;
	private Button translate;
	private Button mix;
	private Button alpha;
	private Button continue_btn;
	private Button continue_btn2;
	private Button flash;
	private Button move;
	private Button change;
	private Button layout;
	private Button frame;
    private AnimationDrawable animationDrawable;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		image = (ImageView) findViewById(id.image);
		scale = (Button) findViewById(id.scale);
		rotate = (Button) findViewById(id.rotate);
		translate = (Button) findViewById(id.translate);
		alpha = (Button) findViewById(id.alpha);
		continue_btn = (Button) findViewById(id.continue_btn);
		continue_btn2 = (Button) findViewById(id.continue_btn2);
		flash = (Button) findViewById(id.flash);
		move = (Button) findViewById(id.move);
		change=(Button) findViewById(id.change);
		layout=(Button) findViewById(id.layout);
		frame=(Button) findViewById(id.frame);
		scale.setOnClickListener(this);
		rotate.setOnClickListener(this);
		translate.setOnClickListener(this);
		alpha.setOnClickListener(this);
		continue_btn.setOnClickListener(this);
		continue_btn2.setOnClickListener(this);
		flash.setOnClickListener(this);
		move.setOnClickListener(this);
		change.setOnClickListener(this);
		layout.setOnClickListener(this);
		frame.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		Animation loadAnimation;
		switch (view.getId()) {
		case id.scale: {
			loadAnimation = AnimationUtils.loadAnimation(this, R.anim.scale);
			image.startAnimation(loadAnimation);
			break;
		}

		case id.alpha: {
			loadAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha);
			image.startAnimation(loadAnimation);
            break;
        }

		case id.rotate: {
			loadAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
			image.startAnimation(loadAnimation);
			break;
		}

		case id.translate: {

			loadAnimation = AnimationUtils.loadAnimation(this, R.anim.translate);
			image.startAnimation(loadAnimation);
			break;
		}

		case id.continue_btn: {
			loadAnimation = AnimationUtils
					.loadAnimation(this, R.anim.translate);
			image.startAnimation(loadAnimation);
			final Animation loadAnimation2 = AnimationUtils.loadAnimation(this,
					R.anim.rotate);
			loadAnimation.setAnimationListener(new AnimationListener() {

				@Override
				public void onAnimationStart(Animation arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onAnimationRepeat(Animation arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onAnimationEnd(Animation arg0) {
					// TODO Auto-generated method stub
					image.startAnimation(loadAnimation2);
				}
			});
			break;
		}

		case id.continue_btn2: {
			loadAnimation = AnimationUtils.loadAnimation(this,
					R.anim.continue_anim);
			image.startAnimation(loadAnimation);
			break;
		}



		case id.move: {
			TranslateAnimation translate = new TranslateAnimation(-50, 50,
					0, 0);
			translate.setDuration(1000);
			translate.setRepeatCount(Animation.INFINITE);
			translate.setRepeatMode(Animation.REVERSE);
			image.startAnimation(translate);

			break;
		}

		case id.flash: {

			AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
			alphaAnimation.setDuration(100);
			alphaAnimation.setRepeatCount(10);
			//倒序重复REVERSE  正序重复RESTART
			alphaAnimation.setRepeatMode(Animation.REVERSE);
			image.startAnimation(alphaAnimation);

			break;
		}
		
		case id.change:
		{
			Intent intent=new Intent(MainActivity.this,MainActivity2.class);
			startActivity(intent);
			overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out);
			break;
		}
		
		case id.layout:
		{
			Intent intent=new Intent(MainActivity.this,ListActivity.class);
			startActivity(intent);
			break;
		}
		
		case id.frame:
		{
			image.setImageResource(R.drawable.anim_list);
            animationDrawable = (AnimationDrawable) image.getDrawable();
            animationDrawable.start();
            break;
			
		}

		}
	}

}
