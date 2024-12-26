package com.example.bookapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController

class DetailsFragment : Fragment() {

    private val bookViewModel: BookViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_details, container, false)

        // Отображение данных выбранной книги
        val titleTextView = view.findViewById<TextView>(R.id.tvTitle)
        val authorTextView = view.findViewById<TextView>(R.id.tvAuthor)
        val descriptionTextView = view.findViewById<TextView>(R.id.tvDescription)

        bookViewModel.selectedBook.value?.let { selectedBook ->
            titleTextView.text = selectedBook.title
            authorTextView.text = selectedBook.author
            descriptionTextView.text = selectedBook.description
        }

        // Переход к EditFragment по кнопке "Edit"
        view.findViewById<Button>(R.id.btnEdit).setOnClickListener {
            findNavController().navigate(R.id.action_detailsFragment_to_editFragment)
        }

        return view
    }
}
