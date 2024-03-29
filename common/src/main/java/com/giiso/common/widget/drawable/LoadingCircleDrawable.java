/*
 * Copyright (C) 2014-2016 Qiujuer <qiujuer@live.cn>
 * WebSite http://www.qiujuer.net
 * Author qiujuer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.giiso.common.widget.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/**
 * BuildConfig drawable to draw loading form Circle Type
 * <p>
 * Form:https://github.com/qiujuer/Genius-Android
 *
 * @author qiujuer Email:qiujuer@live.cn
 * @version 1.0.0
 */
public class LoadingCircleDrawable extends LoadingDrawable {
    private static final int ANGLE_ADD = 5;
    private static final int MIN_ANGLE_SWEEP = 3;
    private static final int MAX_ANGLE_SWEEP = 255;
    private static int DEFAULT_SIZE = 56;

    private int mMinSize = DEFAULT_SIZE;
    private int mMaxSize = DEFAULT_SIZE;
    private RectF mOval = new RectF();

    private float mStartAngle = 0;
    private float mSweepAngle = 0;
    private int mAngleIncrement = -3;

    public LoadingCircleDrawable() {
        super();
        mForegroundPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public LoadingCircleDrawable(int minSize, int maxSize) {
        super();
        mMinSize = minSize;
        mMaxSize = maxSize;
    }

    @Override
    public int getIntrinsicHeight() {
        float maxLine = Math.max(mBackgroundPaint.getStrokeWidth(), mForegroundPaint.getStrokeWidth());
        int size = (int) (maxLine * 2 + 10);
        return Math.min(mMaxSize, Math.max(size, mMinSize));
    }

    @Override
    public int getIntrinsicWidth() {
        float maxLine = Math.max(mBackgroundPaint.getStrokeWidth(), mForegroundPaint.getStrokeWidth());
        int size = (int) (maxLine * 2 + 10);
        return Math.min(mMaxSize, Math.max(size, mMinSize));
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        if (bounds.left == 0 && bounds.top == 0 && bounds.right == 0 && bounds.bottom == 0) {
            return;
        }

        final int centerX = bounds.centerX();
        final int centerY = bounds.centerY();

        final int radius = Math.min(bounds.height(), bounds.width()) >> 1;
        final int maxStrokeRadius = ((int) Math.max(getForegroundLineSize(), getBackgroundLineSize()) >> 1) + 1;
        final int areRadius = radius - maxStrokeRadius;

        mOval.set(centerX - areRadius, centerY - areRadius, centerX + areRadius, centerY + areRadius);
    }

    @Override
    protected void onProgressChange(float progress) {
        mStartAngle = 0;
        mSweepAngle = 360 * progress;
    }

    @Override
    protected void onRefresh() {
        final float angle = ANGLE_ADD;
        mStartAngle += angle;

        if (mStartAngle > 360) {
            mStartAngle -= 360;
        }

        if (mSweepAngle > MAX_ANGLE_SWEEP) {
            mAngleIncrement = -mAngleIncrement;
        } else if (mSweepAngle < MIN_ANGLE_SWEEP) {
            mSweepAngle = MIN_ANGLE_SWEEP;
            return;
        } else if (mSweepAngle == MIN_ANGLE_SWEEP) {
            mAngleIncrement = -mAngleIncrement;
            getNextForegroundColor();
        }
        mSweepAngle += mAngleIncrement;
    }

    @Override
    protected void drawBackground(Canvas canvas, Paint backgroundPaint) {
        canvas.drawArc(mOval, 0, 360, false, backgroundPaint);
    }

    @Override
    protected void drawForeground(Canvas canvas, Paint foregroundPaint) {
        canvas.drawArc(mOval, mStartAngle, -mSweepAngle, false, foregroundPaint);
    }
}