package com.irokotv.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.Image;
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

import org.w3c.dom.Text;

/**
 * Created by tonyofrancis on 7/14/16.
 */
public class CardInfoView extends FrameLayout {

    public TextView titleView;
    public TextView detailView;
    public ImageView leftActionView;
    public ImageView midActionView;
    public ImageView rightActionView;


    public CardInfoView(Context context) {
        super(context,null);
    }

    public CardInfoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CardInfoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.card_info_view,this,false);
        addView(view);

        titleView = (TextView) view.findViewById(R.id.titleView);
        detailView = (TextView) view.findViewById(R.id.detailView);
        leftActionView = (ImageView) view.findViewById(R.id.leftActionView);
        midActionView = (ImageView) view.findViewById(R.id.midActionView);
        rightActionView = (ImageView) view.findViewById(R.id.rightActionView);

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

            /*Style midActionView*/
            Drawable midActionViewDrawable = styledAttributes.getDrawable(R.styleable.attr_midActionSrc);

            if (midActionViewDrawable != null) {
                midActionView.setImageDrawable(midActionViewDrawable);
            }

            /*Style rightActionView*/
            Drawable rightActionViewDrawable = styledAttributes.getDrawable(R.styleable.attr_rightActionSrc);

            if (rightActionViewDrawable != null) {
                rightActionView.setImageDrawable(rightActionViewDrawable);
            }

        }finally {

            if(styledAttributes != null) {
                styledAttributes.recycle();
            }
        }

    }

    public void setTitleViewText(@NonNull String title) {
        titleView.setText(title);
    }

    public void setDetailView(@NonNull String detailText) {
        detailView.setText(detailText);
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

    public void showMidActionView() {
        midActionView.setVisibility(VISIBLE);
    }

    private void hideMidActionView() {
        midActionView.setVisibility(GONE);
    }

    public void setMidActionViewListener(@Nullable OnClickListener actionListener) {
        midActionView.setOnClickListener(actionListener);
    }

    public void setMidActionViewDrawable(@NonNull Drawable actionDrawable) {
        midActionView.setImageDrawable(actionDrawable);
    }

}
