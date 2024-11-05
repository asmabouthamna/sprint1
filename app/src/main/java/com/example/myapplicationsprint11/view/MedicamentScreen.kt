package com.example.myapplicationsprint11.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplicationsprint11.model.ResponseMedicament
import com.example.myapplicationsprint11.viewmodel.MedicamentViewModel

@Composable
fun MedicamentScreen(viewModel: MedicamentViewModel = viewModel()) {
    var patientId by remember { mutableStateOf("") }
    val medicaments by viewModel.medicaments.observeAsState(emptyList())

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = patientId,
            onValueChange = { patientId = it },
            label = { Text("Enter Patient ID") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { viewModel.getMedicamentsByPatientId(patientId) }) {
            Text("Get Medicaments")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (medicaments.isNotEmpty()) {
            Text("Medications for Patient ID $patientId:")
            medicaments.forEach { medicament ->
                Column(modifier = Modifier.padding(vertical = 4.dp)) {
                    Text("Name: ${medicament.name ?: "N/A"}")
                    Text("Dosage: ${medicament.dosage ?: "N/A"}")
                    Text("Frequency: ${medicament.frequency ?: "N/A"}")
                    Text("Start Date: ${medicament.startDate ?: "N/A"}")
                    Text("End Date: ${medicament.endDate ?: "N/A"}")
                    // Ajoutez d'autres champs si nécessaire
                    Divider() // Ajoute une séparation entre les médicaments
                }
            }
        } else {
            Text("No medicaments found or enter a valid Patient ID.")
        }
    }
}
