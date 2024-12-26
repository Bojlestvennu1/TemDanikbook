package com.example.bookapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment : Fragment() {

    private val bookViewModel: BookViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        // Связываем RecyclerView с адаптером
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Настройка адаптера и обработка клика
        recyclerView.adapter = BookAdapter(bookViewModel.books.value ?: emptyList()) { selectedBook ->
            // Устанавливаем выбранную книгу в ViewModel
            bookViewModel.selectedBook.value = selectedBook
            // Навигация к DetailsFragment
            findNavController().navigate(R.id.action_listFragment_to_detailsFragment)
        }

        return view
    }
}
