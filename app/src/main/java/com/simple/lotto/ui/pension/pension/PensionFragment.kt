package com.simple.lotto.ui.pension.pension

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.simple.lotto.R

class PensionFragment: Fragment() {

    private  var _binding: com.simple.lotto.databinding.FragmentPensionBinding? = null
    private val binding get() = _binding!!
    private lateinit var pensionViewModel: PensionViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_pension,container,false)

        pensionViewModel = ViewModelProvider(this)[PensionViewModel::class.java]
        binding.viewModel = pensionViewModel
//        binding.start.setOnClickListener {
//            pensionViewModel.updateText()
//        }

        pensionViewModel.lottoNumber1.observe(viewLifecycleOwner) {
            it?.let {
                binding.lottoNumber1.text = it[0]
                binding.lottoNumber2.text = it[1]
                binding.lottoNumber3.text = it[2]
                binding.lottoNumber4.text = it[3]
                binding.lottoNumber5.text = it[4]
                binding.lottoNumber6.text = it[5]
                binding.lottoNumber7.text = it[6]
            }
        }
        pensionViewModel.lottoNumber2.observe(viewLifecycleOwner) {
            it?.let {
                binding.lottoNumber8.text = it[0]
                binding.lottoNumber9.text = it[1]
                binding.lottoNumber10.text = it[2]
                binding.lottoNumber11.text = it[3]
                binding.lottoNumber12.text = it[4]
                binding.lottoNumber13.text = it[5]
                binding.lottoNumber14.text = it[6]
            }
        }
        pensionViewModel.lottoNumber3.observe(viewLifecycleOwner) {
            it?.let {
                binding.lottoNumber15.text = it[0]
                binding.lottoNumber16.text = it[1]
                binding.lottoNumber17.text = it[2]
                binding.lottoNumber18.text = it[3]
                binding.lottoNumber19.text = it[4]
                binding.lottoNumber20.text = it[5]
                binding.lottoNumber21.text = it[6]
            }
        }
        pensionViewModel.lottoNumber4.observe(viewLifecycleOwner) {
            it?.let {
                binding.lottoNumber22.text = it[0]
                binding.lottoNumber23.text = it[1]
                binding.lottoNumber24.text = it[2]
                binding.lottoNumber25.text = it[3]
                binding.lottoNumber26.text = it[4]
                binding.lottoNumber27.text = it[5]
                binding.lottoNumber28.text = it[6]
            }
        }
        pensionViewModel.lottoNumber5.observe(viewLifecycleOwner) {
            it?.let {
                binding.lottoNumber29.text = it[0]
                binding.lottoNumber30.text = it[1]
                binding.lottoNumber31.text = it[2]
                binding.lottoNumber32.text = it[3]
                binding.lottoNumber33.text = it[4]
                binding.lottoNumber34.text = it[5]
                binding.lottoNumber35.text = it[6]
            }
        }
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}