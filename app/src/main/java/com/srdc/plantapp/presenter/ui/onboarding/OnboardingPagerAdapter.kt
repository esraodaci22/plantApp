package com.srdc.plantapp.presenter.ui.onboarding
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.plantapp.R
import com.srdc.plantapp.presenter.theme.toggleVisibility

private const val NUM_PAGES = 3

class OnboardingPagerAdapter(private val context: Context) : RecyclerView.Adapter<OnboardingPagerAdapter.OnboardingViewHolder>() {

    private val images = intArrayOf(R.drawable.onboarding_first, R.drawable.onboarding_second, R.drawable.onboarding_third)
    private val texts = intArrayOf(R.string.onboarding_second_title, R.string.onboarding_third_title)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_onboarding, parent, false)
        return OnboardingViewHolder(view)
    }
    override fun getItemCount() = NUM_PAGES
    override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {
        holder.textView.text = context.getString(texts[position])
        holder.imageView.resources.getResourceName(images[position])
        if (position == 1){
            holder.getStartedLayout.toggleVisibility()
            holder.skipLayout.toggleVisibility()
        }
    }
    class OnboardingViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val textView: TextView = view.findViewById(R.id.onboarding_title)
        val imageView: TextView = view.findViewById(R.id.onboarding_image)
        val getStartedLayout : ConstraintLayout = view.findViewById(R.id.onboarding_container_get_started)
        val skipLayout : ConstraintLayout = view.findViewById(R.id.onboarding_container_skip)
    }
}
