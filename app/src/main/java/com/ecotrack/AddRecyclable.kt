package com.ecotrack

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ecotrack.databinding.AddRecyclableBinding

class AddRecyclable : AppCompatActivity() {
    private lateinit var binding: AddRecyclableBinding
    private val viewModel: RecyclableViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.add_recyclable)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.btnSubmit.setOnClickListener {
            if (validateInput()) {
                addRecyclableItem()
                clearInputFields()
            }
        }

        binding.btnBack.setOnClickListener {
            returnToMainActivity()
        }
    }

    private fun validateInput(): Boolean {
        val type = binding.etType.text?.toString() ?: ""
        val weightText = binding.etWeight.text?.toString() ?: ""

        if (type.isEmpty()) {
            binding.etType.error = "Please enter material type"
            return false
        }

        if (weightText.isEmpty()) {
            binding.etWeight.error = "Please enter weight"
            return false
        }

        val weight = weightText.toDoubleOrNull()
        if (weight == null || weight <= 0) {
            binding.etWeight.error = "Please enter valid weight"
            return false
        }

        return true
    }

    private fun addRecyclableItem() {
        val type = binding.etType.text?.toString() ?: ""
        val weight = binding.etWeight.text?.toString()?.toDoubleOrNull() ?: 0.0

        viewModel.addRecyclable(Recyclable(type, weight))
    }

    private fun clearInputFields() {
        binding.etType.text?.clear()
        binding.etWeight.text?.clear()
        binding.etType.requestFocus()
    }

    private fun returnToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}