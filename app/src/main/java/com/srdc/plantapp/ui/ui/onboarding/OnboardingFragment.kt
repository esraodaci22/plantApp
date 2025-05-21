package com.srdc.plantapp.ui.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.plantapp.databinding.FragmentOnboardingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardingFragment : Fragment() {

    private lateinit var binding: FragmentOnboardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        binding.buttonContinue.setOnClickListener {
//            lifecycleScope.launch {
//                OnboardingPreferences.setOnboardingCompleted(requireContext(), true)
//                findNavController().navigate(R.id.action_onboardingFragment_to_homeFragment)
//            }
//        }
    }
}
