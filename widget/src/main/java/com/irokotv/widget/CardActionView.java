package com.irokotv.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.lzyzsd.circleprogress.DonutProgress;

/**
 * Created by tonyofrancis on 7/14/16.
 */
public final class CardActionView extends FrameLayout {

    public TextView titleView;
    public TextView detailView;
    public ImageView rightActionView;
    public ImageView leftActionView;
    public DonutProgress progressView;


    public CardActionView(Context context) {
        super(context,null);
    }

    public CardActionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CardActionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.card_action_view,this,false);
        addView(view);

        titleView = (TextView) view.findViewById(R.id.titleView);
        detailView = (TextView) view.findViewById(R.id.detailView);
        rightActionView = (ImageView) view.findViewById(R.id.rightActionView);
        leftActionView = (ImageView) view.findViewById(R.id.leftActionView);
        progressView = (DonutProgress) view.findViewById(R.id.progressView);

        styleView(attrs);

    }

    private void styleView(AttributeSet attrs) {

        TypedArray styledAttributes = null;

        try {
            styledAttributes = getContext().obtainStyledAttributes(attrs,R.styleable.attr);


            /*Style TitleView*/
            int titleColor = styledAttributes.getColor(R.styleable.attr_CardTitleTextColor,
                    ContextCompat.getColor(getContext(),android.R.color.black));

            titleView.setTextColor(titleColor);

            float titleTextSize = styledAttributes.getDimensionPixelSize(R.styleable.attr_CardTitleTextSize,
                    getResources().getDimensionPixelSize(R.dimen.default_text_size_small));

            titleView.setTextSize(TypedValue.COMPLEX_UNIT_PX,titleTextSize);

            String titleText = styledAttributes.getString(R.styleable.attr_CardTitleText);

            if(titleText != null) {
                titleView.setText(titleText);
            }

            /*Style DetailView*/
            int detailColor = styledAttributes.getColor(R.styleable.attr_detailTextColor,
                    ContextCompat.getColor(getContext(),android.R.color.black));

            detailView.setTextColor(detailColor);

            float detailTextSize = styledAttributes.getDimensionPixelSize(R.styleable.attr_detailTextSize,
                    getResources().getDimensionPixelSize(R.dimen.default_text_size_small));


            detailView.setTextSize(TypedValue.COMPLEX_UNIT_PX,detailTextSize);

            String detailText = styledAttributes.getString(R.styleable.attr_detailText);

            if(detailText != null) {
                detailView.setText(detailText);
            }

            /*Style leftActionView*/
            Drawable leftActionViewDrawable = styledAttributes.getDrawable(R.styleable.attr_leftActionSrc);

            if (leftActionViewDrawable != null) {
                leftActionView.setImageDrawable(leftActionViewDrawable);
            }

            /*Style rightActionView*/
            Drawable rightActionViewDrawable = styledAttributes.getDrawable(R.styleable.attr_rightActionSrc);

            if (rightActionViewDrawable != null) {
                rightActionView.setImageDrawable(rightActionViewDrawable);
            }


            /*Style ProgressBar*/

            int progress = styledAttributes.getInt(R.styleable.attr_CardProgress,0);
            progressView.setProgress(progress);

            int progressColor = styledAttributes.getColor(R.styleable.attr_CardProgressColor,
                    ContextCompat.getColor(getContext(),R.color.default_progress_color));

            progressView.setFinishedStrokeColor(progressColor);

            int progressBackgroundColor = styledAttributes.getColor(R.styleable.attr_CardProgressBackgroundColor,
                    ContextCompat.getColor(getContext(),R.color.default_progress_backgroundColor));

            progressView.setUnfinishedStrokeColor(progressBackgroundColor);

        }finally {

            if(styledAttributes != null) {
                styledAttributes.recycle();
            }
        }

    }

    public void setProgress(int progress) {
        progressView.setProgress(progress);
    }

    private void hideProgressView(){
        progressView.setVisibility(GONE);
    }

    public void showProgressView() {
        progressView.setVisibility(VISIBLE);
    }

    public void setTitleViewText(@NonNull String title) {
        titleView.setText(title);
    }

    public void setTitleViewActionListener(@Nullable OnClickListener actionListener) {
        titleView.setOnClickListener(actionListener);
    }

    public void setDetailViewText(@NonNull String detail) {
        detailView.setText(detail);
    }

    public void hideDetailView() {
        detailView.setVisibility(GONE);
    }

    public void showDetailView() {
        detailView.setVisibility(VISIBLE);
    }

    public void showRightActionView() {
        rightActionView.setVisibility(VISIBLE);
    }

    public void hideRightActionView() {
        rightActionView.setVisibility(GONE);
    }

    public void setRightActionViewListener(@Nullable OnClickListener actionListener) {
        rightActionView.setOnClickListener(actionListener);
    }

    public void setRightActionViewDrawable(@NonNull Drawable actionDrawable) {
        rightActionView.setImageDrawable(actionDrawable);
    }

    public void showLeftActionView() {
        leftActionView.setVisibility(VISIBLE);
    }

    private void hideLeftActionView() {
        leftActionView.setVisibility(GONE);
    }

    public void setLeftActionViewListener(@Nullable OnClickListener actionListener) {
        leftActionView.setOnClickListener(actionListener);
    }

    public void setLeftActionViewDrawable(@NonNull Drawable actionDrawable) {
        leftActionView.setImageDrawable(actionDrawable);
    }
}
