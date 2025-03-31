package com.example.weatherapp.presentation.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.weatherapp.databinding.FragmentWeatherBinding
import com.example.weatherapp.presentation.viewModel.WeatherViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherFragment : Fragment() {

    private val viewModel: WeatherViewModel by viewModel()

    private var _binding: FragmentWeatherBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.forecast.observe(viewLifecycleOwner) { forecast ->
            forecast?.let {
                val avgTemp = it.forecast.forecastDay.firstOrNull()?.day?.avgTempC ?: "нет данных"
                binding.textViewWeather.text = "Средняя температура: $avgTemp°C"
            }
        }

        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) { error ->
            error?.let {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonLoad.setOnClickListener {
            viewModel.loadForecast("Bishkek", 1)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}