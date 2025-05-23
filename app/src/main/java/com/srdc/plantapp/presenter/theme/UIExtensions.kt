package com.srdc.plantapp.presenter.theme

import android.view.View

/**
 * Sets the visibility of the View to VISIBLE.
 */
fun View.makeVisible() {
    visibility = View.VISIBLE
}

/**
 * Sets the visibility of the View to GONE.
 */
fun View.makeGone() {
    visibility = View.GONE
}

/**
 * Sets the visibility of the View to INVISIBLE.
 */
fun View.makeInvisible() {
    visibility = View.INVISIBLE
}

/**
 * Toggles the visibility of the View between VISIBLE and GONE.
 * If the current visibility is INVISIBLE, it will be set to VISIBLE.
 */
fun View.toggleVisibility() {
    visibility = if (visibility == View.VISIBLE) {
        View.GONE
    } else {
        View.VISIBLE
    }
}

/**
 * Sets the visibility of the View based on the provided boolean.
 * @param visible True to make the View VISIBLE, false to make it GONE.
 */
fun View.setVisibility(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}