package com.hoymm.root.morsecodeconverter._3_ControlButtons;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.hoymm.root.morsecodeconverter.ButtonsTemplate;
import com.hoymm.root.morsecodeconverter.R;
import com.hoymm.root.morsecodeconverter._1_TopBar.MorseToTextConversion.MorseCodeCipher;
import com.hoymm.root.morsecodeconverter._5_FooterPanel.FlashlightButton;
import com.hoymm.root.morsecodeconverter._5_FooterPanel.FooterButtons;
import com.hoymm.root.morsecodeconverter._5_FooterPanel.ScreenButton;
import com.hoymm.root.morsecodeconverter._5_FooterPanel.SoundButton;
import com.hoymm.root.morsecodeconverter._5_FooterPanel.VibrationButton;

/**
 * File created by Damian Muca - Kaizen on 10.07.17.
 */

public class PlayButton extends ButtonsTemplate {
    private static PlayButton instance = null;
    private BroadcastMorseSignals broadcastMorseSignals;

    public static PlayButton initAndGetInstance(Activity activity){
        if (instance == null)
            instance = new PlayButton(activity);
        return instance;
    }

    private PlayButton(Activity activity) {
        super(activity, R.id.playButtonId);
        broadcastMorseSignals = new BroadcastMorseSignals(getActivity());
        setButtonBehavior();
    }

    private void setButtonBehavior() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FooterButtons.atLeastOneFooterButtonActive(getActivity()))
                    changeActiveStatePlayAndStopButtonsAndIconThenRunBroadcastThread(v);
                else
                    showMessageToTheUserToActivateAtLeastBroadcastOneMode();
            }
        });
    }

    private void changeActiveStatePlayAndStopButtonsAndIconThenRunBroadcastThread(View playButton) {
        if (broadcastMorseSignals.isThreadDead()) {
            playButton.setActivated(!playButton.isActivated());
            if (playButton.isActivated()) {
                deactivateStopButton();
                changeButtonImageToActivatedAndRunBroadcastThread();
                PlayPauseStopButtons.initAndGetInstance(getActivity()).makePauseButtonNotClicked();
                PlayPauseStopButtons.initAndGetInstance(getActivity()).makeStopButtonNotClicked();
            }
            else {
                activateStopButton();
                changeButtonImageToDeactivated();
            }

        }
    }

    private void changeButtonImageToActivatedAndRunBroadcastThread() {
        button.setImageResource(R.drawable.play_white);
        broadcastMorseSignals.start();
    }
    private void changeButtonImageToDeactivated() {
        button.setImageResource(R.drawable.play_purple);
    }

    private void deactivateStopButton() {
        if(StopButton.initAndGetInstance(getActivity()).isActive())
            StopButton.initAndGetInstance(getActivity()).callOnClick();
    }

    private void activateStopButton() {
        if(!StopButton.initAndGetInstance(getActivity()).isActive())
            StopButton.initAndGetInstance(getActivity()).callOnClick();
    }

    private void showMessageToTheUserToActivateAtLeastBroadcastOneMode() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getActivity(),
                        R.string.please_activate_at_least_one_broadcast_mode, Toast.LENGTH_SHORT).show();
            }
        });}
}