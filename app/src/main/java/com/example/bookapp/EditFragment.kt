package com.example.bookapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController

class EditFragment : Fragment() {

    private val bookViewModel: BookViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_edit, container, false)

        // Поля для редактирования
        val titleEditText = view.findViewById<EditText>(R.id.etTitle)
        val authorEditText = view.findViewById<EditText>(R.id.etAuthor)
        val descriptionEditText = view.findViewById<EditText>(R.id.etDescription)

        // Заполняем данные выбранной книги
        bookViewModel.selectedBook.value?.let { selectedBook ->
            titleEditText.setText(selectedBook.title)
            authorEditText.setText(selectedBook.author)
            descriptionEditText.setText(selectedBook.description)
        }

        // Сохраняем изменения и возвращаемся к DetailsFragment
        view.findViewById<Button>(R.id.btnSave).setOnClickListener {
            val updatedBook = Book(
                title = titleEditText.text.toString(),
                author = authorEditText.text.toString(),
                description = descriptionEditText.text.toString()
            )
            bookViewModel.updateBook(updatedBook)
            findNavController().navigateUp() // Возвращаемся назад
        }

        return view
    }
}
