package com.hoymm.root.morsecodeconverter._2_TextBoxes;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.hoymm.root.morsecodeconverter.R;

/**
 * File created by Damian Muca - Kaizen on 15.06.17.
 */

public class ResizingTextBoxesAnimation extends EditText {
    public static final int animationTime = 380;
    private RelativeLayout upperBox, lowerBox;
    private Context myContext;
    public ValueAnimator upperBoxToBig, upperBoxToSmall, lowerBoxToBig, lowerBoxToSmall;
    private CalculateHeightsForInputOutput heights;

    public ResizingTextBoxesAnimation(Context context) {
        super(context);
        this.myContext = context;
        heights = new CalculateHeightsForInputOutput(myContext);
        connectEditTextFieldWithXML();
        initializateAnimations();
    }

    private void connectEditTextFieldWithXML() {
        upperBox = (RelativeLayout) getActivity().findViewById(R.id.inputEditTextFieldId);
        lowerBox = (RelativeLayout) getActivity().findViewById(R.id.outputEditTextFieldId);
    }

    private void initializateAnimations() {
        upperBoxToBigAnimationInit();
        upperBoxToSmallAnimationInit();
        lowerBoxToBigAnimationInit();
        lowerBoxToSmallAnimationInit();
    }

    private void upperBoxToBigAnimationInit() {
        final RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) upperBox.getLayoutParams();
        upperBoxToBig = ValueAnimator.ofFloat(heights.upperBoxSmallHeight, heights.boxBigHeight);
        upperBoxToBig.setDuration(animationTime);
        upperBoxToBig.setInterpolator(new AccelerateDecelerateInterpolator());
        upperBoxToBig.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedValue = (float) valueAnimator.getAnimatedValue();
                params.height = (int) animatedValue;
                upperBox.setLayoutParams(params);
            }
        });
    }

    private void upperBoxToSmallAnimationInit() {
        final RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) upperBox.getLayoutParams();
        upperBoxToSmall = ValueAnimator.ofFloat(heights.boxBigHeight, heights.upperBoxSmallHeight);
        upperBoxToSmall.setDuration(animationTime);
        upperBoxToSmall.setInterpolator(new AccelerateDecelerateInterpolator());
        upperBoxToSmall.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedValue = (float) valueAnimator.getAnimatedValue();
                params.height = (int) animatedValue;
                upperBox.setLayoutParams(params);
            }
        });

    }

    private void lowerBoxToBigAnimationInit() {
        final RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) lowerBox.getLayoutParams();
        lowerBoxToBig = ValueAnimator.ofFloat(heights.boxSmallHeight, heights.lowerBoxBigHeight);
        lowerBoxToBig.setDuration(animationTime);
        lowerBoxToBig.setInterpolator(new AccelerateDecelerateInterpolator());
        lowerBoxToBig.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedValue = (float) valueAnimator.getAnimatedValue();
                params.height = (int) animatedValue;
                lowerBox.setLayoutParams(params);
            }
        });
    }

    private void lowerBoxToSmallAnimationInit() {
        final RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) lowerBox.getLayoutParams();
        lowerBoxToSmall = ValueAnimator.ofFloat(heights.lowerBoxBigHeight, heights.boxSmallHeight);
        lowerBoxToSmall.setDuration(animationTime);
        lowerBoxToSmall.setInterpolator(new AccelerateDecelerateInterpolator());
        lowerBoxToSmall.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedValue = (float) valueAnimator.getAnimatedValue();
                params.height = (int) animatedValue;
                lowerBox.setLayoutParams(params);
            }
        });
    }

    private Activity getActivity(){
        return ((Activity)myContext);
    }

}
