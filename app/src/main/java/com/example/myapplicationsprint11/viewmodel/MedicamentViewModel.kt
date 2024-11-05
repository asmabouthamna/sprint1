package com.example.myapplicationsprint11.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplicationsprint11.model.ResponseMedicament
import com.example.myapplicationsprint11.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MedicamentViewModel : ViewModel() {
    private val _medicaments = MutableLiveData<List<ResponseMedicament>>()
    val medicaments: LiveData<List<ResponseMedicament>> get() = _medicaments

    fun getMedicamentsByPatientId(patientId: String) {
        RetrofitClient.apiService.getMedicamentsByPatientId(patientId).enqueue(object : Callback<List<ResponseMedicament>> {
            override fun onResponse(call: Call<List<ResponseMedicament>>, response: Response<List<ResponseMedicament>>) {
                if (response.isSuccessful) {
                    _medicaments.value = response.body()
                } else {
                    // Handle response errors if needed
                    _medicaments.value = emptyList() // Or handle as per your requirement
                }
            }

            override fun onFailure(call: Call<List<ResponseMedicament>>, t: Throwable) {
                // Handle failure
                _medicaments.value = emptyList() // Or handle as per your requirement
            }
        })
    }
}