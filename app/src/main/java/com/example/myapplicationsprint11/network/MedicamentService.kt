package com.example.myapplicationsprint11.network
import com.example.myapplicationsprint11.model.ResponseMedicament
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MedicamentService {
    @GET("api/patients/{patientId}/medicaments")
    fun getMedicamentsByPatientId(@Path("patientId") patientId: String): Call<List<ResponseMedicament>>
}