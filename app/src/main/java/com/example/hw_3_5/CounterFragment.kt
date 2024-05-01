// CounterFragment.kt

package com.example.hw_3_5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hw_3_5.databinding.FragmentCounterBinding

class CounterFragment : Fragment() {

    private var count = 0
    private lateinit var binding: FragmentCounterBinding
    private var isMinusMode = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCounterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btn1.setOnClickListener {
            if (!isMinusMode && count < 10) {
                count++
                binding.tvText.text = count.toString()
                if (count == 10) {
                    binding.btn1.text = "-1"
                    isMinusMode = true
                }
            } else if (isMinusMode && count > 0) {
                count--
                binding.tvText.text = count.toString()
                if (count == 0) {
                    findNavController().navigate(R.id.action_counterFragment_to_resultFragment)
                }
            }
        }
    }
}
