package com.example.myapplicationsprint11.model

data class Patient(
	val address: String? = null,
	val medicaments: List<MedicamentsItem?>? = null,
	val name: String? = null,
	val age: Int? = null
)

data class MedicamentsItem(
	val dosage: String? = null,
	val endDate: String? = null,
	val name: String? = null,
	val sideEffects: List<Any?>? = null,
	val startDate: String? = null,
	val frequency: String? = null
)

